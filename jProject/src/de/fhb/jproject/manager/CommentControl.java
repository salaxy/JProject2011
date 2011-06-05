package de.fhb.jproject.manager;

import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.CommentDocument;
import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
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
	
	
	public void commentDocu(String documentId, String inhalt)
	throws ProjectException{ 	
		
//		Project project=null;
		Member member=null;
		Member memAktUser=null;	
		CommentDocument commentDocu=null;
		Comment comment=null;
		Document document=null;
		
		
		//debuglogging
		logger.info("commentDocu()");
//		logger.debug("String userName("+userLoginName+")"+"String projectName("+projectName+")"+"String rolle("+ rolle+")");	
		
        //abfrage ob user eingeloggt
		if(!isUserLoggedIn()){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//document holen (und implizit Project)
		try {
			document=DAFactory.getDAFactory().getDocumentDA().getDocumentByORMID(Integer.valueOf(documentId));
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Dokument nicht finden! "+ e1.getMessage());
		}catch (NullPointerException e) {
			throw new ProjectException("Keine documentId mitgegeben! "+ e.getMessage());
		}catch(IllegalArgumentException e){
			throw new ProjectException("DocumentId fehlerhaft! "+ e.getMessage());
		}
		
//		//projekt holen
//		try {
//			project=DAFactory.getDAFactory().getProjectDA().getProjectByORMID(document.getProject());
//		} catch (PersistentException e1) {
//			throw new ProjectException("Konnte Projekt nicht finden! "+ e1.getMessage());
//		}	
			
		//wenn user nicht Admin ist dann Member holen und Abfrage der Rechte im Projekt
		if(!isAdmin()){
			
			//Projekt-Rolle des aktuellen Users holen
			try {
				memAktUser=DAFactory.getDAFactory().getMemberDA().getMemberByORMID(aktUser, document.getProject());
			} catch (PersistentException e1) {
				throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
			}
			
			//RECHTE-ABFRAGE Projekt
			if(!(projectRolesController.isAllowedDeleteTaskAction(memAktUser.getProjectRole()))){
				throw new ProjectException("Sie haben keine Rechte die Aufgabe(Task) zu loeschen!");
			}	
		}		

		//EIGENTLICHE AKTIONEN
		commentDocu=DAFactory.getDAFactory().getCommentDocumentDA().createCommentDocument(); 
//		.setDocumentId(document.getId());
//		commentDocu.setDocument();
		
		
		
		
		comment=DAFactory.getDAFactory().getCommentDA().createComment(); 
		comment.setEntry(inhalt);
		comment.setUser(aktUser);
		
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
		
		
		
		
		commentDocu.setComment(comment);
		commentDocu.setDocumentId(document.getId());
//		commentDocu.setDocument(document);
		
//		comment.setCommentDocument(commentDocu);

		
//		//member erzeugen und parameter setzen
//		member=DAFactory.getDAFactory().getMemberDA().createMember();
//		//project setzen
//		member.setProject(project);
//		//rolle setzen
//		member.setProjectRole(rolle);
//		
//		//user holen und setzen
//		try {
//			User tempUser = DAFactory.getDAFactory().getUserDA().getUserByORMID(userLoginName);
//			member.setUser(tempUser);
//		} catch (PersistentException e1) {
//			throw new ProjectException("Konnte den User nicht finden! "+ e1.getMessage());
//		}
		
//		try {		
//			PersistentSession session;		
//			//Session holen
//			session = JProjectPersistentManager.instance().getSession();
//			//und bereinigen
//			session.clear();
//			//Member speichern
//			DAFactory.getDAFactory().getCommentDocumentDA().save(commentDocu);
//		} catch (PersistentException e) {
//			e.printStackTrace();
//			throw new ProjectException("Konnte Member nicht speichern! "+ e.getMessage());
//		}
//					
		//Member speichern
		try {		
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
			//Member speichern
			DAFactory.getDAFactory().getCommentDocumentDA().save(commentDocu);
		} catch (PersistentException e) {
			e.printStackTrace();
			throw new ProjectException("Konnte comment nicht speichern! "+ e.getMessage());
		}
	}
			
	public void commentSource(){}
	
	public void commentTask(){}
	
	public void deleteComment(){
		
		//wer kann ein aufgabe löschen
		//owner/ersteller, admin, projekLEADER
	}
	
	public void commentProject(){}
	
	public void updateComment(){
		//wer kann ein comment löschen
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
		return aktUser.getGlobalRole().equals(GlobalRolesControl.ADMIN);
	}
}
