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

/**
 * Contoller Klasse fuer die ProjectActions
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class ProjectControl {
	User aktUser;
	ProjectRolesControl projectRolesController;
	
	boolean dummy=false;
	private static final Logger logger = Logger.getLogger(ProjectControl.class);
	
	public ProjectControl(User aktUser){
		
		this.aktUser=aktUser;
		this.projectRolesController=ProjectRolesControl.getInstance();
	}
	

	/**
	 *  Hinzufuegen eines Users zu einem Projekt
	 */
	public void addMember(String userLoginName, String projectName, String rolle)
	throws ProjectException{ 	
		
		Project project=null;
		Member member=null;
		Member memAktUser=null;		
		
		//debuglogging
		logger.info("addMember()");
		logger.debug("String userName("+userLoginName+")"+"String projectName("+projectName+")"+"String rolle("+ rolle+")");	
		
		//TODO abfangen ob zulässige rolle mitgegebn		
		
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
		
		//RECHTE-ABFRAGE
		if(projectRolesController.isAllowedAddMemberAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufügen eines Members!");
		}			

		//EIGENTLICHE AKTIONEN
		
		//member erzeugen und parameter setzen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		
		//project setzen (impliziert hier auch das adden zum project ) >>> project.member.add(member); ist unötig
		member.setProjectName(project);		
		
		//rolle setzen
		member.setProjectRole(rolle);
	
		//user holen und setzen
		try {
			member.setUserLoginName(DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte den User nicht finden! "+ e1.getMessage());
		}
		
		//speichern	
		try {	
			DAFactory.getDAFactory().getProjectDA().save(project);
		} catch (PersistentException e) {
            throw new ProjectException("Konnte Projekt oder User nicht finden!");
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
		
		//TODO Globale rechte abfragen
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
		

		try {		
			//projekt speichern
			DAFactory.getDAFactory().getProjectDA().save(project);
		} catch (PersistentException e) {
            throw new ProjectException("Konnte Projekt nicht erstellen!");
		}
		
	}	
	
	public void deleteProject(String name)
	throws ProjectException{ 
		
		//debuglogging
		logger.info("deleteProject()");
		logger.debug("String name("+name+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		
		//loeschen
		Project project=null;
		
		try {
			
			project = DAFactory.getDAFactory().getProjectDA().getProjectByORMID(name);		
			DAFactory.getDAFactory().getProjectDA().delete(project);
			
		} catch (PersistentException e) {
			
			throw new ProjectException("Kann Projekt nicht finden!");
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
		
		//holen der Daten
		try {
			return DAFactory.getDAFactory().getProjectDA().getProjectByORMID(name);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Project nicht finden!");
		}
	}
	
	public void  searchProjects(){}
	
	public List<Project>  showAllProjects()
	throws ProjectException{ 
		
		List<Project> list=null;
		
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
		
		//holen der Daten
		try {
			list=DAFactory.getDAFactory().getProjectDA().listAllProjects();
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Datenbank fehler!");
		}
		
		return list;
	}
	
	public void  showAllOwnProjects(){}
	
	public void  ShowAllMember(){}
	
	private boolean isUserLoggedIn() {		
		return (aktUser!=null);
		//TODO irgentwie ist das noch nicht richtig soo
	}
}

