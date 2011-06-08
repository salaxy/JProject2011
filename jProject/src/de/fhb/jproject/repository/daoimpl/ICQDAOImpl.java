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

public class ICQDAOImpl implements de.fhb.jproject.repository.dao.ICQDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ICQDAOImpl.class);
	public ICQ loadICQByORMID(String icqNumber) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadICQByORMID(session, icqNumber);
		}
		catch (Exception e) {
			_logger.error("loadICQByORMID(String icqNumber)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ getICQByORMID(String icqNumber) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getICQByORMID(session, icqNumber);
		}
		catch (Exception e) {
			_logger.error("getICQByORMID(String icqNumber)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ loadICQByORMID(String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadICQByORMID(session, icqNumber, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadICQByORMID(String icqNumber, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ getICQByORMID(String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getICQByORMID(session, icqNumber, lockMode);
		}
		catch (Exception e) {
			_logger.error("getICQByORMID(String icqNumber, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ loadICQByORMID(PersistentSession session, String icqNumber) throws PersistentException {
		try {
			return (ICQ) session.load(de.fhb.jproject.data.ICQ.class, icqNumber);
		}
		catch (Exception e) {
			_logger.error("loadICQByORMID(PersistentSession session, String icqNumber)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ getICQByORMID(PersistentSession session, String icqNumber) throws PersistentException {
		try {
			return (ICQ) session.get(de.fhb.jproject.data.ICQ.class, icqNumber);
		}
		catch (Exception e) {
			_logger.error("getICQByORMID(PersistentSession session, String icqNumber)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ loadICQByORMID(PersistentSession session, String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ICQ) session.load(de.fhb.jproject.data.ICQ.class, icqNumber, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadICQByORMID(PersistentSession session, String icqNumber, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ getICQByORMID(PersistentSession session, String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ICQ) session.get(de.fhb.jproject.data.ICQ.class, icqNumber, lockMode);
		}
		catch (Exception e) {
			_logger.error("getICQByORMID(PersistentSession session, String icqNumber, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ[] listICQByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listICQByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listICQByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ[] listICQByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listICQByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listICQByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ[] listICQByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ICQ as ICQ");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (ICQ[]) list.toArray(new ICQ[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listICQByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ[] listICQByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ICQ as ICQ");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (ICQ[]) list.toArray(new ICQ[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listICQByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ loadICQByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadICQByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadICQByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ loadICQByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadICQByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadICQByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ loadICQByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ICQ[] iCQs = listICQByQuery(session, condition, orderBy);
		if (iCQs != null && iCQs.length > 0)
			return iCQs[0];
		else
			return null;
	}
	
	public ICQ loadICQByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ICQ[] iCQs = listICQByQuery(session, condition, orderBy, lockMode);
		if (iCQs != null && iCQs.length > 0)
			return iCQs[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateICQByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateICQByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateICQByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateICQByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateICQByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateICQByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateICQByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ICQ as ICQ");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateICQByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateICQByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.ICQ as ICQ");
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
			_logger.error("iterateICQByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public ICQ createICQ() {
		return new de.fhb.jproject.data.ICQ();
	}
	
	public boolean save(de.fhb.jproject.data.ICQ iCQ) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(iCQ);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.ICQ iCQ)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.ICQ iCQ) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(iCQ);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.ICQ iCQ)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.ICQ iCQ)throws PersistentException {
		try {
			if(iCQ.getUserLoginName() != null) {
				iCQ.getUserLoginName().iCQ.remove(iCQ);
			}
			
			return delete(iCQ);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.ICQ iCQ, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(iCQ.getUserLoginName() != null) {
				iCQ.getUserLoginName().iCQ.remove(iCQ);
			}
			
			try {
				session.delete(iCQ);
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
	
	public boolean refresh(de.fhb.jproject.data.ICQ iCQ) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(iCQ);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.ICQ iCQ)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.ICQ iCQ) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(iCQ);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.ICQ iCQ)", e);
			throw new PersistentException(e);
		}
	}
	
}
