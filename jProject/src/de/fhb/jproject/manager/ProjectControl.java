package de.fhb.jproject.manager;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.apache.log4j.Logger;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import java.util.ArrayList;
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
	GlobalRolesControl globalRolesController;
	
	private static final Logger logger = Logger.getLogger(ProjectControl.class);
	
	public ProjectControl(User aktUser, ProjectRolesControl projectRolesController, GlobalRolesControl globalRolesController){
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
		this.globalRolesController=globalRolesController;
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
		
		//TODO abfangen ob zul�ssige rolle mitgegebn	
		//solange werden nur leader hinzugef�gt
		rolle="Leader";
		
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
			
//		//Projekt-Rolle des aktuellen Users holen
//		try {
//			memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
//		} catch (PersistentException e1) {
//			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
//		}
//		
//		//RECHTE-ABFRAGE Projekt
//		if(!projectRolesController.isAllowedAddMemberAction(memAktUser.getProjectRole())){
//			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen eines Members!");
//		}			

		//EIGENTLICHE AKTIONEN
		
		//member erzeugen und parameter setzen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		
		//project setzen (impliziert hier auch das adden zum project ) >>> project.member.add(member); ist un�tig
		member.setProject(project);
		member.setProjectId(project.getName());
		
		//rolle setzen
		member.setProjectRole(rolle);
		
		//user holen und setzen
		try {
			User tempUser = DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName);
			member.setUser(tempUser);
			member.setUserId(tempUser.getLoginName());
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte den User nicht finden! "+ e1.getMessage());
		}
		
		
