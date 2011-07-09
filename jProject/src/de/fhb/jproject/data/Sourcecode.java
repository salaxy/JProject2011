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
 * Ein Sourcecode ist ein in der Informatik, für Menschen lesbare, in einer Programmiersprache geschriebene Text eines Computerprogramms.
 */
public class Sourcecode implements Serializable {
	/**
	 * 
	 */
	public Sourcecode() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_COMMENTSOURCECODE) {
			return ORM_commentSourcecode;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_PROJECT) {
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
	
	private int id;
	
	private de.fhb.jproject.data.Project project;
	
	private String dateiname;
	
	private java.util.Set ORM_commentSourcecode = new java.util.HashSet();
	
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
	 * Der Pfad der Datei des Sourcecodes im System.
	 * 
	 * @param value 
	 */
	public void setDateiname(String value) {
		this.dateiname = value;
	}
	
	/**
	 * Der Pfad der Datei des Sourcecodes im System.
	 * 
	 * @return 
	 */
	public String getDateiname() {
		return dateiname;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setProject(de.fhb.jproject.data.Project value) {
		if (project != null) {
			project.sourcecode.remove(this);
		}
		if (value != null) {
			value.sourcecode.add(this);
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
	
	private void setORM_CommentSourcecode(java.util.Set value) {
		this.ORM_commentSourcecode = value;
	}
	
	private java.util.Set getORM_CommentSourcecode() {
		return ORM_commentSourcecode;
	}
	
	/**
	 * 
	 */
	public final de.fhb.jproject.data.CommentSourcecodeSetCollection commentSourcecode = new de.fhb.jproject.data.CommentSourcecodeSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_COMMENTSOURCECODE, de.fhb.jproject.data.ORMConstants.KEY_COMMENTSOURCECODE_SOURCECODE, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(getId());
	}
	
}
