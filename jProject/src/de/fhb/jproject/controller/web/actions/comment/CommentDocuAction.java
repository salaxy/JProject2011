package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import org.apache.log4j.Level;

/**
 * Action die angesprochen wird wenn ein Dokument kommentiert wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * documentId(Id des Dokuments): request -> documentId
 * entry(Inhalt des Comments): request -> entry
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * 
 * Managermethoden:
 * commentDocu
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=CommentDocu&documentId=1&entry=GutesDokument
 * 
 */
public class CommentDocuAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(CommentDocuAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int documentId(" + req.getParameter("documentId") + "), "
					+ "String entry(" + req.getParameter("entry") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int documentId = 0;
			try {
				documentId = Integer.valueOf(req.getParameter("documentId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte DocumentID nicht entziffern! ", e);
			}
			String entry = req.getParameter("entry");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedCommentDocuAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedCommentDocuAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Hinzufuegen eines DocumentComments!");
				}			
			}
			//Manager in aktion
			mainManager.getCommentManager().commentDocu(aktUser, documentId, entry);
			
			try {
				String[] param = new String[1];
				param[0] = "documentId="+documentId;
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllDocu", param);
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
