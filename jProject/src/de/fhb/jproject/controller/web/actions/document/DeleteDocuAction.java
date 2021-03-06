package de.fhb.jproject.controller.web.actions.document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die beim Löschen eines Dokuments angesprochen wird
 *  <br/> <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * documentId(Id des Documents): request -> documentId <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine
 *  <br/> <br/>
 * 
 * Managermethoden: <br/>
 * deleteDocu <br/>
 *  <br/>
 *  
 * Beispiel-Aufruf: <br/>
 * do=DeleteDocuAction&documentId=1
 *  <br/> <br/>
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * 
 */
public class DeleteDocuAction extends HttpRequestActionBase {

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
					+ "String documentId(" + req.getParameter("documentId")
					);


			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int documentId = 0;
			try {
				documentId = Integer.valueOf(req.getParameter("documentId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte DocumentID nicht entziffern! ", e);
				throw new ProjectException("Ungültige DocumentID!");
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedDeleteDocuAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedDeleteDocuAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum loeschen dieses Dokuments!");
				}			
			}
			//Manager in aktion
			mainManager.getDocumentManager().deleteDocu(documentId, aktProject.getName());
			
			try {
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllDocu", null);
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
