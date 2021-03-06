package de.fhb.jproject.controller.web.actions.project;

import de.fhb.commons.CheckString;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;

/**
 * Action, die beim Hinzufügen eines neuen Projekts angesprochen wird
 *  <br/> <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * projectName(Bezeichnung des Projektes): request -> projectName <br/>
 * status(Projectstatus): request -> status <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * addNewProject <br/>
 *  <br/>
 * Beispiel-Aufruf: <br/>
 * do=AddNewProject&projectName=NeuesProjekt&status=beginn
 *  <br/> <br/>
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class AddNewProjectAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AddNewProjectAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{
		logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();
		CheckString check = new CheckString();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					+ "String status(" + req.getParameter("status") + ")"
					);
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			String projectName = req.getParameter("projectName");
			String status = req.getParameter("status");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			check.checkString("Projectname",projectName);
			
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedAddNewProjectAction(aktUser)){
				throw new ProjectException("Sie haben keine Rechte zum Hinzufuegen eines Projektes!");			
			}
			//Manager in aktion
			mainManager.getProjectManager().addNewProject(aktUser, projectName, status);
			
			try {
				String[] param = new String[1];
				param[0] = "projectName="+projectName;
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
