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
import javax.servlet.http.HttpSession;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * STATUS: FREIGEGEBEN - ERFOLGREICH GETESTET
 */
public class AddMemberAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(AddMemberAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		HttpSession session = req.getSession();
		//Controller holen
		mainController=(MainControl) session.getAttribute("mainController");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String userLoginName(" + req.getParameter("userLoginName") + "), "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					+ "String projectName(" + req.getParameter("rolle") + ")"
					);
			
			//Controller in aktion
			mainController.getProjectContoller().addMember((User)session.getAttribute("aktUser"), 
														   req.getParameter("userLoginName"), 
														   req.getParameter("projectName"), 
														   req.getParameter("rolle"));
			

		}catch (ProjectException e) {
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jspf");
			req.setAttribute("errorString", e.getMessage());
		}catch(NullPointerException e){
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jspf");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
