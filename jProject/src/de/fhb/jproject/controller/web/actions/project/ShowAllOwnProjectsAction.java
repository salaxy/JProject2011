package de.fhb.jproject.controller.web.actions.project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;



/**
 * Action, die beim Anzeigen aller eigenen Projekte angesprochen wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * Managermethoden:
 * showAllOwnProjects
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=ShowAllOwnProjects
 * 
 */
public class ShowAllOwnProjectsAction extends HttpRequestActionBase {
	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllOwnProjectsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		MemberSetCollection ownProjectList = null;
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
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllOwnProjectsAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Projecte dieses Users!");		
			}
			//Manager in aktion
			ownProjectList = mainManager.getProjectManager().showAllOwnProjects(aktUser);
			
			
			req.setAttribute("ownProjectList", ownProjectList.getCollection());
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
