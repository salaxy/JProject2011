package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * 
 * Action die angesprochen wird 
 * wenn alle Aufgaben eines Projektes angezeigt werden sollen
 * 
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author Andy Klay <klay@fh-brandenburg.de>
 * 
 * STATUS: FREIGEGEBEN und GETESTET 
 * 
 * http://localhost:8080/jProject/JProjectServlet?do=ShowAllTasks&projectName=ProjectName
 */
public class ShowAllTasksAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllTasksAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		List<Task> taskList=null;
		Task task = null;
		
		boolean isAllowedUpdateTaskAction = true;
		boolean isAllowedAddNewTaskAction = true;
		boolean isAllowedDeleteTaskAction = true;
		
		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int taskId(" + req.getParameter("taskId") + ")"
					);
			
			
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int taskId = 0;
			try {
				taskId = Integer.valueOf(req.getParameter("taskId"));
			} catch (NumberFormatException e) {
				logger.info("Konnte TaskID nicht entziffern! Zeige erstes Element in Liste an. ", e);
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			
			try {
				/* Darf der User Tasks löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDeleteTaskAction(aktUser, aktProject.getName())){
						isAllowedDeleteTaskAction = false;
						logger.info("isAllowedDeleteTaskAction NO!");
					}			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedDeleteTaskAction NO!");
			}
			
			
			
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllTasksAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowAllTaskAction(aktUser, aktProject.getName())){
					if (!mainManager.getProjectRolesManager().isMember(aktUser, aktProject.getName())) {
						throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Tasks dieses Projektes!");
					}
				}			
			}
			//Manager in aktion
			taskList=mainManager.getTaskManager().showAllTasks(aktProject.getName());
			
			
			
			try {
				/* Darf der User Task updaten? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedUpdateTaskAction(aktUser, aktProject.getName())){
						isAllowedUpdateTaskAction = false;
					}			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedUpdateTaskAction NO!");
			}
			
			try {
				/* Darf der User Task erstellen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedAddNewTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedAddNewTaskAction(aktUser, aktProject.getName())){
						isAllowedAddNewTaskAction = false;
					}			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedAddNewTaskAction NO!");
			}
			
			
			
			if (!taskList.isEmpty()) {
				//Wenn taskId == null dann gib mir den ersten
				if (0 == taskId) {
					taskId = taskList.get(0).getId();
				}
				//TODO DRINGEND RECHTEABFRAGE
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllTasksAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllTaskAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum Anzeigen dieses Tasks!");
					}			
				}
				task = mainManager.getTaskManager().showTask(aktProject.getName(), taskId);
			}
			
			
			
			//setzen der Parameter
			req.setAttribute("taskList", taskList);
			req.setAttribute("task", task);
			
			req.setAttribute("isAllowedUpdateTaskAction", isAllowedUpdateTaskAction);
			req.setAttribute("isAllowedAddNewTaskAction", isAllowedAddNewTaskAction);
			req.setAttribute("isAllowedDeleteTaskAction", isAllowedDeleteTaskAction);
			
			req.setAttribute("contentFile", "showAllTasks.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
