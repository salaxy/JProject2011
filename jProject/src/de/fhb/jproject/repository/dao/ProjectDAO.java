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

public interface ProjectDAO {
	public Project loadProjectByORMID(String name) throws PersistentException;
	public Project getProjectByORMID(String name) throws PersistentException;
	public Project loadProjectByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project getProjectByORMID(String name, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project loadProjectByORMID(PersistentSession session, String name) throws PersistentException;
	public Project getProjectByORMID(PersistentSession session, String name) throws PersistentException;
	public Project loadProjectByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project getProjectByORMID(PersistentSession session, String name, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project[] listProjectByQuery(String condition, String orderBy) throws PersistentException;
	public Project[] listProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project[] listProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Project[] listProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project loadProjectByQuery(String condition, String orderBy) throws PersistentException;
	public Project loadProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project loadProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Project loadProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Project createProject();
	public boolean save(de.fhb.jproject.data.Project project) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Project project) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Project project) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Project project, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Project project) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Project project) throws PersistentException;
}
