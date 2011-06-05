package de.fhb.jproject.manager;

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

public class CommentControl {
	
	User aktUser;
	ProjectRolesControl projectRolesController;
	GlobalRolesControl globalRolesController;
	
	private static final Logger logger = Logger.getLogger(CommentControl.class);
	
	
	
	public CommentControl(User aktUser, ProjectRolesControl projectRolesController,GlobalRolesControl globalRolesController){
		
		this.aktUser=aktUser;
		this.projectRolesController=projectRolesController;
		this.globalRolesController=globalRolesController;
	}
	
	// !!! Comment Actions !!!
	
	/**
	 * kommentieren eines Dokuments
	 */
	public void commentDocu(String documentId, String inhalt)
	throws ProjectException{ 	
		
		Member memAktUser=null;	
		CommentDocument commentDocu=null;
		Comment comment=null;
		Document document=null;
		
		
		//debuglogging
		logger.info("commentDocu()");
		logger.debug("String documentId("+documentId+")"
				+"String inhalt("+inhalt+")");	
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//document holen (und implizit damit auch das Project)
		try {
			document=DAFactory.getDAFactory().getDocumentDA().getDocumentByORMID(Integer.valueOf(documentId));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Dokument nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("DocumentId fehlerhaft! "+ e.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!isAdmin()){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, document.getProject());
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
			//RECHTE-ABFRAGE Projekt
			if(!(projectRolesController.isAllowedCommentDocuAction(memAktUser.getProjectRole()))){
				throw new ProjectException("Sie haben keine Rechte dieses Dokument zu kommentieren!");
			}	
		}		

		
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentDocu=DAFactory.getDAFactory().getCommentDocumentDA().createCommentDocument();
		commentDocu.setDocument(document);
		
		//comment erstellen
		comment=DAFactory.getDAFactory().getCommentDA().createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentDocument(commentDocu);
		
		//Comment speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getCommentDA().save(comment);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentDocu.setComment(comment);
		
		//und CommentDocument speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			// speichern
			DAFactory.getDAFactory().getCommentDocumentDA().save(commentDocu);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
	}
			
	/**
	 * 
	 * @param sourcecodeId
	 * @param inhalt
	 * @throws ProjectException
	 */
	public void commentSource(String sourcecodeId, String inhalt)
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
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//sourcecode holen (und implizit damit auch das Project)
		try {
			sourcecode=DAFactory.getDAFactory().getSourcecodeDA().getSourcecodeByORMID(Integer.valueOf(sourcecodeId));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Sourcecode nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourcecodeId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourcecodeId fehlerhaft! "+ e.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!isAdmin()){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, sourcecode.getProject());
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
		commentSource=DAFactory.getDAFactory().getCommentSourcecodeDA().createCommentSourcecode();
		commentSource.setSourcecode(sourcecode);
		
		//comment erstellen
		comment=DAFactory.getDAFactory().getCommentDA().createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentSourcecode(commentSource);
		
		//Comment speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getCommentDA().save(comment);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentSource.setComment(comment);
		
		//und CommentSourcecode speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			// speichern
			DAFactory.getDAFactory().getCommentSourcecodeDA().save(commentSource);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		
		
	}
	
	public void commentTask(String taskId, String inhalt)	
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
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//Task holen (und implizit damit auch das Project)
		try {
			task=DAFactory.getDAFactory().getTaskDA().getTaskByORMID(Integer.valueOf(taskId));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Task nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine taskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("taskId fehlerhaft! "+ e.getMessage());
		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!isAdmin()){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, task.getProject());
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
		commentTask=DAFactory.getDAFactory().getCommentTaskDA().createCommentTask();
		commentTask.setTask(task);
		
		//comment erstellen
		comment=DAFactory.getDAFactory().getCommentDA().createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentTask(commentTask);
		
		//Comment speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getCommentDA().save(comment);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentTask.setComment(comment);
		
		//und CommentTaskspeichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			// speichern
			DAFactory.getDAFactory().getCommentTaskDA().save(commentTask);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
	}
	
	public void deleteComment(){
		
		//wer kann ein aufgabe l�schen
		//owner/ersteller, admin, projekLEADER
	}
	
	public void commentProject(String projectName, String inhalt)	
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
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//Project holen
		try {
			project=DAFactory.getDAFactory().getProjectDA().getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!isAdmin()){
			
			//Member des aktuellen Users holen
			try {
				memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, project);
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
		commentProject=DAFactory.getDAFactory().getCommentProjectDA().createCommentProject();
		commentProject.setProject(project);
		
		//comment erstellen
		comment=DAFactory.getDAFactory().getCommentDA().createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		comment.setCommentProject(commentProject);
		
		//Comment speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getCommentDA().save(comment);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentProject.setComment(comment);
		
		//und CommentProject speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			// speichern
			DAFactory.getDAFactory().getCommentProjectDA().save(commentProject);
		} catch (PersistentException e) {
			e.printStackTrace();
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
	
	
	private boolean isUserLoggedIn() {		
		return (aktUser.getLoginName()!=null);
	}
	
	private boolean isAdmin(){
		return aktUser.getGlobalRole().equals("Admin");
	}
}
