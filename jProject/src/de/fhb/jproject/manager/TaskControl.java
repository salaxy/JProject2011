package de.fhb.jproject.manager;

import java.sql.Date;
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

		//task erzeugen und parameter setzen
		task=DAFactory.getDAFactory().getTaskDA().createTask();
		//project setzen
		task.setProject(project);
		//setzen weiterer attribute
		task.setAufgabenstellung(aufgabenStellung);
		task.setTitel(titel);
		task.setDone((byte)0);
		
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
			throw new ProjectException("Keine TaskId fehlerhaft! "+ e.getMessage());
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
			//XXX es kann sein das ein Task gar kein termin hat, dann muss trotzdessen die task loeschbar sein
			// daher hier keine Exception! Ist das programmiertechnisch ok?
//			throw new ProjectException("Kann Termin nicht loeschen! "+ e.getMessage());
		}catch (NullPointerException e) {
//			throw new ProjectException("Termin wurde nicht gefunden! "+ e.getMessage());{/
		}
		
		//loeschen
		//Info: Termin wird nicht automatisch mit gelöscht
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
		//Projektteilhaber oder Admin dürfen diese aktion ausführen 
		if(!(projectRolesController.isAllowedShowAllTaskAction(memAktUser.getProjectRole())||aktUser.getGlobalRole().equals(GlobalRolesControl.ADMIN))){
			throw new ProjectException("Sie haben keine Rechte zum Anzeigen der Aufgaben/Tasks !");
		}
		
		return Arrays.asList(project.task.toArray());
	}		
	
	public void  showAllOwnTasks(){}		
	
	public void  updateTask(){}
	
	private boolean isUserLoggedIn() {			
		return (aktUser!=null);
	}
	
	private boolean isAdmin(){
		return aktUser.getGlobalRole().equals(GlobalRolesControl.ADMIN);
	}
}
