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

public interface SkypeDAO {
	public Skype loadSkypeByORMID(String skypeName) throws PersistentException;
	public Skype getSkypeByORMID(String skypeName) throws PersistentException;
	public Skype loadSkypeByORMID(String skypeName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype getSkypeByORMID(String skypeName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype loadSkypeByORMID(PersistentSession session, String skypeName) throws PersistentException;
	public Skype getSkypeByORMID(PersistentSession session, String skypeName) throws PersistentException;
	public Skype loadSkypeByORMID(PersistentSession session, String skypeName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype getSkypeByORMID(PersistentSession session, String skypeName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype[] listSkypeByQuery(String condition, String orderBy) throws PersistentException;
	public Skype[] listSkypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype[] listSkypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Skype[] listSkypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype loadSkypeByQuery(String condition, String orderBy) throws PersistentException;
	public Skype loadSkypeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype loadSkypeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Skype loadSkypeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Skype createSkype();
	public boolean save(de.fhb.jproject.data.Skype skype) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Skype skype) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Skype skype) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Skype skype, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Skype skype) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Skype skype) throws PersistentException;
}
