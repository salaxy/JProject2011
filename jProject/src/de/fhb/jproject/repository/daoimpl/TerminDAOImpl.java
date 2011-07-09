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
public class TerminDAOImpl implements de.fhb.jproject.repository.dao.TerminDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(TerminDAOImpl.class);
	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Termin loadTerminByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTerminByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("loadTerminByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Termin getTerminByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getTerminByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("getTerminByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Termin loadTerminByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTerminByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTerminByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Termin getTerminByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getTerminByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getTerminByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Termin loadTerminByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Termin) session.load(de.fhb.jproject.data.Termin.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("loadTerminByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Termin getTerminByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Termin) session.get(de.fhb.jproject.data.Termin.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("getTerminByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Termin loadTerminByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Termin) session.load(de.fhb.jproject.data.Termin.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTerminByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param id
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public Termin getTerminByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Termin) session.get(de.fhb.jproject.data.Termin.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getTerminByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
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
	public Termin[] listTerminByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listTerminByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listTerminByQuery(String condition, String orderBy)", e);
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
	public Termin[] listTerminByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listTerminByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listTerminByQuery(String condition, String orderBy)", e);
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
	public Termin[] listTerminByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Termin as Termin");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Termin[]) list.toArray(new Termin[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listTerminByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public Termin[] listTerminByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Termin as Termin");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Termin[]) list.toArray(new Termin[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listTerminByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public Termin loadTerminByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTerminByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadTerminByQuery(String condition, String orderBy)", e);
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
	public Termin loadTerminByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTerminByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTerminByQuery(String condition, String orderBy)", e);
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
	public Termin loadTerminByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Termin[] termins = listTerminByQuery(session, condition, orderBy);
		if (termins != null && termins.length > 0)
			return termins[0];
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
	public Termin loadTerminByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Termin[] termins = listTerminByQuery(session, condition, orderBy, lockMode);
		if (termins != null && termins.length > 0)
			return termins[0];
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
	public static java.util.Iterator iterateTerminByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateTerminByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateTerminByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateTerminByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateTerminByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateTerminByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateTerminByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Termin as Termin");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateTerminByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateTerminByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Termin as Termin");
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
			_logger.error("iterateTerminByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Termin createTermin() {
		return new de.fhb.jproject.data.Termin();
	}
	
	/**
	 * 
	 * @param termin
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.Termin termin) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(termin);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Termin termin)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param termin
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.Termin termin) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(termin);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Termin termin)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param termin
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Termin termin)throws PersistentException {
		try {
			de.fhb.jproject.data.Task[] lTasks = termin.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].setTermin(null);
			}
			return delete(termin);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param termin
	 * @param session
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Termin termin, org.orm.PersistentSession session)throws PersistentException {
		try {
			de.fhb.jproject.data.Task[] lTasks = termin.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].setTermin(null);
			}
			try {
				session.delete(termin);
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
	 * @param termin
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.Termin termin) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(termin);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Termin termin)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param termin
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.Termin termin) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(termin);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Termin termin)", e);
			throw new PersistentException(e);
		}
	}
	
}
