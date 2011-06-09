package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.project.AddMemberAction;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * Action die angesprochen wird, wenn einem Member ein Task/Aufgabe zugewiesen wird
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=AssignTask&projectName=ProjectName&userLoginName=karl&taskId=5 
 * @author  Andy Klay <klay@fh-brandenburg.de> 
 */
public class AssignTaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AssignTaskAction.class);

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
					+ "int taskId(" + req.getParameter("taskId") + ")"
					+ "String userLoginName(" + req.getParameter("userLoginName") + ")"
					);
			
			try{
				//Manager in aktion
				mainManager.getTaskManager().assignTask((User)session.getAttribute("aktUser"), 
															  req.getParameter("userLoginName"), 
															  req.getParameter("projectName") ,  
															  Integer.valueOf(req.getParameter("taskId")));
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}/*TODO IllegalArgumentE*/
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
