package de.fhb.jproject.controller.web.actions.document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.apache.commons.fileupload.FileItem;



/**
 * Action, die beim Hinzufügen eines neuen Dokuments angesprochen wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * data(List FileItem): request -> data
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * Managermethoden:
 * addNewDocu
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=AddNewDocuAction
 * 
 */
public class AddNewDocuAction extends HttpRequestActionBase {
private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AddNewDocuAction.class);

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
			/*TODO logger.debug("Parameter: "
					+ "String titel(" + req.getParameter("titel") + ")"
					+ "String aufgabenStellung(" + req.getParameter("aufgabenStellung") + ")"
					+ "Date date(" + req.getParameter("date") + ")"
					);
			 * 
			 */
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			List<FileItem> data = (List<FileItem>)req.getAttribute("data");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedAddNewDocuAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedAddNewDocuAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Hinzufügen eines Documents!");
				}			
			}
			//Manager in aktion
			mainManager.getDocumentManager().addNewDocu(aktProject.getName(), data);
			
			try {
				super.redirect(req, resp, "JProjectServlet", "ShowAllDocu", null);
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
