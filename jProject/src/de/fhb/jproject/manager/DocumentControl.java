package de.fhb.jproject.manager;

import de.fhb.jproject.data.User;

public class DocumentControl {

	User aktUser;
	ProjectRolesControl projectRolesController;
	
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
	
}
