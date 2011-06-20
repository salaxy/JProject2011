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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
		logger.setLevel(Level.DEBUG);
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
		User user = null;
		Member testMember = null;
		
		
		
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
		try {
			user = userDA.getUserByORMID(loginName);
			
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte den User nicht finden! "+ e1.getMessage());
		}
		try {
			testMember = memberDA.loadMemberByORMID(user, project);
		} catch (PersistentException e) {
			logger.debug("Member schon vorhanden, nicht neu anlegen!", e);
		}
		
		//testen ob neuer Member oder Update
		if (testMember != null) {
			//UPDATE MEMBER
			//rolle setzen
			testMember.setProjectRole(rolle);
			
			//Member speichern
			try {

				//Member refreshen
				clearSession();
				memberDA.save(testMember);
			} catch (PersistentException e) {

				throw new ProjectException("Konnte Member nicht speichern! "+ e.getMessage());
			}
		}else{
			//NEW MEMBER
			//member erzeugen und parameter setzen
			member=memberDA.createMember();
			//project setzen
			member.setProject(project);
			//projectId setzen
			member.setProjectId(project.getName());
			//rolle setzen
			member.setProjectRole(rolle);

			member.setUser(user);
			//UserId setzen
			member.setUserId(user.getLoginName());
			
			//Member speichern
			try {
				clearSession();
				//Member speichern
				memberDA.save(member);
			} catch (PersistentException e) {

				throw new ProjectException("Konnte Member nicht speichern! "+ e.getMessage());
			}
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
		
		Project project = null;
		Member member = null;
		User user = null;
		
		//debuglogging
		logger.info("addNewProject()");
		//TODO debuginfo aktUser
		logger.debug("String name("+name+")"
				+"String status("+status+")");
				
		//EIGENTLICHE AKTIONEN
		
		//projekt holen
		project=projectDA.createProject();
		//project parameter setzen
		//Name setzen
		project.setName(name);
		//Status setzen
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
		
		//project erzeuger als member erzeugen und hinzufuegen
		member=memberDA.createMember();
		member.setProject(project);
		member.setProjectId(project.getName());
		member.setProjectRole(LEADER);

		try {
			user = userDA.getUserByORMID(aktUser);
			member.setUser(user);
			//UserId setzen
			member.setUserId(user.getLoginName());
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
	public void deleteProject(String aktUser, String projectName)
	throws ProjectException{ 
		
		Project project=null;	
		
		//debuglogging
		logger.info("deleteProject()");
		//TODO debuginfo aktUser
		logger.debug("String name("+projectName+")");
		
		//TODO UEBERPRÜFEN OB ANGEGEBENER USER EINZIGER LEADER!!!!!!!
		
		
		
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
		
		
		Project project=null;
		Member delMember=null;
		User user=null;
		
		//debuglogging
		logger.info("deleteMember()");
		//TODO debuginfo aktUser
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

		if(project.member.size()<2){
			//TODO villt extra exception
			throw new ProjectException("Sie sind der letzte Member ! Wollen Sie das Prject loeschen?");
		}
		
		//TODO mhm wie soll man das dynamisch loesen??
		if(delMember.getProjectRole()=="Leader"){
			//TODO villt extra exception
			throw new ProjectException("Sie sind Leader des Projects! Wollen Sie ihr Rechte an jemand anders uebertragen?");
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
		//TODO debuginfo aktUser
		
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
		//TODO debuginfo loginName
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
	/**
	 * Anzeigen aller Projektinfos
	 * - Anzahl Member
	 * - Anzahl Dokumente
	 * - Anzahl Sourcecodes
	 * - Anzahl Tasks
	 * 
	 * @param projectName
	 * @return String []
	 * @throws ProjectException
	 */
	/*
	public HashMap<String, String> showProjectInfo(String projectName)
	throws ProjectException{
		clearSession();
		HashMap<String, String> info = new HashMap<String, String>(); 
		//String [] info = new String[4];
		Project project=null;
		
		
		//debuglogging
		logger.info("showProjectInfo()");
		logger.debug("String name("+projectName+")");
		
		
		
		//EIGENTLICHE AKTIONEN
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		info.put("anzMember", ""+project.member.size());
		info.put("anzDocu", ""+project.document.size());
		info.put("anzSource", ""+project.sourcecode.size());
		info.put("anzTask", ""+project.task.size());
		
		return info;
	}
	*/
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

