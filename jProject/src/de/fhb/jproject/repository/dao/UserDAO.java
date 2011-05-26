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

public interface UserDAO {
	public User loadUserByORMID(String loginName) throws PersistentException;
	public User getUserByORMID(String loginName) throws PersistentException;
	public User loadUserByORMID(String loginName, org.hibernate.LockMode lockMode) throws PersistentException;
	public User getUserByORMID(String loginName, org.hibernate.LockMode lockMode) throws PersistentException;
	public User loadUserByORMID(PersistentSession session, String loginName) throws PersistentException;
	public User getUserByORMID(PersistentSession session, String loginName) throws PersistentException;
	public User loadUserByORMID(PersistentSession session, String loginName, org.hibernate.LockMode lockMode) throws PersistentException;
	public User getUserByORMID(PersistentSession session, String loginName, org.hibernate.LockMode lockMode) throws PersistentException;
	public User[] listUserByQuery(String condition, String orderBy) throws PersistentException;
	public User[] listUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public User[] listUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public User[] listUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public User loadUserByQuery(String condition, String orderBy) throws PersistentException;
	public User loadUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public User loadUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public User loadUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public User createUser();
	public boolean save(de.fhb.jproject.data.User user) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.User user) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.User user) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.User user, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.User user) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.User user) throws PersistentException;
}
