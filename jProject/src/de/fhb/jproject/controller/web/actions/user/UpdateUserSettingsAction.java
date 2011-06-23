package de.fhb.jproject.controller.web.actions.user;

import de.fhb.commons.CheckString;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
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
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		CheckString check = new CheckString();
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String loginName = req.getParameter("loginName"); 
			
			String nachname = req.getParameter("nachname");
			String vorname = req.getParameter("vorname");
			/*req.getParameter("neuIcq")*/
			/*req.getParameter("neuSkype")*/
			/*req.getParameter("neutelefon")*/
			String sprache = req.getParameter("sprache");
			String pw1 = req.getParameter("neuesPasswortEins");
			String pw2 = req.getParameter("neuesPasswortZwei");
			/*req.getParameter("altesPasswort")*/
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedUpdateUserSettingsAction(aktUser)){
				if(!aktUser.equals(loginName)){
					throw new ProjectException("Sie haben keine Rechte zum updaten der UserSettings!");
				}
			}
			check.checkIT("Nachname",nachname);
			check.checkIT("Vorname",vorname);
			check.checkIT("Sprache",sprache);
			
			//Manager in aktion
			mainManager.getUserManager().updateUserSettings(loginName, 
															nachname, 
															vorname, 
															/*req.getParameter("neuIcq")*/null, 
															/*req.getParameter("neuSkype")*/null, 
															/*req.getParameter("neutelefon")*/null, 
															sprache, 
															pw1, 
															pw2/*, 
															req.getParameter("altesPasswort")*/);

			
			//setzen der Parameter
			
			try {
				String[] param = new String[1];
				param[0] = "loginName="+loginName;
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowUserSettings", param);
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
