package de.fhb.jproject.controller.web.actions.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;
import javax.servlet.http.HttpSession;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * STATUS: FREIGEGEBEN - ERFOLGREICH GETESTET
 * 
 * http://localhost:8080/jProject/JProjectServlet?do=ShowAllProjects
 */
public class ShowAllProjectsAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(ShowAllProjectsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();
		//Controller holen
		mainController=(MainControl) session.getAttribute("mainController");
		List<Project> projectList=null;
		
		try {		
			//Controller holen
			mainController=(MainControl) req.getSession().getAttribute("mainController");
		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Controller in aktion
			projectList=mainController.getProjectContoller().showAllProjects((User)session.getAttribute("aktUser"));
			
			for( Project p : projectList){
				System.out.println("Project: "+p.getName());
			}		
			
			//setzen der Parameter
			req.setAttribute("projectList", projectList);
			
			//forwarden zum JSP
			forward(req, resp, "/showAllProjects.jsp");

		}catch (ProjectException e) {
			
			
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch (IOException e) {
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}catch(NullPointerException e){
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}
		
	}
}
