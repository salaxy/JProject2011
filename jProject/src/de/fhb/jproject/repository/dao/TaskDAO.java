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

public interface TaskDAO {
	public Task loadTaskByORMID(int id) throws PersistentException;
	public Task getTaskByORMID(int id) throws PersistentException;
	public Task loadTaskByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task getTaskByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task loadTaskByORMID(PersistentSession session, int id) throws PersistentException;
	public Task getTaskByORMID(PersistentSession session, int id) throws PersistentException;
	public Task loadTaskByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task getTaskByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task[] listTaskByQuery(String condition, String orderBy) throws PersistentException;
	public Task[] listTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task[] listTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Task[] listTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task loadTaskByQuery(String condition, String orderBy) throws PersistentException;
	public Task loadTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task loadTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Task loadTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Task createTask();
	public boolean save(de.fhb.jproject.data.Task task) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Task task) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Task task) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Task task, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Task task) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Task task) throws PersistentException;
}
