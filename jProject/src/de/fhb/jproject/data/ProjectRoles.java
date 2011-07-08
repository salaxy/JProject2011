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
 * Eine ProjectRole ist eine projektspezifische Rolle, die ein User des Systems innerhalb eines Projekts spielen kann. D.h. welche Aktionen dieser tätigen kann und darf bzw. nicht darf in einem Projekt.
 */
public class ProjectRoles implements Serializable {
	public ProjectRoles() {
	}
	
	private String role;
	
	private boolean commentDocuAction;
	
	private boolean commentSourceAction;
	
	private boolean commentTaskAction;
	
	private boolean commentProjectAction;
	
	private boolean deleteCommentAction;
	
	private boolean showAllComments41DocuAction;
	
	private boolean showAllComments41SourceAction;
	
	private boolean showAllComments41TaskAction;
	
	private boolean showAllComments41ProjectAction;
	
	private boolean updateCommentAction;
	
	private boolean addNewDocuAction;
	
	private boolean deleteDocuAction;
	
	private boolean downloadDocuAction;
	
	private boolean showDocuAction;
	
	private boolean showAllDocuAction;
	
	private boolean updateDocuAction;
	
	private boolean addMemberAction;
	
	private boolean deleteMemberAction;
	
	private boolean showAllMemberAction;
	
	private boolean addNewSourceAction;
	
	private boolean deleteSourceAction;
	
	private boolean downloadSourceAction;
	
	private boolean showSourceAction;
	
	private boolean showAllSourceAction;
	
	private boolean updateSourceAction;
	
	private boolean addNewTaskAction;
	
	private boolean deleteTaskAction;
	
	private boolean showAllTasksAction;
	
	private boolean showAllOwnTasksAction;
	
	private boolean updateTaskAction;
	
	private boolean deleteProjectAction;
	
	private boolean deAssignTaskAction;
	
	private boolean assignTaskAction;
	
	private boolean showTaskAction;
	
	private boolean showMemberAction;
	
