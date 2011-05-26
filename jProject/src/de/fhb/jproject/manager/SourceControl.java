package de.fhb.jproject.manager;

import de.fhb.jproject.data.User;

public class SourceControl {
	
	User aktUser;
	ProjectRolesControl projectRolesController;
	
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
}
