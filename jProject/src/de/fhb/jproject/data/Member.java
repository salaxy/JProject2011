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
 * Member ist Assoziationsklasse zwischen User und Project.
 * Ein Member ist also ein User der in ein Projekt involviert ist.
 */
public class Member implements Serializable {
	public Member() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Member))
			return false;
		Member member = (Member)aObj;
		if (getUser() == null) {
			if (member.getUser() != null)
				return false;
		}
		else if (!getUser().equals(member.getUser()))
			return false;
		if (getProject() == null) {
			if (member.getProject() != null)
				return false;
		}
		else if (!getProject().equals(member.getProject()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getUser() != null) {
			hashcode = hashcode + (getUser().getORMID() == null ? 0 : getUser().getORMID().hashCode());
		}
		if (getProject() != null) {
			hashcode = hashcode + (getProject().getORMID() == null ? 0 : getProject().getORMID().hashCode());
		}
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_MEMBER_TASK) {
			return ORM_task;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_MEMBER_USER) {
			this.user = (de.fhb.jproject.data.User) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_MEMBER_PROJECT) {
			this.project = (de.fhb.jproject.data.Project) owner;
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
	
	private de.fhb.jproject.data.User user;
	
	private String userId;
	
	public void setUserId(String value) {
		this.userId = value;
	}
	
	public String getUserId() {
		return userId;
	}
	
	private de.fhb.jproject.data.Project project;
	
	private String projectId;
	
	public void setProjectId(String value) {
		this.projectId = value;
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	private String projectRole;
	
	private java.util.Set ORM_task = new java.util.HashSet();
	
	/**
	 * Projektrolle des Member in einem Projekt.
	 */
	public void setProjectRole(String value) {
		this.projectRole = value;
	}
	
	/**
	 * Projektrolle des Member in einem Projekt.
	 */
	public String getProjectRole() {
		return projectRole;
	}
	
	public void setUser(de.fhb.jproject.data.User value) {
		if (user != null) {
			user.member.remove(this);
		}
		if (value != null) {
			value.member.add(this);
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
	
	public void setProject(de.fhb.jproject.data.Project value) {
		if (project != null) {
			project.member.remove(this);
		}
		if (value != null) {
			value.member.add(this);
		}
	}
	
	public de.fhb.jproject.data.Project getProject() {
		return project;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Project(de.fhb.jproject.data.Project value) {
		this.project = value;
	}
	
	private de.fhb.jproject.data.Project getORM_Project() {
		return project;
	}
	
	private void setORM_Task(java.util.Set value) {
		this.ORM_task = value;
	}
	
	private java.util.Set getORM_Task() {
		return ORM_task;
	}
	
	public final de.fhb.jproject.data.TaskSetCollection task = new de.fhb.jproject.data.TaskSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_MEMBER_TASK, de.fhb.jproject.data.ORMConstants.KEY_TASK_MEMBERUSER, de.fhb.jproject.data.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(((getUser() == null) ? "" : String.valueOf(getUser().getORMID())) + " " + ((getProject() == null) ? "" : String.valueOf(getProject().getORMID())));
	}
	
}
