/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */


package de.fhb.jproject.repository.daoimpl;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;
import de.fhb.jproject.data.*;

/**
 * 
 * @author MacYser
 */
public class ProjectDAOImpl implements de.fhb.jproject.repository.dao.ProjectDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ProjectDAOImpl.class);
	/**
	 * 
	 * @param name
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectByORMID(session, name);
		}
		catch (Exception e) {
			_logger.error("loadProjectByORMID(String name)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws PersistentException
	 */
	public Project getProjectByORMID(String name) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getProjectByORMID(session, name);
		}
		catch (Exception e) {
			_logger.error("getProjectByORMID(String name)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProjectByORMID(String name, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project getProjectByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getProjectByORMID(session, name, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProjectByORMID(String name, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param name
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Project) session.load(de.fhb.jproject.data.Project.class, name);
		}
		catch (Exception e) {
			_logger.error("loadProjectByORMID(PersistentSession session, String name)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param name
	 * @return
	 * @throws PersistentException
	 */
	public Project getProjectByORMID(PersistentSession session, String name) throws PersistentException {
		try {
			return (Project) session.get(de.fhb.jproject.data.Project.class, name);
		}
		catch (Exception e) {
			_logger.error("getProjectByORMID(PersistentSession session, String name)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param name
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Project) session.load(de.fhb.jproject.data.Project.class, name, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProjectByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param name
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project getProjectByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Project) session.get(de.fhb.jproject.data.Project.class, name, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProjectByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public Project[] listProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listProjectByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project[] listProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listProjectByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public Project[] listProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Project as Project");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Project[]) list.toArray(new Project[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project[] listProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Project as Project");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Project[]) list.toArray(new Project[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadProjectByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProjectByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Project[] projects = listProjectByQuery(session, condition, orderBy);
		if (projects != null && projects.length > 0)
			return projects[0];
		else
			return null;
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Project loadProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Project[] projects = listProjectByQuery(session, condition, orderBy, lockMode);
		if (projects != null && projects.length > 0)
			return projects[0];
		else
			return null;
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateProjectByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateProjectByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Project as Project");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Project as Project");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Project createProject() {
		return new de.fhb.jproject.data.Project();
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(project);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(project);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Project project)throws PersistentException {
		try {
			de.fhb.jproject.data.Member[] lMembers = project.member.toArray();
			for(int i = 0; i < lMembers.length; i++) {
				lMembers[i].setProject(null);
			}
			de.fhb.jproject.data.Sourcecode[] lSourcecodes = project.sourcecode.toArray();
			for(int i = 0; i < lSourcecodes.length; i++) {
				lSourcecodes[i].setProject(null);
			}
			de.fhb.jproject.data.Document[] lDocuments = project.document.toArray();
			for(int i = 0; i < lDocuments.length; i++) {
				lDocuments[i].setProject(null);
			}
			de.fhb.jproject.data.Task[] lTasks = project.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].setProject(null);
			}
			de.fhb.jproject.data.CommentProject[] lCommentProjects = project.commentProject.toArray();
			for(int i = 0; i < lCommentProjects.length; i++) {
				lCommentProjects[i].setProject(null);
			}
			return delete(project);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param project
	 * @param session
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Project project, org.orm.PersistentSession session)throws PersistentException {
		try {
			de.fhb.jproject.data.Member[] lMembers = project.member.toArray();
			for(int i = 0; i < lMembers.length; i++) {
				lMembers[i].setProject(null);
			}
			de.fhb.jproject.data.Sourcecode[] lSourcecodes = project.sourcecode.toArray();
			for(int i = 0; i < lSourcecodes.length; i++) {
				lSourcecodes[i].setProject(null);
			}
			de.fhb.jproject.data.Document[] lDocuments = project.document.toArray();
			for(int i = 0; i < lDocuments.length; i++) {
				lDocuments[i].setProject(null);
			}
			de.fhb.jproject.data.Task[] lTasks = project.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].setProject(null);
			}
			de.fhb.jproject.data.CommentProject[] lCommentProjects = project.commentProject.toArray();
			for(int i = 0; i < lCommentProjects.length; i++) {
				lCommentProjects[i].setProject(null);
			}
			try {
				session.delete(project);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(project);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param project
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(project);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
}
