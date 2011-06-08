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
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.manager.MainManager;
import java.util.List;
import javax.servlet.RequestDispatcher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

@WebServlet("/JProjectServlet")
public class JProjectServlet extends HttpServletControllerBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(JProjectServlet.class);
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws IOException, ServletException{
		if (!(getOperation(req).equals("Logout")) && session.getAttribute("aktUser")!=null) {	
			synchronized(session){
				/*TODO DELETE ACTION
				ShowAllOwnProjectsAction showAllOwnProjectsAction = new ShowAllOwnProjectsAction();
				showAllOwnProjectsAction.perform(req, resp);
				 * 
				 */
				//TODO BO-ACCESS LAYOUT

				List<Project> ownProjectList = null;

				try {
					ownProjectList = mainManager.getProjectManager().showAllOwnProjects((User)session.getAttribute("aktUser"));
				} catch (ProjectException ex) {
					logger.error(ex.getMessage(), ex);
					req.setAttribute("contentFile", "error.jsp");
					req.setAttribute("errorString", ex.getMessage());
				}
				//Show all other loggedIn-Stuff...
				//Session fuer topNaviLinks
				session.setAttribute("ownProjectList", ownProjectList);



				//TODO Comments per AJAX
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhb.music.controller.web.HttpServletManagerBase#init(javax.servlet
	 * .ServletConfig)
	 */
	public void init(ServletConfig conf) throws ServletException {
		HttpRequestActionBase action = null;
		actions = new HashMap();
		
		//Actions hinzufuegen
		
		// !!! Kommentar Actions !!!
		
		//kommentieren eines Dokuments
		action = new CommentDocuAction();
		actions.put("CommentDocu", action);
				
		action = new CommentSourceAction();
		actions.put("CommentSource", action);
		
		action = new CommentProjectAction();
		actions.put("CommentProject", action);
		
		action = new CommentTaskAction();
		actions.put("CommentTask", action);
		
		action = new DeleteCommentAction();
		actions.put("DeleteComment", action);
		
		action = new ShowAllComments41DocuAction();
		actions.put("ShowAllComments41Docu", action);
		
		action = new ShowAllComments41SourceAction();
		actions.put("ShowAllComments41Source", action);
		
		action = new ShowAllComments41TaskAction();
		actions.put("ShowAllComments41Task", action);
		
		action = new ShowAllComments41ProjectAction();
		actions.put("ShowAllComments41Project", action);
		
		action = new UpdateCommentAction();
		actions.put("UpdateComment", action);
		
	
		
		// !!! Dokument Actions !!!
		
		action = new AddNewDocuAction();
		actions.put("AddNewDocu", action);
			
		action = new DeleteDocuAction();
		actions.put("DeleteDocu", action);
		
		action = new DownloadDocuAction();
		actions.put("DownloadDocu", action);
		
		action = new ShowAllDocuAction();
		actions.put("ShowAllDocu", action);
		
		action = new UpdateDocuAction();
		actions.put("UpdateDocu", action);
		
		action = new ShowDocuAction();
		actions.put("ShowDocu", action);
		
		// !!! Projekt Actions !!!

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
		
		action = new ShowAllProjectsAction();
		actions.put("ShowAllProjects", action);
		
		action = new ShowAllOwnProjectsAction();
		actions.put("ShowAllOwnProjects", action);		
		
		action = new ShowAllMemberAction();
		actions.put("ShowAllMember", action);
		
		
		// !!! Source Actions !!!
		
		
		action = new AddNewSourceAction();
		actions.put("AddNewSource", action);		
		
		action = new DeleteSourceAction();
		actions.put("DeleteSource", action);		
		
		action = new DownloadSourceAction();
		actions.put("DownloadSource", action);		
		
		action = new ShowSourceAction();
		actions.put("ShowSource", action);		
		
		action = new ShowAllSourceAction();
		actions.put("ShowAllSource", action);	
		
		action = new UpdateSourceAction();
		actions.put("UpdateSource", action);	
		
		
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
		
		action = new LoginAction();
		actions.put("Login", action);		
		
		action = new LogoutAction();
		actions.put("Logout", action);
		
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
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			//Player fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null || getOperation(req).equals("Login")) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
		}
		super.doGet(req, resp);
		
		processRequest(req, resp, session);
		
		
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
		List<FileItem> fields = null;
		if (isMultipartContent) {
				
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				
				fields = upload.parseRequest(req);
			} catch (FileUploadException e) {
				System.out.println("FAIL");
			}
		}
		System.out.println("OP: "+req.getParameter("do"));
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			//Player fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null || getOperation(req).equals("Login")) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
		}
		super.doPost(req, resp);
		
		processRequest(req, resp, session);
		
		
		logger.info("sending contentFile: "+req.getAttribute("contentFile"));
		
		RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
		reqDisp.forward(req, resp);
	}
}
