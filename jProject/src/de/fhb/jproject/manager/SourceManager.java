package de.fhb.jproject.manager;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class SourceManager {
	
	private ProjectRolesManager projectRolesManager;
	private GlobalRolesManager globalRolesManager;
	
	public SourceManager(ProjectRolesManager projectRolesManager, GlobalRolesManager globalRolesManager){
		
		this.projectRolesManager=projectRolesManager;
		this.globalRolesManager=globalRolesManager;
	}
	
	// !!! Source Actions !!!
	
	public void  addNewSource(){}	
	
	public void  deleteSource(){}	
	
	public void  downloadSource(){}	
	
	public void  showSource(){}	
	
	public void  showAllSource(){}	
	
	public void  updateSource(){}
	
	private void clearSession() throws PersistentException{
		PersistentSession session;		
		//Session holen
		session = JProjectPersistentManager.instance().getSession();
		//und bereinigen
		session.clear();
	}
}
