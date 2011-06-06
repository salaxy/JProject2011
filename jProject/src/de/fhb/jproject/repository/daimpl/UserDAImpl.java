/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;


import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.User;
import de.fhb.jproject.repository.da.UserDA;
import de.fhb.jproject.repository.dao.UserDAO;
import de.fhb.jproject.repository.daoimpl.UserDAOImpl;
import java.util.Arrays;
import java.util.List;

public class UserDAImpl extends UserDAOImpl implements UserDA {
	
    /* TRANSAKTIONS AUFRUF
        try {
            PersistentTransaction t = session.beginTransaction();
            //HIER DER ANDERE TRY CATCH BLOCK!!!!!!!!!!!!!
            try {
                //HIER DIE TRANSAKTION!!!!!!!!!!!!!
                //Transaktion1 probiere aus
                //Transaktion2 probiere aus
                //Transaktion3 probiere aus
                t.commit();//wenn alles erfolgreich speichere
            } catch (PersistentException e) {
                t.rollback();
                
                throw new ProjectException("Transaktion fehlgeschlagen!");
            }
            
        } catch (PersistentException e) {
            
            throw new ProjectException("Kann Transaktion nicht initialisieren!");
        }
	*/
    /* NORMALER AUFRUF
        
        try {
            //HIER DIE Operation!!!!!!!!!!!!!
            //Operation1 probiere aus
            t.commit();//wenn alles erfolgreich speichere
        } catch (PersistentException e) {
            
            throw new ProjectException("Operation fehlgeschlagen!");
        }
            
        
	*/
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(UserDAImpl.class);
	
	public UserDAImpl(){
		logger.info(" new UserDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.error("Kann Session nicht anlegen! ", ex);// TODO maybe FATAL
        }
	}

	@Override
	public void delete(String loginName) throws PersistentException{
		logger.info("delete(String loginName)");
		logger.debug("String loginName("+loginName+")");
		delete(loadUserByORMID(loginName));
	}
	@Override
	public List<User> listAllUsers() throws PersistentException {
		logger.info("listAllUsers()");
		
		return Arrays.asList(listUserByQuery("User.loginName = User.loginName", "LoginName"));
		
	}
	@Override
	public List<User> listAllUsers(String orderBy) throws PersistentException {
		logger.info("listAllUsers(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listUserByQuery("User.loginName = User.loginName", orderBy));
		
	}
}
