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

public interface CommentSourcecodeDAO {
	public CommentSourcecode[] listCommentSourcecodeByQuery(String condition, String orderBy) throws PersistentException;
	public CommentSourcecode[] listCommentSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentSourcecode[] listCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentSourcecode[] listCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentSourcecode loadCommentSourcecodeByQuery(String condition, String orderBy) throws PersistentException;
	public CommentSourcecode loadCommentSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentSourcecode loadCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CommentSourcecode loadCommentSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CommentSourcecode createCommentSourcecode();
	public boolean save(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.CommentSourcecode commentSourcecode, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.CommentSourcecode commentSourcecode) throws PersistentException;
}
