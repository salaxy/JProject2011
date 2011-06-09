package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.project.DeleteMemberAction;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * Action die aufgerufen wird wenn ein Task geloescht werden soll
 * 
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * STATUS: FREIGEGEBEN - ERFOLGREICH GETESTET
 *  
 * URL BEISPIEL: JProjectServlet?do=DeleteTask&projectName=ProjectName&taskId=2
 *  
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class DeleteTaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(DeleteTaskAction.class);

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
					+ "int taskId(" + req.getParameter("taskId") + "), "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);
			
			try{
				//Manager in aktion
				mainManager.getTaskManager().deleteTask((User)session.getAttribute("aktUser"), 
															  Integer.valueOf(req.getParameter("taskId")), 
															  req.getParameter("projectName"));
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
