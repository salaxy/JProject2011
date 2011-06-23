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
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * UNUSED
 * Action die angesprochen wird wenn alle Projekte angezeigt werden sollen
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	http://localhost:8080/jProject/JProjectServlet?do=ShowAllProjects
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowAllProjectsAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllProjectsAction.class);
	

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();		
		List<Project> projectList=null;
		//Project project = null;
		
		
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		
		try {
		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
				
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String projectName = req.getParameter("projectName");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllProjectsAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum anzeigen aller Projekte!");
			}
			//Manager in aktion
			projectList=mainManager.getProjectManager().showAllProjects();
			
			//setzen der Parameter
			req.setAttribute("projectList", projectList);
			//req.setAttribute("project", project);
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
