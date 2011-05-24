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

public class Document {
	public Document() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_DOCUMENT_COMMENT_DOCUMENT) {
			return ORM_comment_Document;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_DOCUMENT_PROJECTNAME) {
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
	
	private java.util.Set ORM_comment_Document = new java.util.HashSet();
	
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
			projectName.document.remove(this);
		}
		if (value != null) {
			value.document.add(this);
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
	
	private void setORM_Comment_Document(java.util.Set value) {
		this.ORM_comment_Document = value;
	}
	
	private java.util.Set getORM_Comment_Document() {
		return ORM_comment_Document;
	}
	
	public final de.fhb.jproject.data.CommentDocumentSetCollection comment_Document = new de.fhb.jproject.data.CommentDocumentSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_DOCUMENT_COMMENT_DOCUMENT, de.fhb.jproject.data.ORMConstants.KEY_COMMENTDOCUMENT_DOCUMENT, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
