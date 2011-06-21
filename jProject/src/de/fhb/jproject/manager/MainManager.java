package de.fhb.jproject.manager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Hauptmanager fuer die Aktionen (Haupt BO-Klasse),
 * besitzt die Untermanager(BOs) zu den einzelnen Teilbereichen
 * an Abfragen und Aktionen des systems
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>, Michael Koppen <michael.koppen@googlemail.com>
 * 
 */
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
		rootLogger.setLevel(Level.INFO);
		
		globalRolesManager=new GlobalRolesManager();	
		projectRolesManager= new ProjectRolesManager();
		
		userManager=new UserManager();		
		
		projectManager=new ProjectManager();
		sourceManager=new SourceManager();
		taskManager=new TaskManager();
		documentManager=new DocumentManager();
		commentManager=new CommentManager();
		
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
	
	
	public ProjectRolesManager getProjectRolesManager(){
		return projectRolesManager;
	}
	
	
	public GlobalRolesManager getGlobalRolesManager(){
		return globalRolesManager;
	}
}
