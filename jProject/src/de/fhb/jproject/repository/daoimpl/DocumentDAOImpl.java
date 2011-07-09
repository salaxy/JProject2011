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
public class DocumentDAOImpl implements de.fhb.jproject.repository.dao.DocumentDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(DocumentDAOImpl.class);
	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Document loadDocumentByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadDocumentByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("loadDocumentByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws PersistentException
	 */
	public Document getDocumentByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getDocumentByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("getDocumentByORMID(int id)", e);
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
	public Document loadDocumentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadDocumentByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadDocumentByORMID(int id, org.hibernate.LockMode lockMode)", e);
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
	public Document getDocumentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getDocumentByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getDocumentByORMID(int id, org.hibernate.LockMode lockMode)", e);
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
	public Document loadDocumentByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Document) session.load(de.fhb.jproject.data.Document.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("loadDocumentByORMID(PersistentSession session, int id)", e);
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
	public Document getDocumentByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Document) session.get(de.fhb.jproject.data.Document.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("getDocumentByORMID(PersistentSession session, int id)", e);
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
	public Document loadDocumentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Document) session.load(de.fhb.jproject.data.Document.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadDocumentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
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
	public Document getDocumentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Document) session.get(de.fhb.jproject.data.Document.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getDocumentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
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
	public Document[] listDocumentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listDocumentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listDocumentByQuery(String condition, String orderBy)", e);
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
	public Document[] listDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listDocumentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listDocumentByQuery(String condition, String orderBy)", e);
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
	public Document[] listDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Document as Document");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Document[]) list.toArray(new Document[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public Document[] listDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Document as Document");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Document[]) list.toArray(new Document[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public Document loadDocumentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadDocumentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadDocumentByQuery(String condition, String orderBy)", e);
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
	public Document loadDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadDocumentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadDocumentByQuery(String condition, String orderBy)", e);
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
	public Document loadDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Document[] documents = listDocumentByQuery(session, condition, orderBy);
		if (documents != null && documents.length > 0)
			return documents[0];
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
	public Document loadDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Document[] documents = listDocumentByQuery(session, condition, orderBy, lockMode);
		if (documents != null && documents.length > 0)
			return documents[0];
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
	public static java.util.Iterator iterateDocumentByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateDocumentByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateDocumentByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateDocumentByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateDocumentByQuery(String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Document as Document");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
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
	public static java.util.Iterator iterateDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Document as Document");
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
			_logger.error("iterateDocumentByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Document createDocument() {
		return new de.fhb.jproject.data.Document();
	}
	
	/**
	 * 
	 * @param document
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.Document document) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(document);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Document document)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param document
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.Document document) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(document);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Document document)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param document
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Document document)throws PersistentException {
		try {
			if(document.getProject() != null) {
				document.getProject().document.remove(document);
			}
			
			de.fhb.jproject.data.CommentDocument[] lCommentDocuments = document.commentDocument.toArray();
			for(int i = 0; i < lCommentDocuments.length; i++) {
				lCommentDocuments[i].setDocument(null);
			}
			return delete(document);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param document
	 * @param session
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.Document document, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(document.getProject() != null) {
				document.getProject().document.remove(document);
			}
			
			de.fhb.jproject.data.CommentDocument[] lCommentDocuments = document.commentDocument.toArray();
			for(int i = 0; i < lCommentDocuments.length; i++) {
				lCommentDocuments[i].setDocument(null);
			}
			try {
				session.delete(document);
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
	 * @param document
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.Document document) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(document);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Document document)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param document
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.Document document) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(document);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Document document)", e);
			throw new PersistentException(e);
		}
	}
	
}
