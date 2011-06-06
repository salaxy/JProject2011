package de.fhb.jproject.controller.web.actions.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class RegisterAction extends HttpRequestActionBase {


	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();
		//Controller holen
		mainController=(MainControl) session.getAttribute("mainController");
		

		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Controller in aktion
			mainController.getUserController().register();
			
			
			//forwarden zum JSP
			//TODO syso entfernen
			System.out.println("Erfolgreich registriert!");
			forward(req, resp, "/index.jsp");

		}catch (ProjectException e) {
			
			
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch (IOException e) {
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}catch(NullPointerException e){
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}
		
		
	}
}
