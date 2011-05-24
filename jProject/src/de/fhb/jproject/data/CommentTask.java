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

public class CommentTask {
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
	
	private de.fhb.jproject.data.Task task;
	
	private int taskId;
	
	public void setTaskId(int value) {
		this.taskId = value;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setTask(this);
			}
			else {
				lcomment.setTask(null);
			}
		}
	}
	
	public de.fhb.jproject.data.Comment getComment() {
		return comment;
	}
	
	public void setTask(de.fhb.jproject.data.Task value) {
		if (task != null) {
			task.comment_Task.remove(this);
		}
		if (value != null) {
			value.comment_Task.add(this);
		}
	}
	
	public de.fhb.jproject.data.Task getTask() {
		return task;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Task(de.fhb.jproject.data.Task value) {
		this.task = value;
	}
	
	private de.fhb.jproject.data.Task getORM_Task() {
		return task;
	}
	
	public de.fhb.jproject.data.Task getORMID() {
		return getTask();
	}
	
	public String toString() {
		return String.valueOf(((getTask() == null) ? "" : String.valueOf(getTask().getORMID())));
	}
	
}
