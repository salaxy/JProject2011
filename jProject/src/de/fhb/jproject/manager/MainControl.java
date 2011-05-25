package de.fhb.jproject.manager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class MainControl{
	
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
		rootLogger.setLevel(Level.OFF);
		
//		globalRolesController=new GlobalRolesControl();	
//		projectRolesController= new ProjectRolesControl();
		//INFO habe die beiden controller hier dr�ber zum singleton gemacht
		// warum...is total unnötig...dann kannste auch alle controller als singleton machen
		//man hör auf mit solchen experimenten
		
		userController=new UserControl();		
		
		projectContoller=new ProjectControl(userController.getAktUser());
		sourceContoller=new SourceControl(userController.getAktUser());
		taskcontroller=new TaskControl(userController.getAktUser());
		documentController=new DocumentControl(userController.getAktUser());
		commentController=new CommentControl(userController.getAktUser());
		
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
