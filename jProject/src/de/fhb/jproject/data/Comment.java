/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package de.fhb.jproject.data;

import java.io.Serializable;
/**
 * Kommentar zu Sourcecode/Document/Project/Task. Beinhaltet spezielle Kommentare.
 */
public class Comment implements Serializable {
	public Comment() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_USER) {
			this.user = (de.fhb.jproject.data.User) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_COMMENTPROJECT) {
			this.commentProject = (de.fhb.jproject.data.CommentProject) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_COMMENTSOURCECODE) {
			this.commentSourcecode = (de.fhb.jproject.data.CommentSourcecode) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_COMMENTDOCUMENT) {
			this.commentDocument = (de.fhb.jproject.data.CommentDocument) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_COMMENTTASK) {
			this.commentTask = (de.fhb.jproject.data.CommentTask) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private de.fhb.jproject.data.User user;
	
	private String entry;
	
	private de.fhb.jproject.data.CommentProject commentProject;
	
	private de.fhb.jproject.data.CommentSourcecode commentSourcecode;
	
	private de.fhb.jproject.data.CommentDocument commentDocument;
	
	private de.fhb.jproject.data.CommentTask commentTask;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * Der eigentliche Inhalt des Kommentars
	 */
	public void setEntry(String value) {
		this.entry = value;
	}
	
	/**
	 * Der eigentliche Inhalt des Kommentars
	 */
	public String getEntry() {
		return entry;
	}
	
	public void setUser(de.fhb.jproject.data.User value) {
		if (user != null) {
			user.comment.remove(this);
		}
		if (value != null) {
			value.comment.add(this);
		}
	}
	
	public de.fhb.jproject.data.User getUser() {
		return user;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_User(de.fhb.jproject.data.User value) {
		this.user = value;
	}
	
	private de.fhb.jproject.data.User getORM_User() {
		return user;
	}
	
	public void setCommentProject(de.fhb.jproject.data.CommentProject value) {
		if (this.commentProject != value) {
			de.fhb.jproject.data.CommentProject lcommentProject = this.commentProject;
			this.commentProject = value;
			if (value != null) {
				commentProject.setComment(this);
			}
			else {
				lcommentProject.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentProject getCommentProject() {
		return commentProject;
	}
	
	public void setCommentSourcecode(de.fhb.jproject.data.CommentSourcecode value) {
		if (this.commentSourcecode != value) {
			de.fhb.jproject.data.CommentSourcecode lcommentSourcecode = this.commentSourcecode;
			this.commentSourcecode = value;
			if (value != null) {
				commentSourcecode.setComment(this);
			}
			else {
				lcommentSourcecode.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentSourcecode getCommentSourcecode() {
		return commentSourcecode;
	}
	
	public void setCommentDocument(de.fhb.jproject.data.CommentDocument value) {
		if (this.commentDocument != value) {
			de.fhb.jproject.data.CommentDocument lcommentDocument = this.commentDocument;
			this.commentDocument = value;
			if (value != null) {
				commentDocument.setComment(this);
			}
			else {
				lcommentDocument.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentDocument getCommentDocument() {
		return commentDocument;
	}
	
	public void setCommentTask(de.fhb.jproject.data.CommentTask value) {
		if (this.commentTask != value) {
			de.fhb.jproject.data.CommentTask lcommentTask = this.commentTask;
			this.commentTask = value;
			if (value != null) {
				commentTask.setComment(this);
			}
			else {
				lcommentTask.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentTask getCommentTask() {
		return commentTask;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
