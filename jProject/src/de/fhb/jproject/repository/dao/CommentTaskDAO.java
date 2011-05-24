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

public interface CommentTaskDAO {
	public CommentTask[] listCommentTaskByQuery(String condition, String orderBy) throws PersistentException;
	public CommentTask[] listCommentTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentTask[] listCommentTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentTask[] listCommentTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentTask loadCommentTaskByQuery(String condition, String orderBy) throws PersistentException;
	public CommentTask loadCommentTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentTask loadCommentTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentTask loadCommentTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentTask createCommentTask();
	public boolean save(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentTask commentTask, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.CommentTask commentTask) throws PersistentException;
}
