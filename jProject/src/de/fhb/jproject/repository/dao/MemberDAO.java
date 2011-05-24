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

public interface MemberDAO {
	public Member loadMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException;
	public Member getMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException;
	public Member loadMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member getMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException;
	public Member getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException;
	public Member loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member[] listMemberByQuery(String condition, String orderBy) throws PersistentException;
	public Member[] listMemberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member[] listMemberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Member[] listMemberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member loadMemberByQuery(String condition, String orderBy) throws PersistentException;
	public Member loadMemberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member loadMemberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Member loadMemberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Member createMember();
	public boolean save(de.fhb.jproject.data.Member member) throws PersistentException;
	public boolean delete(de.fhb.jproject.data.Member member) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Member member) throws PersistentException;
	public boolean deleteAndDissociate(de.fhb.jproject.data.Member member, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(de.fhb.jproject.data.Member member) throws PersistentException;
	public boolean evict(de.fhb.jproject.data.Member member) throws PersistentException;
}
