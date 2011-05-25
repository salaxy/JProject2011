package de.fhb.jproject.controller.web.actions.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class UpdateUserSettingsAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(UpdateUserSettingsAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		//Controller holen
		mainController=(MainControl) req.getSession().getAttribute("mainController");
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Controller in aktion
			mainController.getUserController().updateUserSettings(req.getParameter("nachname"), req.getParameter("vorname"), req.getParameter("neuIcq"),
					req.getParameter("neuSkype"), req.getParameter("neutelefon"), req.getParameter("sprache"), req.getParameter("neuesPasswortEins"),
					req.getParameter("neuesPasswortZwei"), req.getParameter("altesPasswort"));
			
			
			//forwarden zum JSP
			forward(req, resp, "/showUserSettings.jsp");

		}catch (ProjectException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch (IOException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}catch(NullPointerException e){
			
			e.printStackTrace();
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}
		
	}
}
