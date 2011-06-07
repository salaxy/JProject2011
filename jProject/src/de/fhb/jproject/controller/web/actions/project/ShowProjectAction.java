package de.fhb.jproject.controller.web.actions.project;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.util.List;
import javax.servlet.http.HttpSession;


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
		List<Member> memberList = null;
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);
			
			//Manager in aktion
			project=mainManager.getProjectManager().showProject((User)session.getAttribute("aktUser"), 
																	 req.getParameter("projectName"));
			
			/*TODO DELETE ACTION
			ShowAllMemberAction showAllMemberAction = new ShowAllMemberAction();
			showAllMemberAction.perform(req, resp);
			 * 
			 */
			try {
				memberList = mainManager.getProjectManager().showAllMember((User)session.getAttribute("aktUser"), req.getParameter("projectName")); 
			}catch (ProjectException e) {
				logger.error(e.getMessage());
				/*
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", e.getMessage());
				 * 
				 */
			}
			
			//TODO anzahl documente, anzahl Sourcecode
			//TODO fähigkeiten addMember, DeleteMember
			
			//setzen der Parameter
			req.setAttribute("project", project);
			session.setAttribute("aktProject", project);//TODO PRUEFEN OB NOCH GEBRAUCHT
			
			req.setAttribute("memberList", memberList);
			
			req.setAttribute("contentFile", "showProject.jsp");
			
			

		}catch (ProjectException e) {
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch(NullPointerException e){
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
