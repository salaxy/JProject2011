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
 * Ein Task ist eine Aufgabe die es in einem Projekt zu erledigen gilt.
 */
public class Task implements Serializable {
	/**
	 * 
	 */
	public Task() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_MEMBERUSER) {
			return ORM_memberUser;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_COMMENTTASK) {
			return ORM_commentTask;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_TASK_PROJECT) {
			this.project = (de.fhb.jproject.data.Project) owner;
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
	
	private de.fhb.jproject.data.Project project;
	
	private String titel;
	
	private String aufgabenstellung;
	
	private boolean done;
	
	private de.fhb.jproject.data.Termin termin;
	
	private java.util.Set ORM_memberUser = new java.util.HashSet();
	
	private java.util.Set ORM_commentTask = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getORMID() {
		return getId();
	}
	
	/**
	 * Bezeichnung der Task
	 * 
	 * @param value 
	 */
	public void setTitel(String value) {
		this.titel = value;
	}
	
	/**
	 * Bezeichnung der Task
	 * 
	 * @return 
	 */
	public String getTitel() {
		return titel;
	}
	
	/**
	 * Formulierter Inhalt der Aufgabenstellung
	 * 
	 * @param value 
	 */
	public void setAufgabenstellung(String value) {
		this.aufgabenstellung = value;
	}
	
	/**
	 * Formulierter Inhalt der Aufgabenstellung
	 * 
	 * @return 
	 */
	public String getAufgabenstellung() {
		return aufgabenstellung;
	}
	
	/**
	 * Flag für den Status ob ein Task erledigt ist oder nicht.
	 * 
	 * @param value 
	 */
	public void setDone(boolean value) {
		this.done = value;
	}
	
	/**
	 * Flag für den Status ob ein Task erledigt ist oder nicht.
	 * 
	 * @return 
	 */
	public boolean getDone() {
		return done;
	}
	
	private void setORM_MemberUser(java.util.Set value) {
		this.ORM_memberUser = value;
	}
	
	private java.util.Set getORM_MemberUser() {
		return ORM_memberUser;
	}
	
	/**
	 * 
	 */
	public final de.fhb.jproject.data.MemberSetCollection memberUser = new de.fhb.jproject.data.MemberSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_TASK_MEMBERUSER, de.fhb.jproject.data.ORMConstants.KEY_MEMBER_TASK, de.fhb.jproject.data.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	/**
	 * 
	 * @param value
	 */
	public void setProject(de.fhb.jproject.data.Project value) {
		if (project != null) {
			project.task.remove(this);
		}
		if (value != null) {
			value.task.add(this);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Project getProject() {
		return project;
	}
	
	/**
	 * This method is for internal use only.
	 * 
	 * @param value 
	 */
	public void setORM_Project(de.fhb.jproject.data.Project value) {
		this.project = value;
	}
	
	private de.fhb.jproject.data.Project getORM_Project() {
		return project;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setTermin(de.fhb.jproject.data.Termin value) {
		if (termin != null) {
			termin.task.remove(this);
		}
		if (value != null) {
			value.task.add(this);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Termin getTermin() {
		return termin;
	}
	
	/**
	 * This method is for internal use only.
	 * 
	 * @param value 
	 */
	public void setORM_Termin(de.fhb.jproject.data.Termin value) {
		this.termin = value;
	}
	
	private de.fhb.jproject.data.Termin getORM_Termin() {
		return termin;
	}
	
	private void setORM_CommentTask(java.util.Set value) {
		this.ORM_commentTask = value;
	}
	
	private java.util.Set getORM_CommentTask() {
		return ORM_commentTask;
	}
	
	/**
	 * 
	 */
	public final de.fhb.jproject.data.CommentTaskSetCollection commentTask = new de.fhb.jproject.data.CommentTaskSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_TASK_COMMENTTASK, de.fhb.jproject.data.ORMConstants.KEY_COMMENTTASK_TASK, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(getId());
	}
	
}
