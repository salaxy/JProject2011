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
public class CommentProjectDAOImpl implements de.fhb.jproject.repository.dao.CommentProjectDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(CommentProjectDAOImpl.class);
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public CommentProject[] listCommentProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listCommentProjectByQuery(String condition, String orderBy)", e);
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
	public CommentProject[] listCommentProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listCommentProjectByQuery(String condition, String orderBy)", e);
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
	public CommentProject[] listCommentProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentProject as CommentProject");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (CommentProject[]) list.toArray(new CommentProject[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public CommentProject[] listCommentProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentProject as CommentProject");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (CommentProject[]) list.toArray(new CommentProject[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public CommentProject loadCommentProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadCommentProjectByQuery(String condition, String orderBy)", e);
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
	public CommentProject loadCommentProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentProjectByQuery(String condition, String orderBy)", e);
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
	public CommentProject loadCommentProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CommentProject[] commentProjects = listCommentProjectByQuery(session, condition, orderBy);
		if (commentProjects != null && commentProjects.length > 0)
			return commentProjects[0];
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
	public CommentProject loadCommentProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CommentProject[] commentProjects = listCommentProjectByQuery(session, condition, orderBy, lockMode);
		if (commentProjects != null && commentProjects.length > 0)
			return commentProjects[0];
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
	public static java.util.Iterator iterateCommentProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateCommentProjectByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateCommentProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateCommentProjectByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateCommentProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentProject as CommentProject");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateCommentProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateCommentProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentProject as CommentProject");
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
			_logger.error("iterateCommentProjectByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public CommentProject createCommentProject() {
		return new de.fhb.jproject.data.CommentProject();
	}
	
	/**
	 * 
	 * @param commentProject
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(commentProject);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.CommentProject commentProject)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param commentProject
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(commentProject);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.CommentProject commentProject)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param commentProject
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentProject commentProject)throws PersistentException {
		try {
			de.fhb.jproject.data.Comment comment = commentProject.getComment();
			if(commentProject.getComment() != null) {
				commentProject.getComment().setCommentProject(null);
			}
			commentProject.setComment(comment);
			
			if(commentProject.getProject() != null) {
				commentProject.getProject().commentProject.remove(commentProject);
			}
			
			return delete(commentProject);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param commentProject
	 * @param session
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentProject commentProject, org.orm.PersistentSession session)throws PersistentException {
		try {
			de.fhb.jproject.data.Comment comment = commentProject.getComment();
			if(commentProject.getComment() != null) {
				commentProject.getComment().setCommentProject(null);
			}
			commentProject.setComment(comment);
			
			if(commentProject.getProject() != null) {
				commentProject.getProject().commentProject.remove(commentProject);
			}
			
			try {
				session.delete(commentProject);
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
	 * @param commentProject
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(commentProject);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.CommentProject commentProject)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param commentProject
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(commentProject);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.CommentProject commentProject)", e);
			throw new PersistentException(e);
		}
	}
	
}
