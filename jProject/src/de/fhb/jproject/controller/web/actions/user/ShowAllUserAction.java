package de.fhb.jproject.controller.web.actions.user;

import de.fhb.jproject.commons.exceptions.ProjectException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.jproject.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.manager.MainControl;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class ShowAllUserAction extends HttpRequestActionBase {

	private MainControl _mainController;
	private static final Logger _logger = Logger.getLogger(ShowAllUserAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		
		List <User> userList=null;
	
		//Controller holen
		_mainController=(MainControl) req.getSession().getAttribute("mainController");
		
		try {
			
			//Debugprint
			_logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");			
			
			//UserList holen
			userList=_mainController.getUserController().showAllUser();
			
//			for( User user : userList){
//				System.out.println("User: "+user.getLoginName());
//			}

			//Daten dem Reqest mitgeben
			req.setAttribute("userList", userList);
			
			//forwarden zum JSP
			forward(req, resp, "ShowAllUser.jsp");

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
