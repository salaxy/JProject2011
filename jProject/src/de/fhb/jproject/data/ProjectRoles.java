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
	/**
	 * 
	 */
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
	
	/**
	 * 
	 * @param value
	 */
	public void setRole(String value) {
		this.role = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getORMID() {
		return getRole();
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setCommentDocuAction(boolean value) {
		this.commentDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getCommentDocuAction() {
		return commentDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setCommentSourceAction(boolean value) {
		this.commentSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getCommentSourceAction() {
		return commentSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setCommentTaskAction(boolean value) {
		this.commentTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getCommentTaskAction() {
		return commentTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setCommentProjectAction(boolean value) {
		this.commentProjectAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getCommentProjectAction() {
		return commentProjectAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeleteCommentAction(boolean value) {
		this.deleteCommentAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeleteCommentAction() {
		return deleteCommentAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllComments41DocuAction(boolean value) {
		this.showAllComments41DocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllComments41DocuAction() {
		return showAllComments41DocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllComments41SourceAction(boolean value) {
		this.showAllComments41SourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllComments41SourceAction() {
		return showAllComments41SourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllComments41TaskAction(boolean value) {
		this.showAllComments41TaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllComments41TaskAction() {
		return showAllComments41TaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllComments41ProjectAction(boolean value) {
		this.showAllComments41ProjectAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllComments41ProjectAction() {
		return showAllComments41ProjectAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setUpdateCommentAction(boolean value) {
		this.updateCommentAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getUpdateCommentAction() {
		return updateCommentAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setAddNewDocuAction(boolean value) {
		this.addNewDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getAddNewDocuAction() {
		return addNewDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeleteDocuAction(boolean value) {
		this.deleteDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeleteDocuAction() {
		return deleteDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDownloadDocuAction(boolean value) {
		this.downloadDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDownloadDocuAction() {
		return downloadDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowDocuAction(boolean value) {
		this.showDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowDocuAction() {
		return showDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllDocuAction(boolean value) {
		this.showAllDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllDocuAction() {
		return showAllDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setUpdateDocuAction(boolean value) {
		this.updateDocuAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getUpdateDocuAction() {
		return updateDocuAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setAddMemberAction(boolean value) {
		this.addMemberAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getAddMemberAction() {
		return addMemberAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeleteMemberAction(boolean value) {
		this.deleteMemberAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeleteMemberAction() {
		return deleteMemberAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllMemberAction(boolean value) {
		this.showAllMemberAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllMemberAction() {
		return showAllMemberAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setAddNewSourceAction(boolean value) {
		this.addNewSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getAddNewSourceAction() {
		return addNewSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeleteSourceAction(boolean value) {
		this.deleteSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeleteSourceAction() {
		return deleteSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDownloadSourceAction(boolean value) {
		this.downloadSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDownloadSourceAction() {
		return downloadSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowSourceAction(boolean value) {
		this.showSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowSourceAction() {
		return showSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllSourceAction(boolean value) {
		this.showAllSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllSourceAction() {
		return showAllSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setUpdateSourceAction(boolean value) {
		this.updateSourceAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getUpdateSourceAction() {
		return updateSourceAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setAddNewTaskAction(boolean value) {
		this.addNewTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getAddNewTaskAction() {
		return addNewTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeleteTaskAction(boolean value) {
		this.deleteTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeleteTaskAction() {
		return deleteTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllTasksAction(boolean value) {
		this.showAllTasksAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllTasksAction() {
		return showAllTasksAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowAllOwnTasksAction(boolean value) {
		this.showAllOwnTasksAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowAllOwnTasksAction() {
		return showAllOwnTasksAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setUpdateTaskAction(boolean value) {
		this.updateTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getUpdateTaskAction() {
		return updateTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeleteProjectAction(boolean value) {
		this.deleteProjectAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeleteProjectAction() {
		return deleteProjectAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setDeAssignTaskAction(boolean value) {
		this.deAssignTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDeAssignTaskAction() {
		return deAssignTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setAssignTaskAction(boolean value) {
		this.assignTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getAssignTaskAction() {
		return assignTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowTaskAction(boolean value) {
		this.showTaskAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowTaskAction() {
		return showTaskAction;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setShowMemberAction(boolean value) {
		this.showMemberAction = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getShowMemberAction() {
		return showMemberAction;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(getRole());
	}
	
}
