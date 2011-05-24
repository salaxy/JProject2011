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

public class Comment {
	public Comment() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_USERLOGINNAME) {
			this.userLoginName = (de.fhb.jproject.data.User) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_PROJECTNAME) {
			this.projectName = (de.fhb.jproject.data.CommentProject) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_SOURCECODE) {
			this.sourcecode = (de.fhb.jproject.data.CommentSourcecode) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_DOCUMENT) {
			this.document = (de.fhb.jproject.data.CommentDocument) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENT_TASK) {
			this.task = (de.fhb.jproject.data.CommentTask) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private de.fhb.jproject.data.User userLoginName;
	
	private String entry;
	
	private de.fhb.jproject.data.CommentProject projectName;
	
	private de.fhb.jproject.data.CommentSourcecode sourcecode;
	
	private de.fhb.jproject.data.CommentDocument document;
	
	private de.fhb.jproject.data.CommentTask task;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setEntry(String value) {
		this.entry = value;
	}
	
	public String getEntry() {
		return entry;
	}
	
	public void setUserLoginName(de.fhb.jproject.data.User value) {
		if (userLoginName != null) {
			userLoginName.comment.remove(this);
		}
		if (value != null) {
			value.comment.add(this);
		}
	}
	
	public de.fhb.jproject.data.User getUserLoginName() {
		return userLoginName;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_UserLoginName(de.fhb.jproject.data.User value) {
		this.userLoginName = value;
	}
	
	private de.fhb.jproject.data.User getORM_UserLoginName() {
		return userLoginName;
	}
	
	public void setProjectName(de.fhb.jproject.data.CommentProject value) {
		if (this.projectName != value) {
			de.fhb.jproject.data.CommentProject lprojectName = this.projectName;
			this.projectName = value;
			if (value != null) {
				projectName.setComment(this);
			}
			else {
				lprojectName.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentProject getProjectName() {
		return projectName;
	}
	
	public void setSourcecode(de.fhb.jproject.data.CommentSourcecode value) {
		if (this.sourcecode != value) {
			de.fhb.jproject.data.CommentSourcecode lsourcecode = this.sourcecode;
			this.sourcecode = value;
			if (value != null) {
				sourcecode.setComment(this);
			}
			else {
				lsourcecode.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentSourcecode getSourcecode() {
		return sourcecode;
	}
	
	public void setDocument(de.fhb.jproject.data.CommentDocument value) {
		if (this.document != value) {
			de.fhb.jproject.data.CommentDocument ldocument = this.document;
			this.document = value;
			if (value != null) {
				document.setComment(this);
			}
			else {
				ldocument.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentDocument getDocument() {
		return document;
	}
	
	public void setTask(de.fhb.jproject.data.CommentTask value) {
		if (this.task != value) {
			de.fhb.jproject.data.CommentTask ltask = this.task;
			this.task = value;
			if (value != null) {
				task.setComment(this);
			}
			else {
				ltask.setComment(null);
			}
		}
	}
	
	public de.fhb.jproject.data.CommentTask getTask() {
		return task;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
