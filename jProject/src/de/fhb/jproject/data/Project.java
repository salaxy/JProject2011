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
public class Project implements Serializable {
	public Project() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_PROJECT_MEMBER) {
			return ORM_member;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_PROJECT_SOURCECODE) {
			return ORM_sourcecode;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_PROJECT_DOCUMENT) {
			return ORM_document;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_PROJECT_TASK) {
			return ORM_task;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_PROJECT_COMMENTPROJECT) {
			return ORM_commentProject;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String name;
	
	private String status;
	
	private java.util.Set ORM_member = new java.util.HashSet();
	
	private java.util.Set ORM_sourcecode = new java.util.HashSet();
	
	private java.util.Set ORM_document = new java.util.HashSet();
	
	private java.util.Set ORM_task = new java.util.HashSet();
	
	private java.util.Set ORM_commentProject = new java.util.HashSet();
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getORMID() {
		return getName();
	}
	
	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return status;
	}
	
	private void setORM_Member(java.util.Set value) {
		this.ORM_member = value;
	}
	
	private java.util.Set getORM_Member() {
		return ORM_member;
	}
	
	public final de.fhb.jproject.data.MemberSetCollection member = new de.fhb.jproject.data.MemberSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_PROJECT_MEMBER, de.fhb.jproject.data.ORMConstants.KEY_MEMBER_PROJECT, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Sourcecode(java.util.Set value) {
		this.ORM_sourcecode = value;
	}
	
	private java.util.Set getORM_Sourcecode() {
		return ORM_sourcecode;
	}
	
	public final de.fhb.jproject.data.SourcecodeSetCollection sourcecode = new de.fhb.jproject.data.SourcecodeSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_PROJECT_SOURCECODE, de.fhb.jproject.data.ORMConstants.KEY_SOURCECODE_PROJECT, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Document(java.util.Set value) {
		this.ORM_document = value;
	}
	
	private java.util.Set getORM_Document() {
		return ORM_document;
	}
	
	public final de.fhb.jproject.data.DocumentSetCollection document = new de.fhb.jproject.data.DocumentSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_PROJECT_DOCUMENT, de.fhb.jproject.data.ORMConstants.KEY_DOCUMENT_PROJECT, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Task(java.util.Set value) {
		this.ORM_task = value;
	}
	
	private java.util.Set getORM_Task() {
		return ORM_task;
	}
	
	public final de.fhb.jproject.data.TaskSetCollection task = new de.fhb.jproject.data.TaskSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_PROJECT_TASK, de.fhb.jproject.data.ORMConstants.KEY_TASK_PROJECT, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_CommentProject(java.util.Set value) {
		this.ORM_commentProject = value;
	}
	
	private java.util.Set getORM_CommentProject() {
		return ORM_commentProject;
	}
	
	public final de.fhb.jproject.data.CommentProjectSetCollection commentProject = new de.fhb.jproject.data.CommentProjectSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_PROJECT_COMMENTPROJECT, de.fhb.jproject.data.ORMConstants.KEY_COMMENTPROJECT_PROJECT, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getName());
	}
	
}
