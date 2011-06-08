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

public interface ICQDAO {
	public ICQ loadICQByORMID(String icqNumber) throws PersistentException;
	public ICQ getICQByORMID(String icqNumber) throws PersistentException;
	public ICQ loadICQByORMID(String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ getICQByORMID(String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ loadICQByORMID(PersistentSession session, String icqNumber) throws PersistentException;
	public ICQ getICQByORMID(PersistentSession session, String icqNumber) throws PersistentException;
	public ICQ loadICQByORMID(PersistentSession session, String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ getICQByORMID(PersistentSession session, String icqNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ[] listICQByQuery(String condition, String orderBy) throws PersistentException;
	public ICQ[] listICQByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ[] listICQByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public ICQ[] listICQByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ loadICQByQuery(String condition, String orderBy) throws PersistentException;
	public ICQ loadICQByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ loadICQByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public ICQ loadICQByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ICQ createICQ();
	public boolean save(de.fhb.jproject.data.ICQ iCQ) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.ICQ iCQ) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.ICQ iCQ) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.ICQ iCQ, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.ICQ iCQ) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.ICQ iCQ) throws PersistentException;
}
