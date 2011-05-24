package de.fhb.jproject.manager;

import de.fhb.jproject.data.User;

public class CommentControl {
	
	User aktUser;
	ProjectRolesControl projectRolesController;
	
	public CommentControl(User aktUser, ProjectRolesControl projectRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
	}
	
	// !!! Comment Actions !!!
	
	public void commentDocu(){}
			
	public void commentSource(){}
	
	public void commentTask(){}
	
	public void deleteComment(){}
	
	public void showComment(){}
	
}
