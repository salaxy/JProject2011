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
 * 
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
		Project project = null;
		String projectName = "";
		
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		
		try {
		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Manager in aktion
			try {
				projectList=mainManager.getProjectManager().showAllProjects((User)session.getAttribute("aktUser"));
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			try{
				//Wenn projectName == null dann gib mir den ersten
				if (null == req.getParameter("projectName")) {
					projectName = projectList.get(0).getName();
				}else{
					projectName = req.getParameter("projectName");
				}
			} catch (IllegalArgumentException e) {
				throw new ProjectException("ProjectName ungültig "+e);
			}catch(NullPointerException e){
				logger.error("Keine Projekte vorhanden!"+e.getMessage(), e);
			}
			
			try {
				project = mainManager.getProjectManager().showProject((User)session.getAttribute("aktUser"),
						 projectName);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			/*
			for( Project p : projectList){
				System.out.println("Project: "+p.getName());
			}		
			*/
			//setzen der Parameter
			req.setAttribute("projectList", projectList);
			req.setAttribute("project", project);
			
			
			req.setAttribute("contentFile", "showAllProjects.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
