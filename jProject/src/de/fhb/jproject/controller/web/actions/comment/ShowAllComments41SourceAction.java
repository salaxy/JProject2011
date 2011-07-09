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
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/** 
 * Action die angesprochen wenn zu einem Sourcecode alle Kommentare angezeigt werden
 *  <br/> <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * sourcecodeId(Id des Sourcecodes): request -> sourcecodeId <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * showAllComments41Source <br/> <br/>
 * 
 * Beispiel-Aufruf: <br/>
 * do=ShowAllComments41Source&sourcecodeId=1 <br/> <br/>
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class ShowAllComments41SourceAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllComments41SourceAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();		
		List<Comment> commentList=null;
		boolean isAllowedUpdateCommentAction = true;
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String sourcecodeId(" + req.getParameter("sourcecodeId") + ")"
					);	
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int sourcecodeId = 0;
			try {
				sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte SourcecodeID nicht entziffern! ", e);
				throw new ProjectException("Ungültige SourcecodeID!");
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			try{
				/* Darf der User Comments ändern? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateCommentAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedUpdateCommentAction(aktUser, aktProject.getName())){
						isAllowedUpdateCommentAction = false;
					}			
				}
			} catch (ProjectException e) {
				isAllowedUpdateCommentAction = false;
				logger.info("isAllowedUpdateCommentAction NO!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllComments41SourceAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowAllComments41SourceAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum anzeigen aller SourcecodeComments!");
				}			
			}
			//Manager in aktion
			commentList=mainManager.getCommentManager().showAllComments41Source(aktUser, aktProject.getName(), sourcecodeId);
			JSONObject json = new JSONObject();
			if (!commentList.isEmpty()) {
				for (Comment comment : commentList) {
					try {
						JSONObject comm = new JSONObject();
						comm.put("id", comment.getId());
						comm.put("entry", comment.getEntry());
						comm.put("user", comment.getUser());
						if (comment.getUser().getLoginName().equals(aktUser)) {
							comm.put("isAllowedUpdateCommentAction", true);
						}else{
							comm.put("isAllowedUpdateCommentAction", isAllowedUpdateCommentAction);
						}
						json.append("comment", comm);
						//json.append("comment", new JSONObject(comment));
					} catch (JSONException e) {
						logger.error("Konnte JSON nicht packen! "+e.getMessage(), e);
						throw new ProjectException("Konnte JSON nicht packen! "+ e);
					}
				}
			}
			resp.setContentType("application/json");
			try {
				//forward(req, resp, "/snippet.jsp");
				resp.getWriter().println(json);
			} catch (IOException e) {
				logger.error("Konnte JSON nicht senden! "+e.getMessage(), e);
				throw new ProjectException("Konnte JSON nicht senden! "+ e);
			}

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
