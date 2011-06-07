/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Skype;
import de.fhb.jproject.repository.da.SkypeDA;
import de.fhb.jproject.repository.daoimpl.SkypeDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class SkypeDAImpl  extends SkypeDAOImpl implements SkypeDA {
	private static final Logger logger = Logger.getLogger(SkypeDAImpl.class);
	
	public SkypeDAImpl(){
		logger.info(" new SkypeDAImpl()");
	}

	@Override
	public List<Skype> listAllSkypes() throws PersistentException {
		logger.info("listAllSkypes()");
		
		return Arrays.asList(listSkypeByQuery("Skype.skypeName = Skype.skypeName", "SkypeName"));
		
	}
	@Override
	public List<Skype> listAllSkypes(String orderBy) throws PersistentException {
		logger.info("listAllSkypes(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listSkypeByQuery("Skype.skypeName = Skype.skypeName", orderBy));
		
	}
}
