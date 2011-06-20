package de.fhb.jproject.controller.web.actions.project;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.JProjectPersistentManager;
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
import org.orm.PersistentException;


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
		//logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		Project project = null;
		MemberSetCollection memberSet = null;
		Member member = null;
		
		int anzMember = 0;
		int anzDocu = 0;
		int anzSource = 0;
		int anzTask = 0;
		
		boolean isAllowedAddMemberAction = true;
		boolean isAllowedDeleteMemberAction = true;
		boolean isAllowedUpdateCommentAction = true;
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					+ "String loginName((optional)" + req.getParameter("loginName") + ")"
					);
			
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String projectName = req.getParameter("projectName");
			String loginName = req.getParameter("loginName");
			
			logger.debug("Session: "
					+ "String aktUser(" + aktUser + ")"
					+ "Project aktProject(" + aktProject + ")");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			if(projectName == null || projectName.equals("")){
				projectName = aktProject.getName();
				//throw new ProjectException("kein Projekt gewählt!");
			}
			
			
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowProjectAction(aktUser)){
					if (!mainManager.getProjectRolesManager().isMember(aktUser, projectName)) {
						throw new ProjectException("Sie haben keine Rechte zum anzeigen dieses Projektes!");
					}
				}
				//Manager in aktion
				project=mainManager.getProjectManager().showProject(projectName);
				
				
				anzDocu = project.document.size();
				anzSource = project.sourcecode.size();
				anzTask = project.task.size();
				
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			try {
				/* Darf der User Member hinzufügen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedAddMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedAddMemberAction(aktUser, projectName)){
						isAllowedAddMemberAction = false;
					}			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedAddMemberAction NO!");
			}
			try{
				/* Darf der User Member löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedDeleteMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDeleteMemberAction(aktUser, projectName)){
						isAllowedDeleteMemberAction = false;
					}			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedDeleteMemberAction NO!");
			}
			
			try{
				/* Darf der User Member löschen? (für GUI-Anzeige) */
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateCommentAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedUpdateCommentAction(aktUser, projectName)){
						isAllowedUpdateCommentAction = false;
					}			
				}
			} catch (ProjectException e) {
				logger.info("isAllowedDeleteMemberAction NO!");
			}
			
			
			try {
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser, projectName)){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen aller Member!");
					}			
				}
				memberSet = mainManager.getProjectManager().showAllMember(projectName);
				
			}/*catch (ProjectException e) {
				logger.error(e.getMessage(), e);
			}*/catch (NullPointerException e) {
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
			
			
			//TODO NOCHMAL HOLEN FÜR KORREKTUR Oo
			try {
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser, projectName)){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen aller Member!");
					}			
				}
				memberSet = mainManager.getProjectManager().showAllMember(projectName);
				anzMember = memberSet.size();
			}/*catch (ProjectException e) {
				logger.error(e.getMessage(), e);
			}*/catch (NullPointerException e) {
				logger.error(e.getMessage(), e);
			}
			
			/*XXX Testausgabe*/			
			if (logger.getLevel()==Level.DEBUG) {
				System.out.println("DEBUG IS SET");
				logger.debug("Size: "+memberSet.size());
				
				for (Object o : memberSet.getCollection()) {
					Member mem = (Member)o;
					logger.debug("Member: "+mem.getUser()+" Projectname: "+mem.getProject().getName()+" ORMID: "+mem.getProject().getORMID()+" Status: "+mem.getProject().getStatus());

				}
			}
			
			//TODO fähigkeiten DeleteMember
			
			
			
			//setzen der Session
			session.setAttribute("aktProject", project);
			session.setAttribute("isAllowedAddMember", isAllowedAddMemberAction);
			session.setAttribute("isAllowedDeleteMember", isAllowedDeleteMemberAction);
			session.setAttribute("isAllowedUpdateCommentAction", isAllowedUpdateCommentAction);
			
			//setzen der Parameter
			req.setAttribute("memberList", memberSet.getCollection());
			req.setAttribute("member", member);
			req.setAttribute("project", project);
			
			//Statistische Daten
			req.setAttribute("anzMember", anzMember);
			req.setAttribute("anzDocu", anzDocu);
			req.setAttribute("anzSource", anzSource);
			req.setAttribute("anzTask", anzTask);
			
			
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
