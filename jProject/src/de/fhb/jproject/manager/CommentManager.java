package de.fhb.jproject.manager;

import de.fhb.jproject.repository.da.UserDA;
import java.util.List;

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
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.SourcecodeDA;
import de.fhb.jproject.repository.da.TaskDA;
import org.apache.log4j.Level;

/**
 *  Manager fuer die Kommentare
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class CommentManager {
	
	private DocumentDA documentDA;
	private SourcecodeDA sourcecodeDA;
	private CommentDA commentDA;
	private CommentDocumentDA commentDocumentDA;
	private CommentSourcecodeDA commentSourcecodeDA;
	private TaskDA taskDA;
	private CommentTaskDA commentTaskDA;
	private ProjectDA projectDA;
	private CommentProjectDA commentProjectDA;
	private final UserDA userDA;
	
	private static final Logger logger = Logger.getLogger(CommentManager.class);
	
	
	
	
	public CommentManager(){
		documentDA = DAFactory.getDAFactory().getDocumentDA();
		sourcecodeDA = DAFactory.getDAFactory().getSourcecodeDA();
		commentDA = DAFactory.getDAFactory().getCommentDA();
		commentDocumentDA = DAFactory.getDAFactory().getCommentDocumentDA();
		commentSourcecodeDA = DAFactory.getDAFactory().getCommentSourcecodeDA();
		taskDA = DAFactory.getDAFactory().getTaskDA();
		commentTaskDA = DAFactory.getDAFactory().getCommentTaskDA();
		projectDA = DAFactory.getDAFactory().getProjectDA();
		commentProjectDA = DAFactory.getDAFactory().getCommentProjectDA();
		userDA = DAFactory.getDAFactory().getUserDA();
		
	}
	
	
	/**
	 * kommentieren eines Dokuments
	 * 
	 * @param aktUser
	 * @param documentId
	 * @param inhalt
	 * @throws ProjectException
	 */
	public void commentDocu(String aktUser, int documentId, String inhalt)
	throws ProjectException{ 	
		clearSession();	
		CommentDocument commentDocu=null;
		Comment comment=null;
		Document document=null;
		User user=null;
		
		//debuglogging
		logger.info("commentDocu()");
		logger.debug("int documentId("+documentId+")"
				+"String inhalt("+inhalt+")");	
		
		
		
		try {
			//holen der daten
			user= userDA.loadUserByORMID(aktUser);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
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
		
		
		clearSession();
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentDocu=commentDocumentDA.createCommentDocument();
		commentDocu.setDocument(document);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(user);
		comment.setCommentDocument(commentDocu);
		
		//Comment speichern
		try {
			
			//Referenz auf Comment setzen
			commentDocu.setComment(comment);
			//Comment speichern
			commentDA.save(comment);
			
			//CommentDocu speichern
			commentDocumentDA.save(commentDocu);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
	}
			
	/**
	 * kommentieren eines Sourcecodes
	 * 
	 * @param sourcecodeId
	 * @param inhalt
	 * @throws ProjectException
	 */
	public void commentSource(String aktUser, int sourcecodeId, String inhalt)
	throws ProjectException{ 	
		clearSession();
		CommentSourcecode commentSource=null;
		Comment comment=null;
		Sourcecode sourcecode=null;
		User user=null;
		
		//debuglogging
		logger.info("commentSource()");
		logger.debug("int sourcecodeId("+sourcecodeId+")"
				+"String inhalt("+inhalt+")");	
		
		
		try {
			//holen der daten
			user= userDA.loadUserByORMID(aktUser);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		//sourcecode holen (und implizit damit auch das Project)
		try {
			sourcecode=sourcecodeDA.getSourcecodeByORMID(sourcecodeId);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Sourcecode nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine sourcecodeId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("sourcecodeId fehlerhaft! "+ e.getMessage());
		}	
		

		clearSession();
		//EIGENTLICHE AKTIONEN
		
		//CommentSourcecode erstellen
		commentSource=commentSourcecodeDA.createCommentSourcecode();
		commentSource.setSourcecode(sourcecode);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(user);
		comment.setCommentSourcecode(commentSource);
		
		//Comment speichern
		try {
			//Member speichern
			commentDA.save(comment);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentSource.setComment(comment);
		
		//und CommentSourcecode speichern
		try {
			// speichern
			commentSourcecodeDA.save(commentSource);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		
		
	}
	
	/**
	 * kommentieren eines Task
	 * 
	 * @param aktUser
	 * @param taskId
	 * @param inhalt
	 * @throws ProjectException
	 */
	public void commentTask(String aktUser, int taskId, String inhalt)	
	throws ProjectException{ 	
		clearSession();
		CommentTask commentTask=null;
		Comment comment=null;
		Task task=null;
		User user=null;
		
		//debuglogging
		logger.info("commentTask()");
		logger.debug("int taskId("+taskId+")"
				+"String inhalt("+inhalt+")");	
		
		
		try {
			//holen der daten
			user= userDA.loadUserByORMID(aktUser);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		//Task holen (und implizit damit auch das Project)
		try {
			task=taskDA.getTaskByORMID(taskId);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Task nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine taskId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("taskId fehlerhaft! "+ e.getMessage());
		}	

		clearSession();
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentTask=commentTaskDA.createCommentTask();
		commentTask.setTask(task);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(user);
		comment.setCommentTask(commentTask);
		
		//Comment speichern
		try {
			//Member speichern
			commentDA.save(comment);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentTask.setComment(comment);
		
		//und CommentTaskspeichern
		try {
			// speichern
			commentTaskDA.save(commentTask);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
	}
	

	/**
	 * kommentieren eines Projects
	 * 
	 * @param aktUser
	 * @param projectName
	 * @param inhalt
	 * @throws ProjectException
	 */
	public void commentProject(String aktUser, String projectName, String inhalt)	
	throws ProjectException{ 	
		clearSession();
		CommentProject commentProject=null;
		Comment comment=null;
		Project project=null;
		User user=null;
		
		//debuglogging
		logger.info("commentProject()");
		logger.debug("String projectName("+projectName+")"
				+"String inhalt("+inhalt+")");	
		
		
		try {
			//holen der daten
			user= userDA.loadUserByORMID(aktUser);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		//Project holen
		try {
			project=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine projectName mitgegeben! "+ e.getMessage());
		}
	

		clearSession();
		//EIGENTLICHE AKTIONEN
		
		//commentdocu erstellen
		commentProject=commentProjectDA.createCommentProject();
		commentProject.setProject(project);
		
		//comment erstellen
		comment=commentDA.createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(user);
		comment.setCommentProject(commentProject);
		
		//Comment speichern
		try {
			//Member speichern
			commentDA.save(comment);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
		//referenz auf comment setzen
		commentProject.setComment(comment);
		
		//und CommentProject speichern
		try {
			// speichern
			commentProjectDA.save(commentProject);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
		
	}
	
	/**
	 * Loeschen eines Kommentars
	 * 
	 * @param aktUser
	 * @param projectName
	 * @param commentId
	 * @throws ProjectException
	 */
	public void deleteComment(String aktUser, String projectName, int commentId)
	throws ProjectException{
		clearSession();
		//debuglogging
		logger.info("deleteComment()");
		//TODO DEBUGINFO
		
		
		
		//EIGENTLICHE AKTIONEN
		
		//loeschen des comments
		try {
			commentDA.delete(commentDA.getCommentByORMID(commentId));
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Comment nicht loeschen!");
		}
	}
	
	/**
	 * Updaten des Inhalts eines Kommentars
	 * 
	 * @param aktUser
	 * @param projectName
	 * @param commentId
	 * @param neuerInhalt
	 * @throws ProjectException
	 */
	public void updateComment(String aktUser, String projectName, int commentId, String neuerInhalt)
	throws ProjectException{ 	
		clearSession();
		Comment comment=null;
		
		//debuglogging
		logger.info("updateComment()");
		//TODO DEBUGINFO
		
		//comment holen
		try {
			comment=commentDA.getCommentByORMID(commentId);
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Comment nicht finden!");
		}

		//setzen der aenderung
		comment.setEntry(neuerInhalt);
		
		//speichern des comments
		try {
			commentDA.save(comment);
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Comment nicht speichern!");
		}	
	}
	
	/**
	 * Alle Kommentare eines Dokuments holen
	 * 
	 * @param aktUser
	 * @param projectName
	 * @param documentId
	 * @return
	 * @throws ProjectException
	 */
	public List<Comment> showAllComments41Docu(String aktUser, String projectName, int documentId)
	throws ProjectException{
		clearSession();
		
		List<Comment> list=null;
		
		//debuglogging
		logger.info("showAllComments41Docu()");
		
		//EIGENTLICHE AKTIONEN
		
		//holen der comments
		try {
			list=commentDA.listAllCommentsToDocument(documentId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Comments nicht finden! "+ e.getMessage());
		}
		
		return list;
	}
	
	
	/**
	 * Alle Kommentare eines Sourcecodes holen
	 * 
	 * @param aktUser
	 * @param projectName
	 * @param sourcecodeId
	 * @throws ProjectException
	 */
	public List<Comment>  showAllComments41Source(String aktUser, String projectName, int sourcecodeId)
	throws ProjectException{
		clearSession();
		
		List<Comment> list=null;
		
		//debuglogging
		logger.info("showAllComments41Source()");
		//TODO DEBUGINFO
		
		//holen der Comments
		try {
			list=commentDA.listAllCommentsToSourcecode(sourcecodeId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Comments nicht finden! "+ e.getMessage());
		}
		
		return list;
	}
	
	/**
	 * Alle Kommentare eines Tasks holen
	 * 
	 * @param aktUser
	 * @param projectName
	 * @param taskId
	 * @return
	 * @throws ProjectException
	 */
	public List<Comment> showAllComments41Task(String aktUser, String projectName, int taskId)
	throws ProjectException{
		clearSession();
		
		List<Comment> list=null;
		
		//debuglogging
		logger.info("showAllComments41Task()");
		//TODO DEBUGINFO
		//EIGENTLICHE AKTIONEN
		
		//holen der comments
		try {
			list=commentDA.listAllCommentsToTask(taskId);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Comments nicht finden! "+ e.getMessage());
		}
		
		return list;
	}
	
	/**
	 * Alle Kommentare eines Projektes holen
	 * 
	 * @param aktUser
	 * @param projectName
	 * @return
	 * @throws ProjectException
	 */
	public List<Comment> showAllComments41Project(String aktUser, String projectName)
	throws ProjectException{
		clearSession();
		
		List<Comment> list=null;
		
		//debuglogging
		logger.info("showAllComments41Project()");
		//TODO DEBUGINFO
		
		//holen der comments
		try {
			list=commentDA.listAllCommentsToProject(projectName);
		} catch (PersistentException e) {
			throw new ProjectException("Kann Comments nicht finden! "+ e.getMessage());
		}
		
		return list;
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
