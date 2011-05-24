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

public class CommentProject {
	public CommentProject() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTPROJECT_COMMENT) {
			this.comment = (de.fhb.jproject.data.Comment) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTPROJECT_PROJECTNAME) {
			this.projectName = (de.fhb.jproject.data.Project) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private de.fhb.jproject.data.Comment comment;
	
	private de.fhb.jproject.data.Project projectName;
	
	private String projectNameId;
	
	public void setProjectNameId(String value) {
		this.projectNameId = value;
	}
	
	public String getProjectNameId() {
		return projectNameId;
	}
	
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setProjectName(this);
			}
			else {
				lcomment.setProjectName(null);
			}
		}
	}
	
	public de.fhb.jproject.data.Comment getComment() {
		return comment;
	}
	
	public void setProjectName(de.fhb.jproject.data.Project value) {
		if (projectName != null) {
			projectName.comment_Project.remove(this);
		}
		if (value != null) {
			value.comment_Project.add(this);
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
	
	public de.fhb.jproject.data.Project getORMID() {
		return getProjectName();
	}
	
	public String toString() {
		return String.valueOf(((getProjectName() == null) ? "" : String.valueOf(getProjectName().getORMID())));
	}
	
}
