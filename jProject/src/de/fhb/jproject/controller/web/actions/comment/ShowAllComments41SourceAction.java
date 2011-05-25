package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.manager.MainControl;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class ShowAllComments41SourceAction extends HttpRequestActionBase {

	private MainControl _mainController;

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		//Controller holen
		_mainController=(MainControl) req.getSession().getAttribute("mainController");
		
//		try {
//			//Debugprint
//			DebugSystem.println(DebugSystem.LEVEL_ACTIONS,"Action: XXX_Action");
//			
//			//Controller in aktion
//			mainController.getUserController().login(req.getParameter("loginName"),req.getParameter("password"));
//			
//			//forwarden zum JSP
//			forward(req, resp, "/mainpage.jsp");
//
//		}catch (ProjectException e) {
//			
//			e.printStackTrace();			
//			errorforward(req, resp, e.getMessage());
//			
//		}catch (IOException e) {
//			
//			e.printStackTrace();
//            errorforward(req, resp, e.getMessage());
//			
//		}catch(NullPointerException e){
//			
//			e.printStackTrace();
//            errorforward(req, resp, e.getMessage());
//			
//		}
		
	}

}