	public void setRole(String value) {
		this.role = value;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getORMID() {
		return getRole();
	}
	
	public void setCommentDocuAction(boolean value) {
		this.commentDocuAction = value;
	}
	
	public boolean getCommentDocuAction() {
		return commentDocuAction;
	}
	
	public void setCommentSourceAction(boolean value) {
		this.commentSourceAction = value;
	}
	
	public boolean getCommentSourceAction() {
		return commentSourceAction;
	}
	
	public void setCommentTaskAction(boolean value) {
		this.commentTaskAction = value;
	}
	
	public boolean getCommentTaskAction() {
		return commentTaskAction;
	}
	
	public void setCommentProjectAction(boolean value) {
		this.commentProjectAction = value;
	}
	
	public boolean getCommentProjectAction() {
		return commentProjectAction;
	}
	
	public void setDeleteCommentAction(boolean value) {
		this.deleteCommentAction = value;
	}
	
	public boolean getDeleteCommentAction() {
		return deleteCommentAction;
	}
	
	public void setShowAllComments41DocuAction(boolean value) {
		this.showAllComments41DocuAction = value;
	}
	
	public boolean getShowAllComments41DocuAction() {
		return showAllComments41DocuAction;
	}
	
	public void setShowAllComments41SourceAction(boolean value) {
		this.showAllComments41SourceAction = value;
	}
	
	public boolean getShowAllComments41SourceAction() {
		return showAllComments41SourceAction;
	}
	
	public void setShowAllComments41TaskAction(boolean value) {
		this.showAllComments41TaskAction = value;
	}
	
	public boolean getShowAllComments41TaskAction() {
		return showAllComments41TaskAction;
	}
	
	public void setShowAllComments41ProjectAction(boolean value) {
		this.showAllComments41ProjectAction = value;
	}
	
	public boolean getShowAllComments41ProjectAction() {
		return showAllComments41ProjectAction;
	}
	
	public void setUpdateCommentAction(boolean value) {
		this.updateCommentAction = value;
	}
	
	public boolean getUpdateCommentAction() {
		return updateCommentAction;
	}
	
	public void setAddNewDocuAction(boolean value) {
		this.addNewDocuAction = value;
	}
	
	public boolean getAddNewDocuAction() {
		return addNewDocuAction;
	}
	
	public void setDeleteDocuAction(boolean value) {
		this.deleteDocuAction = value;
	}
	
	public boolean getDeleteDocuAction() {
		return deleteDocuAction;
	}
	
	public void setDownloadDocuAction(boolean value) {
		this.downloadDocuAction = value;
	}
	
	public boolean getDownloadDocuAction() {
		return downloadDocuAction;
	}
	
	public void setShowDocuAction(boolean value) {
		this.showDocuAction = value;
	}
	
	public boolean getShowDocuAction() {
		return showDocuAction;
	}
	
	public void setShowAllDocuAction(boolean value) {
		this.showAllDocuAction = value;
	}
	
	public boolean getShowAllDocuAction() {
		return showAllDocuAction;
	}
	
	public void setUpdateDocuAction(boolean value) {
		this.updateDocuAction = value;
	}
	
	public boolean getUpdateDocuAction() {
		return updateDocuAction;
	}
	
	public void setAddMemberAction(boolean value) {
		this.addMemberAction = value;
	}
	
	public boolean getAddMemberAction() {
		return addMemberAction;
	}
	
	public void setDeleteMemberAction(boolean value) {
		this.deleteMemberAction = value;
	}
	
	public boolean getDeleteMemberAction() {
		return deleteMemberAction;
	}
	
	public void setShowAllMemberAction(boolean value) {
		this.showAllMemberAction = value;
	}
	
	public boolean getShowAllMemberAction() {
		return showAllMemberAction;
	}
	
	public void setAddNewSourceAction(boolean value) {
		this.addNewSourceAction = value;
	}
	
	public boolean getAddNewSourceAction() {
		return addNewSourceAction;
	}
	
	public void setDeleteSourceAction(boolean value) {
		this.deleteSourceAction = value;
	}
	
	public boolean getDeleteSourceAction() {
		return deleteSourceAction;
	}
	
	public void setDownloadSourceAction(boolean value) {
		this.downloadSourceAction = value;
	}
	
	public boolean getDownloadSourceAction() {
		return downloadSourceAction;
	}
	
	public void setShowSourceAction(boolean value) {
		this.showSourceAction = value;
	}
	
	public boolean getShowSourceAction() {
		return showSourceAction;
	}
	
	public void setShowAllSourceAction(boolean value) {
		this.showAllSourceAction = value;
	}
	
	public boolean getShowAllSourceAction() {
		return showAllSourceAction;
	}
	
	public void setUpdateSourceAction(boolean value) {
		this.updateSourceAction = value;
	}
	
	public boolean getUpdateSourceAction() {
		return updateSourceAction;
	}
	
	public void setAddNewTaskAction(boolean value) {
		this.addNewTaskAction = value;
	}
	
	public boolean getAddNewTaskAction() {
		return addNewTaskAction;
	}
	
	public void setDeleteTaskAction(boolean value) {
		this.deleteTaskAction = value;
	}
	
	public boolean getDeleteTaskAction() {
		return deleteTaskAction;
	}
	
	public void setShowAllTasksAction(boolean value) {
		this.showAllTasksAction = value;
	}
	
	public boolean getShowAllTasksAction() {
		return showAllTasksAction;
	}
	
	public void setShowAllOwnTasksAction(boolean value) {
		this.showAllOwnTasksAction = value;
	}
	
	public boolean getShowAllOwnTasksAction() {
		return showAllOwnTasksAction;
	}
	
	public void setUpdateTaskAction(boolean value) {
		this.updateTaskAction = value;
	}
	
	public boolean getUpdateTaskAction() {
		return updateTaskAction;
	}
	
	public void setDeleteProjectAction(boolean value) {
		this.deleteProjectAction = value;
	}
	
	public boolean getDeleteProjectAction() {
		return deleteProjectAction;
	}
	
	public void setDeAssignTaskAction(boolean value) {
		this.deAssignTaskAction = value;
	}
	
	public boolean getDeAssignTaskAction() {
		return deAssignTaskAction;
	}
	
	public void setAssignTaskAction(boolean value) {
		this.assignTaskAction = value;
	}
	
	public boolean getAssignTaskAction() {
		return assignTaskAction;
	}
	
	public void setShowTaskAction(boolean value) {
		this.showTaskAction = value;
	}
	
	public boolean getShowTaskAction() {
		return showTaskAction;
	}
	
	public void setShowMemberAction(boolean value) {
		this.showMemberAction = value;
	}
	
	public boolean getShowMemberAction() {
		return showMemberAction;
	}
	
	public String toString() {
		return String.valueOf(getRole());
	}
	
}
