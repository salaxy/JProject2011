package de.fhb.jproject.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;

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
	
	//Notiz: Get>>>komplett neu aus der DB, LOAD>> schon vorgehalten
	
	private static final Logger logger = Logger.getLogger(ProjectControl.class);
	
	public ProjectControl(User aktUser, ProjectRolesControl projectRolesController, GlobalRolesControl globalRolesController){
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
		this.globalRolesController=globalRolesController;
	}
	

	/**
	 *  Hinzufuegen eines Users zu einem Projekt
	 *  Notiz: Methode Funktioniert auch zum updaten
	 */
	public void addMember(String userLoginName, String projectName, String rolle)
	throws ProjectException{ 	
		
		Project project=null;
		Member member=null;
		Member memAktUser=null;		
		
		//debuglogging
		logger.info("addMember()");
		logger.debug("String userName("+userLoginName+")"+"String projectName("+projectName+")"+"String rolle("+ rolle+")");	
		
		if(!(rolle.equals(ProjectRolesControl.MEMBER)||rolle.equals(ProjectRolesControl.LEADER))){
            throw new ProjectException("Keine zulässige Rolle!");
		}
		
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
		
		//RECHTE-ABFRAGE Projekt
		if(!projectRolesController.isAllowedAddMemberAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen eines Members!");
		}			

		//EIGENTLICHE AKTIONEN
		
		//member erzeugen und parameter setzen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		//project setzen
		member.setProject(project);
		//rolle setzen
		member.setProjectRole(rolle);
		
		//user holen und setzen
		try {
			User tempUser = DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName);
			member.setUser(tempUser);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte den User nicht finden! "+ e1.getMessage());
		}
					
		//Member speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getMemberDA().save(member);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte Member nicht speichern! "+ e);
		}
		
	}
	
	/**
	 * ein user erstellt ein neues Projekt
	 * und wird als erster Leader eingetragen
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
		
		//Project speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getProjectDA().save(project);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte Project nicht speichern! "+ e.getMessage());
		}
		
		
		//project erzeuger als member erzeugen und hinzufuegen
		member=DAFactory.getDAFactory().getMemberDA().createMember();
		member.setProject(project);		
		member.setProjectRole(ProjectRolesControl.LEADER);

		try {
			member.setUser(DAFactory.getDAFactory().getUserDA().getUserByORMID(aktUser.getLoginName()));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte aktuellen User nicht finden! "+ e1.getMessage());
		}
		
		//ersten Member als LEADER speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getMemberDA().save(member);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte Member nicht speichern! "+ e.getMessage());
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
		
		//RECHTE-ABFRAGE Projekt und Global
		//Admin und ProjektLeader sind berechtigt 
		if(!projectRolesController.isAllowedDeleteProjectAction(memAktUser.getProjectRole())||globalRolesController.isAllowedDeleteProjectAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte das Projekt zu loeschen!");
		}	
		
		//EIGENTLICHE AKTIONEN
		
		//loeschen
		//Info: Member werden automatisch gelöscht durch das cascade in der DB
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
			throw new ProjectException("Konnte zu entfernenden Member nicht finden! "+ e1.getMessage());
		}

		//Member loeschen
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member loeschen
			DAFactory.getDAFactory().getMemberDA().delete(delMember);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte Member nicht entfernen! "+ e.getMessage());
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
		//TODO suche implementieren in der DA..... List<Project> findProjectsLike(String teilName)
		//
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
//			JProjectPersistentManager.instance().getSession().clear();
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
		
		
		//TODO immernoch erscheint ein Null eintrag aus heiterem himmel!?
		//bleibt vorerst unbeachtet
		//fehler kaschieren
		Member[] arrayFehler=project.member.toArray();
		
//		Member[] array= new Member[arrayFehler.length-1];
//		
//		for(int i=0;i<array.length;i++){
//			array[i]=arrayFehler[i];
//		}
		
		return Arrays.asList(arrayFehler);
			
	}
	
	
	private boolean isUserLoggedIn() {		
		return (aktUser.getLoginName()!=null);
	}
}

