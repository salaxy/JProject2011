package de.fhb.jproject.controller.web.actions.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.manager.MainManager;


/**
 * Action, die beim Logout eines Users angesprochen wird. <br/>
 *  <br/>
 * Parameter:  <br/>
 * keine <br/>
 *  <br/>
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * logout <br/>
 *  <br/>
 *  Beispiel-Aufruf: <br/>
 * do=Logout <br/>
 *  <br/>
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de> 
 */
public class LogoutAction extends HttpRequestActionBase {

	
	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(LoginAction.class);
//	private JProjectBO logic;

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
			
			//Manager in aktion
			mainManager.getUserManager().logout();
			synchronized(session){
				session.setAttribute("mainManager", null);
				session.setAttribute("loggedIn", null);
				session.setAttribute("aktUser", null);
				session.invalidate();
			}
			
			logger.debug("Erfolgreich ausgeloggt!");

		}catch(NullPointerException e){
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
