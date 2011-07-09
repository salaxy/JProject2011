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
 * Action, die beim Hinzufügen eines neuen Tasks in einem Projekt angesprochen wird <br/>
 *  <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * titel(Bezeichnung des Tasks): request -> titel <br/>
 * aufgabenStellung(formulierte Aufgabenstellung): request -> aufgabenStellung <br/>
 * date(Datum der Form "yyyy-mm-dd"): request -> date <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * Managermethoden: <br/>
 * addNewTask <br/>
 *  <br/>
 *  Beispiel-Aufruf: <br/>
 * do=AddNewTask&titel=TestAufgabe&aufgabenStellung=Tue%20dies%20und%20das!&date=2011-06-02 <br/>
 *  <br/>
 *  
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class AddNewTaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AddNewTaskAction.class);

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
					+ "String titel(" + req.getParameter("titel") + ")"
					+ "String aufgabenStellung(" + req.getParameter("aufgabenStellung") + ")"
					+ "Date date(" + req.getParameter("date") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String titel = req.getParameter("titel");
			String aufgabenstellung = req.getParameter("aufgabenstellung");
			//yyyy-mm-dd <<< Datumsstring muss sooo aussehen
			Date date = null;
			int taskId = 0;
			try {
				if(date != null){
					date = Date.valueOf(req.getParameter("date"));
				}
			} catch (IllegalArgumentException e) {
				logger.error("Konnte Datum nicht entziffern! ", e);
				throw new ProjectException("Ungültiges Datum!");
			}
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedAddNewTaskAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedAddNewTaskAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Hinzufügen eines Tasks!");
				}			
			}
			//Manager in aktion
			taskId = mainManager.getTaskManager().addNewTask(aktProject.getName(), titel, aufgabenstellung, date);
			
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
