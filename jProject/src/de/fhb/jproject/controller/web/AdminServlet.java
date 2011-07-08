package de.fhb.jproject.controller.web;

import de.fhb.jproject.exceptions.ProjectException;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.commons.web.HttpServletControllerBase;
import de.fhb.jproject.controller.web.actions.comment.CommentDocuAction;
import de.fhb.jproject.controller.web.actions.comment.CommentProjectAction;
import de.fhb.jproject.controller.web.actions.comment.CommentSourceAction;
import de.fhb.jproject.controller.web.actions.comment.CommentTaskAction;
import de.fhb.jproject.controller.web.actions.comment.DeleteCommentAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41DocuAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41ProjectAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41SourceAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41TaskAction;
import de.fhb.jproject.controller.web.actions.comment.UpdateCommentAction;
import de.fhb.jproject.controller.web.actions.document.AddNewDocuAction;
import de.fhb.jproject.controller.web.actions.document.DeleteDocuAction;
import de.fhb.jproject.controller.web.actions.document.DownloadDocuAction;
import de.fhb.jproject.controller.web.actions.document.ShowAllDocuAction;
import de.fhb.jproject.controller.web.actions.document.ShowDocuAction;
import de.fhb.jproject.controller.web.actions.document.UpdateDocuAction;
import de.fhb.jproject.controller.web.actions.project.AddMemberAction;
import de.fhb.jproject.controller.web.actions.project.AddNewProjectAction;
import de.fhb.jproject.controller.web.actions.project.DeleteMemberAction;
import de.fhb.jproject.controller.web.actions.project.DeleteProjectAction;
import de.fhb.jproject.controller.web.actions.project.SearchProjectsAction;
import de.fhb.jproject.controller.web.actions.project.ShowAllMemberAction;
import de.fhb.jproject.controller.web.actions.project.ShowAllOwnProjectsAction;
import de.fhb.jproject.controller.web.actions.project.ShowAllProjectsAction;
import de.fhb.jproject.controller.web.actions.project.ShowProjectAction;
import de.fhb.jproject.controller.web.actions.project.UpdateMemberAction;
import de.fhb.jproject.controller.web.actions.sources.AddNewSourceAction;
import de.fhb.jproject.controller.web.actions.sources.DeleteSourceAction;
import de.fhb.jproject.controller.web.actions.sources.DownloadSourceAction;
import de.fhb.jproject.controller.web.actions.sources.ShowAllSourceAction;
import de.fhb.jproject.controller.web.actions.sources.ShowSourceAction;
import de.fhb.jproject.controller.web.actions.sources.UpdateSourceAction;
import de.fhb.jproject.controller.web.actions.task.AddNewTaskAction;
import de.fhb.jproject.controller.web.actions.task.AssignTaskAction;
import de.fhb.jproject.controller.web.actions.task.DeAssignTaskAction;
import de.fhb.jproject.controller.web.actions.task.DeleteTaskAction;
import de.fhb.jproject.controller.web.actions.task.ShowAllOwnTasksAction;
import de.fhb.jproject.controller.web.actions.task.ShowAllTasksAction;
import de.fhb.jproject.controller.web.actions.task.UpdateTaskAction;
import de.fhb.jproject.controller.web.actions.user.DeleteUserAction;
import de.fhb.jproject.controller.web.actions.user.LoginAction;
import de.fhb.jproject.controller.web.actions.user.LogoutAction;
import de.fhb.jproject.controller.web.actions.user.OpenAdminconsole;
import de.fhb.jproject.controller.web.actions.user.RegisterAction;
import de.fhb.jproject.controller.web.actions.user.SearchUserAction;
import de.fhb.jproject.controller.web.actions.user.ShowAllUserAction;
import de.fhb.jproject.controller.web.actions.user.ShowUserInfoAction;
import de.fhb.jproject.controller.web.actions.user.ShowUserSettingsAction;
import de.fhb.jproject.controller.web.actions.user.UpdateUserSettingsAction;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.manager.MainManager;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import org.apache.log4j.Logger;
/*
 * AdminServlet ist zum Verwalten der GET und POST Requests.
 * Dieses Servlet is spezialisiert auf alle Anfragen die speziell den Admin betreffen.
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServletControllerBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AdminServlet.class);
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws IOException, ServletException{
		List<Project> projectList = null;
		List<User> userList = null;
		
		boolean isAllowedDeleteUserAction = true;
		boolean isAllowedDeleteProjectAction = true;
		
		
		if (!(session.getAttribute("aktUser")==null)) {
			
			String aktUser = (String) session.getAttribute("aktUser");
			
			//abfrage ob user eingeloggt
			if(aktUser == null){
				logger.error("Sie sind nicht eingeloggt!");
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", "Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllProjectsAction(aktUser)){
					throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller Projekte!");
				}
				//Manager in aktion
				projectList=mainManager.getProjectManager().showAllProjects();
				
				try {
					/* Darf dieser User User löschen? (für GUI-Anzeige) */
					if(!mainManager.getGlobalRolesManager().isAllowedDeleteProjectAction(aktUser)){
						logger.info("isAllowedDeleteProjectAction NO!");
						isAllowedDeleteProjectAction = false;
					}
				} catch (ProjectException e) {
					isAllowedDeleteProjectAction = false;
					logger.info("isAllowedDeleteProjectAction NO!");
				}
			
			} catch (ProjectException ex) {
				logger.error(ex.getMessage(), ex);
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", ex.getMessage());
			}
			
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedShowAllUserAction(aktUser)){
					throw new ProjectException("Sie haben keine Rechte zum Anzeigen aller User!");	
				}
				
				try {
					/* Darf dieser User User löschen? (für GUI-Anzeige) */
					if(!mainManager.getGlobalRolesManager().isAllowedDeleteUserAction(aktUser)){
						logger.info("isAllowedDeleteUserAction NO!");
						isAllowedDeleteUserAction = false;
					}
				} catch (ProjectException e) {
					isAllowedDeleteUserAction = false;
					logger.info("isAllowedDeleteUserAction NO!");
				}
				
				//Manager in aktion
				userList=mainManager.getUserManager().showAllUser();
			
			} catch (ProjectException ex) {
				logger.error(ex.getMessage(), ex);
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", ex.getMessage());
			}
			
			req.setAttribute("isAllowedDeleteProjectAction", isAllowedDeleteProjectAction);
			req.setAttribute("isAllowedDeleteUserAction", isAllowedDeleteUserAction);
			req.setAttribute("projectList", projectList);
			req.setAttribute("userList", userList);
			
			req.setAttribute("naviFile", "adminnavi.jsp");
			
		}
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			mainManager = (MainManager)session.getAttribute("mainManager");
			//mainManger fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
			session.setAttribute("aktServlet", "AdminServlet");
		}
		try {
			super.doGet(req, resp);
			processRequest(req, resp, session);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			//req.setAttribute("triedLogin", true);
			req.setAttribute("contentFile", "welcome.jsp");
			req.setAttribute("naviFile", "welcomenavi.jsp");
		}
		
		
		logger.info("sending contentFile: "+req.getAttribute("contentFile"));
		logger.info("sending naviFile: "+req.getAttribute("naviFile"));
		
		if (resp.getHeader("Location") == null) {
			RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
			reqDisp.forward(req, resp);
		}
		logger.info("--------------------------------------------------------------------------------------");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			mainManager = (MainManager)session.getAttribute("mainManager");
			//mainManager fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
			session.setAttribute("aktServlet", "AdminServlet");
		}
		try {
			super.doPost(req, resp);
			processRequest(req, resp, session);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			//req.setAttribute("triedLogin", true);
			req.setAttribute("contentFile", "welcome.jsp");
			req.setAttribute("naviFile", "welcomenavi.jsp");
		}
		
		
		logger.info("sending contentFile: "+req.getAttribute("contentFile"));
		logger.info("sending naviFile: "+req.getAttribute("naviFile"));
		
		if (resp.getHeader("Location") == null) {
			RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
			reqDisp.forward(req, resp);
		}
		logger.info("--------------------------------------------------------------------------------------");
	}


	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	public String getServletInfo() {
		return "Short description";
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhb.music.controller.web.HttpServletManagerBase#init(javax.servlet
	 * .ServletConfig)
	 */
	public void init(ServletConfig conf) throws ServletException {
		super.init();
		HttpRequestActionBase action = null;
		actions = new HashMap();
		
		//Actions hinzufuegen
		// !!! Admin !!!
		//Nur Admin
		action = new OpenAdminconsole();
		actions.put("OpenAdminconsole", action);
		
		// !!! Comment Actions !!!
		action = new CommentDocuAction();
		actions.put("CommentDocu", action);
		
		action = new CommentProjectAction();
		actions.put("CommentProject", action);
		
		action = new CommentSourceAction();
		actions.put("CommentSource", action);
		
		action = new CommentTaskAction();
		actions.put("CommentTask", action);
		
		action = new DeleteCommentAction();
		actions.put("DeleteComment", action);
		/* DATAServlet
		action = new ShowAllComments41DocuAction();
		actions.put("ShowAllComments41Docu", action);
		
		action = new ShowAllComments41ProjectAction();
		actions.put("ShowAllComments41Project", action);
		
		action = new ShowAllComments41SourceAction();
		actions.put("ShowAllComments41Source", action);
		
		action = new ShowAllComments41TaskAction();
		actions.put("ShowAllComments41Task", action);
		*/
		action = new UpdateCommentAction();
		actions.put("UpdateComment", action);
		
	
		
		// !!! Dokument Actions !!!		
		action = new DeleteDocuAction();
		actions.put("DeleteDocu", action);
		
		action = new ShowAllDocuAction();
		actions.put("ShowAllDocu", action);
		
		action = new ShowDocuAction();
		actions.put("ShowDocu", action);
		
		// !!! Projekt Actions !!!

		action = new UpdateMemberAction();
		actions.put("UpdateMember", action);
		
		action = new AddMemberAction();
		actions.put("AddMember", action);
		
		action = new AddNewProjectAction();
		actions.put("AddNewProject", action);		
		
		action = new DeleteProjectAction();
		actions.put("DeleteProject", action);	
		
		action = new DeleteMemberAction();
		actions.put("DeleteMember", action);
		
		action = new ShowProjectAction();
		actions.put("ShowProject", action);
		
		action = new SearchProjectsAction();
		actions.put("SearchProjects", action);
		
		//Nur Admin
		action = new ShowAllProjectsAction();
		actions.put("ShowAllProjects", action);
		
		action = new ShowAllOwnProjectsAction();
		actions.put("ShowAllOwnProjects", action);		
		
		action = new ShowAllMemberAction();
		actions.put("ShowAllMember", action);
		
		
		// !!! Source Actions !!!
				
		action = new DeleteSourceAction();
		actions.put("DeleteSource", action);	
		
		action = new ShowSourceAction();
		actions.put("ShowSource", action);		
		
		action = new ShowAllSourceAction();
		actions.put("ShowAllSource", action);	
		
		
		// !!! Task Actions !!!

		action = new AddNewTaskAction();
		actions.put("AddNewTask", action);		
		
		action = new DeleteTaskAction();
		actions.put("DeleteTask", action);		
		
		action = new ShowAllTasksAction();
		actions.put("ShowAllTasks", action);		
		
		action = new ShowAllOwnTasksAction();
		actions.put("ShowAllOwnTasks", action);		
		
		action = new UpdateTaskAction();
		actions.put("UpdateTask", action);	
		
		action = new AssignTaskAction();
		actions.put("AssignTask", action);	
		
		action = new DeAssignTaskAction();
		actions.put("DeAssignTask", action);
		
		// !!! User Actions !!!
		/* nur Admin */
		action = new DeleteUserAction();
		actions.put("DeleteUser", action);		
		
		action = new ShowUserSettingsAction();
		actions.put("ShowUserSettings", action);	
		
		action = new ShowUserInfoAction();
		actions.put("ShowUserInfo", action);		
		
		action = new SearchUserAction();
		actions.put("SearchUser", action);		
		
		action = new UpdateUserSettingsAction();
		actions.put("UpdateUserSettings", action);		
		/* Nur Admin */
		action = new ShowAllUserAction();
		actions.put("ShowAllUser", action);
		
		action = new LoginAction();
		actions.put("Login", action);		
		
		action = new LogoutAction();
		actions.put("Logout", action);
		/* Nur Admin */
		action = new RegisterAction();
		actions.put("Register", action);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhb.music.controller.web.HttpServletManagerBase#getOperation(javax
	 * .servlet.http.HttpServletRequest)
	 */
	protected String getOperation(HttpServletRequest req) {
		// do ist in diesem Fall der Steuerbefahl z.B. ?do=selectCD&cdId=1
		return req.getParameter("do");
	}// </editor-fold>

}	