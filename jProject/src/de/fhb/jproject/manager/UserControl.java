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
 * Contoller Klasse f�r die UserActions
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>, Michael Koppen <michael.koppen@googlemail.com>, 
 * 
 */
public class UserControl {
	
	
	private GlobalRolesControl globalRolesController;
	
	private UserDA userDA;
	
	private static final Logger logger = Logger.getLogger(UserControl.class);
    
    public UserControl(GlobalRolesControl globalRolesController){		
    	//debuglogging
		logger.info("new UserControl()");
		userDA = DAFactory.getDAFactory().getUserDA();
		this.globalRolesController = globalRolesController;
		
    }

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
		if(!globalRolesController.isAllowedDeleteUserAction(aktUser.getGlobalRole()) || aktUser == user){
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
	 * @return
	 * @throws ProjectException
	 */
	public User showUserSettings(User aktUser/*, String loginName???*/)
	throws ProjectException{
		
		//debuglogging
		logger.info("showUserSettings()");
		
		User user=null;
		
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(!globalRolesController.isAllowedShowUsersettingsAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//holen der daten
			user= userDA.loadUserByORMID(aktUser.getLoginName());
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		user.setPassword(null);
		
		return user;
	}
	
	
	/**
	 * Anezwigen von Kontaktdaten eines anderen Users
	 * @return
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
		
		//abfrage ob user Rechte hat
		if(!globalRolesController.isAllowedShowUserInfoAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//holen der daten
			user= userDA.loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		user.setLoginName(null);
		user.setPassword(null);
		
		return user;	
	}
	
	
	
	
	public User searchUser(User aktUser, String loginName) 
    throws ProjectException{
		
		User user=null;
		
		//debuglogging
		logger.info("searchUser(String loginName)");
		logger.debug("String loginName("+loginName+")");
		
        //abfrage ob user eingeloggt
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(!globalRolesController.isAllowedSearchUserAction(aktUser.getGlobalRole())){
			// TODO Rechte abfragen oder sowas
			throw new ProjectException("Sie haben keine Rechte zum suchen!");
		}
		try {
			//holen der daten
			user= userDA.loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		user.setPassword(null);
		
		return user;	
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
		if(!globalRolesController.isAllowedUpdateUserSettingsAction(aktUser.getGlobalRole())){
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
	 * 
	 * @return
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
		if(!globalRolesController.isAllowedShowAllUserAction(aktUser.getGlobalRole())){
			throw new ProjectException("Sie haben keine Rechte zum loeschen!");
		}
		try {
			//holen der userliste
			return userDA.listAllUsers();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann keinen User finden! "+ ex);
		}
	}
	
	
	
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
			throw new ProjectException("ungueltige parameter");
		}

		try {
			//user suchen
			user = userDA.loadUserByORMID(loginName);
			
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		if(user.getPassword().equals(password)){
			
		}
		return user;
	}
	
	
	public void logout(){
		
		//debuglogging
		logger.info("logout()");
		
        //abfrage ob user eingeloggt
		//In der Action auf null setzen
        /*if(aktUser != null){
			aktUser = null;
        }*/
    }
	
	public void register()throws ProjectException{
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
