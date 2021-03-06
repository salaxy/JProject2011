/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.repository.da.SourcecodeDA;
import de.fhb.jproject.repository.daoimpl.SourcecodeDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class SourcecodeDAImpl  extends SourcecodeDAOImpl implements SourcecodeDA {
	private static final Logger logger = Logger.getLogger(SourcecodeDAImpl.class);
	
	/**
	 * 
	 */
	public SourcecodeDAImpl(){
		logger.info(" new SourcecodeDAImpl()");
	}

	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<Sourcecode> listAllSourcecodes() throws PersistentException {
		logger.info("listAllSourcecodes()");
		
		return Arrays.asList(listSourcecodeByQuery("Sourcecode.id = Sourcecode.id", "ID"));
		
	}
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<Sourcecode> listAllSourcecodes(String orderBy) throws PersistentException {
		logger.info("listAllSourcecodes(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listSourcecodeByQuery("Sourcecode.id = Sourcecode.id", orderBy));
		
	}
	
	
}
