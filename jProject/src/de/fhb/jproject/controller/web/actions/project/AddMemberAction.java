package de.fhb.jproject.controller.web.actions.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.user.ShowUserInfoAction;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 * 
 * STATUS: NICHT FREIGEGEBEN
 */
public class AddMemberAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(AddMemberAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String userLoginName(" + req.getParameter("userLoginName") + "), "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					+ "String projectName(" + req.getParameter("rolle") + ")"
					);
			
			//Controller holen
			mainController=(MainControl) req.getSession().getAttribute("mainController");
		
			//Controller in aktion
			mainController.getProjectContoller().addMember(req.getParameter("userLoginName"),
					req.getParameter("projectName"), req.getParameter("rolle"));
			
			//forwarden zum JSP
			forward(req, resp, "/AddMember.jsp");

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
