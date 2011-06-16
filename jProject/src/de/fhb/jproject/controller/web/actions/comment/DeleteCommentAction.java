package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action die angesprochen wird wenn ein Kommentar geloescht werden soll
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=DeleteComment&projectName=ProjectName&commentId=1
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class DeleteCommentAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(DeleteCommentAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String commentId(" + req.getParameter("commentId") + ")"
					);
			//Parameter laden
			User aktUser = (User)session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int commentId = 0;
			try {
				commentId = Integer.valueOf(req.getParameter("commentId"));
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
			
			//TODO EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteCommentAction(aktUser.getLoginName())){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDeleteCommentAction(aktUser.getLoginName(), aktProject.getName())){
						for (Object comment : aktUser.comment.getCollection()) {
							int id = ((Comment)comment).getId();
							boolean isMine = false;
							if (id == commentId) {
								isMine = true;
							}
							if (!isMine) {
								throw new ProjectException("Sie haben keine Rechte zum loeschen eines Comments!");
							}
						}
					}			
				}
				//Manager in aktion
				mainManager.getCommentManager().deleteComment(aktUser, aktProject.getName(), commentId);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
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
