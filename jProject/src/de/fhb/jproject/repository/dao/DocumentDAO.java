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

public interface DocumentDAO {
	public Document loadDocumentByORMID(int id) throws PersistentException;
	public Document getDocumentByORMID(int id) throws PersistentException;
	public Document loadDocumentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document getDocumentByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document loadDocumentByORMID(PersistentSession session, int id) throws PersistentException;
	public Document getDocumentByORMID(PersistentSession session, int id) throws PersistentException;
	public Document loadDocumentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document getDocumentByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document[] listDocumentByQuery(String condition, String orderBy) throws PersistentException;
	public Document[] listDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document[] listDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Document[] listDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document loadDocumentByQuery(String condition, String orderBy) throws PersistentException;
	public Document loadDocumentByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document loadDocumentByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Document loadDocumentByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Document createDocument();
	public boolean save(de.fhb.jproject.data.Document document) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Document document) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Document document) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Document document, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Document document) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Document document) throws PersistentException;
}
