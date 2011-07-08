package de.fhb.jproject.controller.web.actions.sources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.document.ShowAllDocuAction;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die beim Löschen eines Sourcecodes angesprochen wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * sourcecodeId(Id des Sourcecodes): request -> sourcecodeId
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * 
 * Managermethoden:
 * deleteSource
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=DeleteSourceAction&sourcecodeId=1
 * 
 */
public class DeleteSourceAction extends HttpRequestActionBase {


	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllDocuAction.class);

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
					+ "String sourcecodeId(" + req.getParameter("sourcecodeId")
					);

			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int sourcecodeId = 0;
			try {
				sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte SourcecodeID nicht entziffern! ", e);
				throw new ProjectException("Ungültige SourcecodeID!");
			}
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedDeleteSourceAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedDeleteSourceAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum loeschen dieses Sourcecodes!");
				}			
			}
			//Manager in aktion
			mainManager.getSourceManager().deleteSource(sourcecodeId, aktProject.getName());
			
			try {
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllSource", null);
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
