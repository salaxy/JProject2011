package de.fhb.jproject.manager;

import de.fhb.jproject.data.User;

public class CommentControl {
	
	User aktUser;
	ProjectRolesControl projectRolesController;
	
	public CommentControl(User aktUser){
		
		this.aktUser=aktUser;
		this.projectRolesController=ProjectRolesControl.getInstance();
	}
	
	// !!! Comment Actions !!!
	
	
	public void commentDocu(){}
			
	public void commentSource(){}
	
	public void commentTask(){}
	
	public void deleteComment(){}
	
	public void commentProject(){}
	
	public void updateComment(){}
	
	public void showAllComments41Docu(){}
	
	public void showAllComments41Source(){}
	
	public void showAllComments41Task(){}
	
	public void showAllComments41Project(){}
	
}
