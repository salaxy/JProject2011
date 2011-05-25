package de.fhb.jproject.controller.web.actions.project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class ShowAllOwnProjectsAction extends HttpRequestActionBase {
	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(ShowAllOwnProjectsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		//Controller holen
		mainController=(MainControl) req.getSession().getAttribute("mainController");
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName") + ")"
					);
			
			//Controller in aktion			
			List<Project> list = mainController.getProjectContoller().showAllOwnProjects();
			for (Project aktProject : list) {
				System.out.println("Project: "+aktProject.getName());
			}
			
			//forwarden zum JSP
			forward(req, resp, "/showAllOwnProjects.jsp");

		}catch (ProjectException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch (IOException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}catch(NullPointerException e){
			
			e.printStackTrace();
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}
		
	}
}
