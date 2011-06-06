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
    private User aktUser = null;
	
	private UserDA userDA = DAFactory.getDAFactory().getUserDA();
	
	private static final Logger logger = Logger.getLogger(UserControl.class);
    
    public UserControl(GlobalRolesControl globalRolesController){		
    	//debuglogging
		logger.info("new UserControl()");
		
		this.globalRolesController = globalRolesController;
		
		//WAS IST DAS?!?!?!?
    	//aktUser=userDA.createUser();
    }

	public void deleteUser(String loginName)
	throws ProjectException{
		User user = null;
		
		//debuglogging
		logger.info("deleteUser(String loginName)");
        logger.debug("String loginName("+loginName+")");
		
        //abfrage ob user eingeloggt
		logged();
		
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
	public User showUserSettings()
	throws ProjectException{
		
		//debuglogging
		logger.info("showUserSettings()");
		
		User user=null;
		
		
        //abfrage ob user eingeloggt
		logged();
		
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
	public User showUserInfo(String loginName)
	throws ProjectException{
		
		User user=null;
		
		//debuglogging
		logger.info("showUserInfo()");
		
		
        //abfrage ob user eingeloggt
		logged();
		
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
	
	
	
	
	public User searchUser(String loginName) 
    throws ProjectException{
		
		User user=null;
		
		//debuglogging
		logger.info("searchUser(String loginName)");
		logger.debug("String loginName("+loginName+")");
		
        //abfrage ob user eingeloggt
		logged();
		
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
	
	public void updateUserSettings(String nachName, String vorname, String icq, String skype,String telefon, String sprache, String neuesPasswortEins, String neuesPasswortZwei, String altesPasswort)
	throws ProjectException{
		
		//debuglogging
		logger.info("updateUserSettings(String name, String vorname, String icq, " +
				"String skype,String telefon, String sprache, " +
				"String neuesPasswortEins, String neuesPasswortZwei, String altesPasswort)");
        logger.debug("updateUserSettings(String "+ nachName+", String "+vorname+", String "+icq+", String "+skype
        		+",String "+telefon+", String "+sprache
        		+", String "+neuesPasswortEins+", String "+neuesPasswortZwei+", String "+altesPasswort+")");
		
        //abfrage ob user eingeloggt
		logged();
		
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
	public List<User> showAllUser()
	throws ProjectException{ 
		
		//debuglogging
		logger.info("showAllUser()");
		
        //abfrage ob user eingeloggt
		logged();
		
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
        if(aktUser != null){
			aktUser = null;
        }
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
    
    public User getAktUser(){
    	
		//debuglogging
		logger.info("getAktUser()");
		
		//Passwort auf null setzen und Nachname kuerzen um sicherheit zu wahren
		//zieht folgefehler nach sich
		/*
		User tempUser=new User();
		tempUser.setLoginName(aktUser.getLoginName());
                tempUser.setNachname(aktUser.getNachname());
                tempUser.setVorname(aktUser.getVorname());
                tempUser.setPassword(null);
                tempUser.setSprache(aktUser.getSprache());
				tempUser.setGlobalRole(aktUser.getGlobalRole());
				tempUser.comment.clear();
				for (Comment aktComment : aktUser.comment.toArray()) {
					tempUser.comment.add(aktComment);
				}
				tempUser.iCQ.clear();
				for (ICQ aktICQ : aktUser.iCQ.toArray()) {
					tempUser.iCQ.add(aktICQ);
				}
				tempUser.member.clear();
				for (Member aktMember : aktUser.member.toArray()) {
					tempUser.member.add(aktMember);
				}
				tempUser.skype.clear();
				for (Skype aktSkype : aktUser.skype.toArray()) {
					tempUser.skype.add(aktSkype);
				}
				tempUser.telefon.clear();
				for (Telefon aktTelefon : aktUser.telefon.toArray()) {
					tempUser.telefon.add(aktTelefon);
				}
		
		return tempUser;
		 * 
		 */
		return aktUser;
    }
	private void logged() throws ProjectException{
		if(aktUser == null){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
	}
    
	
}
