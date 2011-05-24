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

public interface CommentDAO {
	public Comment loadCommentByORMID(int id) throws PersistentException;
	public Comment getCommentByORMID(int id) throws PersistentException;
	public Comment loadCommentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment getCommentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment loadCommentByORMID(PersistentSession session, int id) throws PersistentException;
	public Comment getCommentByORMID(PersistentSession session, int id) throws PersistentException;
	public Comment loadCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment getCommentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment[] listCommentByQuery(String condition, String orderBy) throws PersistentException;
	public Comment[] listCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment[] listCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Comment[] listCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment loadCommentByQuery(String condition, String orderBy) throws PersistentException;
	public Comment loadCommentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment loadCommentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Comment loadCommentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Comment createComment();
	public boolean save(de.fhb.jproject.data.Comment comment) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Comment comment) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Comment comment) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Comment comment, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Comment comment) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Comment comment) throws PersistentException;
}
