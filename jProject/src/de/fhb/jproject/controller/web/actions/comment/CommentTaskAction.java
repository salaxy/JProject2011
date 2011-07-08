package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;

/**
 * Action die angesprochen wird wenn eine Aufgabe kommentiert wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * taskId(Id des Tasks): request -> taskId
 * entry(Inhalt des Comments): request -> entry
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * 
 * Managermethoden:
 * commentTask
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=CommentSource&taskId=1&entry=DieseAufgabeIstDringend
 * 
 */
public class CommentTaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(CommentTaskAction.class);

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
					+ "int taskId(" + req.getParameter("taskId") + "), "
					+ "String entry(" + req.getParameter("entry") + ")"
					);
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int taskId = 0;
			try {
				taskId = Integer.valueOf(req.getParameter("taskId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte TaskID nicht entziffern! ", e);
				throw new ProjectException("Ungültige TaskID!");
			}
			String entry = req.getParameter("entry");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedCommentTaskAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedCommentTaskAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Hinzufuegen eines TaskComments!");
				}			
			}
			//Manager in aktion
			mainManager.getCommentManager().commentTask(aktUser, taskId, entry);
			
			try {
				String[] param = new String[1];
				param[0] = "taskId="+taskId;
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllTasks", param);
			} catch (IOException e) {
				logger.error("Konnte Redirect nicht ausführen! "+e.getMessage(), e);
				throw new ProjectException("Konnte Redirect nicht ausführen!");
			}
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
