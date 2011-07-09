package de.fhb.jproject.controller.web.actions.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;


/**
 * Action, die beim Anzeigen der Settings eines Users angesprochen wird. <br/>
 *  <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * loginName: request -> loginName <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * isAllowedUpdateUserSettings <br/>
 *  <br/>
 * Managermethoden: <br/>
 * showUserSettings <br/>
 *  <br/>
 *  Beispiel-Aufruf: <br/>
 * do=showUserSettings&loginName=loginName <br/>
 *  <br/>
 *  
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de> 
 */
public class ShowUserSettingsAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowUserSettingsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		boolean isAllowedUpdateUserSettings = true;
		User user = null;
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String loginName = req.getParameter("loginName");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			try {
				/* Darf der User die UserSettings bearbeiten? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateUserSettingsAction(aktUser)){
					if(!aktUser.equals(loginName)){
						isAllowedUpdateUserSettings = false;
					}
				}
			} catch (ProjectException e) {
				isAllowedUpdateUserSettings = false;
				logger.info("isAllowedUpdateUserSettings NO!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowUserSettingsAction(aktUser)){
				if(!aktUser.equals(loginName)){
					throw new ProjectException("Sie haben keine Rechte zum Anzeigen der UserSettings!");
				}
			}			

			//Manager in aktion
			user = mainManager.getUserManager().showUserSettings(loginName);
			
			//setzen der Parameter
			req.setAttribute("user", user);
			
			session.setAttribute("isAllowedUpdateUserSettings", isAllowedUpdateUserSettings);
			
			req.setAttribute("contentFile", "showUserSettings.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
