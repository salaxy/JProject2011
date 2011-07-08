package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action, die beim Updaten einer Task in einem Projekt angesprochen wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * taskId(Id des Tasks): request -> taskId
 * (optional)titel(titel des Tasks): request -> titel
 * (optional)aufgabenStellung(aufgabenStellung des Tasks): request -> aufgabenStellung
 * (optional)date(Termin des Tasks): request -> date
 * (optional)done(Status des Tasks): request -> done
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * 
 * Managermethoden:
 * updateTask
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=UpdateTask&taskId=5&titel=DeineAufgabe&date=2011-06-10&done=true
 * 
 */
public class UpdateTaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(UpdateTaskAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int taskId(" + req.getParameter("taskId") + ")"
					+ "String titel(" + req.getParameter("titel") + ")"
					+ "String aufgabenStellung(" + req.getParameter("aufgabenStellung") + ")"
					+ "Date date(" + req.getParameter("date") + ")"
					+ "boolean done(" + req.getParameter("done") + ")"
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
			String titel = req.getParameter("titel");
			String aufgabenstellung = req.getParameter("aufgabenstellung");
			//yyyy-mm-dd <<< muss sooo aussehen
			Date date = null;
			try {
				if (date != null) {
					date = Date.valueOf(req.getParameter("date"));
				}
			} catch (IllegalArgumentException e) {
				logger.error("Konnte Datum nicht entziffern! ", e);
				throw new ProjectException("Ungültiges Datum!");
			}
			boolean done = Boolean.getBoolean(req.getParameter("done"));
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedUpdateTaskAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedUpdateTaskAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Updaten dieses Tasks!");
				}			
			}
			//Manager in aktion
			mainManager.getTaskManager().updateTask(aktProject.getName(), taskId, titel, aufgabenstellung, date, done);
			
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
