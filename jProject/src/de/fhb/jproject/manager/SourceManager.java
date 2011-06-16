package de.fhb.jproject.manager;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import java.util.List;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class SourceManager {
	
	
	public SourceManager(){
		
	}
	
	// !!! Source Actions !!!
	
	public void  addNewSource(){}	
	
	public void  deleteSource(){}	
	
	public void  downloadSource(){}	
	
	public Sourcecode  showSource(User aktUser, String projectName, int documentId)throws ProjectException{return null;}
	
	public List<Sourcecode>  showAllSource(User aktUser, String projectName)throws ProjectException{return null;}	
	
	public void  updateSource(){}
	
	private void clearSession() throws PersistentException{
		PersistentSession session;		
		//Session holen
		session = JProjectPersistentManager.instance().getSession();
		//und bereinigen
		session.clear();
	}
}
