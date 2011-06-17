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
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class UpdateSourceAction extends HttpRequestActionBase {
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
			/*TODO logger.debug("Parameter: "
					+ "String documentId(" + req.getParameter("documentId") + "), "
					+ "String inhalt(" + req.getParameter("inhalt") + ")"
					);
			*/
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			List<FileItem> data = (List<FileItem>)req.getAttribute("data");
			int sourcecodeId = 0;
			try {
				sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
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
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateSourceAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					//TODO DRINGEND RECHTE_ABFRAGE
					/*
					if(!mainManager.getProjectRolesManager().isAllowedUpdateSourceAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen dieses Sourcecodes!");
					}
					 * 
					 */
				}
				//Manager in aktion
				mainManager.getSourceManager().updateSource(aktProject.getName(), data, sourcecodeId);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			

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
