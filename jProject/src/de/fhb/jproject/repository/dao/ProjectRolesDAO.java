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

public interface ProjectRolesDAO {
	public ProjectRoles loadProjectRolesByORMID(String role) throws PersistentException;
	public ProjectRoles getProjectRolesByORMID(String role) throws PersistentException;
	public ProjectRoles loadProjectRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles getProjectRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles loadProjectRolesByORMID(PersistentSession session, String role) throws PersistentException;
	public ProjectRoles getProjectRolesByORMID(PersistentSession session, String role) throws PersistentException;
	public ProjectRoles loadProjectRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles getProjectRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles[] listProjectRolesByQuery(String condition, String orderBy) throws PersistentException;
	public ProjectRoles[] listProjectRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles[] listProjectRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public ProjectRoles[] listProjectRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles loadProjectRolesByQuery(String condition, String orderBy) throws PersistentException;
	public ProjectRoles loadProjectRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles loadProjectRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public ProjectRoles loadProjectRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ProjectRoles createProjectRoles();
	public boolean save(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.ProjectRoles projectRoles) throws PersistentException;
}
