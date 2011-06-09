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
 * Action die angesprochen wird wenn eine User gesucht wird
 * 
 * STATUS:	NICHT FREIGEGEBEN 
 * URL: 	JProjectServlet?do=UpdateUserSettings&nachname=MeinNeuerNachname
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
			
			try {
				//Manager in aktion
				mainManager.getUserManager().updateUserSettings((User)session.getAttribute("aktUser"), 
																req.getParameter("nachname"), 
																req.getParameter("vorname"), 
																req.getParameter("neuIcq"), 
																req.getParameter("neuSkype"), 
																req.getParameter("neutelefon"), 
																req.getParameter("sprache"), 
																req.getParameter("neuesPasswortEins"), 
																req.getParameter("neuesPasswortZwei"), 
																req.getParameter("altesPasswort"));

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
