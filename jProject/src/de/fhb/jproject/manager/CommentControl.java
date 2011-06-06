package de.fhb.jproject.manager;

import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.CommentDocument;
import de.fhb.jproject.data.CommentProject;
import de.fhb.jproject.data.CommentSourcecode;
import de.fhb.jproject.data.CommentTask;
import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.CommentDA;
import de.fhb.jproject.repository.da.CommentDocumentDA;
import de.fhb.jproject.repository.da.CommentProjectDA;
import de.fhb.jproject.repository.da.CommentSourcecodeDA;
import de.fhb.jproject.repository.da.CommentTaskDA;
import de.fhb.jproject.repository.da.DocumentDA;
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.SourcecodeDA;
import de.fhb.jproject.repository.da.TaskDA;
import org.hibernate.LockMode;

public class CommentControl {
	
	private ProjectRolesControl projectRolesController;
	private GlobalRolesControl globalRolesController;
	
	private DocumentDA documentDA;
	private MemberDA memberDA;
	private SourcecodeDA sourcecodeDA;
	private CommentDA commentDA;
	private CommentDocumentDA commentDocumentDA;
	private CommentSourcecodeDA commentSourcecodeDA;
	private TaskDA taskDA;
	private CommentTaskDA commentTaskDA;
	private ProjectDA projectDA;
	private CommentProjectDA commentProjectDA;
	
	private static final Logger logger = Logger.getLogger(CommentControl.class);
	
	
	
	public CommentControl(ProjectRolesControl projectRolesController,GlobalRolesControl globalRolesController){
		documentDA = DAFactory.getDAFactory().getDocumentDA();
		memberDA = DAFactory.getDAFactory().getMemberDA();
		sourcecodeDA = DAFactory.getDAFactory().getSourcecodeDA();
		commentDA = DAFactory.getDAFactory().getCommentDA();
		commentDocumentDA = DAFactory.getDAFactory().getCommentDocumentDA();
		commentSourcecodeDA = DAFactory.getDAFactory().getCommentSourcecodeDA();
		taskDA = DAFactory.getDAFactory().getTaskDA();
		commentTaskDA = DAFactory.getDAFactory().getCommentTaskDA();
		projectDA = DAFactory.getDAFactory().getProjectDA();
		commentProjectDA = DAFactory.getDAFactory().getCommentProjectDA();
		
		this.projectRolesController=projectRolesController;
		this.globalRolesController=globalRolesController;
	}
	
	// !!! Comment Actions !!!
	
