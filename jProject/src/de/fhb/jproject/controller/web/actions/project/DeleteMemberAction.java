package de.fhb.jproject.controller.web.actions.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;

/**
 * Action, die beim Löschen eines Members angesprochen wird
 *  <br/> <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * userLoginName(loginname eines Users der Member ist): request -> userLoginName <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * deleteMember <br/>
 *  <br/>
 * Beispiel-Aufruf: <br/>
 * do=DeleteMember&userLoginName=karl <br/>
 *  <br/>
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class DeleteMemberAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(DeleteMemberAction.class);

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
					+ "String loginName(" + req.getParameter("loginName") + "), "
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String loginName = req.getParameter("loginName");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedDeleteMemberAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedDeleteMemberAction(aktUser, aktProject.getName())){
					if (!aktUser.equals(loginName)) {
						System.out.println("loginName: "+loginName);
						throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");
					}	
				}			
			}
			//Manager in aktion
			mainManager.getProjectManager().deleteMember(aktUser, loginName, aktProject.getName(), mainManager.getGlobalRolesManager());
			
			try {
				String[] param = new String[1];
				param[0] = "projectName="+aktProject.getName();
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowProject", param);
			} catch (IOException e) {
				logger.error("Konnte Redirect nicht ausführen! "+e.getMessage(), e);
				throw new ProjectException("Konnte Redirect nicht ausführen!");
			}
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
