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
 * Spezieller Kommentar zu einem Task
 */
public class CommentTask implements Serializable {
	/**
	 * 
	 */
	public CommentTask() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTTASK_COMMENT) {
			this.comment = (de.fhb.jproject.data.Comment) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTTASK_TASK) {
			this.task = (de.fhb.jproject.data.Task) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private de.fhb.jproject.data.Comment comment;
	
	private int commentId;
	
	/**
	 * 
	 * @param value
	 */
	public void setCommentId(int value) {
		this.commentId = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCommentId() {
		return commentId;
	}
	
	private de.fhb.jproject.data.Task task;
	
	/**
	 * 
	 * @param value
	 */
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setCommentTask(this);
			}
			else {
				lcomment.setCommentTask(null);
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Comment getComment() {
		return comment;
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Comment getORMID() {
		return getComment();
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setTask(de.fhb.jproject.data.Task value) {
		if (task != null) {
			task.commentTask.remove(this);
		}
		if (value != null) {
			value.commentTask.add(this);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Task getTask() {
		return task;
	}
	
	/**
	 * This method is for internal use only.
	 * 
	 * @param value 
	 */
	public void setORM_Task(de.fhb.jproject.data.Task value) {
		this.task = value;
	}
	
	private de.fhb.jproject.data.Task getORM_Task() {
		return task;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(((getComment() == null) ? "" : String.valueOf(getComment().getORMID())));
	}
	
}
