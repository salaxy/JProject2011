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
		Member member = null;
		
		boolean isAllowedAddMemberAction = true;
		boolean isAllowedDeleteMemberAction = true;
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);
			
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String projectName = req.getParameter("projectName");
			String loginName = req.getParameter("loginName");
			
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			if(projectName == null || projectName.equals("")){
				throw new ProjectException("kein Projekt gewählt!");
			}
			/* Darf der User Member hinzufügen? (für GUI-Anzeige) */
			if(!mainManager.getGlobalRolesManager().isAllowedAddMemberAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedAddMemberAction(aktUser, projectName)){
					isAllowedAddMemberAction = false;
				}			
			}
			/* Darf der User Member löschen? (für GUI-Anzeige) */
			if(!mainManager.getGlobalRolesManager().isAllowedDeleteMemberAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedDeleteMemberAction(aktUser, projectName)){
					isAllowedDeleteMemberAction = false;
				}			
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowProjectAction(aktUser)){
					throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");		
				}
				//Manager in aktion
				project=mainManager.getProjectManager().showProject(projectName);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			try {
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser, projectName)){
						throw new ProjectException("Sie haben keine Rechte zum loeschen eines Members!");
					}			
				}
				memberSet = mainManager.getProjectManager().showAllMember(projectName); 
			}catch (ProjectException e) {
				logger.error(e.getMessage(), e);
			}catch (NullPointerException e) {
				logger.error(e.getMessage(), e);
			}
			
			try {
				//Wenn loginName == null dann gib mir den ersten
				if (loginName == null) {
					loginName = ((Member)memberSet.toArray()[0]).getUser().getLoginName();
				}
			} catch (IllegalArgumentException e) {
				throw new ProjectException("loginName ungültig "+e);
			}catch(ArrayIndexOutOfBoundsException e){
				logger.error("Keine Member vorhanden!"+e.getMessage(), e);
			}catch(NullPointerException e){
				logger.error("Keine Member vorhanden!"+e.getMessage(), e);
			}
			
			//RECHTE-ABFRAGE Global
			try{
				//TODO RECHTEABFRAGE
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser, projectName)){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen dieses Members!");
					}			
				}
				//Manager in aktion
				member = mainManager.getProjectManager().showMember(aktUser, loginName, projectName);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			
			/*XXX Testausgabe*/
			//TODO ÄH MUSS DEBUG MACHEN SONST FEHLER
			logger.debug("Size: "+memberSet.size());
			
			if (logger.getLevel()==Level.DEBUG) {
				System.out.println("DEBUG IS SET");
				logger.debug("Size: "+memberSet.size());
				
				for (Object o : memberSet.getCollection()) {
					Member mem = (Member)o;
					logger.debug("Member: "+mem.getUser()+" Projectname: "+mem.getProject().getName()+" ORMID: "+mem.getProject().getORMID()+" Status: "+mem.getProject().getStatus());

				}
			}
			
			//TODO anzahl documente, anzahl Sourcecode
			//TODO fähigkeiten addMember, DeleteMember
			
			
			
			//setzen der Session
			session.setAttribute("aktProject", project);
			session.setAttribute("isAllowedAddMember", isAllowedAddMemberAction);
			session.setAttribute("isAllowedDeleteMember", isAllowedDeleteMemberAction);
			
			//setzen der Parameter
			req.setAttribute("memberList", memberSet.getCollection());
			req.setAttribute("member", member);
			req.setAttribute("project", project);
			
			//Statistische Daten
			/*
			req.setAttribute("anzMember", project.member.size());
			req.setAttribute("anzDocu", project.document.size());
			req.setAttribute("anzSource", project.sourcecode.size());
			req.setAttribute("anzTask", project.task.size());
			 * 
			 */
			
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
