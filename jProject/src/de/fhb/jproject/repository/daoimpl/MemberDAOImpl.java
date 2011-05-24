/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */


package de.fhb.jproject.repository.daoimpl;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;
import de.fhb.jproject.data.*;

public class MemberDAOImpl implements de.fhb.jproject.repository.dao.MemberDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(MemberDAOImpl.class);
	public Member loadMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadMemberByORMID(session, userLoginName, projectName);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getMemberByORMID(session, userLoginName, projectName);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadMemberByORMID(session, userLoginName, projectName, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getMemberByORMID(session, userLoginName, projectName, lockMode);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUserLoginName(userLoginName);
			member.setProjectName(projectName);
			
			return (Member) session.load(de.fhb.jproject.data.Member.class, member);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUserLoginName(userLoginName);
			member.setProjectName(projectName);
			
			return (Member) session.get(de.fhb.jproject.data.Member.class, member);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUserLoginName(userLoginName);
			member.setProjectName(projectName);
			
			return (Member) session.load(de.fhb.jproject.data.Member.class, member, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUserLoginName(userLoginName);
			member.setProjectName(projectName);
			
			return (Member) session.get(de.fhb.jproject.data.Member.class, member, lockMode);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User userLoginName, de.fhb.jproject.data.Project projectName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member[] listMemberByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listMemberByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listMemberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member[] listMemberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listMemberByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listMemberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member[] listMemberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Member as Member");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Member[]) list.toArray(new Member[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listMemberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member[] listMemberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Member as Member");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Member[]) list.toArray(new Member[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listMemberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadMemberByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadMemberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadMemberByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadMemberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Member[] members = listMemberByQuery(session, condition, orderBy);
		if (members != null && members.length > 0)
			return members[0];
		else
			return null;
	}
	
	public Member loadMemberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Member[] members = listMemberByQuery(session, condition, orderBy, lockMode);
		if (members != null && members.length > 0)
			return members[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMemberByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateMemberByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateMemberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMemberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateMemberByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateMemberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMemberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Member as Member");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateMemberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateMemberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Member as Member");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateMemberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member createMember() {
		return new de.fhb.jproject.data.Member();
	}
	
	public boolean save(de.fhb.jproject.data.Member member) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(member);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Member member)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.Member member) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(member);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Member member)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Member member)throws PersistentException {
		try {
			de.fhb.jproject.data.User userLoginName = member.getUserLoginName();
			if(member.getUserLoginName() != null) {
				member.getUserLoginName().member.remove(member);
			}
			member.setORM_UserLoginName(userLoginName);
			
			de.fhb.jproject.data.Project projectName = member.getProjectName();
			if(member.getProjectName() != null) {
				member.getProjectName().member.remove(member);
			}
			member.setORM_ProjectName(projectName);
			
			de.fhb.jproject.data.Task[] lTasks = member.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].memberUserLoginName.remove(member);
			}
			return delete(member);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Member member, org.orm.PersistentSession session)throws PersistentException {
		try {
			de.fhb.jproject.data.User userLoginName = member.getUserLoginName();
			if(member.getUserLoginName() != null) {
				member.getUserLoginName().member.remove(member);
			}
			member.setORM_UserLoginName(userLoginName);
			
			de.fhb.jproject.data.Project projectName = member.getProjectName();
			if(member.getProjectName() != null) {
				member.getProjectName().member.remove(member);
			}
			member.setORM_ProjectName(projectName);
			
			de.fhb.jproject.data.Task[] lTasks = member.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].memberUserLoginName.remove(member);
			}
			try {
				session.delete(member);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(de.fhb.jproject.data.Member member) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(member);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Member member)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.Member member) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(member);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Member member)", e);
			throw new PersistentException(e);
		}
	}
	
}
