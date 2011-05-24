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

public interface TelefonDAO {
	public Telefon loadTelefonByORMID(int telNumber) throws PersistentException;
	public Telefon getTelefonByORMID(int telNumber) throws PersistentException;
	public Telefon loadTelefonByORMID(int telNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon getTelefonByORMID(int telNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon loadTelefonByORMID(PersistentSession session, int telNumber) throws PersistentException;
	public Telefon getTelefonByORMID(PersistentSession session, int telNumber) throws PersistentException;
	public Telefon loadTelefonByORMID(PersistentSession session, int telNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon getTelefonByORMID(PersistentSession session, int telNumber, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon[] listTelefonByQuery(String condition, String orderBy) throws PersistentException;
	public Telefon[] listTelefonByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon[] listTelefonByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Telefon[] listTelefonByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon loadTelefonByQuery(String condition, String orderBy) throws PersistentException;
	public Telefon loadTelefonByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon loadTelefonByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Telefon loadTelefonByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Telefon createTelefon();
	public boolean save(de.fhb.jproject.data.Telefon telefon) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Telefon telefon) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Telefon telefon) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Telefon telefon, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Telefon telefon) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Telefon telefon) throws PersistentException;
}
