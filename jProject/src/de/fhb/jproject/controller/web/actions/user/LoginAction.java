package de.fhb.jproject.controller.web.actions.user;

import de.fhb.jproject.exceptions.ProjectException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.manager.MainControl;
import javax.servlet.http.HttpSession;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class LoginAction extends HttpRequestActionBase {


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
			logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName") + "), "
					+ "String password(" + req.getParameter("password") + ")"
					);
			
			//Controller in aktion
			synchronized(session){
				
				session.setAttribute("aktUser", mainController.getUserController().login(
						req.getParameter("loginName"),
						req.getParameter("password")));
			}
			
			//XXX syso entfernen
			System.out.println("Erfolgreich eingeloggt!");

		}catch (ProjectException e) {
			
			
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch(NullPointerException e){
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}
		synchronized(session){
			session.setAttribute("loggedIn", true);
		}
		
	}
}
