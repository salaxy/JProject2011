package de.fhb.jproject.controller.web.actions.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
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
			User aktUser = (User)session.getAttribute("aktUser");
			String loginName = req.getParameter("loginName");
			String passwort = req.getParameter("passwort");
			String passwortWdhl = req.getParameter("passwordWdhl");
			String nachname = req.getParameter("nachname");
			String vorname = req.getParameter("vorname");
			
			//TODO EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedRegisterAction(aktUser.getLoginName())){
					throw new ProjectException("Sie haben keine Rechte zum hinzufügen eines Users!");	
				}
				//Manager in aktion
				mainManager.getUserManager().register(aktUser, loginName, passwort, passwortWdhl, nachname, vorname);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			

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
		