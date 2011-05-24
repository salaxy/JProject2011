package de.fhb.jproject.manager;

import de.fhb.jproject.exceptions.ProjectException;
import java.util.Arrays;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;

public class ProjectControl {

	User aktUser;
	ProjectRolesControl projectRolesController;
	
	public ProjectControl(User aktUser, ProjectRolesControl projectRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
	}
	
	// !!! Projekt Actions !!!

	public void  addMember(){}
	
	public void  addNewProject(){}	
	
	public void  deleteProject(){}	
	
	public void  deleteMember(){}
	
	public void  showProject(){}
	
	public void  searchProjects(){}
	
	public List<Project>  showAllProjects()
	throws ProjectException{		
        
//		DebugSystem.println(DebugSystem.LEVELCONTROL, "ProjectControl.showAllProjects()");
				
		Project[] projectArray = null;
        PersistentSession session = null;

        try {
        	session = JProjectPersistentManager.instance().getSession();
        	
            try {
                //Projecte holen
				
            	projectArray = DAOFactory.getDAOFactory().getProjectDAO().listProjectByQuery("Project.name = Project.name", "name");
            	
    			if(projectArray==null){
    				throw new ProjectException("Projekte nicht gefunden");
    			}
    			
    			session.close();
//    			DebugSystem.println(DebugSystem.LEVELCONTROL, "Closing Connection!");
    		
            } catch (PersistentException e) {
                //t.rollback();
                session.close();
                e.printStackTrace();
            }
        
        } catch (PersistentException e) {
            e.printStackTrace();
			throw new ProjectException("Projekte nicht gefunden");
        }
		
		return Arrays.asList(projectArray);
	}
	
	public void  showAllOwnProjects(){}
	
	
	
}
