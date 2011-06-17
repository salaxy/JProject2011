package de.fhb.jproject.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.ProjectRolesDA;
import de.fhb.jproject.repository.da.UserDA;
import java.util.Set;
import org.apache.log4j.Level;

/**
 * Manager fuer die ProjectActions
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class ProjectManager {
	
	private final String LEADER = "Leader";
	
	//Notiz: Get>>>komplett neu aus der DB, get>> schon vorgehalten
	
	private MemberDA memberDA;
	private ProjectDA projectDA;
	private ProjectRolesDA projectRolesDA;
	private UserDA userDA;
	
	private static final Logger logger = Logger.getLogger(ProjectManager.class);
	
	public ProjectManager(){
		memberDA = DAFactory.getDAFactory().getMemberDA();
		projectDA = DAFactory.getDAFactory().getProjectDA();
		projectRolesDA = DAFactory.getDAFactory().getProjectRolesDA();
		userDA = DAFactory.getDAFactory().getUserDA();
	}
	

	/**
	 * 	 Hinzufuegen eines Users zu einem Projekt
	 *  (Methode Funktioniert auch zum updaten der Rolle)
	 * 
	 * @param aktUser
	 * @param loginName
	 * @param projectName
	 * @param rolle
	 * @throws ProjectException
	 */
	public void addMember(String loginName, String projectName, String rolle)
	throws ProjectException{ 	
		clearSession();
		Project project=null;
		Member member=null;
		
		
		
		//debuglogging
		logger.info("addMember()");
		logger.debug("String userName("+loginName+")"
				+"String projectName("+projectName+")"
				+"String rolle("+ rolle+")");	
		
		try {
			if (rolle == null) {
				rolle = "Member";
			}
			projectRolesDA.getProjectRolesByORMID(rolle);
		} catch (PersistentException ex) {
			throw new ProjectException("Keine zulaessige Rolle angegeben!");
		}
		
		//EIGENTLICHE AKTIONEN
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
		//member erzeugen und parameter setzen
		member=memberDA.createMember();
		//project setzen
		member.setProject(project);
		//rolle setzen
		member.setProjectRole(rolle);
		
		//user holen und setzen
		try {
			User tempUser = userDA.getUserByORMID(loginName);
			member.setUser(tempUser);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte den User nicht finden! "+ e1.getMessage());
		}
					
		//Member speichern
		try {
			clearSession();
			//Member speichern
			memberDA.save(member);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte Member nicht speichern! "+ e.getMessage());
		}
		
	}
	
	/**
	 * ein user erstellt ein neues Projekt
	 * und wird als erster Leader eingetragen
	 * @param aktUser
	 * @param name
	 * @param status
	 * @throws ProjectException
	 */
	public void addNewProject(String aktUser, String name, String status)
	throws ProjectException{
		clearSession();
		Project project=null;
		Member member=null;
		
		//debuglogging
		logger.info("addNewProject()");
		logger.debug("String name("+name+")"
				+"String status("+status+")");
				
		//EIGENTLICHE AKTIONEN
		
		//project parameter setzen
		project=projectDA.createProject();
		project.setName(name);
		if (status == null) {
			status = "New";
		}
		project.setStatus(status);
		
		//Project speichern
		try {
			//Member speichern
			projectDA.save(project);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte Project nicht speichern! "+ e.getMessage());
		}
		
		
		//EIGENTLICHE AKTIONEN
		
		//project erzeuger als member erzeugen und hinzufuegen
		member=memberDA.createMember();
		member.setProject(project);		
		member.setProjectRole(LEADER);

		try {
			member.setUser(userDA.getUserByORMID(aktUser));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte aktuellen User nicht finden! "+ e1.getMessage());
		}
		
		//ersten Member als LEADER speichern
		try {
			//Member speichern
			memberDA.save(member);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte Member nicht speichern! "+ e.getMessage());
		}
	}	
	
	/**
	 * loeschen eines Projektes
	 * @param aktUser
	 * @throws ProjectException
	 */
	public void deleteProject(String projectName)
	throws ProjectException{ 
		clearSession();
		//TODO ÜBERPRÜFEN OB ANGEGEBENER USER EINZIGER LEADER!!!!!!!SONST DEADLOCK
		Project project=null;	
		
		//debuglogging
		logger.info("deleteProject()");
		logger.debug("String name("+projectName+")");
		
		//EIGENTLICHE AKTIONEN
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
		//loeschen
		//Info: Member werden automatisch gel�scht durch das cascade in der DB
		try {	
			projectDA.delete(project);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Projekt nicht loeschen! "+ e.getMessage());
		}	
	}	
	
	/**
	 *  Member aus einen Projekt entfernen
	 * @param aktUser
	 * @param projectName
	 * @throws ProjectException
	 */
	public void deleteMember(String aktUser, String loginName, String projectName)
	throws ProjectException{ 
		clearSession();
		
		Project project=null;
		Member delMember=null;
		User user=null;
		
		//debuglogging
		logger.info("deleteMember()");
		logger.debug("String loginName("+loginName+")"
				+"String projectName("+projectName+")");
		
		//EIGENTLICHE AKTIONEN
		
		if (loginName == null) {
			loginName=aktUser;
		}
		
		//User holen
		try {
			user=userDA.getUserByORMID(loginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte User nicht finden! "+ e1.getMessage());
		}
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
		
		//zuloeschenden Member holen
		try {
			delMember=memberDA.getMemberByORMID(user, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte zu entfernenden Member nicht finden! "+ e1.getMessage());
		}

		//Member loeschen
		try {
			//Member loeschen
			clearSession();
			memberDA.delete(delMember);
		} catch (PersistentException e) {
			
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
		clearSession();
		
		Project project=null;	
		
		//debuglogging
		logger.info("showProject()");
		logger.debug("String name("+projectName+")");
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		
		return project;
	}
	
	/**
	 *  Projekte suchen
	 * @param aktUser
	 * @param loginName
	 * @return
	 * @throws ProjectException
	 */
	public List<Project> searchProjects(String searchValue)
	throws ProjectException{
		clearSession();
		
		List <Project> list=null;
		
		//debuglogging
		logger.info("searchProjects()");
		logger.debug("String loginName("+searchValue+")");
		
		//holen der daten
		try {
			list= projectDA.listAllProjectsLike(searchValue);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte nicht finden! "+ ex.getMessage());	
		}
		
		return list;
	}
	
	/**
	 *  anzeigen aller existierenden Projekte
	 * 
	 * @param aktUser
	 * @return
	 * @throws ProjectException
	 */
	public List<Project> showAllProjects()
	throws ProjectException{ 
		clearSession();
		List<Project> list=null;
		
		//debuglogging
		logger.info("showAllProjects()");
		
		
		//holen der Daten
		try {
			list=projectDA.listAllProjects();
		} catch (PersistentException e) {
			throw new ProjectException("Kann kein Projekt finden! "+ e.getMessage());
		}
		
		return list;
	}
	
	/**
	 * Anzeigen aller projekte des aktuellen Users
	 * @return
	 * @throws ProjectException
	 */
	public MemberSetCollection showAllOwnProjects(String aktUser)
	throws ProjectException{
		clearSession();
		//debuglogging
		logger.info("showAllOwnProjects()");
		Set<Project> list= null;	
		User user=null;
		
		
		// user neu holen um seiten effekte zu vermeiden
		try {
			//user suchen
			user = userDA.getUserByORMID(aktUser);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		//projekte in liste eintragen
		/*XXX Testausgabe
		for (Member aktMember : user.member.toArray()) {
			list.add(aktMember.getProject());
		}
		*/
		
		//TODO LATER Projectliste übergeben nicht memberliste
		return user.member;
	}
	/**
	 * Anzeigen eines Member eines Projektes
	 * 
	 * @param aktUser
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public Member showMember(String aktUser, String loginName, String projectName)
	throws ProjectException{
		clearSession();
		Project project = null;
		Member member = null;
		User user = null;
		
		//debuglogging
		logger.info("showMember()");
		logger.debug("User aktUser("+aktUser+")"
				+ "String name("+projectName+")");
		
		
		
		//EIGENTLICHE AKTIONEN
		//User holen
		try {
			user=userDA.getUserByORMID(loginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte User nicht finden! "+ e1.getMessage());
		}
		//Project holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		//Member holen
		try {
			member=memberDA.getMemberByORMID(user, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		return member;
	}
	
	/**
	 * Anzeigen aller Member eines Projektes
	 * 
	 * @param aktUser
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public MemberSetCollection showAllMember(String projectName)
	throws ProjectException{
		clearSession();
		Project project=null;
		
		//debuglogging
		logger.info("showAllMember()");
		logger.debug("String name("+projectName+")");
		
		
		
		//EIGENTLICHE AKTIONEN
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		return project.member;
	}
	
	private void clearSession() throws ProjectException{
		try {
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Session nicht clearen! "+ e.getMessage());
		}
		
	}
		
}

