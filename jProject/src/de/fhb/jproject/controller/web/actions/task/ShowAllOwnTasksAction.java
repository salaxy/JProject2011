package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * Aktion die ausgefuehrt wird, wenn die eigenen Tasks/Aufgaben
 * zu einem Projekt in dem der User teilnimmt angezeigt werden sollen
 * 
 * STATUS:	NICHT FREIGEGEBEN
 * URL:		JProjectServlet?do=ShowAllOwnTasks&projectName=ProjectName
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
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		List<Task> taskList=null;
		
		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			try {
				taskList=mainManager.getTaskManager().showAllOwnTasks((User)session.getAttribute("aktUser"));
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			//Manager in aktion
			
//			for( Task t : taskList){
//				System.out.println("Task: "+ t.getId()+" "+t.getTitel()+" "+t.getDone());
//			}	
			
			//setzen der Parameter
			req.setAttribute("taskList", taskList);
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
