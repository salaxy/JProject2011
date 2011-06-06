/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.exceptions.ProjectException;
import org.apache.log4j.Logger;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public class ProjectRolesControl {
	
	
	private static final Logger logger = Logger.getLogger(ProjectRolesControl.class);
	
	public boolean isAllowedCommentDocuAction(String role) throws ProjectException{
		logger.info("isAllowedCommentDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getCommentDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedCommentSourceAction(String role) throws ProjectException{
		logger.info("isAllowedCommentSourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getCommentSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedCommentTaskAction(String role) throws ProjectException{
		logger.info("isAllowedCommentTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getCommentTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedCommentProjektAction(String role) throws ProjectException{
		logger.info("isAllowedCommentProjektAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getCommentProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteCommentAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteCommentAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeleteCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41DocuAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllComments41DocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllComments41DocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41SourceAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllComments41SourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllComments41SourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41TaskAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllComments41TaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllComments41TaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments42ProjektAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllComments42ProjektAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllComments41ProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateCommentAction(String role) throws ProjectException{
		logger.info("isAllowedUpdateCommentAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getUpdateCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddNewDocuAction(String role) throws ProjectException{
		logger.info("isAllowedAddNewDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getAddNewDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteDocuAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeleteDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDownloadDocuAction(String role) throws ProjectException{
		logger.info("isAllowedDownloadDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDownloadDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowDocuAction(String role) throws ProjectException{
		logger.info("isAllowedShowDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllDocuAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateDocuAction(String role) throws ProjectException{
		logger.info("isAllowedUpdateDocuAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getUpdateDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddMemberAction(String role) throws ProjectException{
		logger.info("isAllowedAddMemberAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getAddMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteMemberAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteMemberAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeleteMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllMemberAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllMemberAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddNewSourceAction(String role) throws ProjectException{
		logger.info("isAllowedAddNewSourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getAddNewSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteSourceAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteSourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeleteSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDownloadSourceAction(String role) throws ProjectException{
		logger.info("isAllowedDownloadSourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDownloadSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowSourceAction(String role) throws ProjectException{
		logger.info("isAllowedShowSourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllSourceAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllSourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdatesourceAction(String role) throws ProjectException{
		logger.info("isAllowedUpdatesourceAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getUpdateSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddNewTaskAction(String role) throws ProjectException{
		logger.info("isAllowedAddNewTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getAddNewTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteTaskAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeleteTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllTaskAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllOwnTasksAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllOwnTasksAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getShowAllOwnTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateTaskAction(String role) throws ProjectException{
		logger.info("isAllowedUpdateTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getUpdateTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteProjectAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteProjectAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeleteProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAssignTaskAction(String role) throws ProjectException{
		logger.info("isAllowedAssignTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getAssignTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeAssignTaskAction(String role) throws ProjectException{
		logger.info("isAllowedDeAssignTaskAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getProjectRolesDA().loadProjectRolesByORMID(role).getDeAssignTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
}
