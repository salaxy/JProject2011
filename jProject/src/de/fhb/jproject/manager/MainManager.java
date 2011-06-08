package de.fhb.jproject.manager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class MainManager{
	
    private static final Logger rootLogger = Logger.getRootLogger();
    private static final Logger logger = Logger.getLogger(MainManager.class);
    
	private UserManager userManager;
	private ProjectManager projectManager;
	private SourceManager sourceManager;
	private TaskManager taskManager;
	private DocumentManager documentManager;
	private CommentManager commentManager;
	private ProjectRolesManager projectRolesManager;	
	private GlobalRolesManager globalRolesManager;

	

	public MainManager() {
		rootLogger.setLevel(Level.OFF);
		
		globalRolesManager=new GlobalRolesManager();	
		projectRolesManager= new ProjectRolesManager();
		
		userManager=new UserManager(globalRolesManager);		
		
		projectManager=new ProjectManager(projectRolesManager,globalRolesManager);
		sourceManager=new SourceManager(projectRolesManager,globalRolesManager);
		taskManager=new TaskManager(projectRolesManager,globalRolesManager);
		documentManager=new DocumentManager(projectRolesManager,globalRolesManager);
		commentManager=new CommentManager(projectRolesManager, globalRolesManager);
		
	}


	public ProjectManager getProjectManager() {
		return projectManager;
	}


	public SourceManager getSourceManager() {
		return sourceManager;
	}


	public TaskManager getTaskManager() {
		return taskManager;
	}


	public DocumentManager getDocumentManager() {
		return documentManager;
	}


	public CommentManager getCommentManager() {
		return commentManager;
	}


	public UserManager getUserManager() {
		return userManager;
	}
	
	
//	public ProjectRolesManager getProjectRolesManager(){
//		return projectRolesManager;
//	}
//	
//	
//	public GlobalRolesManager getGlobalRolesManager(){
//		return globalRolesManager;
//	}
}
