package de.fhb.jproject.controller.web.actions.user;

import de.fhb.jproject.commons.exceptions.ProjectException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.jproject.commons.web.HttpRequestActionBase;
import de.fhb.jproject.manager.MainControl;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class DeleteUserAction extends HttpRequestActionBase {

	private MainControl _mainController;
	private static final Logger _logger = Logger.getLogger(DeleteUserAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)throws ServletException {
				
		//Controller holen
		_mainController=(MainControl) req.getSession().getAttribute("mainController");
		
		try {
			
			//Debugprint
			_logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			_logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName") + ")"
					);
			
			//Controller in aktion			
			_mainController.getUserController().deleteUser(req.getParameter("loginName"));
			
			//forwarden zum JSP
			forward(req, resp, "/userGeloescht.jsp");

		}catch (ProjectException e) {
			
			e.printStackTrace();
			_logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch (IOException e) {
			
			e.printStackTrace();
			_logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}catch(NullPointerException e){
			
			e.printStackTrace();
			_logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
			
		}
		
		
	}
}
