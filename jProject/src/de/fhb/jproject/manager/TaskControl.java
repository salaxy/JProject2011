package de.fhb.jproject.manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.data.Termin;
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

	/**
	 * Hinzufuegen einer neuen Aufgabe
	 */
	public void addNewTask(String projectName, String titel, String aufgabenStellung, String date)
	throws ProjectException{ 
		
		
		Project project=null;
		Task task=null;
		Member memAktUser=null;	
		Termin termin = null;
		
		//debuglogging
		logger.info("addNewTask()");
		logger.debug("String projectName("+projectName+")"
				+"String titel("+titel+")"
				+"String date("+date+")"
				);	
		
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
		//TODO Admin darf keine task hinzufuegen! muss er das? brauchen wir einen eintag in den global role contoller fuer die action?
		if(!projectRolesController.isAllowedAddNewTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen einer Aufgabe/Task!");
		}			

		//EIGENTLICHE AKTIONEN
		
		//task erzeugen und parameter setzen
		task=DAFactory.getDAFactory().getTaskDA().createTask();
		//project setzen
		task.setProject(project);
		//setzen weiterer attribute
		task.setAufgabenstellung(aufgabenStellung);
		task.setTitel(titel);
		task.setDone((byte)0);
		//Hinweis: dieser block hier dr�ber muss vor dem termin setten ausgef�hrt werden sonst
		// gibt es eine LazyIn....Ecxpetion bei... setProject 
		
		// Termin erzeugen und setzen
		termin =DAFactory.getDAFactory().getTerminDA().createTermin();
		
		//datum in der Form >>>yyyy-mm-dd	als	Date erzeugen und setzen
		try {	
			termin.setTermin(Date.valueOf(date));
		} catch (IllegalArgumentException e) {
			throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Kein Datum uebergeben! "+ e.getMessage());
		}
		
		//termin speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getTerminDA().save(termin);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte Termin nicht speichern! "+ e.getMessage());
		}

		
		//der Task den termin hinzufuegen
		task.setTermin(termin);
					
		//task speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getTaskDA().save(task);
		} catch (PersistentException e) {
			e.printStackTrace();
			try {
				DAFactory.getDAFactory().getTerminDA().delete(termin);
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Task nicht speichern und erstellten Termin nicht wieder leoschen! "+ e.getMessage());
			}
			throw new ProjectException("Konnte Task nicht speichern! "+ e.getMessage());
		}
	}	
	
	/**
	 * loeschen eines Taks eines Projektes
	 * 
	 */
	public void  deleteTask(String taskId, String projectName)
	throws ProjectException{ 
		//INFO: projektName ist zum loeschen an sich nicht notwendig,
		//jedoch notwendig um die Rechte zum loeschen abzufragen
		
		Project project=null;
		Member memAktUser=null;	
		Task task=null;
		
		//debuglogging
		logger.info("deleteTask()");
		logger.debug("String projectName("+projectName+")");
		logger.debug("String taskId("+taskId+")");
		
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
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!isAdmin()){
			
			//Projekt-Rolle des aktuellen Users holen
			try {
				memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
			//RECHTE-ABFRAGE Projekt
			if(!(projectRolesController.isAllowedDeleteTaskAction(memAktUser.getProjectRole()))){
				throw new ProjectException("Sie haben keine Rechte die Aufgabe(Task) zu loeschen!");
			}	
		}
		

		
		//EIGENTLICHE AKTIONEN
		
		//hole den task
		try {
			task=DAFactory.getDAFactory().getTaskDA().getTaskByORMID(Integer.valueOf(taskId));
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine TaskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("TaskId fehlerhaft! "+ e.getMessage());
		}
		
		//termin loeschen
		try {	
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//loeschen
			DAFactory.getDAFactory().getTerminDA().delete(task.getTermin());
		} catch (PersistentException e) {
			//XXX es kann sein das ein Task gar kein termin hat, dann muss trotzdessen die task loeschbar sein,muss es???
			// daher hier keine Exception! Ist das programmiertechnisch ok?
			//sollte bei normaler erstellung allerdings erstellt worden sein
//			throw new ProjectException("Kann Termin nicht loeschen! "+ e.getMessage());
		}catch (NullPointerException e) {
//			throw new ProjectException("Termin wurde nicht gefunden! "+ e.getMessage());{/
		}
		
		//loeschen
		//Info: Termin wird nicht automatisch mit gel�scht
		try {	
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//task loeschen
			DAFactory.getDAFactory().getTaskDA().delete(task);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht loeschen! "+ e.getMessage());
		}	
	}		
	
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
		//Projektteilhaber oder Admin d�rfen diese aktion ausf�hren 
		if(!(projectRolesController.isAllowedShowAllTaskAction(memAktUser.getProjectRole()))){
			throw new ProjectException("Sie haben keine Rechte zum Anzeigen der Aufgaben/Tasks !");
		}
		
		return Arrays.asList(project.task.toArray());
	}		
	
	/**
	 * Alle zugeordneten Aufgaben des aktuellen Users zu einem
	 * angegeben Projekt holen (in dem der User Member ist)
	 * 
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public List<Task> showAllOwnTasks(String projectName)
	throws ProjectException{
		
		Project project=null;
		Member memAktUser=null;	
		
		List<Task> list=new ArrayList<Task>();
		
		//debuglogging
		logger.info("addNewTask()");
		logger.debug("String projectName("+projectName+")");
		//wenn projectname null ist dann zeige alle aufgaben???
		
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
		//TODO Admin??? Rechte Nachbessern?
		if(!projectRolesController.isAllowedShowAllOwnTasksAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen einer Aufgabe/Task!");
		}

		//Array zu liste umformen
		for (Task aktTask : memAktUser.task.toArray()) {
			list.add(aktTask);
		}
		
		return list;
	}	
	
	
	/**
	 * Einem Member eines Projektes eine Aufgabe/Task zuordnen
	 * (TODO eintrag erzeugen)
	 * 
	 * @param userLoginName
	 * @param projectName
	 * @param taskId
	 * @throws ProjectException
	 */
	public void assignTask(String userLoginName, String projectName, String taskId)
	throws ProjectException{ 
		
		Project project=null;
		Member memAktUser=null;	
		
		Task task=null;		
		User assignUser=null;
		Member assignMember=null;
		
		//debuglogging
		logger.info("assignTask()");
		logger.debug("String projectName(" + projectName + ")"
				+ "String userLoginName(" + userLoginName + ")"
				+ "String taskId(" + taskId + ")"
				);	
		
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
			
		//Member des aktuellen Users holen
		try {
			memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
		//TODO Admin darf keine task zuordnen! muss er das? brauchen wir einen eintag in den global role contoller fuer die action?
		//TODO Rechte nachbessern?
		if(!projectRolesController.isAllowedAddNewTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum Zuordnen einer Aufgabe/Task!");
		}
		
		//zuzuordnenden user holen
		try {
			assignUser=DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte zuzuordnenden User nicht finden! "+ e1.getMessage());
		}
		
		//Membereintrag des zuzuordnenden Users holen
		try {
			assignMember=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(assignUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//zuzuordnenden Task holen
		try {
			task=DAFactory.getDAFactory().getTaskDA().getTaskByORMID(Integer.valueOf(taskId));
			
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine TaskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("Keine TaskId fehlerhaft! "+ e.getMessage());
		}
		
		//task zum Member hinzufuegen
		assignMember.task.add(task);
		
		//updaten/speichern des Members
		try {	
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//task loeschen
			DAFactory.getDAFactory().getMemberDA().save(assignMember);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Member nicht speichern! "+ e.getMessage());
		}	
	}
	
	
	/**
	 * User von einer Aufgabe abordern 
	 * (TODO eintrag loeschen)
	 * 
	 * @param userLoginName
	 * @param projectName
	 * @param taskId
	 * @throws ProjectException
	 */
	public void deAssignTask(String userLoginName, String projectName, String taskId)
	throws ProjectException{ 
		
		Project project=null;
		Member memAktUser=null;	
		
		Task task=null;		
		User deassignUser=null;
		Member deassignMember=null;
		
		//debuglogging
		logger.info("deAssignTask()");
		logger.debug("String projectName(" + projectName + ")"
				+ "String userLoginName(" + userLoginName + ")"
				+ "String taskId(" + taskId + ")"
				);	
		
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
			
		//Member des aktuellen Users holen
		try {
			memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
		//TODO Admin darf keine task zuordnen! muss er das? brauchen wir einen eintag in den global role contoller fuer die action?
		//TODO RECHTE nachbessern?
		if(!projectRolesController.isAllowedDeleteTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen einer Aufgabe/Task!");
		}
		
		//zugeordneten user holen
		try {
			deassignUser=DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte zuzuordnenden User nicht finden! "+ e1.getMessage());
		}
		
		//Membereintrag des zugeordneten Users holen
		try {
			deassignMember=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(deassignUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//Task dazu holen
		try {
			task=DAFactory.getDAFactory().getTaskDA().getTaskByORMID(Integer.valueOf(taskId));
			
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine TaskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("Keine TaskId fehlerhaft! "+ e.getMessage());
		}
		
		//task im member entfernen
		deassignMember.task.remove(task);
		
		//updaten/speichern des Members
		try {	
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//task loeschen
			DAFactory.getDAFactory().getMemberDA().save(deassignMember);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Member nicht speichern! "+ e.getMessage());
		}	
	}
	
	
	
	public void updateTask(String projectName,String taskId, String titel, String aufgabenStellung, String date, String done)
	throws ProjectException{ 
		
		Project project=null;
		Task task=null;
		Member memAktUser=null;	
		
		//debuglogging
		logger.info("updateTask()");
		logger.debug("String projectName("+projectName+")"
				//TODO
//				+"String titel("+titel+")"
//				+"String date("+date+")"
				);	
		
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
		if(!projectRolesController.isAllowedUpdateTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum updaten einer Aufgabe/Task!");
		}			

		//EIGENTLICHE AKTIONEN
		
		//task holen
		try {
			task=DAFactory.getDAFactory().getTaskDA().getTaskByORMID(Integer.valueOf(taskId));
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine TaskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("Keine TaskId fehlerhaft! "+ e.getMessage());
		}
		
		//Attribute neu setzen wenn sie mitgegebn wurde (also nicht null sind)
		
		if(titel!=null){
			task.setTitel(titel);
		}
		
		if(aufgabenStellung!=null){
			task.setAufgabenstellung(titel);
		}
		
		if(date!=null){
			
			Termin termin=null;
			
			if(task.getTermin()!=null){
				try{
					termin=task.getTermin();
					termin.setTermin(Date.valueOf(date));
				} catch (IllegalArgumentException e) {
					throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
				}catch (NullPointerException e) {
					throw new ProjectException("Kein Datum uebergeben! "+ e.getMessage());
				}
			}else{
				//wenn noch kein termin eintrag existiert
				try{
					termin=DAFactory.getDAFactory().getTerminDA().createTermin();
					termin.setTermin(Date.valueOf(date));
					task.setTermin(termin);
				} catch (IllegalArgumentException e){
					throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
				}
			}
			
			//termin speichern
			try {		
				PersistentSession session;		
				//Session holen
				session = JProjectPersistentManager.instance().getSession();
				//und bereinigen
				session.clear();
				//Member speichern
				DAFactory.getDAFactory().getTerminDA().save(termin);
			} catch (PersistentException e) {
				e.printStackTrace();
				throw new ProjectException("Konnte Termin nicht speichern! "+ e.getMessage());
			}
		}
		
		
		if(done!=null){
			
			boolean value;
			
			try{
				value=Boolean.valueOf(done);
			}catch (IllegalArgumentException e){
				throw new ProjectException("Done ist falsch gesetzt! "+ e.getMessage());
			}

			if(value){
				task.setDone((byte)1);				
			}else{
				task.setDone((byte)0);
			}
		}
		
		//task speichern/updaten
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getTaskDA().save(task);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte Task nicht speichern! "+ e.getMessage());
		}
	}
	
	private boolean isUserLoggedIn() {			
		return (aktUser!=null);
	}
	
	private boolean isAdmin(){
		return aktUser.getGlobalRole().equals("Admin");
	}
}
