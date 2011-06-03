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
	public void  addNewTask(String projectName, String titel, String aufgabenStellung, String time)
	throws ProjectException{ 
		
		
		Project project=null;
		Task task=null;
		Member memAktUser=null;	
		Termin termin = null;
		
		//debuglogging
		logger.info("addMember()");
		logger.debug("String projectName("+projectName+")"+"String titel("+titel+")");	
		
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
	
		// Termin erzeugen und setzen
		termin =DAFactory.getDAFactory().getTerminDA().createTermin();
		//timestring in der Form >>>yyyy-mm-dd	als	Date erzeugen und setzen
		termin.setTermin(Date.valueOf(time));
		
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
			throw new ProjectException("Konnte Task nicht speichern! "+ e.getMessage());
		}

	}	
	
	public void  deleteTask(){
		//wer kann eine aufgabe löschen
		//owner/ersteller, admin, projekLEADER
		
		
		
		
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
		//TODO irgentwie ist das noch nicht richtig soo		
		return (aktUser!=null);
	}
	
}
