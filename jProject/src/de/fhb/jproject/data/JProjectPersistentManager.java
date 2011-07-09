/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package de.fhb.jproject.data;

import org.orm.*;
import org.orm.cfg.JDBCConnectionSetting;
import org.hibernate.*;
import java.util.Properties;

/**
 * 
 * @author MacYser
 */
public class JProjectPersistentManager extends PersistentManager {
	private static final String PROJECT_NAME = "JProject";
	private static PersistentManager _instance = null;
	private static SessionType _sessionType = SessionType.THREAD_BASE;
	private static int _timeToAlive = 60000;
	private static JDBCConnectionSetting _connectionSetting = null;
	private static Properties _extraProperties = null;
	
	private JProjectPersistentManager() throws PersistentException {
		super(_connectionSetting, _sessionType, _timeToAlive, new String[] {}, _extraProperties);
		setFlushMode(FlushMode.AUTO);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getProjectName() {
		return PROJECT_NAME;
	}
	
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public static synchronized final PersistentManager instance() throws PersistentException {
		if (_instance == null) {
			_instance = new JProjectPersistentManager();
		}
		
		return _instance;
	}
	
	/**
	 * 
	 * @throws PersistentException
	 */
	public void disposePersistentManager() throws PersistentException {
		_instance = null;
		super.disposePersistentManager();
	}
	
	/**
	 * 
	 * @param sessionType
	 * @throws PersistentException
	 */
	public static void setSessionType(SessionType sessionType) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session type after create PersistentManager instance");
		}
		else {
			_sessionType = sessionType;
		}
		
	}
	
	/**
	 * 
	 * @param timeInMs
	 * @throws PersistentException
	 */
	public static void setAppBaseSessionTimeToAlive(int timeInMs) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set session time to alive after create PersistentManager instance");
		}
		else {
			_timeToAlive = timeInMs;
		}
		
	}
	
	/**
	 * 
	 * @param aConnectionSetting
	 * @throws PersistentException
	 */
	public static void setJDBCConnectionSetting(JDBCConnectionSetting aConnectionSetting) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set connection setting after create PersistentManager instance");
		}
		else {
			_connectionSetting = aConnectionSetting;
		}
		
	}
	
	/**
	 * 
	 * @param aProperties
	 * @throws PersistentException
	 */
	public static void setHibernateProperties(Properties aProperties) throws PersistentException {
		if (_instance != null) {
			throw new PersistentException("Cannot set hibernate properties after create PersistentManager instance");
		}
		else {
			_extraProperties = aProperties;
		}
		
	}
	
	/**
	 * 
	 */
	public static void saveJDBCConnectionSetting() {
		PersistentManager.saveJDBCConnectionSetting(PROJECT_NAME, _connectionSetting);
	}
}
