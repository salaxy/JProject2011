package de.fhb.jproject.controller.web.actions.project;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.GlobalRolesManager;
import de.fhb.jproject.manager.MainManager;
import de.fhb.jproject.manager.ProjectRolesManager;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * STATUS: FREIGEGEBEN - ERFOLGREICH GETESTET
 * 
 * do=ShowProject&projectName=ProjectName
 * 
 */
public class ShowProjectAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowProjectAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		Project project = null;
		MemberSetCollection memberSet = null;
		boolean isAllowedAddMemberAction = true;
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);
			
			
			//Parameter laden
			User aktUser = (User)session.getAttribute("aktUser");
			String projectName = req.getParameter("projectName");
			
			//TODO EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowProjectAction(aktUser.getLoginName())){
					throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");		
				}
				//Manager in aktion
				project=mainManager.getProjectManager().showProject(aktUser, projectName);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			try {
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser.getLoginName())){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser.getLoginName(), projectName)){
						throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");
					}			
				}
				memberSet = mainManager.getProjectManager().showAllMember(aktUser, projectName); 
			}catch (ProjectException e) {
				logger.error(e.getMessage(), e);
			}catch (NullPointerException e) {
				logger.error(e.getMessage(), e);
			}
			//XXX Testausgabe
			if (logger.getLevel()==Level.DEBUG) {
				logger.debug("Size: "+memberSet.getCollection().size());

				for (Object o : memberSet.getCollection()) {
					Member mem = (Member)o;
					logger.debug("Member: "+mem.getUser()+" Projectname: "+mem.getProject().getName()+" ORMID: "+mem.getProject().getORMID()+" Status: "+mem.getProject().getStatus());

				}
			}
			//TODO anzahl documente, anzahl Sourcecode
			//TODO fähigkeiten addMember, DeleteMember
			
			/* Darf der User Member löschen? (für GUI-Anzeige) */
			if(!mainManager.getGlobalRolesManager().isAllowedAddMemberAction(aktUser.getLoginName())){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedAddMemberAction(aktUser.getLoginName(), projectName)){
					isAllowedAddMemberAction = false;
				}			
			}
			
			//setzen der Session
			session.setAttribute("aktProject", project);
			session.setAttribute("isAllowedAddMember", isAllowedAddMemberAction);
			
			//setzen der Parameter
			req.setAttribute("memberList", memberSet.getCollection());
			req.setAttribute("project", project);			
			req.setAttribute("contentFile", "showProject.jsp");
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
