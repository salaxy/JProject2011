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

public class CommentDocumentDAOImpl implements de.fhb.jproject.repository.dao.CommentDocumentDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(CommentDocumentDAOImpl.class);
	public CommentDocument[] listCommentDocumentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentDocumentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listCommentDocumentByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument[] listCommentDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listCommentDocumentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listCommentDocumentByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument[] listCommentDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentDocument as CommentDocument");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (CommentDocument[]) list.toArray(new CommentDocument[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument[] listCommentDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentDocument as CommentDocument");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (CommentDocument[]) list.toArray(new CommentDocument[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listCommentDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument loadCommentDocumentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentDocumentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadCommentDocumentByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument loadCommentDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadCommentDocumentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadCommentDocumentByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument loadCommentDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CommentDocument[] commentDocuments = listCommentDocumentByQuery(session, condition, orderBy);
		if (commentDocuments != null && commentDocuments.length > 0)
			return commentDocuments[0];
		else
			return null;
	}
	
	public CommentDocument loadCommentDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CommentDocument[] commentDocuments = listCommentDocumentByQuery(session, condition, orderBy, lockMode);
		if (commentDocuments != null && commentDocuments.length > 0)
			return commentDocuments[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCommentDocumentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentDocumentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateCommentDocumentByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateCommentDocumentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateCommentDocumentByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentDocument as CommentDocument");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateCommentDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCommentDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.CommentDocument as CommentDocument");
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
			_logger.error("iterateCommentDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public CommentDocument createCommentDocument() {
		return new de.fhb.jproject.data.CommentDocument();
	}
	
	public boolean save(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(commentDocument);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.CommentDocument commentDocument)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(commentDocument);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.CommentDocument commentDocument)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentDocument commentDocument)throws PersistentException {
		try {
			if(commentDocument.getComment() != null) {
				commentDocument.getComment().setCommentDocument(null);
			}
			
			de.fhb.jproject.data.Document document = commentDocument.getDocument();
			if(commentDocument.getDocument() != null) {
				commentDocument.getDocument().commentDocument.remove(commentDocument);
			}
			commentDocument.setORM_Document(document);
			
			return delete(commentDocument);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentDocument commentDocument, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(commentDocument.getComment() != null) {
				commentDocument.getComment().setCommentDocument(null);
			}
			
			de.fhb.jproject.data.Document document = commentDocument.getDocument();
			if(commentDocument.getDocument() != null) {
				commentDocument.getDocument().commentDocument.remove(commentDocument);
			}
			commentDocument.setORM_Document(document);
			
			try {
				session.delete(commentDocument);
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
	
	public boolean refresh(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(commentDocument);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.CommentDocument commentDocument)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(commentDocument);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.CommentDocument commentDocument)", e);
			throw new PersistentException(e);
		}
	}
	
}
