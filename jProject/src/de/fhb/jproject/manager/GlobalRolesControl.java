package de.fhb.jproject.manager;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.exceptions.ProjectException;
import org.apache.log4j.Logger;
import org.orm.PersistentException;

public class GlobalRolesControl {
	
	private static final Logger logger = Logger.getLogger(GlobalRolesControl.class);
	
	public boolean isAllowedAddNewProjectAction(String role) throws ProjectException{
		logger.info("isAllowedAddNewProjectAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getAddNewProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteProjectAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteProjectAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowProjectAction(String role) throws ProjectException{
		logger.info("isAllowedShowProjectAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedSearchProjectsAction(String role) throws ProjectException{
		logger.info("isAllowedSearchProjectsAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getSearchProjectsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllProjectsAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllProjectsAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllProjectsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllOwnProjectsAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllOwnProjectsAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllOwnProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteUserAction(String role) throws ProjectException{
		logger.info("isAllowedDeleteUserAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getDeleteUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowUsersettingsAction(String role) throws ProjectException{
		logger.info("isAllowedShowUsersettingsAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowUserSettingsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateUserSettingsAction(String role) throws ProjectException{
		logger.info("isAllowedUpdateUserSettingsAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getUpdateUserSettingsAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowUserInfoAction(String role) throws ProjectException{
		logger.info("isAllowedShowUserInfoAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowUserInfoAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedSearchUserAction(String role) throws ProjectException{
		logger.info("isAllowedSearchUserAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getSearchUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllUserAction(String role) throws ProjectException{
		logger.info("isAllowedShowAllUserAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getShowAllUserAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedLoginAction(String role) throws ProjectException{
		logger.info("isAllowedLoginAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getLoginAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedLogoutAction(String role) throws ProjectException{
		logger.info("isAllowedLogoutAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getLogoutAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedRegisterAction(String role) throws ProjectException{
		logger.info("isAllowedRegisterAction(String role)");
		logger.debug("String role("+role+")");
		try {
			return DAFactory.getDAFactory().getGlobalRolesDA().loadGlobalRolesByORMID(role).getRegisterAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Globale Rolle nich laden! "+ ex);
		}
	}

}
