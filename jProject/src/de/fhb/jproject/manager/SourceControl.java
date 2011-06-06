package de.fhb.jproject.manager;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class SourceControl {
	
	private User aktUser;
	private ProjectRolesControl projectRolesController;
	
	public SourceControl(User aktUser, ProjectRolesControl projectRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
	}
	
	// !!! Source Actions !!!
	
	public void  addNewSource(){}	
	
	public void  deleteSource(){}	
	
	public void  downloadSource(){}	
	
	public void  showSource(){}	
	
	public void  showAllSource(){}	
	
	public void  updateSource(){}
	
	private void logged() throws ProjectException{
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
	}
	private void clearSession() throws PersistentException{
		PersistentSession session;		
		//Session holen
		session = JProjectPersistentManager.instance().getSession();
		//und bereinigen
		session.clear();
	}
}
