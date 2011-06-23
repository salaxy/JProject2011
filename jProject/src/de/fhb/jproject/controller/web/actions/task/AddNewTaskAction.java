package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.project.AddMemberAction;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.sql.Date;
import javax.servlet.http.HttpSession;


/**
 * Action die angesprochen wird wenn eine Aufgabe einem Projekt hingefuegt wird
 * 
 * Hinweise:
 * - Parameter "date" MUSS die Form "yyyy-mm-dd" haben
 *  
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=AddNewTask&projectName=ProjectName&titel=TestAufgabe&aufgabenStellung=Tue%20dies%20und%20das!&date=2011-06-02
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
					+ "String projectName(" + req.getParameter("projectName") + "), "
					+ "String titel(" + req.getParameter("titel") + ")"
					+ "String aufgabenStellung(" + req.getParameter("aufgabenStellung") + ")"
					+ "Date date(" + req.getParameter("date") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String titel = req.getParameter("titel");
			String aufgabenstellung = req.getParameter("aufgabenstellung");
			//yyyy-mm-dd <<< muss sooo aussehen
			//Date date = Date.valueOf(req.getParameter("date"));
			Date date = null;
			int taskId = 0;
			try {
				if (date != null) {
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
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedAddNewTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedAddNewTaskAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum hinzufügen eines Tasks!");
					}			
				}
				//Manager in aktion
				taskId = mainManager.getTaskManager().addNewTask(aktProject.getName(), titel, aufgabenstellung, date);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			try {
				String[] param = new String[1];
				param[0] = "taskId="+taskId;
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllTasks", param);
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
