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
 * Action, die beim Anzeigen der Info eines Users angesprochen wird.
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * loginName: request -> loginName
 * 
 * 
 * Rechteüberprüfung für GUI:
 * isAllowedShowUserSettings
 * 
 * Managermethoden:
 * showUserInfo
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=showUserInfo&loginName=loginName
 * 
 */
public class ShowUserInfoAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowUserInfoAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		boolean isAllowedShowUserSettings = true;
		User user=null;
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			//TODO DEBUGINFO
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String loginName = req.getParameter("loginName");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			try {
				/* Darf der User die UserSettings sehen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedShowUserSettingsAction(aktUser)){
					isAllowedShowUserSettings = false;			
				}
			} catch (ProjectException e) {
				isAllowedShowUserSettings = false;
				logger.info("isAllowedShowUserSettings NO!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowUserInfoAction(aktUser)){
				if(!aktUser.equals(loginName)){
					throw new ProjectException("Sie haben keine Rechte zum Anzeigen der UserInfo!");
				}
			}			

			//Manager in aktion
			user = mainManager.getUserManager().showUserInfo(loginName);
			
			//setzen der Parameter
			req.setAttribute("user", user);
			
			session.setAttribute("isAllowedShowUserSettings", isAllowedShowUserSettings);
			
			req.setAttribute("contentFile", "showUserInfo.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
