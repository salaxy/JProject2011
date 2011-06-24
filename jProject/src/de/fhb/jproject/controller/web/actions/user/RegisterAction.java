package de.fhb.jproject.controller.web.actions.user;

import de.fhb.commons.CheckString;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
* Action die angesprochen wird wenn jemand als User registriert wird (vom Admin beispielsweise)
* 
* STATUS:	NICHT FREIGEGEBEN 
* URL: 		do=Register&loginName=neuerUser&passwort=passwort&passwortWdhl=passwort&nachname=Schmidt&vorname=Kurt
* @author  	Andy Klay <klay@fh-brandenburg.de>
*/
public class RegisterAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(RegisterAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		
		HttpSession session = req.getSession();
		CheckString check = new CheckString();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName") + "), "
					+ "String passwort(" + req.getParameter("passwort") + ")"
					+ "String passwortWdhl(" + req.getParameter("passwortWdhl") + ")"
					+ "String nachname(" + req.getParameter("nachname") + ")"
					+ "String vorname(" + req.getParameter("vorname") + ")"
					);
		
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String loginName = req.getParameter("loginName").toLowerCase();
			String passwort = req.getParameter("passwort");
			String passwortWdhl = req.getParameter("passwortWdhl");
			String nachname = req.getParameter("nachname");
			String vorname = req.getParameter("vorname");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			check.checkIT("Loginname",loginName);
			check.checkIT("Vorname",vorname);
			check.checkIT("Nachname",nachname);
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedRegisterAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Hinzufügen eines Users!");	
			}
			//Manager in aktion
			mainManager.getUserManager().register(loginName, passwort, passwortWdhl, nachname, vorname);
			
			try {
				String[] param = new String[1];
				param[0] = "loginName="+loginName;
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "OpenAdminconsole", null);
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
		