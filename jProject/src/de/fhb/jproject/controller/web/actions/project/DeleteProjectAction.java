package de.fhb.jproject.controller.web.actions.project;

import java.io.IOException;

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
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 *
 *  STATUS: FREIGEGEBEN - ERFOLGREICH GETESTET
 *  
 *  http://localhost:8080/jProject/JProjectServlet?do=DeleteProject&projectName=Blubb
 */
public class DeleteProjectAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(DeleteProjectAction.class);

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
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);
			
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
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteProjectAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDeleteProjectAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");
					}			
				}
				//Manager in aktion
				mainManager.getProjectManager().deleteProject(aktUser, projectName);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			

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
