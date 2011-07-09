package de.fhb.jproject.controller.web.actions.sources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.document.ShowAllDocuAction;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * Action, die beim Anzeigen eines Sourcecode in einem Projekt angesprochen wird <br/>
 * (UNUSED) <br/>
 *  <br/>
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * sourcecodeId(Id des Sourcecodes): request -> sourcecodeId <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * showSource <br/>
 *  <br/>
 *  Beispiel-Aufruf: <br/>
 * do=ShowSourceAction&sourcecodeId=1 <br/>
 *  <br/>
 *  
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowSourceAction extends HttpRequestActionBase {


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
		Sourcecode sourcecode = null;
		String sourcecodeContent = null;
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
			if(!mainManager.getGlobalRolesManager().isAllowedShowSourceAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowSourceAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum anzeigen dieses Sourcecodes!");
				}			
			}
			logger.debug("sourceId: "+sourcecodeId);
			sourcecode = mainManager.getSourceManager().showSource(sourcecodeId);

			try {

				sourcecodeContent = mainManager.getSourceManager().showSourceContent(aktProject.getName(), sourcecodeId);
			} catch (NullPointerException e) {
				logger.info(e.getMessage(), e);
				sourcecodeContent = "Kann Sourcecode nicht lesen! ";
			}
			
			//setzen der Parameter
			req.setAttribute("sourcecode", sourcecode);
			req.setAttribute("sourcecodeContent", sourcecodeContent);

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
