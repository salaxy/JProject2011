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

public interface SourcecodeDAO {
	public Sourcecode loadSourcecodeByORMID(int id) throws PersistentException;
	public Sourcecode getSourcecodeByORMID(int id) throws PersistentException;
	public Sourcecode loadSourcecodeByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode getSourcecodeByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode loadSourcecodeByORMID(PersistentSession session, int id) throws PersistentException;
	public Sourcecode getSourcecodeByORMID(PersistentSession session, int id) throws PersistentException;
	public Sourcecode loadSourcecodeByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode getSourcecodeByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode[] listSourcecodeByQuery(String condition, String orderBy) throws PersistentException;
	public Sourcecode[] listSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode[] listSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Sourcecode[] listSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode loadSourcecodeByQuery(String condition, String orderBy) throws PersistentException;
	public Sourcecode loadSourcecodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode loadSourcecodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Sourcecode loadSourcecodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Sourcecode createSourcecode();
	public boolean save(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Sourcecode sourcecode, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Sourcecode sourcecode) throws PersistentException;
}
