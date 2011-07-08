package de.fhb.jproject.controller.web.actions.project;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import org.apache.log4j.Level;

/**
 * Action, die beim Suchen von Projekten angesprochen wird
 * (UNUSED)
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * searchValue(Teil einer Bezeichnung eines gesuchten Projektes): request -> searchValue
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * 
 * Managermethoden:
 * searchProjects
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=SearchProjects&searchValue=a
 * 
 */
public class SearchProjectsAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(SearchProjectsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		
		HttpSession session = req.getSession();		
		List<Project> projectList=null;
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {
		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			//TODO DEBUGINFO
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String searchValue = req.getParameter("searchValue");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedSearchProjectsAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");		
			}
			//Manager in aktion
			projectList=mainManager.getProjectManager().searchProjects(searchValue);
			
			//DEBUG Testausgabe
			if(logger.getLevel()==Level.DEBUG){
				for( Project p : projectList){
					logger.debug("Project: "+p.getName());
				}
			}
			//TODO PARAMETERÜBERGABE

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
