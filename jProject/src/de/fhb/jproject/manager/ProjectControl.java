package de.fhb.jproject.manager;

import java.util.List;
import java.util.logging.Level;

import org.apache.log4j.Logger;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import org.orm.PersistentException;

public class ProjectControl {

	User aktUser;
	ProjectRolesControl projectRolesController;
	boolean dummy=false;
	private static final Logger logger = Logger.getLogger(ProjectControl.class);
	
	public ProjectControl(User aktUser, ProjectRolesControl projectRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
	}
	

	/**
	 *  Hinzufuegen eines Users zu einem Projekt
	 */
	public void addMember(String userLoginName, String projectName, String rolle)
	throws ProjectException{ 	
		
		Project project=null;
		Member member=null;
		
		//debuglogging
		logger.info("addMember()");
		logger.debug("String userName("+userLoginName+")"+"String projectName("+projectName+")"+"String rolle("+ rolle+")");
		
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//projekt holen
			project=DAFactory.getDAFactory().getProjectDA().loadProjectByORMID(projectName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekt nicht laden! "+ ex);
		}
		
		//member erzeugen und parameter setzen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		member.setProjectName(project);
		member.setProjectRole(rolle);
		//TODO rolle richtig einbauen
		try {
			//user holen und setzen
			member.setUserLoginName(DAFactory.getDAFactory().getUserDA().loadUserByORMID(userLoginName));
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Member nicht laden! "+ ex);
		}
		
	}
	
	
	
	public void addNewProject(String name, String status)
	throws ProjectException{ 
		
		Project project=null;
		Member member=null;
		
		//debuglogging
		logger.info("addNewProject()");
		logger.debug("String name("+name+")"+"String status("+status+")");
		
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		
		
		//project parameter setzen
		project=DAFactory.getDAFactory().getProjectDA().createProject();
		project.setName(name);
		project.setStatus(status);
		
		//project erzeuger als member erzeugen und hinzufuegen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		member.setProjectNameId(name);
		member.setUserLoginNameId(aktUser.getLoginName());
		project.member.add(member);
		try {
			//projekt speichern
			DAFactory.getDAFactory().getProjectDA().save(project);
			
			//TODO rechte richtig setzen
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekt nicht speichern! "+ ex);
		}
	}	
	
	public void deleteProject(String name)
	throws ProjectException{ 
		
		//debuglogging
		logger.info("deleteProject(String name)");
		logger.debug("String name("+name+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//loeschen
			DAFactory.getDAFactory().getProjectDA().delete(name);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Project nicht loeschen! "+ ex);
		}
	}	
	
	public void deleteMember(){}
	
	public Project showProject(String name)
	throws ProjectException{ 
		
		//debuglogging
		logger.info("showProject()");
		logger.debug("String name("+name+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//holen der Daten
			return DAFactory.getDAFactory().getProjectDA().loadProjectByORMID(name);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekt nicht laden! "+ ex);
		}
		
	}
	
	public void  searchProjects(){}
	
	public List<Project>  showAllProjects()
	throws ProjectException{ 
		
		//debuglogging
		logger.info("showAllProjects()");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//holen der Daten
			return DAFactory.getDAFactory().getProjectDA().listAllProjects();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projektliste nicht laden! "+ ex);
		}
	}
	
	public void  showAllOwnProjects(){}
	
	public void  ShowAllMember(){}
	
	private boolean isUserLoggedIn() {		
		return (aktUser.getLoginName()!=null)&&(aktUser.getLoginName()!=null)&&(aktUser.getLoginName()!=null);
		//TODO einer w�rde vieleicht auch reichen
	}
	
	
}