//		try {
//			DAFactory.getDAFactory().getProjectDA().evict(project);
//		} catch (PersistentException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//speichern	
		try {	
			System.out.println("member: "+member.getProjectId());
			System.out.println("member: "+member.getUserId());
			System.out.println("member: "+member.getProjectRole());
			System.out.println("member: "+member.getUser());
			System.out.println("member: "+member.getProject());
			DAFactory.getDAFactory().getMemberDA().save(member);
		} catch (PersistentException e) {
            throw new ProjectException("Konnte Projekt oder User nicht finden!" +e.getMessage());
		}
	}
	
	/**
	 * ein user erstellt ein neues Projekt
	 * @param name
	 * @param status
	 * @throws ProjectException
	 */
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
		
		//RECHTE-ABFRAGE Global
		if(!globalRolesController.isAllowedAddNewProjectAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum erstellen eines Projektes!");
		}
		
		//project parameter setzen
		project=DAFactory.getDAFactory().getProjectDA().createProject();
		project.setName(name);
		project.setStatus(status);
		
		//project erzeuger als member erzeugen und hinzufuegen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		member.setProjectId(name);
		member.setUserId(aktUser.getLoginName());
		member.setProjectRole("Leader");
		
		//projekt speichern
		try {		
			DAFactory.getDAFactory().getProjectDA().save(project);
		} catch (PersistentException e) {
            throw new ProjectException("Konnte Projekt nicht erstellen!");
		}
	}	
	
	/**
	 * loeschen eines Projektes
	 * @param name
	 * @throws ProjectException
	 */
	public void deleteProject(String projectName)
	throws ProjectException{ 
		
		Project project=null;
		Member memAktUser=null;	
		
		//debuglogging
		logger.info("deleteProject()");
		logger.debug("String name("+projectName+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//TODO Admin und ProjektLeader sind berechtigt 
		//projekt holen
//		try {
//			project=DAFactory.getDAFactory().getProjectDA().getProjectByORMID(projectName);
//		} catch (PersistentException e1) {
//			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
//		}	
//			
//		//Projekt-Rolle des aktuellen Users holen
//		try {
//			memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
//		} catch (PersistentException e1) {
//			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
//		}
		
//		//RECHTE-ABFRAGE Projekt
//		if(!projectRolesController.isAllowedDeleteProjectAction(memAktUser.getProjectRole())){
//			throw new ProjectException("Sie haben keine Rechte das Projekt zu loeschen!");
//		}	
		
		//EIGENTLICHE AKTIONEN
		
		//loeschen
		try {	
			DAFactory.getDAFactory().getProjectDA().delete(project);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Projekt nicht loeschen! "+ e.getMessage());
		}	
	}	
	
	/**
	 *  Member aus einen Projekt entfernen
	 * @param userLoginName
	 * @param projectName
	 * @throws ProjectException
	 */
	public void deleteMember(String userLoginName, String projectName)
	throws ProjectException{ 
		
		Project project=null;
		Member memAktUser=null;
		Member delMember=null;
		User user=null;
		
		//debuglogging
		logger.info("deleteMember()");
		logger.debug("String name("+userLoginName+")"+"String name("+projectName+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//TODO Admin und ProjektLeader sind berechtigt 
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
		
		//RECHTE-ABFRAGE Projekt
		if(!projectRolesController.isAllowedDeleteMemberAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte den Member zu loeschen!");
		}	
		
		//EIGENTLICHE AKTIONEN
		
		//User holen
		try {
			user=DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte User nicht finden! "+ e1.getMessage());
		}
		
		//zuloeschenden Member holen
		try {
			delMember=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(user, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht loeschen! "+ e1.getMessage());
		}
		
		//loeschen
		try {	
			DAFactory.getDAFactory().getMemberDA().delete(delMember);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Projekt nicht loeschen! "+ e.getMessage());
		}	
	}
	
	/**
	 * Projekt-daten holen
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public Project showProject(String projectName)
	throws ProjectException{ 
		
		Project project=null;	
		
		//debuglogging
		logger.info("showProject()");
		logger.debug("String name("+projectName+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(!globalRolesController.isAllowedShowProjectAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte!");
		}		
		
		//projekt holen
		try {
			project=DAFactory.getDAFactory().getProjectDA().getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		
		return project;
	}
	
	public List<Project> searchProjects(String teilName)
	throws ProjectException{
		
		List<Project> list=null;
		
		//debuglogging
		logger.info("searchProjects()");
		logger.debug("String teilName("+teilName+")");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//RECHTE-ABFRAGE Global
		if(!globalRolesController.isAllowedSearchProjectsAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum Scuhen der Projekte!");
		}	
		
		//holen der Daten
		//TODO suche implementieren
//		try {
//			list=DAFactory.getDAFactory().getProjectDA().listAllProjects();
//		} catch (PersistentException e) {
//			e.printStackTrace();
//			throw new ProjectException("Kann kein Projekt finden! "+ e.getMessage());
//		}
		
		return list;	
	}
	
	/**
	 * anzeigen aller existierenden Projekte
	 * @return
	 * @throws ProjectException
	 */
	public List<Project> showAllProjects()
	throws ProjectException{ 
		
		List<Project> list=null;
		
		//debuglogging
		logger.info("showAllProjects()");
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//RECHTE-ABFRAGE Global
		if(!globalRolesController.isAllowedShowAllProjectsAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum Anzeigen der Projekte!");
		}	
		
		//holen der Daten
		try {
			list=DAFactory.getDAFactory().getProjectDA().listAllProjects();
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Kann kein Projekt finden! "+ e.getMessage());
		}
		
		return list;
	}
	
	/**
	 * Anzeigen aller projekte des aktuellen Users
	 * @return
	 * @throws ProjectException
	 */
	public List<Project> showAllOwnProjects()
	throws ProjectException{
		//debuglogging
		logger.info("showAllOwnProjects()");
		List<Project> list=new ArrayList<Project>();
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//RECHTE-ABFRAGE Global
		if(!globalRolesController.isAllowedShowAllOwnProjectsAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum Anzeigen der Projekte!");
		}
		
		for (Member aktMember : aktUser.member.toArray()) {
			list.add(aktMember.getProject());
		}
		
		return list;
	}
	
	public List<Member> showAllMember(String projectName)
	throws ProjectException{
		
		Project project=null;
		Member memAktUser=null;
		
		//debuglogging
		logger.info("ShowAllMember()");
		logger.debug("String name("+projectName+")");
		
        //abfrage ob user eingeloggt
		
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		//projekt holen
		try {
			project=DAFactory.getDAFactory().getProjectDA().loadProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		//Projekt-Rolle des aktuellen Users holen
		try {
			memAktUser=DAFactory.getDAFactory().getMemberDA().loadMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		//RECHTE-ABFRAGE projekt
		if(!projectRolesController.isAllowedShowAllMemberAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum Anzeigen der Member!");
		}
		
		return Arrays.asList(project.member.toArray());
		//aus performance gr�nden habe ich hier keine auslagerung vorgenommen,
		//da das project eh schon vorliegt, keine extra anfrage notwendig
			
	}
	
	
	private boolean isUserLoggedIn() {		
		//TODO irgentwie ist das noch nicht richtig soo		
		return (aktUser.getLoginName()!=null);
	}
}

