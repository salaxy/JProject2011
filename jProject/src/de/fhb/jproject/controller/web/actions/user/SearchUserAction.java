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
 * Action, die beim Suchen eines Users angesprochen wird. <br/>
 * (UNUSED) <br/>
 *  <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * searchValue: request -> searchValue <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * Managermethoden: <br/>
 * searchUser <br/>
 *  <br/>
 *  Beispiel-Aufruf: <br/>
 * do=searchUser&searchValue=loginName <br/>
 *  <br/>
 *  
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
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
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String searchValue = req.getParameter("searchValue");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedDeleteUserAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Hinzufügen eines Tasks!");	
			}
			//Manager in aktion
			userList = mainManager.getUserManager().searchUser(searchValue);
			
			
			//Daten dem Reqest mitgeben
			req.setAttribute("userList", userList);
			
			//setzen der Parameter
			req.setAttribute("userList", userList);
			req.setAttribute("contentFile", "content.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
