package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Member;
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
		
		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);	
					
			//Manager in aktion
			taskList=mainManager.getTaskManager().showAllTasks((User)session.getAttribute("aktUser"), req.getParameter("projectName"));
			
//			for( Task t : taskList){
//				System.out.println("Task: "+ t.getId()+" "+t.getTitel()+" "+t.getDone());
//			}		
			
			/*TODO METHODE IM CONTROLLER ERSTELLEN, KEINE ACTION ERSTELLEN
			ShowTaskAction showTaskAction = new ShowTaskAction();
			showTaskAction.perform(req, resp);
			 * 
			 */
			
			//setzen der Parameter
			req.setAttribute("taskList", taskList);
			
			req.setAttribute("contentFile", "showAllTasks.jsp");
			

		}catch (ProjectException e) {
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch(NullPointerException e){
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
