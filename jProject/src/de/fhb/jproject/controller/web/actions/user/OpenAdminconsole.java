package de.fhb.jproject.controller.web.actions.user;

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
 * URL: 	http://localhost:8080/jProject/AdminServlet?do=OpenAdminconsole
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class OpenAdminconsole extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(OpenAdminconsole.class);
	

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();		
		List<Project> projectList = null;
		List<User> userList = null;
		boolean isAllowedRegister = true;
		
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		
		try {
		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
				
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllProjectsAction(aktUser)){
					throw new ProjectException("Sie haben keine Rechte zum anzeigen aller Projekte!");
				}
				//Manager in aktion
				projectList=mainManager.getProjectManager().showAllProjects();
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllUserAction(aktUser)){
					throw new ProjectException("Sie haben keine Rechte zum anzeigen aller User!");	
				}
				//Manager in aktion
				userList=mainManager.getUserManager().showAllUser();
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			try{
				/* Darf der User Member löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedRegisterAction(aktUser)){
					isAllowedRegister = false;			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedDeleteMemberAction NO!");
			}
			
			/*
			for( Project p : projectList){
				System.out.println("Project: "+p.getName());
			}		
			*/
			//setzen der Parameter
			req.setAttribute("anzProjects", projectList.size());
			req.setAttribute("anzUser", userList.size());
			//req.setAttribute("project", project);
			
			session.setAttribute("isAllowedRegister", isAllowedRegister);
			
			
			req.setAttribute("contentFile", "adminoverview.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}