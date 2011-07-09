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
public class ProjectRolesDAOImpl implements de.fhb.jproject.repository.dao.ProjectRolesDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ProjectRolesDAOImpl.class);
	/**
	 * 
	 * @param role
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles loadProjectRolesByORMID(String role) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectRolesByORMID(session, role);
		}
		catch (Exception e) {
			_logger.error("loadProjectRolesByORMID(String role)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param role
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles getProjectRolesByORMID(String role) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getProjectRolesByORMID(session, role);
		}
		catch (Exception e) {
			_logger.error("getProjectRolesByORMID(String role)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param role
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles loadProjectRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectRolesByORMID(session, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProjectRolesByORMID(String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param role
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles getProjectRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getProjectRolesByORMID(session, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProjectRolesByORMID(String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param role
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles loadProjectRolesByORMID(PersistentSession session, String role) throws PersistentException {
		try {
			return (ProjectRoles) session.load(de.fhb.jproject.data.ProjectRoles.class, role);
		}
		catch (Exception e) {
			_logger.error("loadProjectRolesByORMID(PersistentSession session, String role)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param role
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles getProjectRolesByORMID(PersistentSession session, String role) throws PersistentException {
		try {
			return (ProjectRoles) session.get(de.fhb.jproject.data.ProjectRoles.class, role);
		}
		catch (Exception e) {
			_logger.error("getProjectRolesByORMID(PersistentSession session, String role)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param role
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles loadProjectRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ProjectRoles) session.load(de.fhb.jproject.data.ProjectRoles.class, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProjectRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param role
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public ProjectRoles getProjectRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ProjectRoles) session.get(de.fhb.jproject.data.ProjectRoles.class, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("getProjectRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode)", e);
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
	public ProjectRoles[] listProjectRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listProjectRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listProjectRolesByQuery(String condition, String orderBy)", e);
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
	public ProjectRoles[] listProjectRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listProjectRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listProjectRolesByQuery(String condition, String orderBy)", e);
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
	public ProjectRoles[] listProjectRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ProjectRoles as ProjectRoles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (ProjectRoles[]) list.toArray(new ProjectRoles[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProjectRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public ProjectRoles[] listProjectRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ProjectRoles as ProjectRoles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (ProjectRoles[]) list.toArray(new ProjectRoles[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listProjectRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public ProjectRoles loadProjectRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadProjectRolesByQuery(String condition, String orderBy)", e);
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
	public ProjectRoles loadProjectRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadProjectRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadProjectRolesByQuery(String condition, String orderBy)", e);
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
	public ProjectRoles loadProjectRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ProjectRoles[] projectRoleses = listProjectRolesByQuery(session, condition, orderBy);
		if (projectRoleses != null && projectRoleses.length > 0)
			return projectRoleses[0];
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
	public ProjectRoles loadProjectRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ProjectRoles[] projectRoleses = listProjectRolesByQuery(session, condition, orderBy, lockMode);
		if (projectRoleses != null && projectRoleses.length > 0)
			return projectRoleses[0];
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
	public static java.util.Iterator iterateProjectRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateProjectRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateProjectRolesByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateProjectRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateProjectRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateProjectRolesByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateProjectRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ProjectRoles as ProjectRoles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateProjectRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateProjectRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ProjectRoles as ProjectRoles");
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
			_logger.error("iterateProjectRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ProjectRoles createProjectRoles() {
		return new de.fhb.jproject.data.ProjectRoles();
	}
	
	/**
	 * 
	 * @param projectRoles
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(projectRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.ProjectRoles projectRoles)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param projectRoles
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(projectRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.ProjectRoles projectRoles)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param projectRoles
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(projectRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.ProjectRoles projectRoles)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param projectRoles
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(projectRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.ProjectRoles projectRoles)", e);
			throw new PersistentException(e);
		}
	}
	
}
