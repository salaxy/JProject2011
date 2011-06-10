package de.fhb.jproject.manager;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.ICQ;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Skype;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.repository.da.UserDA;

/**
 * Manager fuer die User Aktionen
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>, Michael Koppen <michael.koppen@googlemail.com>
 * 
 */
public class UserManager {
	
	
	private GlobalRolesManager globalRolesManager;
	
	private UserDA userDA;
	
	private static final Logger logger = Logger.getLogger(UserManager.class);
    
	/**
	 * UserManager Konstruktor
	 * @param globalRolesManager
	 */
    public UserManager(GlobalRolesManager globalRolesManager){		
    	//debuglogging
		logger.info("new UserControl()");
		userDA = DAFactory.getDAFactory().getUserDA();
		this.globalRolesManager = globalRolesManager;
		
    }
    

    /**
     * User loeschen
     * 
     * @param aktUser
     * @param loginName
     * @throws ProjectException
     */
	public void deleteUser(User aktUser, String loginName)
	throws ProjectException{
		clearSession();
		User user = null;
		
		//debuglogging
		logger.info("deleteUser(String loginName)");
        logger.debug("User aktUser("+aktUser+")"+
				"String loginName("+loginName+")"
				);
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		try {
			user = userDA.loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht laden! "+ ex);
		}
		
		//abfrage ob user Rechte hat bzw Eigner ist
		if(!globalRolesManager.isAllowedDeleteUserAction(aktUser.getGlobalRole()) 
				&& !(user.getLoginName().equals(aktUser.getLoginName()))){
			throw new ProjectException("Sie haben keine Rechte zum loeschen!");
		}
		try {
			//loeschen des users
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
	public User showUserSettings(User aktUser)
	throws ProjectException{
		clearSession();
		//debuglogging
		logger.info("showUserSettings()");
		
		User user=null;
		
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		try {
			//holen der daten
			user= userDA.loadUserByORMID(aktUser.getLoginName());
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		//abfrage ob user Rechte hat
		if(!globalRolesManager.isAllowedShowUsersettingsAction(aktUser.getGlobalRole()) 
				&& !(user.getLoginName().equals(aktUser.getLoginName()))){
			throw new ProjectException("Sie haben keine Rechte!");
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
	public User showUserInfo(User aktUser, String loginName)
	throws ProjectException{
		clearSession();
		User user=null;
		
		//debuglogging
		logger.info("showUserInfo()");
		
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		try {
			//holen der daten
			user= userDA.loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}

		//abfrage ob user Rechte hat
		if(!globalRolesManager.isAllowedShowUserInfoAction(aktUser.getGlobalRole()) 
				&& !(user.getLoginName().equals(aktUser.getLoginName()))){
			throw new ProjectException("Sie haben keine Rechte!");
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
	public List <User>  searchUser(User aktUser, String searchValue) 
    throws ProjectException{
		clearSession();
		
		List<User> list=null;
		
		//debuglogging
		logger.info("searchUser(String loginName)");
		logger.debug("String loginName("+searchValue+")");
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(!globalRolesManager.isAllowedSearchUserAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum suchen!");
		}
		
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
	public void updateUserSettings(User aktUser, String nachName, String vorname, String icq, String skype,String telefon, String sprache, String neuesPasswortEins, String neuesPasswortZwei, String altesPasswort)
	throws ProjectException{
		clearSession();
		//TODO noch nicht fertig
		
		User user=null;
		//PerformenceBOOL 
		boolean changed = false;
		
		//debuglogging
		logger.info("updateUserSettings(String name, String vorname, String icq, " +
				"String skype,String telefon, String sprache, " +
				"String neuesPasswortEins, String neuesPasswortZwei, String altesPasswort)");
        logger.debug("updateUserSettings(String "+ nachName+", String "+vorname+", String "+icq+", String "+skype
        		+",String "+telefon+", String "+sprache
        		+", String "+neuesPasswortEins+", String "+neuesPasswortZwei+", String "+altesPasswort+")");
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//User neu holen
		try {
			user=userDA.getUserByORMID(aktUser.getLoginName());
		} catch (PersistentException e) {
			throw new ProjectException("Konnte User nicht finden! "+ e.getMessage());
		}
		
		//abfrage ob user Rechte hat
		if(!globalRolesManager.isAllowedUpdateUserSettingsAction(aktUser.getGlobalRole()) 
				&& !(user.getLoginName().equals(aktUser.getLoginName()))){
			throw new ProjectException("Sie haben keine Rechte zum aendern der Usereinstellungen!");
		}
	
		clearSession();
		//EIGENTLICHE AKTIONEN
		
		//User neu holen
		try {
			user=userDA.getUserByORMID(aktUser.getLoginName());
		} catch (PersistentException e) {
			throw new ProjectException("Konnte User nicht finden! "+ e.getMessage());
		}
		
		
		
		//aendern der user einstellungen
		//wenn nicht leerer String und ge�ndert
		//nachname
		if(!(nachName==null)&&!(nachName.isEmpty())&&!(nachName.equals(aktUser.getNachname()))){
			//aendern
			user.setNachname(nachName);
			changed = true;
		}
		
		//vorname
		if(!(vorname==null)&&!(vorname.isEmpty())&&!(vorname.equals(aktUser.getVorname()))){
			//aendern
			user.setVorname(vorname);
			changed = true;
		}
		
		//ICQ
		
		if(icq!=null&&!icq.isEmpty()){
			
			ICQ i =DAFactory.getDAFactory().getICQDA().createICQ();
			i.setUserLoginName(user);
			i.setIcqNumber(icq);
			
			
			
			changed = true;
		}

		
		
		//Skype
		if(skype!=null&&!skype.isEmpty()){
			
			Skype s =DAFactory.getDAFactory().getSkypeDA().createSkype();
			s.setUserLoginName(user);
			s.setSkypeName(skype);
			
			//wenn bereits enthalten
			if(!user.skype.contains(s)){
				user.skype.add(s);
			}
			changed = true;
		}
		
		//telefon
//		if(telefon!=null&&!telefon.isEmpty()){
//			
//			Telefon s =DAFactory.getDAFactory().getTelefonDA().createTelefon();
//			s.setUserLoginName(user);
//			s.setSkypeName(skype);
//			
//			//wenn bereits enthalten
//			if(!user.skype.contains(s)){
//				user.skype.add(s);
//			}
//			changed = true;
//		}
		
		
		//sprache
		
		//passwort
		
		
//		ICQ i =DAFactory.getDAFactory().getICQDA().createICQ();
//		
//		
//		if(user.iCQ.c.contains(icq))
		
//		if(neuesPasswortEins!=null){
//			//aendern
//		}
		
		
		//user speichern/updaten
		if (changed) {
			try {
				//Member speichern
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
	public List<User> showAllUser(User aktUser)
	throws ProjectException{ 
		clearSession();
		//debuglogging
		logger.info("showAllUser()");
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(!globalRolesManager.isAllowedShowAllUserAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum loeschen!");
		}
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
		clearSession();
		
		//debuglogging
        logger.info("login(String loginName, String password)");
        logger.debug("String "+"loginName("+loginName+"), String "+"password("+password+")");
		
		//abfrage ob user eingeloggt
		//throw new ProjectException("Sie sind bereits eingeloggt");
		User user = null;

		//eingabefehler abfangen
		if(loginName==null||password==null||password.equals("")){
			throw new ProjectException("Ungueltige Eingabe");
		}

		try {
			//user suchen
			user = userDA.loadUserByORMID(loginName);
			
		} catch (PersistentException ex) {
			throw new ProjectException("Falscher Benutzername! ");
		}
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
	 * weitere einstellungen aknn der user dann machen wenn er sich eingeloggt hat
	 * ueber die usereinstellungen
	 * 
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
	public void register(String loginName, String passwort, String passwortWdhl, String nachname, String vorname)
	throws ProjectException{
		clearSession();
		
		//XXX k.a wie wir das machen nachm registriren mit dem Freigebn des users 
		//Koennte man aber einfacherweise ueber eine Rolle machen>>> kann sich einloggen aber nichts machen weil er z.b Role=Gesperrt oder sowas
		// d.h jemand sich erfolgreich registriert hat kann sich auch gleich einloggen, aber nix machen bis er freigegebn wird
		//TODO @ micher konnte nicht testen, musst im Servlet noch was aendern!!
		// das hier noch daszu || getOperation(req).equals("Register") ..das allein hatte aber allien nicht geholfen!
		
		//Rechteabfrage entfaellt
		User user=null;
		
		//eingabe fehler abfangen
		
		//betreffen loginName
		if(loginName==null){
			throw new ProjectException("kein loginName oder loginNameWdhl mitgegeben!");
		}
		
		if(loginName.isEmpty()){
			throw new ProjectException("Leerer loginName!");
		}
		
		
		//mindestlaenge 5 zeichen
		if(loginName.length()<5){
			throw new ProjectException("loginName mind. 5 zeichen!!");
		}
		
		
		//betreffend passwort
		if(passwort==null||passwortWdhl==null){
			throw new ProjectException("kein passwort oder passwortWdhl mitgegeben!");
		}
		
		if(passwort.isEmpty()){
			throw new ProjectException("Leeres Passwort!");
		}
		
		if(!passwort.equals(passwortWdhl)){
			throw new ProjectException("Passwort neu eingeben!!");
		}
		
		//mindestlaenge 5 zeichen
		if(passwort.length()<5){
			throw new ProjectException("passwort mind. 5 zeichen!!");
		}
		
		
		
		if(vorname==null||nachname==null){
			throw new ProjectException("kein vorname oder nachname mitgegeben!");
		}
		
		if(vorname.isEmpty()){
			throw new ProjectException("Leerer Vorname!");
		}
		
		if(nachname.isEmpty()){
			throw new ProjectException("Leerer Nachname!");
		}
		
		
		//setzen der parameter des users
		user=userDA.createUser();
		user.setGlobalRole("Member");
		user.setSprache("Deutsch");
		user.setVorname(vorname);
		user.setNachname(nachname);
		user.setLoginName(loginName);
			
		//speichern des users
		try {
			userDA.save(user);
		} catch (PersistentException e) {
			throw new ProjectException("User konnte nicht gespeichert werden!");
		}
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
