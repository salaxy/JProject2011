package de.fhb.jproject.manager;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class DocumentManager {

	private ProjectRolesManager projectRolesManager;
	private GlobalRolesManager globalRolesManager;
	
	public DocumentManager(ProjectRolesManager projectRolesManager, GlobalRolesManager globalRolesManager){
		
		this.projectRolesManager=projectRolesManager;
		this.globalRolesManager=globalRolesManager;
	}
	
	// !!! Dokument Actions !!!
	
	public void addNewDocu(Project aktProject, List<FileItem> fields)throws ProjectException{}
		
	public void deleteDocu(){}
	
	public void downloadDocu(){}
	
	public void showAllDocu(){}
	
	public void updateDocu(){}
	
	public void showDocu(){}
	
	private void clearSession() throws PersistentException{
		PersistentSession session;		
		//Session holen
		session = JProjectPersistentManager.instance().getSession();
		//und bereinigen
		session.clear();
	}
	
}
