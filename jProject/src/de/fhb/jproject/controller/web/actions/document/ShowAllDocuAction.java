package de.fhb.jproject.controller.web.actions.document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.DocumentSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
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
		
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			/*TODO logger.debug("Parameter: "
					+ "int documentId(" + req.getParameter("taskId") + ")"
					);
			 * 
			 */
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int documentId = 0;
			try {
				documentId = Integer.valueOf(req.getParameter("documentId"));
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
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
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			
			try {
				//TODO HIER MUSS EIN FEHLER SEIN!
				//Wenn documentId == null dann gib mir den ersten
				if (0 == documentId) {
					documentId = ((Document)documentList.toArray()[0]).getId();
				}
			} catch (IllegalArgumentException e) {
				throw new ProjectException("DocumentID ungültig "+e);
			}catch(ArrayIndexOutOfBoundsException e){
				logger.error("Keine Dokumente vorhanden!"+e.getMessage(), e);
			}catch(NullPointerException e){
				logger.error("Keine Dokumente vorhanden!"+e.getMessage(), e);
			}
			
			
			
			try {
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
				
			}catch(NullPointerException e){
				logger.info(e.getMessage(), e);
				documentContent = "Kann Document nicht lesen! ";
			}
			
			//setzen der Parameter
			req.setAttribute("documentList", documentList.getCollection());
			req.setAttribute("document", document);
			req.setAttribute("documentContent", documentContent);
			
			req.setAttribute("contentFile", "showAllDocu.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
