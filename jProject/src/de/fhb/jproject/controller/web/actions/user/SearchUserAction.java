package de.fhb.jproject.controller.web.actions.user;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action die angesprochen wird wenn eine User gesucht wird
 * 
 * STATUS:	NICHT FREIGEGEBEN 
 * URL: 	JProjectServlet?do=SearchUser&searchValue=ael!
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class SearchUserAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(SearchUserAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		
		HttpSession session = req.getSession();
		List <User> userList=null;
	
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");			
			
			try {
				//UserList holen
				userList = mainManager.getUserManager().searchUser((User)session.getAttribute("aktUser"),req.getParameter("searchValue"));
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			for( User user : userList){
				System.out.println("User: "+user.getLoginName());
			}

			//Daten dem Reqest mitgeben
			req.setAttribute("userList", userList);
			
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
