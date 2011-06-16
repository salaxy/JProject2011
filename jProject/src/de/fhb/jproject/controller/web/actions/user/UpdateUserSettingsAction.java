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
 * Action die angesprochen wird wenn eine User seine Daten aenderst
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=UpdateUserSettings&nachname=MeinNeuerNachname&vorname=MeinNeuerVorname&sprache=NeueSprache&neuesPasswortEins=pw&neuesPasswortZwei=pw&altesPasswort=password
 * drei parameter fehlen !! neuIcq, neuSkype, neutelefon
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class UpdateUserSettingsAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(UpdateUserSettingsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Parameter laden
			User aktUser = (User)session.getAttribute("aktUser");
			String loginName = req.getParameter("loginName"); 
			
			//TODO EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateUserSettingsAction(aktUser.getLoginName())){
					if(!aktUser.getLoginName().equals(loginName)){
						throw new ProjectException("Sie haben keine Rechte zum updaten der UserSettings!");
					}
				}			
				
				//Manager in aktion
				String[] neu ={"123","4567","789"};
				
				//Manager in aktion
//				mainManager.getUserManager().updateUserSettings((User)session.getAttribute("aktUser"), loginName, 
//																req.getParameter("nachname"), 
//																req.getParameter("vorname"), 
//																req.getParameter("neuIcq"), 
//																req.getParameter("neuSkype"), 
//																req.getParameter("neutelefon"), 
//																req.getParameter("sprache"), 
//																req.getParameter("neuesPasswortEins"), 
//																req.getParameter("neuesPasswortZwei"), 
//																req.getParameter("altesPasswort"));
				mainManager.getUserManager().updateUserSettings(aktUser, loginName, 
						null, 
						null, 
						neu, 
						null, 
						null, 
						"neueSprache", 
						null, 
						null, 
						null);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			//setzen der Parameter
			
			req.setAttribute("contentFile", "showUserSettings.jsp");
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
