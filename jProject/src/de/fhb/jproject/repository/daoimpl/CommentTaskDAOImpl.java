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

public class CommentTaskDAOImpl implements de.fhb.jproject.repository.dao.CommentTaskDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(CommentTaskDAOImpl.class);
	public CommentTask[] listCommentTaskByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentTaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listCommentTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask[] listCommentTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentTaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listCommentTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask[] listCommentTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentTask as CommentTask");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (CommentTask[]) list.toArray(new CommentTask[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask[] listCommentTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentTask as CommentTask");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (CommentTask[]) list.toArray(new CommentTask[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask loadCommentTaskByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentTaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadCommentTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask loadCommentTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentTaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask loadCommentTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CommentTask[] commentTasks = listCommentTaskByQuery(session, condition, orderBy);
		if (commentTasks != null && commentTasks.length > 0)
			return commentTasks[0];
		else
			return null;
	}
	
	public CommentTask loadCommentTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CommentTask[] commentTasks = listCommentTaskByQuery(session, condition, orderBy, lockMode);
		if (commentTasks != null && commentTasks.length > 0)
			return commentTasks[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCommentTaskByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentTaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateCommentTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentTaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateCommentTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentTask as CommentTask");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateCommentTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentTask as CommentTask");
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
			_logger.error("iterateCommentTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentTask createCommentTask() {
		return new de.fhb.jproject.data.CommentTask();
	}
	
	public boolean save(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(commentTask);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.CommentTask commentTask)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(commentTask);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.CommentTask commentTask)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentTask commentTask)throws PersistentException {
		try {
			if(commentTask.getComment() != null) {
				commentTask.getComment().setCommentTask(null);
			}
			
			de.fhb.jproject.data.Task task = commentTask.getTask();
			if(commentTask.getTask() != null) {
				commentTask.getTask().commentTask.remove(commentTask);
			}
			commentTask.setORM_Task(task);
			
			return delete(commentTask);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentTask commentTask, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(commentTask.getComment() != null) {
				commentTask.getComment().setCommentTask(null);
			}
			
			de.fhb.jproject.data.Task task = commentTask.getTask();
			if(commentTask.getTask() != null) {
				commentTask.getTask().commentTask.remove(commentTask);
			}
			commentTask.setORM_Task(task);
			
			try {
				session.delete(commentTask);
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
	
	public boolean refresh(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(commentTask);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.CommentTask commentTask)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(commentTask);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.CommentTask commentTask)", e);
			throw new PersistentException(e);
		}
	}
	
}
