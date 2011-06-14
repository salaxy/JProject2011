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

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServletControllerBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(AdminServlet.class);
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws IOException, ServletException{
		if ((session.getAttribute("aktUser")==null)) {	
			synchronized(session){
				/*TODO DELETE ACTION
				ShowAllOwnProjectsAction showAllOwnProjectsAction = new ShowAllOwnProjectsAction();
				showAllOwnProjectsAction.perform(req, resp);
				 * 
				 */
				//TODO BO-ACCESS LAYOUT

				//TODO Comments per AJAX
			}
		}
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			mainManager = (MainManager)session.getAttribute("mainManager");
			//Player fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null/* || getOperation(req).equals("Login")*/) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
		}
		try {
			super.doGet(req, resp);
			processRequest(req, resp, session);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("triedLogin", true);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", "ERROR 404 - Konnte Seite nicht finden!");
		}
		
		
		logger.info("sending contentFile: "+req.getAttribute("contentFile"));
		
		RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
		reqDisp.forward(req, resp);
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
			//Player fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null/* || getOperation(req).equals("Login")*/) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
		}
		try {
			super.doPost(req, resp);
			processRequest(req, resp, session);
		} catch (NullPointerException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("triedLogin", true);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", "ERROR 404 - Konnte Seite nicht finden!");
		}
		
		
		logger.info("sending contentFile: "+req.getAttribute("contentFile"));
		
		RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
		reqDisp.forward(req, resp);
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
		
		// !!! Projekt Actions !!!

		action = new ShowAllProjectsAction();
		actions.put("ShowAllProjects", action);
		
		// !!! User Actions !!!
		
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
		
		action = new ShowAllUserAction();
		actions.put("ShowAllUser", action);
		
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