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
	
	public void deleteComment(){
		
		//wer kann ein aufgabe l�schen
		//owner/ersteller, admin, projekLEADER
	}
	
	public void commentProject(){}
	
	public void updateComment(){
		//wer kann ein comment l�schen
		//owner/ersteller, admin, projekLEADER
		
	}
	
	public void showAllComments41Docu(){}
	
	public void showAllComments41Source(){}
	
	public void showAllComments41Task(){}
	
	public void showAllComments41Project(){}
	
}
