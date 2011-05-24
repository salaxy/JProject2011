/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Telefon;
import de.fhb.jproject.repository.da.TelefonDA;
import de.fhb.jproject.repository.daoimpl.TelefonDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class TelefonDAImpl  extends TelefonDAOImpl implements TelefonDA {
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(TelefonDAImpl.class);
	
	public TelefonDAImpl(){
		logger.info(" new TelefonDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.error("Kann Session nicht anlegen! ", ex);// TODO maybe FATAL
        }
	}

	public List<Telefon> listAllTelefons() throws PersistentException {
		logger.info("listAllTelefons()");
		
		return Arrays.asList(listTelefonByQuery("Telefon.telNumber = Telefon.telNumber", "TelNumber"));
		
	}
	public List<Telefon> listAllTelefons(String orderBy) throws PersistentException {
		logger.info("listAllTelefons(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listTelefonByQuery("Telefon.telNumber = Telefon.telNumber", orderBy));
		
	}
}
