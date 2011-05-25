package de.fhb.jproject.manager;

import java.util.List;

import org.apache.log4j.Logger;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;

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
				
		//projekt holen
		project=DAFactory.getDAFactory().getProjectDA().findProject(projectName);
		
		//member erzeugen und parameter setzen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		member.setProjectName(project);
		member.setProjectRole(rolle);
		//TODO rolle richtig einbauen
		
		//user holen und setzen
		member.setUserLoginName(DAFactory.getDAFactory().getUserDA().findUser(userLoginName));
		
		//unötig wird in set .setProjectName(project); schon realisiert
//		//member hinzu
//		project.member.add(member);
		
		//speichern
		DAFactory.getDAFactory().getProjectDA().saveProject(project);
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
		
		//projekt speichern
		DAFactory.getDAFactory().getProjectDA().saveProject(project);
		
		//TODO rechte richtig setzen
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
		DAFactory.getDAFactory().getProjectDA().deleteProject(name);
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
		return DAFactory.getDAFactory().getProjectDA().findProject(name);
		
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
		
		//holen der Daten
		return DAFactory.getDAFactory().getProjectDA().listAllProjects();
	}
	
	public void  showAllOwnProjects(){}
	
	public void  ShowAllMember(){}
	
	private boolean isUserLoggedIn() {		
		return (aktUser.getLoginName()!=null)&&(aktUser.getLoginName()!=null)&&(aktUser.getLoginName()!=null);
		//TODO einer würde vieleicht auch reichen
	}
	
	
}
