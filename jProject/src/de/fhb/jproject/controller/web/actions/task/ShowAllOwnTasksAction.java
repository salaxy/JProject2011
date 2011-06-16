package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * Aktion die ausgefuehrt wird, wenn die eigenen Tasks/Aufgaben
 * zu einem Projekt in dem der User teilnimmt angezeigt werden sollen
 * 
 * STATUS:	FREIGEGEBEN und getestet
 * URL:		JProjectServlet?do=ShowAllOwnTasks
 * @author	Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowAllOwnTasksAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllOwnTasksAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		
		HttpSession session = req.getSession();		
		List<Task> taskList=null;
		Task task = null;
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Parameter laden
			User aktUser = (User)session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int taskId = 0;
			try {
				taskId = Integer.valueOf(req.getParameter("taskId"));
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
				//TODO DRINGEND RECHTEABFRAGE
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllTasksAction(aktUser.getLoginName())){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllTaskAction(aktUser.getLoginName(), aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum hinzufügen eines Tasks!");
					}			
				}
				//Manager in aktion
				taskList=mainManager.getTaskManager().showAllOwnTasks(aktUser);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			try{
				//Wenn taskId == null dann gib mir den ersten
				if (0 == taskId) {
					taskId = taskList.get(0).getId();
				}
			} catch (IllegalArgumentException e) {
				throw new ProjectException("TaskID ungültig "+e);
			}catch(ArrayIndexOutOfBoundsException e){
				logger.error("Keine Tasks vorhanden!"+e.getMessage(), e);
			}
			
			try {
				//TODO DRINGEND RECHTEABFRAGE
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllTasksAction(aktUser.getLoginName())){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllTaskAction(aktUser.getLoginName(), aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen dieses Tasks!");
					}			
				}
				task = mainManager.getTaskManager().showTask(aktUser, aktProject.getName(), taskId);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			//setzen der Parameter
			req.setAttribute("taskList", taskList);
			req.setAttribute("task", task);
			
			req.setAttribute("contentFile", "showAllOwnTasks.jsp");
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
