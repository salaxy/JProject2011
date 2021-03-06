package de.fhb.jproject.manager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Hauptmanager fuer die Aktionen (Haupt BO-Klasse),
 * besitzt die Untermanager(BOs) zu den einzelnen Teilbereichen
 * an Abfragen und Aktionen des systems
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
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

	

	/**
	 * 
	 */
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


	/**
	 * 
	 * @return
	 */
	public ProjectManager getProjectManager() {
		return projectManager;
	}


	/**
	 * 
	 * @return
	 */
	public SourceManager getSourceManager() {
		return sourceManager;
	}


	/**
	 * 
	 * @return
	 */
	public TaskManager getTaskManager() {
		return taskManager;
	}


	/**
	 * 
	 * @return
	 */
	public DocumentManager getDocumentManager() {
		return documentManager;
	}


	/**
	 * 
	 * @return
	 */
	public CommentManager getCommentManager() {
		return commentManager;
	}


	/**
	 * 
	 * @return
	 */
	public UserManager getUserManager() {
		return userManager;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ProjectRolesManager getProjectRolesManager(){
		return projectRolesManager;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public GlobalRolesManager getGlobalRolesManager(){
		return globalRolesManager;
	}
}
