package de.fhb.jproject.controller.web.actions.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.CheckString;
import de.fhb.commons.HashIt;
import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action, die beim Ändern von Settings eines Users angesprochen wird.
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * loginName: request -> loginName
 * nachname: request -> nachname
 * vorname: request -> vorname
 * neuesPasswortEins: request -> neuesPasswortEins
 * neuesPasswortZwei: request -> neuesPasswortZwei
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * Managermethoden:
 * updateUserSettings
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=updateUserSettings&loginName=neuerUser&nachname=Schmidt&vorname=Kurt&neuesPasswortEins=bla&neuesPasswortZwei=bla
 * 
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
		CheckString checkString = new CheckString();
		HashIt hash = new HashIt();
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
			String passwort = req.getParameter("neuesPasswortEins");
			String passwortWdhl = req.getParameter("neuesPasswortZwei");
			/*req.getParameter("altesPasswort")*/
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedUpdateUserSettingsAction(aktUser)){
				if(!aktUser.equals(loginName)){
					throw new ProjectException("Sie haben keine Rechte zum Updaten der UserSettings!");
				}
			}
			checkString.checkString("Nachname",nachname);
			checkString.checkString("Vorname",vorname);
			checkString.checkString("Sprache",sprache);
			checkString.checkPassword(passwort, passwortWdhl);
			
			try {
				/* TODO zufälligen Salt aus der Datenbank lesen */
				passwort = hash.calcSHA1(passwort);
			} catch (NoSuchAlgorithmException ex) {
				logger.error("Konnte Algorithmus zum hashen nicht finden.", ex);
				throw new ProjectException("Konnte Algorithmus zum hashen nicht finden.");
			} catch (UnsupportedEncodingException ex) {
				logger.error("Konnte Password nicht encodieren.", ex);
				throw new ProjectException("Konnte Password nicht encodieren.");
			} 
			
			//Manager in aktion
			mainManager.getUserManager().updateUserSettings(loginName, 
															nachname, 
															vorname, 
															/*req.getParameter("neuIcq")*/null, 
															/*req.getParameter("neuSkype")*/null, 
															/*req.getParameter("neutelefon")*/null, 
															sprache, 
															passwort/*, 
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
