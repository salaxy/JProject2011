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
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTPROJECT_PROJECT) {
			this.project = (de.fhb.jproject.data.Project) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private de.fhb.jproject.data.Comment comment;
	
	private de.fhb.jproject.data.Project project;
	
	private String projectId;
	
	public void setProjectId(String value) {
		this.projectId = value;
	}
	
	public String getProjectId() {
		return projectId;
	}
	
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setCommentProject(this);
			}
			else {
				lcomment.setCommentProject(null);
			}
		}
	}
	
	public de.fhb.jproject.data.Comment getComment() {
		return comment;
	}
	
	public void setProject(de.fhb.jproject.data.Project value) {
		if (project != null) {
			project.commentProject.remove(this);
		}
		if (value != null) {
			value.commentProject.add(this);
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
	
	public de.fhb.jproject.data.Project getORMID() {
		return getProject();
	}
	
	public String toString() {
		return String.valueOf(((getProject() == null) ? "" : String.valueOf(getProject().getORMID())));
	}
	
}
