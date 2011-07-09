package de.fhb.jproject.controller.web.actions.sources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die beim Anzeigen aller Sourcecodes in einem Projekt angesprochen wird,
 * dabei wird das erste Element detailiert angezeigt falls der Parameter sourceodeId null ist.
 * Wenn der Parameter nicht null ist wird der entsprechende Sourcecode angezeigt. <br/>
 *  <br/>
 * 
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * (optional)sourcecodeId: request -> sourcecodeId <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * isAllowedDeleteSourceAction <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * showAllSource <br/>
 *  <br/>
 *  Beispiel-Aufruf: <br/>
 * do=ShowAllSourceAction <br/>
 *  <br/>
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowAllSourceAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllSourceAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		Set<Sourcecode> sourcecodeList = null;
		Sourcecode sourcecode = null;
		String sourcecodeContent = null;
		
		boolean isAllowedDeleteSourceAction = true;
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int sourcecodeId(" + req.getParameter("sourcecodeId") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int sourcecodeId = 0;
			try {
				sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
			} catch (NumberFormatException e) {
				logger.info("Konnte SourcecodeID nicht entziffern! Zeige erstes Element in Liste an. ", e);
			}
			 
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			
			try {
				/* Darf der User Sourcecode löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteSourceAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDeleteSourceAction(aktUser, aktProject.getName())){
						isAllowedDeleteSourceAction = false;
						logger.info("isAllowedDeleteSourceAction NO!");
					}			
				}
			} catch (ProjectException e) {
				isAllowedDeleteSourceAction = false;
				logger.info("isAllowedDeleteSourceAction NO!");
			}
			
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllSourceAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowAllSourceAction(aktUser, aktProject.getName())){
					if (!mainManager.getProjectRolesManager().isMember(aktUser, aktProject.getName())) {
						throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Sourcecodes dieses Projektes!");
					}
				}			
			}
			//Manager in aktion
			sourcecodeList = mainManager.getSourceManager().showAllSource(aktProject.getName()).getCollection();
			sourcecodeList.size();
				
			if(!sourcecodeList.isEmpty()) {
				//Wenn sourcecodeId == null dann gib mir den ersten
				if (0 == sourcecodeId) {
					sourcecodeId = ((Sourcecode)sourcecodeList.toArray()[0]).getId();
				}
				
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
			}
			
			//setzen der Parameter
			req.setAttribute("sourcecodeList", sourcecodeList);
			req.setAttribute("sourcecode", sourcecode);
			req.setAttribute("sourcecodeContent", sourcecodeContent);
			req.setAttribute("isAllowedDeleteSourceAction", isAllowedDeleteSourceAction);
			
			req.setAttribute("contentFile", "showAllSource.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
