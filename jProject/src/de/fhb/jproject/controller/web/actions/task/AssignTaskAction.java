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
					+ "int taskId(" + req.getParameter("taskId") + ")"
					+ "String loginName(" + req.getParameter("userLoginName") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String loginName = req.getParameter("loginName");
			int taskId = 0;
			try {
				taskId = Integer.valueOf(req.getParameter("taskId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte TaskID nicht entziffern! ", e);
				throw new ProjectException("Ungültige TaskID!");
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getProjectRolesManager().isAllowedAssignTaskAction(aktUser, aktProject.getName())){
				throw new ProjectException("Sie haben keine Rechte zum vergeben von Tasks!");
			}			

			if(loginName.equals("")){
				throw new ProjectException("Bitte wählen sie einen Member aus.");
			}
			//Manager in aktion
			mainManager.getTaskManager().assignTask(loginName, aktProject.getName(), taskId);
			
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
