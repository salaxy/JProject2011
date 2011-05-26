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
	public Member loadMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadMemberByORMID(session, user, project);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getMemberByORMID(session, user, project);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadMemberByORMID(session, user, project, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getMemberByORMID(session, user, project, lockMode);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUser(user);
			member.setProject(project);
			
			return (Member) session.load(de.fhb.jproject.data.Member.class, member);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUser(user);
			member.setProject(project);
			
			return (Member) session.get(de.fhb.jproject.data.Member.class, member);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUser(user);
			member.setProject(project);
			
			return (Member) session.load(de.fhb.jproject.data.Member.class, member, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Member getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			Member member = new de.fhb.jproject.data.Member();
			member.setUser(user);
			member.setProject(project);
			
			return (Member) session.get(de.fhb.jproject.data.Member.class, member, lockMode);
		}
		catch (Exception e) {
			_logger.error("getMemberByORMID(PersistentSession session, de.fhb.jproject.data.User user, de.fhb.jproject.data.Project project, org.hibernate.LockMode lockMode)", e);
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
			de.fhb.jproject.data.User user = member.getUser();
			if(member.getUser() != null) {
				member.getUser().member.remove(member);
			}
			member.setORM_User(user);
			
			de.fhb.jproject.data.Project project = member.getProject();
			if(member.getProject() != null) {
				member.getProject().member.remove(member);
			}
			member.setORM_Project(project);
			
			de.fhb.jproject.data.Task[] lTasks = member.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].memberUser.remove(member);
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
			de.fhb.jproject.data.User user = member.getUser();
			if(member.getUser() != null) {
				member.getUser().member.remove(member);
			}
			member.setORM_User(user);
			
			de.fhb.jproject.data.Project project = member.getProject();
			if(member.getProject() != null) {
				member.getProject().member.remove(member);
			}
			member.setORM_Project(project);
			
			de.fhb.jproject.data.Task[] lTasks = member.task.toArray();
			for(int i = 0; i < lTasks.length; i++) {
				lTasks[i].memberUser.remove(member);
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
