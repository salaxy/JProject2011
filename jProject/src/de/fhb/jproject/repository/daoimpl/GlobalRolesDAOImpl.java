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

public class GlobalRolesDAOImpl implements de.fhb.jproject.repository.dao.GlobalRolesDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(GlobalRolesDAOImpl.class);
	public GlobalRoles loadGlobalRolesByORMID(String role) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadGlobalRolesByORMID(session, role);
		}
		catch (Exception e) {
			_logger.error("loadGlobalRolesByORMID(String role)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles getGlobalRolesByORMID(String role) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getGlobalRolesByORMID(session, role);
		}
		catch (Exception e) {
			_logger.error("getGlobalRolesByORMID(String role)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles loadGlobalRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadGlobalRolesByORMID(session, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGlobalRolesByORMID(String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles getGlobalRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getGlobalRolesByORMID(session, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGlobalRolesByORMID(String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles loadGlobalRolesByORMID(PersistentSession session, String role) throws PersistentException {
		try {
			return (GlobalRoles) session.load(de.fhb.jproject.data.GlobalRoles.class, role);
		}
		catch (Exception e) {
			_logger.error("loadGlobalRolesByORMID(PersistentSession session, String role)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles getGlobalRolesByORMID(PersistentSession session, String role) throws PersistentException {
		try {
			return (GlobalRoles) session.get(de.fhb.jproject.data.GlobalRoles.class, role);
		}
		catch (Exception e) {
			_logger.error("getGlobalRolesByORMID(PersistentSession session, String role)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles loadGlobalRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (GlobalRoles) session.load(de.fhb.jproject.data.GlobalRoles.class, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGlobalRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles getGlobalRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (GlobalRoles) session.get(de.fhb.jproject.data.GlobalRoles.class, role, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGlobalRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles[] listGlobalRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listGlobalRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGlobalRolesByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles[] listGlobalRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listGlobalRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGlobalRolesByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles[] listGlobalRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.GlobalRoles as GlobalRoles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (GlobalRoles[]) list.toArray(new GlobalRoles[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGlobalRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles[] listGlobalRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.GlobalRoles as GlobalRoles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (GlobalRoles[]) list.toArray(new GlobalRoles[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGlobalRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles loadGlobalRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadGlobalRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGlobalRolesByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles loadGlobalRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadGlobalRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGlobalRolesByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles loadGlobalRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		GlobalRoles[] globalRoleses = listGlobalRolesByQuery(session, condition, orderBy);
		if (globalRoleses != null && globalRoleses.length > 0)
			return globalRoleses[0];
		else
			return null;
	}
	
	public GlobalRoles loadGlobalRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		GlobalRoles[] globalRoleses = listGlobalRolesByQuery(session, condition, orderBy, lockMode);
		if (globalRoleses != null && globalRoleses.length > 0)
			return globalRoleses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateGlobalRolesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateGlobalRolesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGlobalRolesByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGlobalRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateGlobalRolesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGlobalRolesByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGlobalRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.GlobalRoles as GlobalRoles");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGlobalRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateGlobalRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.GlobalRoles as GlobalRoles");
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
			_logger.error("iterateGlobalRolesByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public GlobalRoles createGlobalRoles() {
		return new de.fhb.jproject.data.GlobalRoles();
	}
	
	public boolean save(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(globalRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.GlobalRoles globalRoles)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(globalRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.GlobalRoles globalRoles)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(globalRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.GlobalRoles globalRoles)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(globalRoles);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.GlobalRoles globalRoles)", e);
			throw new PersistentException(e);
		}
	}
	
}
