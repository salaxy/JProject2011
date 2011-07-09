package de.fhb.jproject.controller.web.actions.task;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;



/**
 * Action die angesprochen wird, wenn alle Aufgaben eines Projektes angezeigt werden sollen
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * taskId(Id des Tasks): request -> taskId
 * 
 * 
 * Rechteüberprüfung für GUI:
 * isAllowedUpdateTaskAction,
 * isAllowedAddNewTaskAction,
 * isAllowedDeleteTaskAction,
 * isAllowedShowAllMemberAction,
 * isAllowedAssignTaskAction,
 * isAllowedDeAssignTaskAction
 * 
 * Managermethoden:
 * showAllTasks
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=ShowAllTasks&taskId=0
 * 
 */
public class ShowAllTasksAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllTasksAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		List<Task> taskList=null;
		Task task = null;
		
		boolean isAllowedUpdateTaskAction = true;
		boolean isAllowedAddNewTaskAction = true;
		boolean isAllowedDeleteTaskAction = true;
		boolean isAllowedShowAllMemberAction = true;
		boolean isAllowedAssignTaskAction = true;
		boolean isAllowedDeAssignTaskAction = true;
		MemberSetCollection memberSet = null;
		Set memberSetDiff = null;
		Set taskMemberSet = null;
		
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
			
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllTasksAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowAllTasksAction(aktUser, aktProject.getName())){
					if (!mainManager.getProjectRolesManager().isMember(aktUser, aktProject.getName())) {
						throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Tasks dieses Projektes!");
					}
				}			
			}
			//Manager in aktion
			taskList=mainManager.getTaskManager().showAllTasks(aktProject.getName());
			
			
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser, aktProject.getName())){
						isAllowedShowAllMemberAction = false;
						logger.info("isAllowedShowAllMemberAction NO!");
					}			
				}

			} catch (ProjectException e) {
				isAllowedShowAllMemberAction = false;
				logger.info("isAllowedShowAllMemberAction NO!");
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
				isAllowedDeleteTaskAction = false;
				logger.info("isAllowedDeleteTaskAction NO!");
			}
			
			
			try {
				/* Darf der User Task updaten? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedUpdateTaskAction(aktUser, aktProject.getName())){
						isAllowedUpdateTaskAction = false;
						logger.info("isAllowedUpdateTaskAction NO!");
					}			
				}
			} catch (ProjectException e) {
				isAllowedUpdateTaskAction = false;
				logger.info("isAllowedUpdateTaskAction NO!");
			}
			
			try {
				/* Darf der User Task erstellen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedAddNewTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedAddNewTaskAction(aktUser, aktProject.getName())){
						isAllowedAddNewTaskAction = false;
						logger.info("isAllowedAddNewTaskAction NO!");
					}			
				}
			} catch (ProjectException e) {
				isAllowedAddNewTaskAction = false;
				logger.info("isAllowedAddNewTaskAction NO!");
			}
			try {
				/* Darf der User Task anhängen? (für GUI-Anzeige) */
				if(!mainManager.getProjectRolesManager().isAllowedAssignTaskAction(aktUser, aktProject.getName())){
					isAllowedAssignTaskAction = false;
					logger.info("isAllowedAssignTaskAction NO!");
				}
			} catch (ProjectException e) {
				isAllowedAssignTaskAction = false;
				logger.info("isAllowedAssignTaskAction NO!");
			}
			
			try {
				/* Darf der User Task ablösen? (für GUI-Anzeige) */
				if(!mainManager.getProjectRolesManager().isAllowedDeAssignTaskAction(aktUser, aktProject.getName())){
					isAllowedDeAssignTaskAction = false;
					logger.info("isAllowedDeAssignTaskAction NO!");
				}
			} catch (ProjectException e) {
				isAllowedDeAssignTaskAction = false;
				logger.info("isAllowedDeAssignTaskAction NO!");
			}
			
			if (!taskList.isEmpty()) {
				//Wenn taskId == null dann gib mir den ersten
				if (0 == taskId) {
					taskId = taskList.get(0).getId();
				}
				//RECHTE-ABFRAGE Global
				if(!mainManager.getGlobalRolesManager().isAllowedShowTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowTaskAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum Anzeigen dieses Tasks!");
					}			
				}
				
				if (isAllowedShowAllMemberAction) {
					memberSet = mainManager.getProjectManager().showAllMember(aktProject.getName());
					memberSet.size();
				}
				
				task = mainManager.getTaskManager().showTask(taskId);
				
				if (isAllowedShowAllMemberAction) {
					taskMemberSet = task.memberUser.getCollection();

					if(isAllowedAssignTaskAction){
						memberSetDiff = memberSet.getCollection();
						if (!taskMemberSet.isEmpty()) {
							memberSetDiff.removeAll(taskMemberSet);
						}
					}
				}
			}
			
			
			
			
			//setzen der Parameter
			req.setAttribute("taskList", taskList);
			req.setAttribute("task", task);
			req.setAttribute("memberList", memberSetDiff);
			req.setAttribute("taskMemberList", taskMemberSet);
			
			req.setAttribute("isAllowedUpdateTaskAction", isAllowedUpdateTaskAction);
			req.setAttribute("isAllowedAddNewTaskAction", isAllowedAddNewTaskAction);
			req.setAttribute("isAllowedDeleteTaskAction", isAllowedDeleteTaskAction);
			req.setAttribute("isAllowedShowAllMemberAction", isAllowedShowAllMemberAction);
			req.setAttribute("isAllowedAssignTaskAction", isAllowedAssignTaskAction);
			req.setAttribute("isAllowedDeAssignTaskAction", isAllowedDeAssignTaskAction);
			
			
			req.setAttribute("contentFile", "showAllTasks.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
