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
public class Member implements Serializable {
	public Member() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Member))
			return false;
		Member member = (Member)aObj;
		if (getUserLoginName() == null) {
			if (member.getUserLoginName() != null)
				return false;
		}
		else if (!getUserLoginName().equals(member.getUserLoginName()))
			return false;
		if (getProjectName() == null) {
			if (member.getProjectName() != null)
				return false;
		}
		else if (!getProjectName().equals(member.getProjectName()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getUserLoginName() != null) {
			hashcode = hashcode + (getUserLoginName().getORMID() == null ? 0 : getUserLoginName().getORMID().hashCode());
		}
		if (getProjectName() != null) {
			hashcode = hashcode + (getProjectName().getORMID() == null ? 0 : getProjectName().getORMID().hashCode());
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
		if (key == de.fhb.jproject.data.ORMConstants.KEY_MEMBER_USERLOGINNAME) {
			this.userLoginName = (de.fhb.jproject.data.User) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_MEMBER_PROJECTNAME) {
			this.projectName = (de.fhb.jproject.data.Project) owner;
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
	
	private de.fhb.jproject.data.User userLoginName;
	
	private String userLoginNameId;
	
	public void setUserLoginNameId(String value) {
		this.userLoginNameId = value;
	}
	
	public String getUserLoginNameId() {
		return userLoginNameId;
	}
	
	private de.fhb.jproject.data.Project projectName;
	
	private String projectNameId;
	
	public void setProjectNameId(String value) {
		this.projectNameId = value;
	}
	
	public String getProjectNameId() {
		return projectNameId;
	}
	
	private String projectRole;
	
	private java.util.Set ORM_task = new java.util.HashSet();
	
	public void setProjectRole(String value) {
		this.projectRole = value;
	}
	
	public String getProjectRole() {
		return projectRole;
	}
	
	public void setUserLoginName(de.fhb.jproject.data.User value) {
		if (userLoginName != null) {
			userLoginName.member.remove(this);
		}
		if (value != null) {
			value.member.add(this);
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
	
	public void setProjectName(de.fhb.jproject.data.Project value) {
		if (projectName != null) {
			projectName.member.remove(this);
		}
		if (value != null) {
			value.member.add(this);
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
	
	private void setORM_Task(java.util.Set value) {
		this.ORM_task = value;
	}
	
	private java.util.Set getORM_Task() {
		return ORM_task;
	}
	
	public final de.fhb.jproject.data.TaskSetCollection task = new de.fhb.jproject.data.TaskSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_MEMBER_TASK, de.fhb.jproject.data.ORMConstants.KEY_TASK_MEMBERUSERLOGINNAME, de.fhb.jproject.data.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(((getUserLoginName() == null) ? "" : String.valueOf(getUserLoginName().getORMID())) + " " + ((getProjectName() == null) ? "" : String.valueOf(getProjectName().getORMID())));
	}
	
}
