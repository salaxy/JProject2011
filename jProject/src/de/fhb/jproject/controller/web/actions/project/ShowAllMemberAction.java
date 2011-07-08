package de.fhb.jproject.controller.web.actions.project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Level;

/**
 * Action, die beim Anzeigen aller Member in einem Projekt angesprochen wird
 * 
 * Parameter: 
 * Aktueller User: Session -> aktUser
 * Aktuelles Project: Session -> aktProject
 * loginName(loginName des Users): request -> loginName
 * 
 * 
 * Rechteüberprüfung für GUI:
 * keine
 * 
 * Managermethoden:
 * showMember
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * Beispiel-Aufruf:
 * do=ShowAllMember&loginName=Heinz
 * 
 */
public class ShowAllMemberAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllMemberAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		MemberSetCollection memberSet=null;
		Member member = null;
		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String loginName(" + req.getParameter("loginName")
					);	
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			String loginName = req.getParameter("loginName"); 
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedShowAllMemberAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedShowAllMemberAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Member!");
				}			
			}
			//Manager in aktion
			memberSet=mainManager.getProjectManager().showAllMember(aktProject.getName());
			
			if (!memberSet.isEmpty()) {
				//RECHTE-ABFRAGE Global
				if(!mainManager.getGlobalRolesManager().isAllowedShowMemberAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedShowMemberAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum Anzeigen dieses Members!");
					}			
				}
				//Manager in aktion
				member = mainManager.getProjectManager().showMember(loginName, aktProject.getName());
				
				
				//DEBUG Testausgabe
				if (logger.getLevel()==Level.DEBUG) {
					logger.debug("Size: "+memberSet.size());

					for (Object o : memberSet.getCollection()) {
						Member mem = (Member)o;
						logger.debug("Member: "+mem.getUser()+" Projectname: "+mem.getProject().getName()+" ORMID: "+mem.getProject().getORMID()+" Status: "+mem.getProject().getStatus());

					}
				}
			}
			
			//setzen der Parameter
			req.setAttribute("memberList", memberSet.getCollection());
			req.setAttribute("member", member);

			req.setAttribute("contentFile", "showAllMember.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
