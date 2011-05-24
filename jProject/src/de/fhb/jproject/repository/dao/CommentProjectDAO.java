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

public interface CommentProjectDAO {
	public CommentProject[] listCommentProjectByQuery(String condition, String orderBy) throws PersistentException;
	public CommentProject[] listCommentProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentProject[] listCommentProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentProject[] listCommentProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentProject loadCommentProjectByQuery(String condition, String orderBy) throws PersistentException;
	public CommentProject loadCommentProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentProject loadCommentProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentProject loadCommentProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentProject createCommentProject();
	public boolean save(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentProject commentProject, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.CommentProject commentProject) throws PersistentException;
}
