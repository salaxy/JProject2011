package de.fhb.jproject.controller.web.actions.user;

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
 * Action, die beim Öffnen der AdminConsole angesprochen wird.
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * 
 * Rechteüberprüfung für GUI:
 * isAllowedRegister
 * 
 * 
 * Managermethoden:
 * showAllProjects
 * showAllUser
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=OpenAdminconsole
 * 
 */
public class OpenAdminconsole extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(OpenAdminconsole.class);
	

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
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
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllProjectsAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Projekte!");
			}
			//Manager in aktion
			projectList=mainManager.getProjectManager().showAllProjects();
			
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllUserAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller User!");	
			}
			//Manager in aktion
			userList=mainManager.getUserManager().showAllUser();
			
			try{
				/* Darf der User Member löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedRegisterAction(aktUser)){
					isAllowedRegister = false;	
				}
			} catch (ProjectException e) {
				isAllowedRegister = false;
				logger.info("isAllowedDeleteMemberAction NO!");
			}
			
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
		}
	}
}