	/**
	 * kommentieren eines Dokuments
	 */
	public void commentDocu(User aktUser, int documentId, String inhalt)
	throws ProjectException{ 	
		
		Member memAktUser=null;	
		CommentDocument commentDocu=null;
		Comment comment=null;
		Document document=null;
		
		
		//debuglogging
		logger.info("commentDocu()");
		logger.debug("int documentId("+documentId+")"
				+"String inhalt("+inhalt+")");	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//document holen (und implizit damit auch das Project)
		try {
			document=documentDA.loadDocumentByORMID(documentId);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Dokument nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("DocumentId fehlerhaft! "+ e.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!globalRolesController.isAllowedCommentDocuAction(aktUser.getGlobalRole())){
			
			//Member des aktuellen Users holen
			
			try {
				memAktUser=memberDA.loadMemberByORMID(aktUser, document.getProject());
				//RECHTE-ABFRAGE Projekt
				if(!(projectRolesController.isAllowedCommentDocuAction(memAktUser.getProjectRole()))){
					throw new ProjectException("Sie haben keine Rechte dieses Dokument zu kommentieren!");
				}
				memberDA.save(memAktUser);
				//System.out.println("Member: "+memAktUser.getUserId());
				
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
				
		}
		
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentDocu=commentDocumentDA.createCommentDocument();
		commentDocu.setDocument(document);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentDocument(commentDocu);
		
		//Comment speichern
		try {		
			clearSession();
			
			//Referenz auf Comment setzen
			commentDocu.setComment(comment);
			//Comment speichern
			commentDA.save(comment);
			
			//CommentDocu speichern
			commentDocumentDA.save(commentDocu);
			clearSession();
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
	}
			
	/**
	 * 
	 * @param sourcecodeId
	 * @param inhalt
	 * @throws ProjectException
	 */
	public void commentSource(User aktUser, String sourcecodeId, String inhalt)
	throws ProjectException{ 	
		
		Member memAktUser=null;	
		CommentSourcecode commentSource=null;
		Comment comment=null;
		Sourcecode sourcecode=null;
		
		
		//debuglogging
		logger.info("commentSource()");
		logger.debug("String sourcecodeId("+sourcecodeId+")"
				+"String inhalt("+inhalt+")");	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//sourcecode holen (und implizit damit auch das Project)
		try {
			sourcecode=sourcecodeDA.getSourcecodeByORMID(Integer.valueOf(sourcecodeId));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Sourcecode nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourcecodeId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourcecodeId fehlerhaft! "+ e.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!globalRolesController.isAllowedCommentSourceAction(aktUser.getGlobalRole())){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=memberDA.getMemberByORMID(aktUser, sourcecode.getProject());
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
			//RECHTE-ABFRAGE Projekt
			if(!(projectRolesController.isAllowedCommentSourceAction(memAktUser.getProjectRole()))){
				throw new ProjectException("Sie haben keine Rechte diesen Sourcecode zu kommentieren!");
			}	
		}		

		
		//EIGENTLICHE AKTIONEN
		
		//CommentSourcecode erstellen
		commentSource=commentSourcecodeDA.createCommentSourcecode();
		commentSource.setSourcecode(sourcecode);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentSourcecode(commentSource);
		
		//Comment speichern
		try {		
			clearSession();
			//Member speichern
			commentDA.save(comment);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentSource.setComment(comment);
		
		//und CommentSourcecode speichern
		try {		
			clearSession();
			// speichern
			commentSourcecodeDA.save(commentSource);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		
		
	}
	
	public void commentTask(User aktUser, String taskId, String inhalt)	
	throws ProjectException{ 	
		
		Member memAktUser=null;	
		CommentTask commentTask=null;
		Comment comment=null;
		Task task=null;
		
		
		//debuglogging
		logger.info("commentTask()");
		logger.debug("String taskId("+taskId+")"
				+"String inhalt("+inhalt+")");	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//Task holen (und implizit damit auch das Project)
		try {
			task=taskDA.getTaskByORMID(Integer.valueOf(taskId));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Task nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine taskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("taskId fehlerhaft! "+ e.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!globalRolesController.isAllowedCommentTaskAction(aktUser.getGlobalRole())){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=memberDA.getMemberByORMID(aktUser, task.getProject());
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
			//RECHTE-ABFRAGE Projekt
			if(!(projectRolesController.isAllowedCommentTaskAction(memAktUser.getProjectRole()))){
				throw new ProjectException("Sie haben keine Rechte diese Aufgabe zu kommentieren!");
			}	
		}		

		
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentTask=commentTaskDA.createCommentTask();
		commentTask.setTask(task);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentTask(commentTask);
		
		//Comment speichern
		try {		
			clearSession();
			//Member speichern
			commentDA.save(comment);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentTask.setComment(comment);
		
		//und CommentTaskspeichern
		try {		
			clearSession();
			// speichern
			commentTaskDA.save(commentTask);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
	}
	
	public void deleteComment(){
		
		//wer kann ein aufgabe l�schen
		//owner/ersteller, admin, projekLEADER
	}
	
	public void commentProject(User aktUser, String projectName, String inhalt)	
	throws ProjectException{ 	
		
		Member memAktUser=null;	
		CommentProject commentProject=null;
		Comment comment=null;
		Project project=null;
		
		
		//debuglogging
		logger.info("commentProject()");
		logger.debug("String projectName("+projectName+")"
				+"String inhalt("+inhalt+")");	
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//Project holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!globalRolesController.isAllowedCommentProjectAction(aktUser.getGlobalRole())){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=memberDA.getMemberByORMID(aktUser, project);
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
			//RECHTE-ABFRAGE Projekt
			if(!(projectRolesController.isAllowedCommentProjektAction(memAktUser.getProjectRole()))){
				throw new ProjectException("Sie haben keine Rechte dieses Projekt zu kommentieren!");
			}	
		}		

		
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentProject=commentProjectDA.createCommentProject();
		commentProject.setProject(project);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentProject(commentProject);
		
		//Comment speichern
		try {		
			clearSession();
			//Member speichern
			commentDA.save(comment);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentProject.setComment(comment);
		
		//und CommentProject speichern
		try {		
			clearSession();
			// speichern
			commentProjectDA.save(commentProject);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
	}
	
	public void updateComment(){
		//wer kann ein comment l�schen
		//owner/ersteller, admin, projekLEADER
		
	}
	
	public void showAllComments41Docu(){}
	
	public void showAllComments41Source(){}
	
	public void showAllComments41Task(){}
	
	public void showAllComments41Project(){}
	
	
	private void clearSession() throws PersistentException{
		PersistentSession session;		
		//Session holen
		session = JProjectPersistentManager.instance().getSession();
		//und bereinigen
		session.clear();
	}
}
