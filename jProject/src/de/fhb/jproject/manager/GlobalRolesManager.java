package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.GlobalRolesDA;
import de.fhb.jproject.repository.da.UserDA;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

public class GlobalRolesManager {

	private UserDA userDA;
	private GlobalRolesDA globalRolesDA;
	private static final Logger logger = Logger.getLogger(GlobalRolesManager.class);
	
	public GlobalRolesManager(){
		userDA = DAFactory.getDAFactory().getUserDA();
		globalRolesDA = DAFactory.getDAFactory().getGlobalRolesDA();
	}

	public boolean isAllowedAddNewProjectAction(String loginName) throws ProjectException {
		logger.info("isAllowedAddNewProjectAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getAddNewProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteProjectAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteProjectAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowProjectAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowProjectAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedSearchProjectsAction(String loginName) throws ProjectException {
		logger.info("isAllowedSearchProjectsAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getSearchProjectsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllProjectsAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllProjectsAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllProjectsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllOwnProjectsAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllOwnProjectsAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllOwnProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	
	public boolean isAllowedDeleteUserAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteUserAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowUserSettingsAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowUsersettingsAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowUserSettingsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateUserSettingsAction(String loginName) throws ProjectException {
		logger.info("isAllowedUpdateUserSettingsAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getUpdateUserSettingsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowUserInfoAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowUserInfoAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowUserInfoAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedSearchUserAction(String loginName) throws ProjectException {
		logger.info("isAllowedSearchUserAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getSearchUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllUserAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllUserAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
/*
	public boolean isAllowedLoginAction(String loginName) throws ProjectException {
		logger.info("isAllowedLoginAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getLoginAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedLogoutAction(String loginName) throws ProjectException {
		logger.info("isAllowedLogoutAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getLogoutAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
*/
	public boolean isAllowedRegisterAction(String loginName) throws ProjectException {
		logger.info("isAllowedRegisterAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getRegisterAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	/*-------------------------------------------------------------------------------------------------*/

	public boolean isAllowedCommentDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedCommentDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getCommentDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedCommentSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedCommentSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getCommentSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedCommentTaskAction(String loginName) throws ProjectException {
		logger.info("isAllowedCommentTaskAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getCommentTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedCommentProjectAction(String loginName) throws ProjectException {
		logger.info("isAllowedCommentProjectAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getCommentProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteCommentAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteCommentAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41DocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllComments41DocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllComments41DocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41SourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllComments41SourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllComments41SourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41TaskAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllComments41TaskAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllComments41TaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllComments41ProjectAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllComments41ProjectAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllComments41ProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateCommentAction(String loginName) throws ProjectException {
		logger.info("isAllowedUpdateCommentAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getUpdateCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddNewDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedAddNewDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getAddNewDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDownloadDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedDownloadDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDownloadDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateDocuAction(String loginName) throws ProjectException {
		logger.info("isAllowedUpdateDocuAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getUpdateDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddMemberAction(String loginName) throws ProjectException {
		logger.info("isAllowedAddMemberAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getAddMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteMemberAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteMemberAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllMemberAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllMemberAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddNewSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedAddNewSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getAddNewSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDownloadSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedDownloadSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDownloadSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateSourceAction(String loginName) throws ProjectException {
		logger.info("isAllowedUpdateSourceAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getUpdateSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedAddNewTaskAction(String loginName) throws ProjectException {
		logger.info("isAllowedAddNewTaskAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getAddNewTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedDeleteTaskAction(String loginName) throws ProjectException {
		logger.info("isAllowedDeleteTaskAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getDeleteTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllTasksAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllTasksAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedShowAllOwnTasksAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowAllOwnTasksAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowAllOwnTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}

	public boolean isAllowedUpdateTaskAction(String loginName) throws ProjectException {
		logger.info("isAllowedUpdateTaskAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getUpdateTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	public boolean isAllowedShowTaskAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowTaskAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	public boolean isAllowedShowMemberAction(String loginName) throws ProjectException {
		logger.info("isAllowedShowMemberAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getShowMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	public boolean isAllowedOpenAdminconsoleAction(String loginName) throws ProjectException {
		logger.info("isAllowedOpenAdminconsoleAction(String loginName)");
		logger.debug("String loginName(" + loginName + ")");
		try {
			return globalRolesDA.loadGlobalRolesByORMID(getUser(loginName).getGlobalRole()).getOpenAdminconsoleAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! " + ex);
		}
	}
	private User getUser(String loginName)throws ProjectException{
		User aktUser = null;
		try {
			aktUser=userDA.getUserByORMID(loginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte User nicht finden! "+ e1.getMessage());
		}
		return aktUser;
	}
	private void clearSession() throws ProjectException{
		try {
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Session nicht clearen! "+ e.getMessage());
		}
		
	}
}
