package de.fhb.jproject.controller.web.actions.user;

import de.fhb.commons.HashIt;
import de.fhb.jproject.exceptions.ProjectException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.manager.MainManager;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpSession;


/**
 * Action, die beim Login eines Users angesprochen wird.
 * 
 * Parameter: 
 * loginName des Accounts: request -> loginname
 * password des Accounts: request -> password
 * 
 * Rechteüberprüfung für GUI:
 * isAllowedOpenAdminconsoleAction
 * 
 * 
 * Managermethoden:
 * login
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=Login&loginName=Bert&password=berta
 * 
 */
public class LoginAction extends HttpRequestActionBase {


	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager = new MainManager()/*(MainManager) session.getAttribute("mainManager")*/;
		User user = null;
		HashIt hash = new HashIt();

		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName") + "), "
					+ "String password(" + req.getParameter("password") + ")"
					);
			
			String loginName = req.getParameter("loginName").toLowerCase();
			String password = req.getParameter("password");
			
			
			//TODO EINGABE CHECKEN
			
			try {
				/* TODO zufälligen Salt aus der Datenbank lesen */
				password = hash.calcSHA1(password);
				System.out.println("Password: "+password);
			} catch (NoSuchAlgorithmException ex) {
				logger.error("Konnte Algorithmus zum hashen nicht finden.", ex);
				throw new ProjectException("Konnte Algorithmus zum hashen nicht finden.");
			} catch (UnsupportedEncodingException ex) {
				logger.error("Konnte Password nicht encodieren.", ex);
				throw new ProjectException("Konnte Password nicht encodieren.");
			} 
			
			
			//Manager in aktion
			user = mainManager.getUserManager().login(loginName, password);
			synchronized(session){

				session.setAttribute("aktUser", user.getLoginName());
				session.setAttribute("mainManager", mainManager);

				
				//RECHTE-ABFRAGE Global
				if(mainManager.getGlobalRolesManager().isAllowedOpenAdminconsoleAction(loginName)){
					session.setAttribute("isAdmin", true);
				}
			}
			
			logger.debug("Erfolgreich eingeloggt!");
			req.setAttribute("triedLogin", false);
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("triedLogin", true);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
