/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */


package de.fhb.jproject.repository.dao;

import org.orm.*;
import de.fhb.jproject.data.*;

public interface CommentDocumentDAO {
	public CommentDocument[] listCommentDocumentByQuery(String condition, String orderBy) throws PersistentException;
	public CommentDocument[] listCommentDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentDocument[] listCommentDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentDocument[] listCommentDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentDocument loadCommentDocumentByQuery(String condition, String orderBy) throws PersistentException;
	public CommentDocument loadCommentDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentDocument loadCommentDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentDocument loadCommentDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentDocument createCommentDocument();
	public boolean save(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentDocument commentDocument, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.CommentDocument commentDocument) throws PersistentException;
}
