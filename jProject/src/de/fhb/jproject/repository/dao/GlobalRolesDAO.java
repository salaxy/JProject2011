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

public interface GlobalRolesDAO {
	public GlobalRoles loadGlobalRolesByORMID(String role) throws PersistentException;
	public GlobalRoles getGlobalRolesByORMID(String role) throws PersistentException;
	public GlobalRoles loadGlobalRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles getGlobalRolesByORMID(String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles loadGlobalRolesByORMID(PersistentSession session, String role) throws PersistentException;
	public GlobalRoles getGlobalRolesByORMID(PersistentSession session, String role) throws PersistentException;
	public GlobalRoles loadGlobalRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles getGlobalRolesByORMID(PersistentSession session, String role, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles[] listGlobalRolesByQuery(String condition, String orderBy) throws PersistentException;
	public GlobalRoles[] listGlobalRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles[] listGlobalRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public GlobalRoles[] listGlobalRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles loadGlobalRolesByQuery(String condition, String orderBy) throws PersistentException;
	public GlobalRoles loadGlobalRolesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles loadGlobalRolesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public GlobalRoles loadGlobalRolesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public GlobalRoles createGlobalRoles();
	public boolean save(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.GlobalRoles globalRoles) throws PersistentException;
}
