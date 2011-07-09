package de.fhb.jproject.controller.web.actions.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;

/**
 * Action, die beim Hinzufügen eines Members in einem Projekt angesprochen wird
 *  <br/> <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * loginName(loginName eines Users): request -> loginName <br/>
 * rolle(Projectrolle): request -> rolle <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * addMember <br/>
 *  <br/>
 *  
 * Beispiel-Aufruf: <br/>
 * do=AddMember&loginName=Heinz&rolle=Member <br/>
 *  <br/>
 *  
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class AddMemberAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AddMemberAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		
		try {
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName") + "), "
					+ "String rolle(" + req.getParameter("rolle") + ")"
					);
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String loginName = req.getParameter("loginName").toLowerCase();
			String rolle = req.getParameter("rolle");
			boolean isMember = false;
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedAddMemberAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedAddMemberAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Hinzufuegen/Bearbeiten eines Members!");
				}			
			}
			//Manager in aktion
			try {
				isMember = mainManager.getProjectRolesManager().isMember(loginName, aktProject.getName());
			} catch (ProjectException e) {
				logger.debug("Kein Member in diesem Project. Alles Okay!");
			}
			
			
			if(!isMember){
				mainManager.getProjectManager().addMember(loginName, aktProject.getName(), rolle);
			}else{
				throw new ProjectException("Der angegebene User ist bereits Member in diesem Projekt!");
			}
			
			
			try {
				String[] param = new String[1];
				param[0] = "projectName="+aktProject.getName();
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowProject", param);
			} catch (IOException e) {
				logger.error("Konnte Redirect nicht ausführen! "+e.getMessage(), e);
				throw new ProjectException("Konnte Redirect nicht ausführen!");
			}
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
