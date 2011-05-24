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

public class TaskDAOImpl implements de.fhb.jproject.repository.dao.TaskDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(TaskDAOImpl.class);
	public Task loadTaskByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTaskByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("loadTaskByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task getTaskByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getTaskByORMID(session, id);
		}
		catch (Exception e) {
			_logger.error("getTaskByORMID(int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task loadTaskByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTaskByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTaskByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task getTaskByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return getTaskByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			_logger.error("getTaskByORMID(int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task loadTaskByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Task) session.load(de.fhb.jproject.data.Task.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("loadTaskByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task getTaskByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Task) session.get(de.fhb.jproject.data.Task.class, new Integer(id));
		}
		catch (Exception e) {
			_logger.error("getTaskByORMID(PersistentSession session, int id)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task loadTaskByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Task) session.load(de.fhb.jproject.data.Task.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTaskByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task getTaskByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Task) session.get(de.fhb.jproject.data.Task.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			_logger.error("getTaskByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task[] listTaskByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listTaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task[] listTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return listTaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task[] listTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Task as Task");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Task[]) list.toArray(new Task[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task[] listTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Task as Task");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Task[]) list.toArray(new Task[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task loadTaskByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task loadTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return loadTaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task loadTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Task[] tasks = listTaskByQuery(session, condition, orderBy);
		if (tasks != null && tasks.length > 0)
			return tasks[0];
		else
			return null;
	}
	
	public Task loadTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Task[] tasks = listTaskByQuery(session, condition, orderBy, lockMode);
		if (tasks != null && tasks.length > 0)
			return tasks[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTaskByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateTaskByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTaskByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = de.fhb.jproject.data.JProjectPersistentManager.instance().getSession();
			return iterateTaskByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateTaskByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTaskByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Task as Task");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTaskByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From de.fhb.jproject.data.Task as Task");
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
			_logger.error("iterateTaskByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public Task createTask() {
		return new de.fhb.jproject.data.Task();
	}
	
	public boolean save(de.fhb.jproject.data.Task task) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().saveObject(task);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(de.fhb.jproject.data.Task task)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(de.fhb.jproject.data.Task task) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().deleteObject(task);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(de.fhb.jproject.data.Task task)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Task task)throws PersistentException {
		try {
			if(task.getProjectName() != null) {
				task.getProjectName().task.remove(task);
			}
			
			if(task.getTermin() != null) {
				task.getTermin().task.remove(task);
			}
			
			de.fhb.jproject.data.Member[] lMemberUserLoginNames = task.memberUserLoginName.toArray();
			for(int i = 0; i < lMemberUserLoginNames.length; i++) {
				lMemberUserLoginNames[i].task.remove(task);
			}
			de.fhb.jproject.data.CommentTask[] lComment_Tasks = task.comment_Task.toArray();
			for(int i = 0; i < lComment_Tasks.length; i++) {
				lComment_Tasks[i].setTask(null);
			}
			return delete(task);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(de.fhb.jproject.data.Task task, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(task.getProjectName() != null) {
				task.getProjectName().task.remove(task);
			}
			
			if(task.getTermin() != null) {
				task.getTermin().task.remove(task);
			}
			
			de.fhb.jproject.data.Member[] lMemberUserLoginNames = task.memberUserLoginName.toArray();
			for(int i = 0; i < lMemberUserLoginNames.length; i++) {
				lMemberUserLoginNames[i].task.remove(task);
			}
			de.fhb.jproject.data.CommentTask[] lComment_Tasks = task.comment_Task.toArray();
			for(int i = 0; i < lComment_Tasks.length; i++) {
				lComment_Tasks[i].setTask(null);
			}
			try {
				session.delete(task);
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
	
	public boolean refresh(de.fhb.jproject.data.Task task) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().refresh(task);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(de.fhb.jproject.data.Task task)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(de.fhb.jproject.data.Task task) throws PersistentException {
		try {
			de.fhb.jproject.data.JProjectPersistentManager.instance().getSession().evict(task);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(de.fhb.jproject.data.Task task)", e);
			throw new PersistentException(e);
		}
	}
	
}
