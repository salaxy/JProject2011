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
import org.apache.log4j.Level;

/**
 * Dieser Manager kontrolliert dden Zugriff auf die Tasks
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class TaskManager {
	
	
	private MemberDA memberDA;
	private TaskDA taskDA;
	private ProjectDA projectDA;
	private UserDA userDA;
	private TerminDA terminDA;
	
	private static final Logger logger = Logger.getLogger(TaskManager.class);
	
	/**
	 * 
	 */
	public TaskManager(){
		logger.setLevel(Level.DEBUG);
		memberDA = DAFactory.getDAFactory().getMemberDA();
		taskDA = DAFactory.getDAFactory().getTaskDA();
		projectDA = DAFactory.getDAFactory().getProjectDA();
		userDA = DAFactory.getDAFactory().getUserDA();
		terminDA = DAFactory.getDAFactory().getTerminDA();
	}


	/**
	 * Hinzufuegen einer neuen Aufgabe
	 * 
	 * @param projectName
	 * @param titel
	 * @param aufgabenStellung
	 * @param date
	 * @return 
	 * @throws ProjectException
	 */
	public int addNewTask(String projectName, String titel, String aufgabenStellung, Date date)
	throws ProjectException{ 
		
		
		Project project=null;
		Task task=null;
		Termin termin = null;
		
		//debuglogging
		logger.info("addNewTask()");
		logger.debug("String projectName("+projectName+")"
				+"String titel("+titel+")"
				+"String aufgabenStellung("+aufgabenStellung+")"
				+"Date date("+date+")"
				);	
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		
		

		//EIGENTLICHE AKTIONEN
		
		//task erzeugen und parameter setzen
		task=taskDA.createTask();
		//project setzen
		task.setProject(project);
		//setzen weiterer attribute
		task.setAufgabenstellung(aufgabenStellung);
		task.setTitel(titel);
		
		// Termin erzeugen und setzen
		if (termin != null) {
			termin =terminDA.createTermin();

			//Date setzen
			try {	
				termin.setTermin(date);
			} catch (IllegalArgumentException e) {
				throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
			}catch (NullPointerException e) {
				throw new ProjectException("Kein Datum uebergeben! "+ e.getMessage());
			}

			//termin speichern
			try {		

				//Member speichern
				clearSession();
				terminDA.save(termin);
			} catch (PersistentException e) {

				throw new ProjectException("Konnte Termin nicht speichern! "+ e.getMessage());
			}

			//der Task den termin hinzufuegen
			task.setTermin(termin);
		}
		
					
		//task speichern
		try {		
			clearSession();
			//Member speichern
			
			taskDA.save(task);
		} catch (PersistentException e) {
			
			try {
				if (termin != null) {
					terminDA.delete(termin);
				}
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Task nicht speichern und erstellten Termin nicht wieder leoschen! "+ e.getMessage());
			}
			throw new ProjectException("Konnte Task nicht speichern! "+ e.getMessage());
		}
		return task.getId();
	}	
	
	/**
	 * loeschen eines Taks eines Projektes
	 * 
	 * @param taskId
	 * @param projectName
	 * @throws ProjectException
	 */
	public void  deleteTask(int taskId, String projectName)
	throws ProjectException{ 
		
		
		Task task=null;
		
		//debuglogging
		logger.info("deleteTask()");
		logger.debug("String projectName("+projectName+")");
		logger.debug("int taskId("+taskId+")");
		

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
			
			//task loeschen
			clearSession();
			taskDA.delete(task);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht loeschen! "+ e.getMessage());
		}	
	}		
	
	/**
	 * Holen aller Aufgaben zu einem Projekt
	 * 
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public List<Task> showAllTasks(String projectName)
	throws ProjectException{ 
		
			
		Project project=null;
		
		//debuglogging
		logger.info("showAllTasks()");
		logger.debug("String projectName("+projectName+")");
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		
		return Arrays.asList(project.task.toArray());
	}	
	
	
	/** 
	 *  Anzeigen einer Aufgabe
	 *  
	 * @param taskId 
	 * @return
	 * @throws ProjectException
	 */
	public Task showTask(int taskId)
	throws ProjectException{ 
		
		Task task=null;
		
		//debuglogging
		logger.info("showTask()");
		logger.debug("int taskId("+taskId+")");
		
		
		//EIGENTLICHE AKTIONEN
		
		//task holen
		try {
			task=taskDA.getTaskByORMID(taskId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Task nicht finden! "+ e.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Ungültige TaskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("TaskId fehlerhaft! "+ e.getMessage());
		}
		
		return task;
	}		
	
	
	
	
	/**
	 * Alle zugeordneten Aufgaben des aktuellen Users holen
	 * (von allen Projekten)
	 * 
	 * @param aktUser 
	 * @return
	 * @throws ProjectException
	 */
	public List<Task> showAllOwnTasks(String aktUser)
	throws ProjectException{
		
		
		User user=null;
		List<Task> list=new ArrayList<Task>();
		
		//debuglogging
		logger.info("showAllOwnTasks()");
		logger.debug("String aktUser("+aktUser+")");
		
		
		//EIGENTLICHE AKTIONEN
		
		//user neu holen (praeventiv wegn moegl Seiten effekte)
		try {
			
			user=userDA.loadUserByORMID(aktUser);
		} catch (PersistentException e) {
			throw new ProjectException("User wurde nicht gefunden!");
		}
	
		
		
		//alle member durchlaufen ueber iterator
		for(Object m : user.member.getCollection()){
			//alle tasks zu einem Member durchlaufen
			for(Object t : ((Member)m).task.getCollection()){
				list.add((Task)t);
			}
		}
		
		return list;
	}	
	
	
	/**
	 * Einem Member eines Projektes eine Aufgabe/Task zuordnen
	 * 
	 * @param loginName
	 * @param projectName
	 * @param taskId
	 * @throws ProjectException
	 */
	public void assignTask(String loginName, String projectName, int taskId)
	throws ProjectException{ 
		
		
		Project project=null;
		
		Task task=null;		
		User assignUser=null;
		Member assignMember=null;
		
		//debuglogging
		logger.info("assignTask()");
		logger.debug("String projectName(" + projectName + ")"
				+ "String loginName(" + loginName + ")"
				+ "int taskId(" + taskId + ")"
				);	
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}	
		
		//EIGENTLICHE AKTIONEN
		
		//zuzuordnenden user holen
		try {
			assignUser=userDA.getUserByORMID(loginName);
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
			
			//task loeschen
			clearSession();
			memberDA.save(assignMember);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Member nicht speichern! "+ e.getMessage());
		}	
	}
	
	
	/**
	 * User von einer Aufgabe abordern 
	 * 
	 * @param loginName
	 * @param projectName
	 * @param taskId
	 * @throws ProjectException
	 */
	public void deAssignTask(String loginName, String projectName, int taskId)
	throws ProjectException{ 
		
		
		Project project=null;
		Member memAktUser=null;	
		
		Task task=null;		
		User deassignUser=null;
		Member deassignMember=null;
		
		//debuglogging
		logger.info("deAssignTask()");
		logger.debug("String projectName(" + projectName + ")"
				+ "String loginName(" + loginName + ")"
				+ "int taskId(" + taskId + ")"
				);	
		
		//projekt holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
		}
		
		//EIGENTLICHE AKTIONEN
		
		//zugeordneten user holen
		try {
			deassignUser=userDA.getUserByORMID(loginName);
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
			
			//task loeschen
			clearSession();
			memberDA.save(deassignMember);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Member nicht speichern! "+ e.getMessage());
		}	
	}
	
	
	/**
	 *  Updaten eines Tasks
	 *  
	 * @param projectName
	 * @param taskId
	 * @param titel
	 * @param aufgabenStellung
	 * @param date
	 * @param done
	 * @throws ProjectException
	 */
	public void updateTask(String projectName,int taskId, String titel, String aufgabenStellung, Date date, boolean done)
	throws ProjectException{ 
		
		
		Task task=null;
		
		//debuglogging
		logger.info("updateTask()");
		logger.debug("String projectName("+projectName+")"
				+"String titel("+titel+")"
				+"int taskId("+taskId+")"
				+"String aufgabenStellung("+aufgabenStellung+")"
				+"String titel("+titel+")"
				+"String date("+date+")"
				+"boolean done("+done+")"
				);	
		
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
			task.setAufgabenstellung(aufgabenStellung);
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
					termin.setTermin(date);
					task.setTermin(termin);
				} catch (IllegalArgumentException e){
					throw new ProjectException("Datumsformat ist nicht richtig! "+ e.getMessage());
				}
			}
			
			//termin speichern
			try {		
				
				//Member speichern
				clearSession();
				terminDA.save(termin);
			} catch (PersistentException e) {
				
				throw new ProjectException("Konnte Termin nicht speichern! "+ e.getMessage());
			}
		}
	
		
		task.setDone(done);
		
		
		//task speichern/updaten
		try {		
			
			//Member speichern
			clearSession();
			taskDA.save(task);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte Task nicht speichern! "+ e.getMessage());
		}
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