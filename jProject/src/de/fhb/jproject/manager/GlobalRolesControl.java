package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.exceptions.ProjectException;
import org.apache.log4j.Logger;
import org.orm.PersistentException;

public class GlobalRolesControl {

	private static final Logger logger = Logger.getLogger(GlobalRolesControl.class);

	public boolean isAllowedAddNewProjectAction(String role) throws ProjectException {
		logger.info("isAllowedAddNewProjectAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getAddNewProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteProjectAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteProjectAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowProjectAction(String role) throws ProjectException {
		logger.info("isAllowedShowProjectAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedSearchProjectsAction(String role) throws ProjectException {
		logger.info("isAllowedSearchProjectsAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getSearchProjectsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllProjectsAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllProjectsAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllProjectsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllOwnProjectsAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllOwnProjectsAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllOwnProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteUserAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteUserAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowUsersettingsAction(String role) throws ProjectException {
		logger.info("isAllowedShowUsersettingsAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowUserSettingsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateUserSettingsAction(String role) throws ProjectException {
		logger.info("isAllowedUpdateUserSettingsAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getUpdateUserSettingsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowUserInfoAction(String role) throws ProjectException {
		logger.info("isAllowedShowUserInfoAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowUserInfoAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedSearchUserAction(String role) throws ProjectException {
		logger.info("isAllowedSearchUserAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getSearchUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllUserAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllUserAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedLoginAction(String role) throws ProjectException {
		logger.info("isAllowedLoginAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getLoginAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedLogoutAction(String role) throws ProjectException {
		logger.info("isAllowedLogoutAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getLogoutAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedRegisterAction(String role) throws ProjectException {
		logger.info("isAllowedRegisterAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getRegisterAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	/*-------------------------------------------------------------------------------------------------*/

	public boolean isAllowedCommentDocuAction(String role) throws ProjectException {
		logger.info("isAllowedCommentDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getCommentDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedCommentSourceAction(String role) throws ProjectException {
		logger.info("isAllowedCommentSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getCommentSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedCommentTaskAction(String role) throws ProjectException {
		logger.info("isAllowedCommentTaskAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getCommentTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedCommentProjectAction(String role) throws ProjectException {
		logger.info("isAllowedCommentProjectAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getCommentProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteCommentAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteCommentAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41DocuAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllComments41DocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllComments41DocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41SourceAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllComments41SourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllComments41SourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41TaskAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllComments41TaskAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllComments41TaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41ProjectAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllComments41ProjectAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllComments41ProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateCommentAction(String role) throws ProjectException {
		logger.info("isAllowedUpdateCommentAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getUpdateCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddNewDocuAction(String role) throws ProjectException {
		logger.info("isAllowedAddNewDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getAddNewDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteDocuAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDownloadDocuAction(String role) throws ProjectException {
		logger.info("isAllowedDownloadDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDownloadDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowDocuAction(String role) throws ProjectException {
		logger.info("isAllowedShowDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllDocuAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateDocuAction(String role) throws ProjectException {
		logger.info("isAllowedUpdateDocuAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getUpdateDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddMemberAction(String role) throws ProjectException {
		logger.info("isAllowedAddMemberAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getAddMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteMemberAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteMemberAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllMemberAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllMemberAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddNewSourceAction(String role) throws ProjectException {
		logger.info("isAllowedAddNewSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getAddNewSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteSourceAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDownloadSourceAction(String role) throws ProjectException {
		logger.info("isAllowedDownloadSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDownloadSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowSourceAction(String role) throws ProjectException {
		logger.info("isAllowedShowSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllSourceAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateSourceAction(String role) throws ProjectException {
		logger.info("isAllowedUpdateSourceAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getUpdateSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddNewTaskAction(String role) throws ProjectException {
		logger.info("isAllowedAddNewTaskAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getAddNewTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteTaskAction(String role) throws ProjectException {
		logger.info("isAllowedDeleteTaskAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllTasksAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllTasksAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllOwnTasksAction(String role) throws ProjectException {
		logger.info("isAllowedShowAllOwnTasksAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllOwnTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateTaskAction(String role) throws ProjectException {
		logger.info("isAllowedUpdateTaskAction(String role)");
		logger.debug("String role(" + role + ")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getUpdateTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
}
