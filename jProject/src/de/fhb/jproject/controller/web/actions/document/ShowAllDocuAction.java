package de.fhb.jproject.controller.web.actions.document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.DocumentSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die beim Anzeigen aller Dokumente in einem Projekt angesprochen wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * documentId(Id des Documents 0 für alle): request -> documentId
 * 
 * 
 * Rechteüberprüfung für GUI:
 * isAllowedDeleteDocuAction
 * 
 * 
 * Managermethoden:
 * showAllDocu
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=ShowAllDocuAction&
 * ???????????????
 * TODO
 * 
 */
public class ShowAllDocuAction extends HttpRequestActionBase {

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
		DocumentSetCollection documentList = null;
		Document document = null;
		String documentContent = null;
		
		boolean isAllowedDeleteDocuAction = true;
		
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int documentId = 0;
			try {
				documentId = Integer.valueOf(req.getParameter("documentId"));
			} catch (NumberFormatException e) {
				logger.info("Konnte DocumentID nicht entziffern! Zeige erstes Element in Liste an. ", e);
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			
			try {
				/* Darf der User Dokumente löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteDocuAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDeleteDocuAction(aktUser, aktProject.getName())){
						isAllowedDeleteDocuAction = false;
						logger.info("isAllowedDeleteDocuAction NO!");
					}			
				}
			} catch (ProjectException e) {
				isAllowedDeleteDocuAction = false;
				logger.info("isAllowedDeleteDocuAction NO!");
			}
			
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllDocuAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowAllDocuAction(aktUser, aktProject.getName())){
					if (!mainManager.getProjectRolesManager().isMember(aktUser, aktProject.getName())) {
						throw new ProjectException("Sie haben keine Rechte zum anzeigen aller Documents dieses Projektes!");
					}

				}		
			}
			//Manager in aktion
			documentList=mainManager.getDocumentManager().showAllDocu(aktProject.getName());
			documentList.size();
			
			
			if(!documentList.isEmpty()) {
				//Wenn documentId == null dann gib mir den ersten
				if (0 == documentId) {
					documentId = ((Document)documentList.toArray()[0]).getId();
				}
			
				if(!mainManager.getGlobalRolesManager().isAllowedShowDocuAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowDocuAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen dieses Documents!");
					}			
				}
				logger.debug("docuId: "+documentId);
				document = mainManager.getDocumentManager().showDocu(documentId);

				try {
					documentContent = mainManager.getDocumentManager().showDocuContent(aktProject.getName(), documentId);
				} catch (NullPointerException e) {
					logger.info(e.getMessage(), e);
					documentContent = "Kann Document nicht lesen! ";
				}
			}
			
			//setzen der Parameter
			req.setAttribute("documentList", documentList.getCollection());
			req.setAttribute("document", document);
			req.setAttribute("documentContent", documentContent);
			req.setAttribute("isAllowedDeleteDocuAction", isAllowedDeleteDocuAction);
			
			req.setAttribute("contentFile", "showAllDocu.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}		
	}
}
