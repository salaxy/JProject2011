package de.fhb.jproject.controller.web.actions.project;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class SearchProjectsAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(SearchProjectsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		
		HttpSession session = req.getSession();		
		List<Project> projectList=null;
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {
		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Manager in aktion
			projectList=mainManager.getProjectManager().searchProjects((User)session.getAttribute("aktUser"),req.getParameter("searchValue"));
			
			for( Project p : projectList){
				System.out.println("Project: "+p.getName());
			}		
			
			//setzen der Parameter
			req.setAttribute("projectList", projectList);
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch(NullPointerException e){
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
