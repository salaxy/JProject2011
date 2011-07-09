/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Termin;
import de.fhb.jproject.repository.da.TerminDA;
import de.fhb.jproject.repository.daoimpl.TerminDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class TerminDAImpl  extends TerminDAOImpl implements TerminDA {
	private static final Logger logger = Logger.getLogger(TerminDAImpl.class);
	
	/**
	 * 
	 */
	public TerminDAImpl(){
		logger.info(" new TerminDAImpl()");
	}

	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<Termin> listAllTermine() throws PersistentException {
		logger.info("listAllTermins()");
		
		return Arrays.asList(listTerminByQuery("Termin.id = Termin.id", "id"));
		
	}
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<Termin> listAllTermine(String orderBy) throws PersistentException {
		logger.info("listAllTermins(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listTerminByQuery("Termin.id = Termin.id", orderBy));
		
	}
	
}
