package de.fhb.jproject.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.ICQ;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Skype;
import de.fhb.jproject.data.Telefon;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.UserDA;
import org.apache.log4j.Level;

/**
 * Manager fuer die User Aktionen
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>, Michael Koppen <michael.koppen@googlemail.com>
 * 
 */
public class UserManager {
	
	
	
	private UserDA userDA;
	
	private final String STANDARDLANGUAGE="Deutsch";
	
	private static final Logger logger = Logger.getLogger(UserManager.class);
    
	/**
	 * UserManager Konstruktor
	 * @param globalRolesManager
	 */
    public UserManager(){		
    	//debuglogging
		logger.info("new UserControl()");
		logger.setLevel(Level.DEBUG);
		userDA = DAFactory.getDAFactory().getUserDA();
		
    }
    

    /**
     * User loeschen
     * 
     * @param aktUser
     * @param loginName
     * @throws ProjectException
     */
	public void deleteUser(String loginName)
	throws ProjectException{
		
		
		//debuglogging
		logger.info("deleteUser(String loginName)");
        logger.debug("String loginName("+loginName+")");
		
		try {
			//loeschen des users
			clearSession();
			userDA.delete(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht loeschen! "+ ex);
		}
		
	}
	
	
	/**
	 * Anzeigen der eigenen Daten zum �ndern
	 * 
	 * @param aktUser
	 * @return User
	 * @throws ProjectException
	 */
	public User showUserSettings(String loginName)
	throws ProjectException{
		
		//debuglogging
		logger.info("showUserSettings()");
		logger.debug("String aktUser("+loginName+")");
		
		User user=null;
		
		try {
			//holen der daten
			user= userDA.loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		
		return user;
	}
	
	
	/**
	 * Anzeigen von Kontaktdaten eines anderen Users
	 * 
	 * @param aktUser
	 * @param loginName
	 * @return User
	 * @throws ProjectException
	 */
	public User showUserInfo(String loginName)
	throws ProjectException{
		
		User user=null;
		
		//debuglogging
		logger.info("showUserInfo()");
		logger.debug("String loginName("+loginName+")");
		
		try {
			//holen der daten
			user= userDA.loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		
		return user;	
	}
	
	/**
	 * Suchen eines User nach Vornamen und Nachnamen
	 * 
	 * @param aktUser
	 * @param searchValue
	 * @return
	 * @throws ProjectException
	 */
	public List<User> searchUser(String searchValue) 
    throws ProjectException{
		
		
		List<User> list=null;
		
		//debuglogging
		logger.info("searchUser(String loginName)");
		logger.debug("String loginName("+searchValue+")");
		
		
		//holen der daten
		try {
			list= userDA.listAllUsersLike(searchValue);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);	
		}
		
		return list;	
    }
	
	/**
	 *  Updaten eines Users
	 *  
	 * @param aktUser
	 * @param nachName
	 * @param vorname
	 * @param icq
	 * @param skype
	 * @param telefon
	 * @param sprache
	 * @param neuesPasswortEins
	 * @param neuesPasswortZwei
	 * @param altesPasswort
	 * @throws ProjectException
	 */
	public void updateUserSettings(String loginName, String nachName, String vorname, String[] icqArray, String[] skypeArray,
			String[] telefonArray, String sprache, String neuesPasswortEins)
	throws ProjectException{
		
		User user=null;
		//PerformenceBOOL 
		boolean changed = false;
		
		//debuglogging
		logger.info("updateUserSettings(String name, String vorname, String icq, " +
				"String skype,String telefon, String sprache, " +
				"String neuesPasswortEins)");
		logger.debug("String loginName("+loginName+")");
        logger.debug("updateUserSettings(String "+ nachName+", String "+vorname+", String "+icqArray+", String "+skypeArray
        		+",String "+telefonArray+", String "+sprache
        		+", String "+neuesPasswortEins+")");
		
		
		//EIGENTLICHE AKTIONEN
		
		//User neu holen
		try {
			user=userDA.getUserByORMID(loginName);
		} catch (PersistentException e) {
			throw new ProjectException("Konnte User nicht finden! "+ e.getMessage());
		}
		
		
		
		//aendern der user einstellungen
		//wenn nicht leerer String und geaendert
		//nachname
		if(!(nachName.equals(user.getNachname()))){
			//aendern
			user.setNachname(nachName);
			changed = true;
		}
		
		//vorname
		if(!(vorname.equals(user.getVorname()))){
			//aendern
			user.setVorname(vorname);
			changed = true;
		}
		
		//ICQ
		if(icqArray!=null){
			
			//ueberpruefen ob nummer
			for(String icq :icqArray){
				try{
					Integer.valueOf(icq);
				}catch(IllegalArgumentException e){
					throw new ProjectException("Ein ICQ Eintrag enthaelt Buchstaben! "+ e.getMessage());
				}
			}
			
			//alte eintraege loeschen
			for(Object ic : user.iCQ.getCollection()){
				
				try {
					DAFactory.getDAFactory().getICQDA().delete(((ICQ)ic));
				} catch (PersistentException e) {
					throw new ProjectException("Konnte ICQ nicht loeschen! "+ e.getMessage());
				}
				
			}
			
			user.iCQ.clear();			
			
			try {
				DAFactory.getDAFactory().getUserDA().save(user);
			} catch (PersistentException e) {
				throw new ProjectException("Konnte ICQ nicht speichern! "+ e.getMessage());
			}
			
			
			//neue eintraege speichern
			for(String icq :icqArray){
				ICQ i =DAFactory.getDAFactory().getICQDA().createICQ();			
				i.setUserLoginName(user);
				i.setIcqNumber(icq);
				user.iCQ.add(i);
				
				try {
					DAFactory.getDAFactory().getICQDA().save(i);
				} catch (PersistentException e) {
					throw new ProjectException("Konnte ICQ nicht speichern! "+ e.getMessage());
				}
			}
			
			
			changed = true;
		}

		
		
		//Skype
		if(skypeArray!=null){
			
			//alte eintraege loeschen
			for(Object s : user.skype.getCollection()){
				
				try {
					DAFactory.getDAFactory().getSkypeDA().delete(((Skype)s));
				} catch (PersistentException e) {
					throw new ProjectException("Konnte Skype nicht loeschen! "+ e.getMessage());
				}
				
			}
			
			user.skype.clear();			
			
			try {
				DAFactory.getDAFactory().getUserDA().save(user);
			} catch (PersistentException e) {
				throw new ProjectException("Konnte nicht speichern! "+ e.getMessage());
			}

			
			for(String skype :skypeArray){
				Skype s =DAFactory.getDAFactory().getSkypeDA().createSkype();			
				s.setUserLoginName(user);
				s.setSkypeName(skype);
				user.skype.add(s);
				
				try {
					DAFactory.getDAFactory().getSkypeDA().save(s);
				} catch (PersistentException e) {
					throw new ProjectException("Konnte Sykpe nicht speichern! "+ e.getMessage());
				}
			}
			
			changed = true;
		}
		
		//telefon
		if(telefonArray!=null){
			
			//alte eintraege loeschen
			for(Object t : user.telefon.getCollection()){
				
				try {
					DAFactory.getDAFactory().getTelefonDA().delete(((Telefon)t));
				} catch (PersistentException e) {
					throw new ProjectException("Konnte Skype nicht loeschen! "+ e.getMessage());
				}
				
			}
			
			user.telefon.clear();			
			
			try {
				DAFactory.getDAFactory().getUserDA().save(user);
			} catch (PersistentException e) {
				throw new ProjectException("Konnte nicht speichern! "+ e.getMessage());
			}
			
			for(String telnr :telefonArray){
				Telefon t =DAFactory.getDAFactory().getTelefonDA().createTelefon();			
				t.setUserLoginName(user);
				t.setTelNumber(telnr);
				user.telefon.add(t);
				
				try {
					DAFactory.getDAFactory().getTelefonDA().save(t);
				} catch (PersistentException e) {
					throw new ProjectException("Konnte Telefon nicht speichern! "+ e.getMessage());
				}
			}
			
			changed = true;
		}
		
		
		//sprache
		if(!(sprache.equals(user.getSprache()))){
			//aendern
			user.setSprache(sprache);
			changed = true;
		}
		
		
		
		//passwort
		if(!(neuesPasswortEins.equals(user.getPassword()))){
			
			
			//aendern
			user.setPassword(neuesPasswortEins);
			changed = true;
		}
		
		
		//user speichern/updaten
		if (changed) {
			try {
				userDA.save(user);
			} catch (PersistentException e) {
				throw new ProjectException("Konnte User nicht speichern! "+ e.getMessage());
			}
		}
		
	}
	
	/**
	 * Alle User Anzeigen
	 * 
	 * @param aktUser
	 * @return List<User>
	 * @throws ProjectException
	 */
	public List<User> showAllUser()
	throws ProjectException{ 
		
		//debuglogging
		logger.info("showAllUser()");
		
		try {
			//holen der userliste
			return userDA.listAllUsers();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann keinen User finden! "+ ex);
		}
	}
	
	
	/**
	 * Einloggen
	 * 
	 * @param loginName
	 * @param password
	 * @return User
	 * @throws ProjectException
	 */
	public User login(String loginName, String password)
	throws ProjectException{
		
		
		//debuglogging
        logger.info("login(String loginName, String password)");
        logger.debug("String loginName("+loginName+"), "
				+ "String password("+password+")");
		
		//abfrage ob user eingeloggt
		//throw new ProjectException("Sie sind bereits eingeloggt");
		User user = null;

		//eingabefehler abfangen
		//TODO PasswordHash into action
		if(loginName==null||password==null||password.equals("")){
			throw new ProjectException("Ungueltige Eingabe");
		}

		try {
			//user suchen
			user = userDA.loadUserByORMID(loginName);
			
		} catch (PersistentException ex) {
			throw new ProjectException("Falscher Benutzername! ");
		}
		//TODO PasswordHash ==
		if(!user.getPassword().equals(password)){
			throw new ProjectException("Falsches Passwort!");
		}
		return user;
	}
	
	
	/**
	 * Ausloggen
	 */
	public void logout(){
		//debuglogging
		logger.info("logout()");
		
    }
	
	/**
	 * einfache Registrieren
	 * nur loginame, vorname, Name, passwort
	 * weitere einstellungen kann der user dann slebst machen wenn er sich eingeloggt hat
	 * ueber die usereinstellungen
	 * (ein admin f�gt ein User hinzu, nicht der user selber)
	 * 
	 * 
	 * @param loginName
	 * @param loginNameWdhl
	 * @param passwort
	 * @param passwortWdhl
	 * @param nachName
	 * @param vorname
	 * @throws ProjectException
	 */
	public void register(String loginName, String passwort, String nachname, String vorname)
	throws ProjectException{
		
		//debuglogging
        logger.info("register(String loginName, String passwort, String passwortWdhl, String nachname, String vorname)");
        logger.debug("String loginName("+loginName+")"
				+"String loginName("+loginName+")"
				+"String passwort("+passwort+")"
				+"String nachname("+nachname+")"
				+"String vorname("+vorname+")"
				);      
		
		User user=null;		
		User userUeberpruf=null;
		
		//ueberprufen ob user schon existent
		try {
			userUeberpruf=userDA.getUserByORMID(loginName);
		} catch (PersistentException e1) {
			throw new ProjectException("Fehler beim Laden!"+e1.getMessage());
		}
		
		if(userUeberpruf!=null){
			throw new ProjectException("UserName existiert schon!");	
		}
		
		
		//setzen der parameter des users
		user=userDA.createUser();
		user.setGlobalRole("Member");
		user.setSprache(this.STANDARDLANGUAGE);
		user.setVorname(vorname);
		user.setNachname(nachname);
		user.setLoginName(loginName);
		user.setPassword(passwort);

		
		//speichern des users
		try {
			userDA.save(user);
		} catch (PersistentException e) {
			throw new ProjectException("User konnte nicht gespeichert werden!"+e.getMessage());
		}
	}
	
	public User getAktUser(String aktUser)throws ProjectException{
		User user = null;
		try {
			user = userDA.getUserByORMID(aktUser);
		} catch (PersistentException e1) {
			throw new ProjectException("Konnte aktuellen User nicht finden! "+ e1.getMessage());
		}
		return user;
	}
	private void clearSession() throws ProjectException{
		try {
			PersistentSession session;		
			//Session holen
			session = JProjectPersistentManager.instance().getSession();
			//und bereinigen
			session.clear();
		} catch (PersistentException e) {
			throw new ProjectException("Konnte Session nicht clearen! "+ e.getMessage());
		}
		
	}
    
	
}
