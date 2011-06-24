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
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		
		HttpSession session = req.getSession();		
		List<Task> taskList=null;
		Task task = null;
		
		boolean isAllowedShowAllOwnTasks = true;
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String loginName = (String) req.getParameter("loginName");
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
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllOwnTasksAction(aktUser)){
				//RECHTE-ABFRAGE Eigner
				if(!aktUser.equals(loginName)){
					//throw new ProjectException("Sie haben keine Rechte zum Anzeigen dieser Tasks!");
					isAllowedShowAllOwnTasks = false;
				}
			}
			if(isAllowedShowAllOwnTasks){
				//Manager in aktion
				taskList = mainManager.getTaskManager().showAllOwnTasks(loginName);
				if(!taskList.isEmpty()){
					//Wenn taskId == null dann gib mir den ersten
					if (0 == taskId) {
						taskId = taskList.get(0).getId();
					}
					//TODO DRINGEND RECHTEABFRAGE ShowTask
					if(!mainManager.getGlobalRolesManager().isAllowedShowAllTasksAction(aktUser)){
						//RECHTE-ABFRAGE Projekt
						if(!mainManager.getProjectRolesManager().isAllowedShowAllTasksAction(aktUser, aktProject.getName())){
							throw new ProjectException("Sie haben keine Rechte zum Anzeigen dieses Tasks!");
						}			
					}

					task = mainManager.getTaskManager().showTask(taskId);
				}
			}
			
				
			//setzen der Parameter
			req.setAttribute("taskList", taskList);
			req.setAttribute("task", task);
			
			req.setAttribute("isAllowedShowAllOwnTasks", isAllowedShowAllOwnTasks);
			
			req.setAttribute("contentFile", "showAllOwnTasks.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
