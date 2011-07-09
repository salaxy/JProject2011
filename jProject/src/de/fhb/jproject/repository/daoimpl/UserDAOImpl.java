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

/**
 * 
 * @author MacYser
 */
public class UserDAOImpl implements de.fhb.jproject.repository.dao.UserDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(UserDAOImpl.class);
	/**
	 * 
	 * @param loginName
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByORMID(String loginName) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadUserByORMID(session, loginName);
		}
		catch (Exception e) {
			_logger.error("loadUserByORMID(String loginName)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param loginName
	 * @return
	 * @throws PersistentException
	 */
	public User getUserByORMID(String loginName) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getUserByORMID(session, loginName);
		}
		catch (Exception e) {
			_logger.error("getUserByORMID(String loginName)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param loginName
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByORMID(String loginName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadUserByORMID(session, loginName, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadUserByORMID(String loginName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param loginName
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User getUserByORMID(String loginName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getUserByORMID(session, loginName, lockMode);
		}
		catch (Exception e) {
			_logger.error("getUserByORMID(String loginName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param loginName
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByORMID(PersistentSession session, String loginName) throws PersistentException {
		try {
			return (User) session.load(de.fhb.jproject.data.User.class, loginName);
		}
		catch (Exception e) {
			_logger.error("loadUserByORMID(PersistentSession session, String loginName)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param loginName
	 * @return
	 * @throws PersistentException
	 */
	public User getUserByORMID(PersistentSession session, String loginName) throws PersistentException {
		try {
			return (User) session.get(de.fhb.jproject.data.User.class, loginName);
		}
		catch (Exception e) {
			_logger.error("getUserByORMID(PersistentSession session, String loginName)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param loginName
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByORMID(PersistentSession session, String loginName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User) session.load(de.fhb.jproject.data.User.class, loginName, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadUserByORMID(PersistentSession session, String loginName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param loginName
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User getUserByORMID(PersistentSession session, String loginName, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (User) session.get(de.fhb.jproject.data.User.class, loginName, lockMode);
		}
		catch (Exception e) {
			_logger.error("getUserByORMID(PersistentSession session, String loginName, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public User[] listUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listUserByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User[] listUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listUserByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public User[] listUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (User[]) list.toArray(new User[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listUserByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User[] listUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (User[]) list.toArray(new User[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listUserByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadUserByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadUserByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		User[] users = listUserByQuery(session, condition, orderBy);
		if (users != null && users.length > 0)
			return users[0];
		else
			return null;
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public User loadUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		User[] users = listUserByQuery(session, condition, orderBy, lockMode);
		if (users != null && users.length > 0)
			return users[0];
		else
			return null;
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateUserByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateUserByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateUserByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateUserByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateUserByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateUserByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateUserByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.User as User");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateUserByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 * @param lockMode
	 * @return
	 * @throws PersistentException
	 */
	public static java.util.Iterator iterateUserByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.User as User");
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
			_logger.error("iterateUserByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public User createUser() {
		return new de.fhb.jproject.data.User();
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws PersistentException
	 */
	public boolean save(de.fhb.jproject.data.User user) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(user);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.User user)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws PersistentException
	 */
	public boolean delete(de.fhb.jproject.data.User user) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(user);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.User user)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.User user)throws PersistentException {
		try {
			de.fhb.jproject.data.Member[] lMembers = user.member.toArray();
			for(int i = 0; i < lMembers.length; i++) {
				lMembers[i].setUser(null);
			}
			de.fhb.jproject.data.Comment[] lComments = user.comment.toArray();
			for(int i = 0; i < lComments.length; i++) {
				lComments[i].setUser(null);
			}
			de.fhb.jproject.data.ICQ[] liCQs = user.iCQ.toArray();
			for(int i = 0; i < liCQs.length; i++) {
				liCQs[i].setUserLoginName(null);
			}
			de.fhb.jproject.data.Skype[] lSkypes = user.skype.toArray();
			for(int i = 0; i < lSkypes.length; i++) {
				lSkypes[i].setUserLoginName(null);
			}
			de.fhb.jproject.data.Telefon[] lTelefons = user.telefon.toArray();
			for(int i = 0; i < lTelefons.length; i++) {
				lTelefons[i].setUserLoginName(null);
			}
			return delete(user);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws PersistentException
	 */
	public boolean deleteAndDissociate(de.fhb.jproject.data.User user, org.orm.PersistentSession session)throws PersistentException {
		try {
			de.fhb.jproject.data.Member[] lMembers = user.member.toArray();
			for(int i = 0; i < lMembers.length; i++) {
				lMembers[i].setUser(null);
			}
			de.fhb.jproject.data.Comment[] lComments = user.comment.toArray();
			for(int i = 0; i < lComments.length; i++) {
				lComments[i].setUser(null);
			}
			de.fhb.jproject.data.ICQ[] liCQs = user.iCQ.toArray();
			for(int i = 0; i < liCQs.length; i++) {
				liCQs[i].setUserLoginName(null);
			}
			de.fhb.jproject.data.Skype[] lSkypes = user.skype.toArray();
			for(int i = 0; i < lSkypes.length; i++) {
				lSkypes[i].setUserLoginName(null);
			}
			de.fhb.jproject.data.Telefon[] lTelefons = user.telefon.toArray();
			for(int i = 0; i < lTelefons.length; i++) {
				lTelefons[i].setUserLoginName(null);
			}
			try {
				session.delete(user);
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
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws PersistentException
	 */
	public boolean refresh(de.fhb.jproject.data.User user) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(user);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.User user)", e);
			throw new PersistentException(e);
		}
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws PersistentException
	 */
	public boolean evict(de.fhb.jproject.data.User user) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(user);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.User user)", e);
			throw new PersistentException(e);
		}
	}
	
}
