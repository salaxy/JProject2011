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

public class Task {
	public Task() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_MEMBERUSERLOGINNAME) {
			return ORM_memberUserLoginName;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_COMMENT_TASK) {
			return ORM_comment_Task;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_PROJECTNAME) {
			this.projectName = (de.fhb.jproject.data.Project) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_TERMIN) {
			this.termin = (de.fhb.jproject.data.Termin) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private de.fhb.jproject.data.Project projectName;
	
	private String titel;
	
	private String aufgabenstellung;
	
	private byte done;
	
	private de.fhb.jproject.data.Termin termin;
	
	private java.util.Set ORM_memberUserLoginName = new java.util.HashSet();
	
	private java.util.Set ORM_comment_Task = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setTitel(String value) {
		this.titel = value;
	}
	
	public String getTitel() {
		return titel;
	}
	
	public void setAufgabenstellung(String value) {
		this.aufgabenstellung = value;
	}
	
	public String getAufgabenstellung() {
		return aufgabenstellung;
	}
	
	public void setDone(byte value) {
		this.done = value;
	}
	
	public byte getDone() {
		return done;
	}
	
	private void setORM_MemberUserLoginName(java.util.Set value) {
		this.ORM_memberUserLoginName = value;
	}
	
	private java.util.Set getORM_MemberUserLoginName() {
		return ORM_memberUserLoginName;
	}
	
	public final de.fhb.jproject.data.MemberSetCollection memberUserLoginName = new de.fhb.jproject.data.MemberSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_TASK_MEMBERUSERLOGINNAME, de.fhb.jproject.data.ORMConstants.KEY_MEMBER_TASK, de.fhb.jproject.data.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setProjectName(de.fhb.jproject.data.Project value) {
		if (projectName != null) {
			projectName.task.remove(this);
		}
		if (value != null) {
			value.task.add(this);
		}
	}
	
	public de.fhb.jproject.data.Project getProjectName() {
		return projectName;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_ProjectName(de.fhb.jproject.data.Project value) {
		this.projectName = value;
	}
	
	private de.fhb.jproject.data.Project getORM_ProjectName() {
		return projectName;
	}
	
	public void setTermin(de.fhb.jproject.data.Termin value) {
		if (termin != null) {
			termin.task.remove(this);
		}
		if (value != null) {
			value.task.add(this);
		}
	}
	
	public de.fhb.jproject.data.Termin getTermin() {
		return termin;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Termin(de.fhb.jproject.data.Termin value) {
		this.termin = value;
	}
	
	private de.fhb.jproject.data.Termin getORM_Termin() {
		return termin;
	}
	
	private void setORM_Comment_Task(java.util.Set value) {
		this.ORM_comment_Task = value;
	}
	
	private java.util.Set getORM_Comment_Task() {
		return ORM_comment_Task;
	}
	
	public final de.fhb.jproject.data.CommentTaskSetCollection comment_Task = new de.fhb.jproject.data.CommentTaskSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_TASK_COMMENT_TASK, de.fhb.jproject.data.ORMConstants.KEY_COMMENTTASK_TASK, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
