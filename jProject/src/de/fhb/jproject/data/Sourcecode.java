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

public class Sourcecode {
	public Sourcecode() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_COMMENT_SOURCECODE) {
			return ORM_Comment_Sourcecode;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_PROJECTNAME) {
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
	
	private int id;
	
	private de.fhb.jproject.data.Project projectName;
	
	private String dateiname;
	
	private java.util.Set ORM_Comment_Sourcecode = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDateiname(String value) {
		this.dateiname = value;
	}
	
	public String getDateiname() {
		return dateiname;
	}
	
	public void setProjectName(de.fhb.jproject.data.Project value) {
		if (projectName != null) {
			projectName.sourcecode.remove(this);
		}
		if (value != null) {
			value.sourcecode.add(this);
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
	
	private void setORM_Comment_Sourcecode(java.util.Set value) {
		this.ORM_Comment_Sourcecode = value;
	}
	
	private java.util.Set getORM_Comment_Sourcecode() {
		return ORM_Comment_Sourcecode;
	}
	
	public final de.fhb.jproject.data.CommentSourcecodeSetCollection comment_Sourcecode = new de.fhb.jproject.data.CommentSourcecodeSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_COMMENT_SOURCECODE, de.fhb.jproject.data.ORMConstants.KEY_COMMENTSOURCECODE_SOURCECODE, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
