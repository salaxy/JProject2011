package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.CommentSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import org.apache.log4j.Level;


/**
 * Action die angesprochen wird wenn ein Kommentar geupdatet werden soll
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=UpdateComment&projectName=ProjectName&commentId=1&inhalt=aenderungInhalt
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class UpdateCommentAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(UpdateCommentAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int commentId(" + req.getParameter("commentId") + ")"
					+ "String entry(" + req.getParameter("entry") + "), "
					);
			
				
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int commentId = 0;
			try {
				commentId = Integer.valueOf(req.getParameter("commentId"));
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
			String entry = req.getParameter("entry");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateCommentAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedUpdateCommentAction(aktUser, aktProject.getName())){
						boolean isMine = false;
						CommentSetCollection commentList = mainManager.getUserManager().getAktUser(aktUser).comment;
						commentList.size();
						for (Object comment : commentList.getCollection()) {
							int id = ((Comment)comment).getId();
							
							logger.debug("ID("+id+") == commentID("+commentId+") ==> "+(id == commentId));
							if (id == commentId) {
								isMine = true;
							}
						}
						if (!isMine) {
							throw new ProjectException("Sie haben keine Rechte zum Updaten dieses Comments!");
						}
					}			
				}
				//Manager in aktion
				mainManager.getCommentManager().updateComment(aktUser, aktProject.getName(), commentId, entry);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			try {
				String[] param = new String[1];
				param[0] = "projectName="+aktProject.getName();
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowProject", param);
			} catch (IOException e) {
				logger.error("Konnte Redirect nicht ausführen! "+e.getMessage(), e);
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
