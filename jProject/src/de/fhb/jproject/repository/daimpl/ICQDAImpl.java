/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.ICQ;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.ICQDA;
import de.fhb.jproject.repository.daoimpl.ICQDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class ICQDAImpl  extends ICQDAOImpl implements ICQDA {
	private static final Logger logger = Logger.getLogger(ICQDAImpl.class);
	
	public ICQDAImpl(){
		logger.info(" new ICQDAImpl()");
	}

	@Override
	public List<ICQ> listAllICQs() throws PersistentException {
		logger.info("listAllICQs()");
		return Arrays.asList(listICQByQuery("ICQ.icqNumber = ICQ.icqNumber", "ICQNumber"));
		
	}
	@Override
	public List<ICQ> listAllICQs(String orderBy) throws PersistentException {
		logger.info("listAllICQs(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		return Arrays.asList(listICQByQuery("ICQ.icqNumber = ICQ.icqNumber", orderBy));
	}
}
