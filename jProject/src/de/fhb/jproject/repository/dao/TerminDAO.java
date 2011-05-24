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

public interface TerminDAO {
	public Termin loadTerminByORMID(int id) throws PersistentException;
	public Termin getTerminByORMID(int id) throws PersistentException;
	public Termin loadTerminByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin getTerminByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin loadTerminByORMID(PersistentSession session, int id) throws PersistentException;
	public Termin getTerminByORMID(PersistentSession session, int id) throws PersistentException;
	public Termin loadTerminByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin getTerminByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin[] listTerminByQuery(String condition, String orderBy) throws PersistentException;
	public Termin[] listTerminByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin[] listTerminByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Termin[] listTerminByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin loadTerminByQuery(String condition, String orderBy) throws PersistentException;
	public Termin loadTerminByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin loadTerminByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Termin loadTerminByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Termin createTermin();
	public boolean save(de.fhb.jproject.data.Termin termin) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Termin termin) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Termin termin) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Termin termin, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Termin termin) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Termin termin) throws PersistentException;
}
