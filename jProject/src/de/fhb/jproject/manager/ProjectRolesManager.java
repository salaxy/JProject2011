/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.ProjectRoles;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.ProjectRolesDA;
import de.fhb.jproject.repository.da.UserDA;

/**
 *
 * @author MacYser
 */
public class ProjectRolesManager {
	
	private MemberDA memberDA;
	private ProjectDA projectDA;
	private UserDA userDA;
	private ProjectRolesDA projectRolesDA;
	private static final Logger logger = Logger.getLogger(ProjectRolesManager.class);
	
	public ProjectRolesManager(){
		memberDA = DAFactory.getDAFactory().getMemberDA();
		projectDA = DAFactory.getDAFactory().getProjectDA();
		userDA = DAFactory.getDAFactory().getUserDA();
		projectRolesDA = DAFactory.getDAFactory().getProjectRolesDA();
	}
	
	public boolean isAllowedCommentDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedCommentDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getCommentDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedCommentSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedCommentSourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getCommentSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedCommentTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedCommentTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getCommentTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedCommentProjektAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedCommentProjektAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getCommentProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteCommentAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeleteCommentAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeleteCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41DocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllComments41DocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllComments41DocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41SourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllComments41SourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllComments41SourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41TaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllComments41TaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllComments41TaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllComments41ProjectAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllComments41ProjectAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllComments41ProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateCommentAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedUpdateCommentAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getUpdateCommentAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddNewDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedAddNewDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getAddNewDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeleteDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeleteDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDownloadDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDownloadDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDownloadDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateDocuAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedUpdateDocuAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getUpdateDocuAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddMemberAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedAddMemberAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getAddMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteMemberAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeleteMemberAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeleteMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllMemberAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllMemberAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddNewSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedAddNewSourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getAddNewSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeleteSourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeleteSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDownloadSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDownloadSourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDownloadSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowSourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllSourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateSourceAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedUpdatesourceAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getUpdateSourceAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAddNewTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedAddNewTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getAddNewTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeleteTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeleteTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllTasksAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedShowAllOwnTasksAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowAllOwnTasksAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowAllOwnTasksAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedUpdateTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedUpdateTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getUpdateTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeleteProjectAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeleteProjectAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeleteProjectAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedAssignTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedAssignTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getAssignTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	public boolean isAllowedDeAssignTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedDeAssignTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getDeAssignTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	public boolean isAllowedShowTaskAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowTaskAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowTaskAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	public boolean isAllowedShowMemberAction(String loginName, String projectName) throws ProjectException{
		logger.info("isAllowedShowMemberAction(String loginName, String projectName)");
		logger.debug("String loginName("+loginName+"), String projectName("+projectName+")");
		try {
			return projectRolesDA.loadProjectRolesByORMID(getMember(getUser(loginName), getProject(projectName)).getProjectRole()).getShowMemberAction();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann Projekte Rolle nich laden! "+ ex);
		}
	}
	
	
	private Member getMember(User aktUser, Project project)throws ProjectException{
		Member aktMember = null;
		try {
			aktMember=memberDA.getMemberByORMID(aktUser, project);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Member nicht finden! "+ e1.getMessage());
		}
		if (aktMember == null) {
			throw new ProjectException("Der User ist kein Member in diesem Project!");
		}
		return aktMember;
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
	private Project getProject(String projectName)throws ProjectException{
		Project aktProject = null;
		try {
			aktProject=projectDA.getProjectByORMID(projectName);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte Project nicht finden! "+ e1.getMessage());
		}
		return aktProject;
	}
	public boolean isMember(String aktUser, String projectName)throws ProjectException{
		logger.info("isMember(String aktUser, String projectName)");
		logger.debug("String aktUser("+aktUser+"), String projectName("+projectName+")");
		try {
			projectRolesDA.loadProjectRolesByORMID(getMember(getUser(aktUser), getProject(projectName)).getProjectRole());
		} catch (PersistentException ex) {
			throw new ProjectException("Konnte nicht überprüfen, ob Sie Member dieses Projektes sind! "+ex);
		}
		return true;
	}
	
	/**
	 * Holt alle Projektrollen als String-Liste
	 * @return
	 * @throws ProjectException
	 */
	public List<String> showAllProjectRoles()
	throws ProjectException{ 

		List<String> list=new ArrayList<String>(); 
		List<ProjectRoles> projectRolesList=null;
		
		logger.info("showAllProjectRoles()");
		
		try {
			projectRolesList=projectRolesDA.listAllProjectRoles();
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Rollen nicht finden! "+ e.getMessage());
		}
		
		for(ProjectRoles rolle : projectRolesList){
			list.add(rolle.getRole());
		}
	
		return list;
	}
}
