package de.fhb.jproject.controller.web.actions.comment;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Action die angesprochen wenn zu einem Task alle Kommentare angezeigt werden
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=ShowAllComments41Task&taskId=1&projectName=ProjectName
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowAllComments41TaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllComments41TaskAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		HttpSession session = req.getSession();		
		List<Comment> commentList=null;
		
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String taskId(" + req.getParameter("taskId") + ")"
					);	
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int taskId = 0;
			try {
				taskId = Integer.valueOf(req.getParameter("taskId"));
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllComments41TaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllComments41TaskAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen aller TaskComments!");
					}			
				}
				//Manager in aktion
				commentList=mainManager.getCommentManager().showAllComments41Source(aktUser, aktProject.getName(), taskId);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
//			for( Comment c : commentList){
//				System.out.println("Comment: "+ c.getId()+" "+ c.getEntry());
//			}		
			
			JSONObject json = new JSONObject();
		
			for (Comment comment : commentList) {
				try {
					JSONObject comm = new JSONObject();
					comm.put("id", comment.getId());
					comm.put("entry", comment.getEntry());
					comm.put("user", comment.getUser());
					json.append("comment", comm);
					//json.append("comment", new JSONObject(comment));
				} catch (JSONException e) {
					logger.error(e.getMessage(), e);
					req.setAttribute("contentFile", "error.jsp");
					req.setAttribute("errorString", e.getMessage());
				}
			}
			resp.setContentType("application/json");
			try {
				//forward(req, resp, "/snippet.jsp");
				resp.getWriter().println(json);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", e.getMessage());
			}

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
