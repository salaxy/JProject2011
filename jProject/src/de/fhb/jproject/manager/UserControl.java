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
	
	private static final Logger logger = Logger.getLogger(UserControl.class);
	private GlobalRolesControl globalRolesController;
	private boolean loggedIn = false;
    private User aktUser = null;
    private boolean dummy=false;
    
    public UserControl(GlobalRolesControl globalRolesController){		
    	//debuglogging
		logger.info("new UserControl()");
		
		this.globalRolesController = globalRolesController;
    	aktUser=DAFactory.getDAFactory().getUserDA().createUser();
    }

	public void deleteUser(String loginName)
	throws ProjectException{
		
		//debuglogging
		logger.info("deleteUser(String loginName)");
        logger.debug("String loginName("+loginName+")");
		
        //abfrage ob user eingeloggt
		if(!loggedIn){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte zum loeschen!");
		}
		try {
			//loeschen des users
			DAFactory.getDAFactory().getUserDA().delete(loginName);
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
		
		//debuglogging
		logger.info("showUserInfo()");
		
		
        //abfrage ob user eingeloggt
		if(!loggedIn){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//holen der daten
			user= DAFactory.getDAFactory().getUserDA().loadUserByORMID(aktUser.getLoginName());
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
		if(!loggedIn){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte!");
		}
		try {
			//holen der daten
			user= DAFactory.getDAFactory().getUserDA().loadUserByORMID(loginName);
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
		if(!loggedIn){
			throw new ProjectException("Sie sind nicht eingeloggt");
		}
		//abfrage ob user Rechte hat
		if(dummy){
			// TODO Rechte abfragen oder sowas
			throw new ProjectException("Sie haben keine Rechte zum suchen!");
		}
		try {
			//holen der daten
			user= DAFactory.getDAFactory().getUserDA().loadUserByORMID(loginName);
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
		if(!loggedIn){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
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
		if(!loggedIn){
            throw new ProjectException("Sie sind nicht eingeloggt!");
        }
		
		//abfrage ob user Rechte hat
		if(dummy){
			throw new ProjectException("Sie haben keine Rechte zum loeschen!");
		}
		try {
			//holen der userliste
			return DAFactory.getDAFactory().getUserDA().listAllUsers();
		} catch (PersistentException ex) {
			throw new ProjectException("Kann keinen User finden! "+ ex);
		}
	}
	
	
	
	public void  login(String loginName, String password)
	throws ProjectException{
		
		//debuglogging
        logger.info("login(String loginName, String password)");
        logger.debug("String "+"loginName("+loginName+"), String "+"password("+password+")");
		
		User user = null;
        
		//eingabefehler abfangen
		if(loginName==null||password==null||password.equals("")){
			throw new ProjectException("Kein Passwort oder Loginname eingegeben!");
		}
		
        //abfrage ob user eingeloggt
        if(loggedIn){
            throw new ProjectException("Sie sind bereits eingeloggt");
        }
		try {
			//user suchen
			user = DAFactory.getDAFactory().getUserDA().loadUserByORMID(loginName);
		} catch (PersistentException ex) {
			throw new ProjectException("Kann User nicht finden! "+ ex);
		}
		
		//passwort ueberpruefen
		if(user.getPassword().equals(password)){
                loggedIn = true;
                aktUser.setLoginName(user.getLoginName());
                aktUser.setNachname(user.getNachname());
                aktUser.setVorname(user.getVorname());
                aktUser.setPassword(user.getPassword());
                aktUser.setSprache(user.getSprache());
				aktUser.setGlobalRole(user.getGlobalRole());
				aktUser.comment.clear();
				for (Comment aktComment : user.comment.toArray()) {
					aktUser.comment.add(aktComment);
				}
				aktUser.iCQ.clear();
				for (ICQ aktICQ : user.iCQ.toArray()) {
					aktUser.iCQ.add(aktICQ);
				}
				aktUser.member.clear();
				for (Member aktMember : user.member.toArray()) {
					aktUser.member.add(aktMember);
				}
				aktUser.skype.clear();
				for (Skype aktSkype : user.skype.toArray()) {
					aktUser.skype.add(aktSkype);
				}
				aktUser.telefon.clear();
				for (Telefon aktTelefon : user.telefon.toArray()) {
					aktUser.telefon.add(aktTelefon);
				}
                
                //aktUser = user;
		}else{
			throw new ProjectException("Falscher Loginname und/oder falsches Passwort!");
		}
        
	}
	
	
	public void  logout(){
		
		//debuglogging
		logger.info("logout()");
		
        //abfrage ob user eingeloggt
        if(loggedIn){
        	//ausloggen
            loggedIn = false;
			aktUser = null;
//            aktUser.setLoginName(null);
//            aktUser.setNachname(null);
//            aktUser.setPassword(null);
//            aktUser.setVorname(null);
//            aktUser.setSprache(null);
        }
    }
	
	public void  register()throws ProjectException{
		PersistentSession session;
		DAFactory fa = DAFactory.getDAFactory();			
		try {
			session = JProjectPersistentManager.instance().getSession();
            try {
				Member tempMember = fa.getMemberDA().createMember();
				tempMember.setProjectRole("Leader");
				//project setzen (impliziert hier auch das adden zum project ) >>> project.member.add(member); ist un�tig
				Project project = fa.getProjectDA().getProjectByORMID("ProjectName");
				tempMember.setProject(project);
				tempMember.setProjectId(project.getName());

				//rolle setzen
				
                User tempUser = fa.getUserDA().getUserByORMID("Bla");
				tempMember.setUser(tempUser);
				tempMember.setUserId(tempUser.getLoginName());

				session.clear();
				fa.getMemberDA().save(tempMember);
            } catch (PersistentException e) {
                e.printStackTrace();
                throw new ProjectException("Konnte User/Project nicht laden! "+ e);
            }
            
        } catch (PersistentException e) {
            e.printStackTrace();
            throw new ProjectException("Kann Transaktion nicht initialisieren! "+e);
        }	
		
			
			
//		User tempUser = DAFactory.getDAFactory().getUserDA().createUser();
//		tempUser.setGlobalRole("Member");
//		tempUser.setLoginName("Bla2");
//		tempUser.setNachname("nachbla");
//		tempUser.setPassword("hex");
//		tempUser.setSprache("deutsch");
//		try {
//			DAFactory.getDAFactory().getUserDA().save(tempUser);
//		} catch (PersistentException ex) {
//			throw new ProjectException("Konnte User nicht anlegen! "+ ex);
//		}
	}
    
    public User getAktUser(){
    	
		//debuglogging
		logger.info("getAktUser()");
		
		//Passwort auf null setzen und Nachname kuerzen um sicherheit zu wahren
		/*
		User tempUser=aktUser;
		tempUser.setPassword(null);
		tempUser.setNachname(aktUser.getNachname().toCharArray()[0]+".");
		
        return tempUser;
		 * 
		 */
		
		return aktUser;
    }
    
	
}
