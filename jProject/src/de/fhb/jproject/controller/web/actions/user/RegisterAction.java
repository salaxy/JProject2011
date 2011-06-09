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
* Action die angesprochen wird wenn sich jemand sich registriert
* 
* STATUS:	FREIGEGEBEN konnte aber nicht testen
* URL: 		http://localhost:8080/jProject/JProjectServlet?do=Register&loginName=neuerUser&loginNameWdhl=neuerUser&passwort=passwort&passwortWdhl=passwort&nachname=Schmidt&vorname=Kurt
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
			/*TODO logger.debug("Parameter: "
					+ "String documentId(" + req.getParameter("documentId") + "), "
					+ "String inhalt(" + req.getParameter("inhalt") + ")"
					);
			*/
		
			
			try {
				//Manager in aktion
				mainManager.getUserManager().register(req.getParameter("loginName"), 
													  req.getParameter("passwort"), 
													  req.getParameter("passwortWdhl"), 
													  req.getParameter("nachname"), 
													  req.getParameter("vorname"));
	
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
		