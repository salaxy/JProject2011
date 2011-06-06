package de.fhb.jproject.manager;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class DocumentControl {

	private User aktUser;
	private ProjectRolesControl projectRolesController;
	
	public DocumentControl(User aktUser, ProjectRolesControl projectRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
	}
	
	// !!! Dokument Actions !!!
	
	public void addNewDocu(){}
		
	public void deleteDocu(){}
	
	public void downloadDocu(){}
	
	public void showAllDocu(){}
	
	public void updateDocu(){}
	
	public void showDocu(){}
	
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
