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
public class CommentDAOImpl implements de.fhb.jproject.repository.dao.CommentDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(CommentDAOImpl.class);
	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Comment loadCommentByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("loadCommentByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Comment getCommentByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getCommentByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("getCommentByORMID(int id)", e);
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
	public Comment loadCommentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentByORMID(int id, org.hibernate.LockMode lockMode)", e);
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
	public Comment getCommentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getCommentByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getCommentByORMID(int id, org.hibernate.LockMode lockMode)", e);
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
	public Comment loadCommentByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Comment) session.load(de.fhb.jproject.data.Comment.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("loadCommentByORMID(PersistentSession session, int id)", e);
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
	public Comment getCommentByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Comment) session.get(de.fhb.jproject.data.Comment.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("getCommentByORMID(PersistentSession session, int id)", e);
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
	public Comment loadCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Comment) session.load(de.fhb.jproject.data.Comment.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
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
	public Comment getCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Comment) session.get(de.fhb.jproject.data.Comment.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
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
	public Comment[] listCommentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listCommentByQuery(String condition, String orderBy)", e);
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
	public Comment[] listCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listCommentByQuery(String condition, String orderBy)", e);
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
	public Comment[] listCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Comment[]) list.toArray(new Comment[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public Comment[] listCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Comment[]) list.toArray(new Comment[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public Comment loadCommentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadCommentByQuery(String condition, String orderBy)", e);
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
	public Comment loadCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentByQuery(String condition, String orderBy)", e);
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
	public Comment loadCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Comment[] comments = listCommentByQuery(session, condition, orderBy);
		if (comments != null && comments.length > 0)
			return comments[0];
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
	public Comment loadCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Comment[] comments = listCommentByQuery(session, condition, orderBy, lockMode);
		if (comments != null && comments.length > 0)
			return comments[0];
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
	public static java.util.Iterator iterateCommentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateCommentByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateCommentByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Comment as Comment");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateCommentByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Comment as Comment");
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
			_logger.error("iterateCommentByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Comment createComment() {
		return new de.fhb.jproject.data.Comment();
	}
	
	/**
	 * 
	 * @param comment
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.Comment comment) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(comment);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Comment comment)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param comment
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.Comment comment) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(comment);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Comment comment)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param comment
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Comment comment)throws PersistentException {
		try {
			if(comment.getUser() != null) {
				comment.getUser().comment.remove(comment);
			}
			
			if(comment.getCommentProject() != null) {
				comment.getCommentProject().setComment(null);
			}
			
			if(comment.getCommentSourcecode() != null) {
				comment.getCommentSourcecode().setComment(null);
			}
			
			if(comment.getCommentDocument() != null) {
				comment.getCommentDocument().setComment(null);
			}
			
			if(comment.getCommentTask() != null) {
				comment.getCommentTask().setComment(null);
			}
			
			return delete(comment);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param comment
	 * @param session
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Comment comment, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(comment.getUser() != null) {
				comment.getUser().comment.remove(comment);
			}
			
			if(comment.getCommentProject() != null) {
				comment.getCommentProject().setComment(null);
			}
			
			if(comment.getCommentSourcecode() != null) {
				comment.getCommentSourcecode().setComment(null);
			}
			
			if(comment.getCommentDocument() != null) {
				comment.getCommentDocument().setComment(null);
			}
			
			if(comment.getCommentTask() != null) {
				comment.getCommentTask().setComment(null);
			}
			
			try {
				session.delete(comment);
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
	 * @param comment
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.Comment comment) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(comment);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Comment comment)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param comment
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.Comment comment) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(comment);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Comment comment)", e);
			throw new PersistentException(e);
		}
	}
	
}
