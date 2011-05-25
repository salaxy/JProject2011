package de.fhb.jproject.manager;

import de.fhb.jproject.data.User;

public class TaskControl {
	
	User aktUser;
	ProjectRolesControl projectRolesController;
	
	public TaskControl(User aktUser){
		
		this.aktUser=aktUser;
		this.projectRolesController=ProjectRolesControl.getInstance();
	}

	// !!! Task Actions !!!

	public void  addNewTask(){}	
	
	public void  deleteTask(){}		
	
	public void  showAllTasks(){}		
	
	public void  showAllOwnTasks(){}		
	
	public void  updateTask(){}
	
}
