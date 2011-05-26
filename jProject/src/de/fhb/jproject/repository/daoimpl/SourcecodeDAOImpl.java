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

public class SourcecodeDAOImpl implements de.fhb.jproject.repository.dao.SourcecodeDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(SourcecodeDAOImpl.class);
	public Sourcecode loadSourcecodeByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSourcecodeByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("loadSourcecodeByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode getSourcecodeByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getSourcecodeByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("getSourcecodeByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode loadSourcecodeByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSourcecodeByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadSourcecodeByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode getSourcecodeByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getSourcecodeByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getSourcecodeByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode loadSourcecodeByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Sourcecode) session.load(de.fhb.jproject.data.Sourcecode.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("loadSourcecodeByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode getSourcecodeByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Sourcecode) session.get(de.fhb.jproject.data.Sourcecode.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("getSourcecodeByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode loadSourcecodeByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sourcecode) session.load(de.fhb.jproject.data.Sourcecode.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadSourcecodeByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode getSourcecodeByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Sourcecode) session.get(de.fhb.jproject.data.Sourcecode.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getSourcecodeByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode[] listSourcecodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listSourcecodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode[] listSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listSourcecodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode[] listSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Sourcecode as Sourcecode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Sourcecode[]) list.toArray(new Sourcecode[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode[] listSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Sourcecode as Sourcecode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Sourcecode[]) list.toArray(new Sourcecode[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode loadSourcecodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSourcecodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode loadSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadSourcecodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode loadSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Sourcecode[] sourcecodes = listSourcecodeByQuery(session, condition, orderBy);
		if (sourcecodes != null && sourcecodes.length > 0)
			return sourcecodes[0];
		else
			return null;
	}
	
	public Sourcecode loadSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Sourcecode[] sourcecodes = listSourcecodeByQuery(session, condition, orderBy, lockMode);
		if (sourcecodes != null && sourcecodes.length > 0)
			return sourcecodes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateSourcecodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateSourcecodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateSourcecodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Sourcecode as Sourcecode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Sourcecode as Sourcecode");
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
			_logger.error("iterateSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Sourcecode createSourcecode() {
		return new de.fhb.jproject.data.Sourcecode();
	}
	
	public boolean save(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(sourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Sourcecode sourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(sourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Sourcecode sourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Sourcecode sourcecode)throws PersistentException {
		try {
			if(sourcecode.getProject() != null) {
				sourcecode.getProject().sourcecode.remove(sourcecode);
			}
			
			de.fhb.jproject.data.CommentSourcecode[] lCommentSourcecodes = sourcecode.commentSourcecode.toArray();
			for(int i = 0; i < lCommentSourcecodes.length; i++) {
				lCommentSourcecodes[i].setSourcecode(null);
			}
			return delete(sourcecode);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Sourcecode sourcecode, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(sourcecode.getProject() != null) {
				sourcecode.getProject().sourcecode.remove(sourcecode);
			}
			
			de.fhb.jproject.data.CommentSourcecode[] lCommentSourcecodes = sourcecode.commentSourcecode.toArray();
			for(int i = 0; i < lCommentSourcecodes.length; i++) {
				lCommentSourcecodes[i].setSourcecode(null);
			}
			try {
				session.delete(sourcecode);
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
	
	public boolean refresh(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(sourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Sourcecode sourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(sourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Sourcecode sourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
}
