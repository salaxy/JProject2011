package de.fhb.jproject.manager;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;

public class TaskControl {
	
	User aktUser;
	ProjectRolesControl projectRolesController;
	GlobalRolesControl globalRolesController;
	private static final Logger logger = Logger.getLogger(ProjectControl.class);
	
	public TaskControl(User aktUser, ProjectRolesControl projectRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
	}

	// !!! Task Actions !!!

	public void  addNewTask(){
//	throws ProjectException{ 
//		
//		Project project=null;
//		Member member=null;
//		
//		//debuglogging
//		logger.info("addNewProject()");
//		logger.debug("String name("+name+")"+"String status("+status+")");
//		
//        //abfrage ob user eingeloggt
//		if(!isUserLoggedIn()){
//            throw new ProjectException("Sie sind nicht eingeloggt!");
//        }
//		
//		//RECHTE-ABFRAGE Global
//		if(!globalRolesController.isAllowedAddNewProjectAction(aktUser.getGlobalRole())){
//			throw new ProjectException("Sie haben keine Rechte zum erstellen eines Projektes!");
//		}
//		
//		//project parameter setzen
//		project=DAFactory.getDAFactory().getProjectDA().createProject();
//		project.setName(name);
//		project.setStatus(status);
//		
//		//project erzeuger als member erzeugen und hinzufuegen
//		member=DAFactory.getDAFactory().getMemberDA().createMember();
//		member.setProjectNameId(name);
//		member.setUserLoginNameId(aktUser.getLoginName());
//		member.setProjectRole("Leader");
//		
//		//projekt speichern
//		try {		
//			DAFactory.getDAFactory().getProjectDA().save(project);
//		} catch (PersistentException e) {
//            throw new ProjectException("Konnte Projekt nicht erstellen!");
//		}

	}	
	
	public void  deleteTask(){}		
	
	/** 
	 *  Anzeigen aller Aufgaben
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public List<Task> showAllTasks(String projectName)
	throws ProjectException{ 
			
		Project project=null;
		Member memAktUser=null;	
		
		//debuglogging
		logger.info("showAllTasks()");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=DAFactory.getDAFactory().getProjectDA().getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Projekt-Rolle des aktuellen Users holen
		try {
			memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}	
		
		//RECHTE-ABFRAGE projekt
		if(!projectRolesController.isAllowedShowAllTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum Anzeigen der Aufgaben/Tasks !");
		}
		
		return Arrays.asList(project.task.toArray());
	}		
	
	public void  showAllOwnTasks(){}		
	
	public void  updateTask(){}
	
	private boolean isUserLoggedIn() {		
		//TODO irgentwie ist das noch nicht richtig soo		
		return (aktUser!=null);
	}
	
}
