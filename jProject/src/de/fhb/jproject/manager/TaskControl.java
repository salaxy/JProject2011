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
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.TaskDA;
import de.fhb.jproject.repository.da.TerminDA;
import de.fhb.jproject.repository.da.UserDA;

public class TaskControl {
	
	private ProjectRolesControl projectRolesController;
	private GlobalRolesControl globalRolesController;
	
	private MemberDA memberDA;
	private TaskDA taskDA;
	private ProjectDA projectDA;
	private UserDA userDA;
	private TerminDA terminDA;
	
	private static final Logger logger = Logger.getLogger(ProjectControl.class);
	
	public TaskControl(ProjectRolesControl projectRolesController){
		memberDA = DAFactory.getDAFactory().getMemberDA();
		taskDA = DAFactory.getDAFactory().getTaskDA();
		projectDA = DAFactory.getDAFactory().getProjectDA();
		userDA = DAFactory.getDAFactory().getUserDA();
		terminDA = DAFactory.getDAFactory().getTerminDA();
		this.projectRolesController=projectRolesController;
		//GlobalRolesController is hier noch null
	}

	// !!! Task Actions !!!

	/**
	 * Hinzufuegen einer neuen Aufgabe
	 */
	public void addNewTask(User aktUser, String projectName, String titel, String aufgabenStellung, Date date)
	throws ProjectException{ 
		
		
		Project project=null;
		Task task=null;
		Member memAktUser=null;	
		Termin termin = null;
		
		//debuglogging
		logger.info("addNewTask()");
		logger.debug("String projectName("+projectName+")"
				+"String titel("+titel+")"
				+"Date date("+date+")"
				);	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Projekt-Rolle des aktuellen Users holen
		try {
			memAktUser=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
		if(!projectRolesController.isAllowedAddNewTaskAction(memAktUser.getProjectRole())
				|| !globalRolesController.isAllowedAddNewTaskAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen einer Aufgabe/Task!");
		}			

		//EIGENTLICHE AKTIONEN
		
		//task erzeugen und parameter setzen
		task=taskDA.createTask();
		//project setzen
		task.setProject(project);
		//setzen weiterer attribute
		task.setAufgabenstellung(aufgabenStellung);
		task.setTitel(titel);
		//Hinweis: dieser block hier dr�ber muss vor dem termin setten ausgef�hrt werden sonst
		// gibt es eine LazyIn....Ecxpetion bei... setProject 
		
		// Termin erzeugen und setzen
		termin =terminDA.createTermin();
		
		//datum in der Form >>>yyyy-mm-dd	als	Date erzeugen und setzen
		try {	
			termin.setTermin(date);
		} catch (IllegalArgumentException e) {
			throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Kein Datum uebergeben! "+ e.getMessage());
		}
		
		//termin speichern
		try {		
			clearSession();
			//Member speichern
			terminDA.save(termin);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte Termin nicht speichern! "+ e.getMessage());
		}

		
		//der Task den termin hinzufuegen
		task.setTermin(termin);
					
		//task speichern
		try {		
			clearSession();
			//Member speichern
			taskDA.save(task);
		} catch (PersistentException e) {
			
			try {
				terminDA.delete(termin);
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
	public void  deleteTask(User aktUser, int taskId, String projectName)
	throws ProjectException{ 
		//INFO: projektName ist zum loeschen an sich nicht notwendig,
		//jedoch notwendig um die Rechte zum loeschen abzufragen
		
		Project project=null;
		Member memAktUser=null;	
		Task task=null;
		
		//debuglogging
		logger.info("deleteTask()");
		logger.debug("String projectName("+projectName+")");
		logger.debug("int taskId("+taskId+")");
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!globalRolesController.isAllowedDeleteTaskAction(aktUser.getGlobalRole())){
			
			//Projekt-Rolle des aktuellen Users holen
			try {
				memAktUser=memberDA.getMemberByORMID(aktUser, project);
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
			task=taskDA.getTaskByORMID(taskId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine TaskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("TaskId fehlerhaft! "+ e.getMessage());
		}
		
		//loeschen
		try {	
			clearSession();
			//task loeschen
			taskDA.delete(task);
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
	public List<Task> showAllTasks(User aktUser, String projectName)
	throws ProjectException{ 
			
		Project project=null;
		Member memAktUser=null;	
		
		//debuglogging
		logger.info("showAllTasks()");
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Projekt-Rolle des aktuellen Users holen
		try {
			memAktUser=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}	
		
		//RECHTE-ABFRAGE projekt
		//Projektteilhaber oder Admin d�rfen diese aktion ausf�hren 
		if(!(projectRolesController.isAllowedShowAllTaskAction(memAktUser.getProjectRole()))
				|| !globalRolesController.isAllowedShowAllTasksAction(aktUser.getGlobalRole())){
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
	public List<Task> showAllOwnTasks(User aktUser, String projectName)
	throws ProjectException{
		
		Project project=null;
		Member memAktUser=null;	
		
		List<Task> list=new ArrayList<Task>();
		
		//debuglogging
		logger.info("addNewTask()");
		logger.debug("String projectName("+projectName+")");
		//wenn projectname null ist dann zeige alle aufgaben???
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Projekt-Rolle des aktuellen Users holen
		try {
			memAktUser=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
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
	public void assignTask(User aktUser, String userLoginName, String projectName, int taskId)
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
				+ "int taskId(" + taskId + ")"
				);	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Member des aktuellen Users holen
		try {
			memAktUser=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
		if(!projectRolesController.isAllowedAssignTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum Zuordnen einer Aufgabe/Task!");
		}
		
		//zuzuordnenden user holen
		try {
			assignUser=userDA.getUserByORMID(userLoginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte zuzuordnenden User nicht finden! "+ e1.getMessage());
		}
		
		//Membereintrag des zuzuordnenden Users holen
		try {
			assignMember=memberDA.getMemberByORMID(assignUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//zuzuordnenden Task holen
		try {
			task=taskDA.getTaskByORMID(taskId);
			
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
			clearSession();
			//task loeschen
			memberDA.save(assignMember);
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
	public void deAssignTask(User aktUser, String userLoginName, String projectName, int taskId)
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
				+ "int taskId(" + taskId + ")"
				);	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Member des aktuellen Users holen
		try {
			memAktUser=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
		if(!projectRolesController.isAllowedDeAssignTaskAction(memAktUser.getProjectRole())){
			throw new ProjectException("Sie haben keine Rechte zum hinzufuegen einer Aufgabe/Task!");
		}
		
		//zugeordneten user holen
		try {
			deassignUser=userDA.getUserByORMID(userLoginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte zuzuordnenden User nicht finden! "+ e1.getMessage());
		}
		
		//Membereintrag des zugeordneten Users holen
		try {
			deassignMember=memberDA.getMemberByORMID(deassignUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//Task dazu holen
		try {
			task=taskDA.getTaskByORMID(taskId);
			
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
			clearSession();
			//task loeschen
			memberDA.save(deassignMember);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Member nicht speichern! "+ e.getMessage());
		}	
	}
	
	
	
	public void updateTask(User aktUser, String projectName,int taskId, String titel, String aufgabenStellung, Date date, boolean done)
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
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
			
		//Projekt-Rolle des aktuellen Users holen
		try {
			memAktUser=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		
		//RECHTE-ABFRAGE Projekt
		if(!projectRolesController.isAllowedUpdateTaskAction(memAktUser.getProjectRole())
				|| !globalRolesController.isAllowedUpdateTaskAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum updaten einer Aufgabe/Task!");
		}			

		//EIGENTLICHE AKTIONEN
		
		//task holen
		try {
			task=taskDA.getTaskByORMID(taskId);
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
					termin.setTermin(date);
				} catch (IllegalArgumentException e) {
					throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
				}catch (NullPointerException e) {
					throw new ProjectException("Kein Datum uebergeben! "+ e.getMessage());
				}
			}else{
				//wenn noch kein termin eintrag existiert
				try{
					termin=terminDA.createTermin();
					termin.setTermin(date);//TODO Date-Parsen in der Action
					task.setTermin(termin);
				} catch (IllegalArgumentException e){
					throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
				}
			}
			
			//termin speichern
			try {		
				clearSession();
				//Member speichern
				terminDA.save(termin);
			} catch (PersistentException e) {
				
				throw new ProjectException("Konnte Termin nicht speichern! "+ e.getMessage());
			}
		}
	
		
		task.setDone(done);
		
		
		//task speichern/updaten
		try {		
			clearSession();
			//Member speichern
			taskDA.save(task);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte Task nicht speichern! "+ e.getMessage());
		}
	}
	
	private void clearSession() throws PersistentException{
		PersistentSession session;		
		//Session holen
		session = JProjectPersistentManager.instance().getSession();
		//und bereinigen
		session.clear();
	}
}
