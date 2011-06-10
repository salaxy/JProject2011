package de.fhb.jproject.controller.web.actions.user;

import java.io.IOException;

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
* Action die angesprochen wird wenn sich jemand Informationen ueber einen Andern user anschauen will
* 
* STATUS:	FREIGEGEBEN 
* URL: 		
* @author  	Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowUserInfoAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowUserInfoAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		User user=null;
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			try {
				//Manager in aktion
				user =mainManager.getUserManager().showUserInfo((User)session.getAttribute("aktUser"), 
																req.getParameter("loginName"));

			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
				
			//setzen der Parameter
			req.setAttribute("user", user);
			req.setAttribute("contentFile", "showUserInfo.jsp");
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
