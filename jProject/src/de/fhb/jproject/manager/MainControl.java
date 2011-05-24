package de.fhb.jproject.manager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class MainControl{
	/*
	 *	+CommentProjectAction
		+ShowAllComments41DocuAction
		+ShowAllComments41SourceAction
		+ShowAllComments41TaskAction
		+ShowAllComments41ProjectAction
		+UpdateCommentAction
		+ShowDocuAction
		+UpdateDocuAction
		+ShowAllMemberAction
		+UpdateSourceAction
		+ShowUserInfoAction
	 */
	
    private static final Logger rootLogger = Logger.getRootLogger();
    private static final Logger logger = Logger.getLogger(MainControl.class);
    
	private UserControl userController;
	private ProjectControl projectContoller;
	private SourceControl sourceContoller;
	private TaskControl taskcontroller;
	private DocumentControl documentController;
	private CommentControl commentController;
	private ProjectRolesControl projectRolesController;	
	private GlobalRolesControl globalRolesController;

	

	public MainControl() {
		rootLogger.setLevel(Level.DEBUG);
		
		globalRolesController=new GlobalRolesControl();	
//		GlobalRolesContoller
//		ProjectRolesContoller
		userController=new UserControl(globalRolesController);		
		
		
		projectContoller=new ProjectControl(userController.getAktUser(), projectRolesController);
		sourceContoller=new SourceControl(userController.getAktUser(), projectRolesController);
		taskcontroller=new TaskControl(userController.getAktUser(), projectRolesController);
		documentController=new DocumentControl(userController.getAktUser(), projectRolesController);
		commentController=new CommentControl(userController.getAktUser(), projectRolesController);
		
	}


	public ProjectControl getProjectContoller() {
		return projectContoller;
	}


	public SourceControl getSourceController() {
		return sourceContoller;
	}


	public TaskControl getTaskcontroller() {
		return taskcontroller;
	}


	public DocumentControl getDocumentController() {
		return documentController;
	}


	public CommentControl getCommentController() {
		return commentController;
	}


	public UserControl getUserController() {
		return userController;
	}
	
	
	public ProjectRolesControl getProjectRolesController(){
		return projectRolesController;
	}
	
	
	public GlobalRolesControl getGlobalRolesController(){
		return globalRolesController;
	}
}
