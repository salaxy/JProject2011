package de.fhb.jproject.controller.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.fhb.jproject.commons.web.HttpRequestActionBase;
import de.fhb.jproject.commons.web.HttpServletControllerBase;
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
import de.fhb.jproject.manager.MainControl;

@WebServlet("/JProjectServlet")
public class JProjectServlet extends HttpServletControllerBase {

	private MainControl _mainController;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhb.music.controller.web.HttpServletControllerBase#init(javax.servlet
	 * .ServletConfig)
	 */
	public void init(ServletConfig conf) throws ServletException {
		HttpRequestActionBase action = null;
		_actions = new HashMap();
		
		//Actions hinzufuegen
		
		// !!! Kommentar Actions !!!
		
		//kommentieren eines Dokuments
		action = new CommentDocuAction();
		_actions.put("CommentDocu", action);
				
		action = new CommentSourceAction();
		_actions.put("CommentSource", action);
		
		action = new CommentProjectAction();
		_actions.put("CommentProject", action);
		
		action = new CommentTaskAction();
		_actions.put("CommentTask", action);
		
		action = new DeleteCommentAction();
		_actions.put("DeleteComment", action);
		
		action = new ShowAllComments41DocuAction();
		_actions.put("ShowAllComments41Docu", action);
		
		action = new ShowAllComments41SourceAction();
		_actions.put("ShowAllComments41Source", action);
		
		action = new ShowAllComments41TaskAction();
		_actions.put("ShowAllComments41Task", action);
		
		action = new ShowAllComments41ProjectAction();
		_actions.put("ShowAllComments41Project", action);
		
		action = new UpdateCommentAction();
		_actions.put("UpdateComment", action);
		
	
		
		// !!! Dokument Actions !!!
		
		action = new AddNewDocuAction();
		_actions.put("AddNewDocu", action);
			
		action = new DeleteDocuAction();
		_actions.put("DeleteDocu", action);
		
		action = new DownloadDocuAction();
		_actions.put("DownloadDocu", action);
		
		action = new ShowAllDocuAction();
		_actions.put("ShowAllDocu", action);
		
		action = new UpdateDocuAction();
		_actions.put("UpdateDocu", action);
		
		action = new ShowDocuAction();
		_actions.put("ShowDocu", action);
		
		// !!! Projekt Actions !!!

		action = new AddMemberAction();
		_actions.put("AddMember", action);
		
		action = new AddNewProjectAction();
		_actions.put("AddNewProject", action);		
		
		action = new DeleteProjectAction();
		_actions.put("DeleteProject", action);	
		
		action = new DeleteMemberAction();
		_actions.put("DeleteMember", action);
		
		action = new ShowProjectAction();
		_actions.put("ShowProject", action);
		
		action = new SearchProjectsAction();
		_actions.put("SearchProjects", action);
		
		action = new ShowAllProjectsAction();
		_actions.put("ShowAllProjects", action);
		
		action = new ShowAllOwnProjectsAction();
		_actions.put("ShowAllOwnProjects", action);		
		
		action = new ShowAllMemberAction();
		_actions.put("ShowAllMember", action);
		
		
		// !!! Source Actions !!!
		
		
		action = new AddNewSourceAction();
		_actions.put("AddNewSource", action);		
		
		action = new DeleteSourceAction();
		_actions.put("DeleteSource", action);		
		
		action = new DownloadSourceAction();
		_actions.put("DownloadSource", action);		
		
		action = new ShowSourceAction();
		_actions.put("ShowSource", action);		
		
		action = new ShowAllSourceAction();
		_actions.put("ShowAllSource", action);	
		
		action = new UpdateSourceAction();
		_actions.put("UpdateSource", action);	
		
		
		// !!! Task Actions !!!

		action = new AddNewTaskAction();
		_actions.put("AddNewTask", action);		
		
		action = new DeleteTaskAction();
		_actions.put("DeleteTask", action);		
		
		action = new ShowAllTasksAction();
		_actions.put("ShowAllTasks", action);		
		
		action = new ShowAllOwnTasksAction();
		_actions.put("ShowAllOwnTasks", action);		
		
		action = new UpdateTaskAction();
		_actions.put("UpdateTask", action);	
		
		
		// !!! User Actions !!!
		
		action = new DeleteUserAction();
		_actions.put("DeleteUser", action);		
		
		action = new ShowUserSettingsAction();
		_actions.put("ShowUserSettings", action);	
		
		action = new ShowUserInfoAction();
		_actions.put("ShowUserInfo", action);		
		
		action = new SearchUserAction();
		_actions.put("SearchUser", action);		
		
		action = new UpdateUserSettingsAction();
		_actions.put("UpdateUserSettings", action);		
		
		action = new ShowAllUserAction();
		_actions.put("ShowAllUser", action);
		
		action = new LoginAction();
		_actions.put("Login", action);		
		
		action = new LogoutAction();
		_actions.put("Logout", action);
		
		action = new RegisterAction();
		_actions.put("Register", action);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhb.music.controller.web.HttpServletControllerBase#getOperation(javax
	 * .servlet.http.HttpServletRequest)
	 */
	protected String getOperation(HttpServletRequest req) {
		// do ist in diesem Fall der Steuerbefahl z.B. ?do=selectCD&cdId=1
		return req.getParameter("do");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Session holen
		HttpSession session = req.getSession();

		//Player fuer die Session erzeugen falls noch nicht erzeugt
		if (session.getAttribute("mainController") == null) {
			_mainController = new MainControl();
			//HttpSession ist nicht Threadsave deswegn Synchronized
			synchronized(session){
				session.setAttribute("mainController", _mainController);
			}
		}
		
		super.doGet(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		//Session holen
		HttpSession session = req.getSession();
		
		
		//Player fuer die Session erzeugen falls noch nicht erzeugt
		if (session.getAttribute("mainController") == null) {
			_mainController = new MainControl();
			//HttpSession ist nicht Threadsave deswegn Synchronized
			synchronized(session){
				session.setAttribute("mainController", _mainController);				
			}
		}

		super.doPost(req, resp);
	}
}
