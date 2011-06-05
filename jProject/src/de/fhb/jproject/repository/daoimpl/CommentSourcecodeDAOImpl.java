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

public class CommentSourcecodeDAOImpl implements de.fhb.jproject.repository.dao.CommentSourcecodeDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(CommentSourcecodeDAOImpl.class);
	public CommentSourcecode[] listCommentSourcecodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentSourcecodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listCommentSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode[] listCommentSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentSourcecodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listCommentSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode[] listCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentSourcecode as CommentSourcecode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (CommentSourcecode[]) list.toArray(new CommentSourcecode[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode[] listCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentSourcecode as CommentSourcecode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (CommentSourcecode[]) list.toArray(new CommentSourcecode[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode loadCommentSourcecodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentSourcecodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadCommentSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode loadCommentSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentSourcecodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode loadCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CommentSourcecode[] commentSourcecodes = listCommentSourcecodeByQuery(session, condition, orderBy);
		if (commentSourcecodes != null && commentSourcecodes.length > 0)
			return commentSourcecodes[0];
		else
			return null;
	}
	
	public CommentSourcecode loadCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CommentSourcecode[] commentSourcecodes = listCommentSourcecodeByQuery(session, condition, orderBy, lockMode);
		if (commentSourcecodes != null && commentSourcecodes.length > 0)
			return commentSourcecodes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCommentSourcecodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentSourcecodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateCommentSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentSourcecodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateCommentSourcecodeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentSourcecode as CommentSourcecode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentSourcecode as CommentSourcecode");
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
			_logger.error("iterateCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentSourcecode createCommentSourcecode() {
		return new de.fhb.jproject.data.CommentSourcecode();
	}
	
	public boolean save(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(commentSourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.CommentSourcecode commentSourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(commentSourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.CommentSourcecode commentSourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentSourcecode commentSourcecode)throws PersistentException {
		try {
			if(commentSourcecode.getSourcecode() != null) {
				commentSourcecode.getSourcecode().commentSourcecode.remove(commentSourcecode);
			}
			
			de.fhb.jproject.data.Comment comment = commentSourcecode.getComment();
			if(commentSourcecode.getComment() != null) {
				commentSourcecode.getComment().setCommentSourcecode(null);
			}
			commentSourcecode.setComment(comment);
			
			return delete(commentSourcecode);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentSourcecode commentSourcecode, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(commentSourcecode.getSourcecode() != null) {
				commentSourcecode.getSourcecode().commentSourcecode.remove(commentSourcecode);
			}
			
			de.fhb.jproject.data.Comment comment = commentSourcecode.getComment();
			if(commentSourcecode.getComment() != null) {
				commentSourcecode.getComment().setCommentSourcecode(null);
			}
			commentSourcecode.setComment(comment);
			
			try {
				session.delete(commentSourcecode);
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
	
	public boolean refresh(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(commentSourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.CommentSourcecode commentSourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(commentSourcecode);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.CommentSourcecode commentSourcecode)", e);
			throw new PersistentException(e);
		}
	}
	
}
