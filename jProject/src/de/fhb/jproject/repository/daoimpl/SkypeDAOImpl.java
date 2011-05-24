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

public class SkypeDAOImpl implements de.fhb.jproject.repository.dao.SkypeDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(SkypeDAOImpl.class);
	public Skype loadSkypeByORMID(String skypeName) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSkypeByORMID(session, skypeName);
		}
		catch (Exception e) {
			_logger.error("loadSkypeByORMID(String skypeName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype getSkypeByORMID(String skypeName) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getSkypeByORMID(session, skypeName);
		}
		catch (Exception e) {
			_logger.error("getSkypeByORMID(String skypeName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype loadSkypeByORMID(String skypeName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSkypeByORMID(session, skypeName, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadSkypeByORMID(String skypeName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype getSkypeByORMID(String skypeName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getSkypeByORMID(session, skypeName, lockMode);
		}
		catch (Exception e) {
			_logger.error("getSkypeByORMID(String skypeName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype loadSkypeByORMID(PersistentSession session, String skypeName) throws PersistentException {
		try {
			return (Skype) session.load(de.fhb.jproject.data.Skype.class, skypeName);
		}
		catch (Exception e) {
			_logger.error("loadSkypeByORMID(PersistentSession session, String skypeName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype getSkypeByORMID(PersistentSession session, String skypeName) throws PersistentException {
		try {
			return (Skype) session.get(de.fhb.jproject.data.Skype.class, skypeName);
		}
		catch (Exception e) {
			_logger.error("getSkypeByORMID(PersistentSession session, String skypeName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype loadSkypeByORMID(PersistentSession session, String skypeName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Skype) session.load(de.fhb.jproject.data.Skype.class, skypeName, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadSkypeByORMID(PersistentSession session, String skypeName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype getSkypeByORMID(PersistentSession session, String skypeName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Skype) session.get(de.fhb.jproject.data.Skype.class, skypeName, lockMode);
		}
		catch (Exception e) {
			_logger.error("getSkypeByORMID(PersistentSession session, String skypeName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype[] listSkypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listSkypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listSkypeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype[] listSkypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listSkypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listSkypeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype[] listSkypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Skype as Skype");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Skype[]) list.toArray(new Skype[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listSkypeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype[] listSkypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Skype as Skype");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Skype[]) list.toArray(new Skype[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listSkypeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype loadSkypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSkypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadSkypeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype loadSkypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSkypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadSkypeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype loadSkypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Skype[] skypes = listSkypeByQuery(session, condition, orderBy);
		if (skypes != null && skypes.length > 0)
			return skypes[0];
		else
			return null;
	}
	
	public Skype loadSkypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Skype[] skypes = listSkypeByQuery(session, condition, orderBy, lockMode);
		if (skypes != null && skypes.length > 0)
			return skypes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSkypeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateSkypeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateSkypeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSkypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateSkypeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateSkypeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSkypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Skype as Skype");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateSkypeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSkypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Skype as Skype");
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
			_logger.error("iterateSkypeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Skype createSkype() {
		return new de.fhb.jproject.data.Skype();
	}
	
	public boolean save(de.fhb.jproject.data.Skype skype) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(skype);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Skype skype)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.Skype skype) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(skype);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Skype skype)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Skype skype)throws PersistentException {
		try {
			if(skype.getUserLoginName() != null) {
				skype.getUserLoginName().skype.remove(skype);
			}
			
			return delete(skype);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Skype skype, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(skype.getUserLoginName() != null) {
				skype.getUserLoginName().skype.remove(skype);
			}
			
			try {
				session.delete(skype);
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
	
	public boolean refresh(de.fhb.jproject.data.Skype skype) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(skype);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Skype skype)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.Skype skype) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(skype);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Skype skype)", e);
			throw new PersistentException(e);
		}
	}
	
}
