package de.fhb.jproject.controller.web.actions.user;

import java.io.IOException;
import java.util.List;

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
 * Action, die beim Anzeigen aller User angesprochen wird.
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * 
 * 
 * Rechteüberprüfung für GUI:
 * isAllowedDeleteUserAction
 * 
 * Managermethoden:
 * showAllUser
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=showAllUser
 * 
 */
public class ShowAllUserAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllUserAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		
		List <User> userList = null;
		User user = null;
		
		boolean isAllowedDeleteUserAction = true;
	
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");			
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			//String loginName = req.getParameter("loginName");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllUserAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller User!");	
			}
			//Manager in aktion
			userList=mainManager.getUserManager().showAllUser();
			
			try {
				/* Darf dieser User User löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteUserAction(aktUser)){
					logger.info("isAllowedDeleteUserAction NO!");
					isAllowedDeleteUserAction = false;
				}
			} catch (ProjectException e) {
				isAllowedDeleteUserAction = false;
				logger.info("isAllowedDeleteUserAction NO!");
			}
			req.setAttribute("userList", userList);
			
			req.setAttribute("isAllowedDeleteUserAction", isAllowedDeleteUserAction);
			
			req.setAttribute("contentFile", "showAllUser.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
