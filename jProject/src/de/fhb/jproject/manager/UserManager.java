package de.fhb.jproject.manager;

import de.fhb.jproject.data.Comment;
import de.fhb.jproject.exceptions.ProjectException;
import java.util.List;
import java.util.logging.Level;

import org.apache.log4j.Logger;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.ICQ;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Skype;
import de.fhb.jproject.data.Telefon;
import de.fhb.jproject.data.User;
import de.fhb.jproject.repository.da.UserDA;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;

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
		User user = null;
		
		//debuglogging
		logger.info("deleteUser(String loginName)");
        logger.debug("String loginName("+loginName+")");
		
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
		if(!globalRolesManager.isAllowedDeleteUserAction(aktUser.getGlobalRole()) || !(aktUser == user)){
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
		if(!globalRolesManager.isAllowedShowUsersettingsAction(aktUser.getGlobalRole()) || !(aktUser == user)){
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
		if(!globalRolesManager.isAllowedShowUserInfoAction(aktUser.getGlobalRole()) || !(aktUser == user)){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		
		
		return user;	
	}
	

	public List <User>  searchUser(User aktUser, String searchValue) 
    throws ProjectException{
	
		List <User> list=null;
		
//		//debuglogging
//		logger.info("searchUser(String loginName)");
//		logger.debug("String loginName("+searchValue+")");
//		
//        //abfrage ob user eingeloggt
//		if(aktUser == null){
//            throw new ProjectException("Sie sind nicht eingeloggt!");
//        }
//		
//		//abfrage ob user Rechte hat
//		if(!globalRolesManager.isAllowedSearchUserAction(aktUser.getGlobalRole())){
//			throw new ProjectException("Sie haben keine Rechte zum suchen!");
//		}
//		try {
//			//holen der daten
//			list= userDA.listUserByQuery("Vorname=%"+searchValue+"%", );
//		} catch (PersistentException ex) {
//			throw new ProjectException("Kann User nicht finden! "+ ex);
//		}
//		//TODO LIKE QUERY IN DER DA SCHICHT
//		user.setPassword(null);
////		SELECT Autor, Buchtitel FROM Buecher WHERE Buchtitel LIKE '%Geld%';
//		
		return list;	
    }
	
	public void updateUserSettings(User aktUser, String nachName, String vorname, String icq, String skype,String telefon, String sprache, String neuesPasswortEins, String neuesPasswortZwei, String altesPasswort)
	throws ProjectException{
		
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
		
		//abfrage ob user Rechte hat
		//TODO || !(aktUser == user)
		if(!globalRolesManager.isAllowedUpdateUserSettingsAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum aendern!");
		}
		
		//aendern der user einstellungen
		//wenn nicht leerer String und ge�ndert
		if(!(nachName.isEmpty())&&!(nachName.equals(aktUser.getNachname()))){
			//�ndern
		}
		
		if(!(vorname.isEmpty())&&!(vorname.equals(aktUser.getVorname()))){
			//�ndern
		}
		
		//TODO noch nicht fertig
		
//		if(neuesPasswortEins!=null){
//			//�ndern
//		}
		
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
	
	public void register()
	throws ProjectException{
		/*
		PersistentSession session;
		DAFactory fa = DAFactory.getDAFactory();			
		
		try {
			session = JProjectPersistentManager.instance().getSession();
			Member tempMember = fa.getMemberDA().createMember();
			tempMember.setProjectRole("Member");
			//project setzen (impliziert hier auch das adden zum project ) >>> project.member.add(member); ist un�tig
			Project project = fa.getProjectDA().getProjectByORMID("ProjectName");
			tempMember.setProject(project);

			//rolle setzen

			User tempUser = fa.getUserDA().getUserByORMID("Bla");
			tempMember.setUser(tempUser);

			session.clear();
			fa.getMemberDA().save(tempMember);
		} catch (PersistentException e) {
			
			throw new ProjectException("Konnte User/Project nicht laden! "+ e);
		}
		
		*/
	}
    
	
}
