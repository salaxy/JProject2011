/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.GlobalRoles;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.GlobalRolesDA;
import de.fhb.jproject.repository.daoimpl.GlobalRolesDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class GlobalRolesDAImpl  extends GlobalRolesDAOImpl implements GlobalRolesDA {
	private static final Logger logger = Logger.getLogger(GlobalRolesDAImpl.class);
	
	/**
	 * 
	 */
	public GlobalRolesDAImpl(){
		logger.info(" new GlobalRolesDAImpl()");
	}

	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<GlobalRoles> listAllGlobalRoles() throws PersistentException {
		logger.info("listAllGlobalRoles()");
		
		return Arrays.asList(listGlobalRolesByQuery("GlobalRoles.role = GlobalRoles.role", "Role"));
		
	}
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<GlobalRoles> listAllGlobalRoles(String orderBy) throws PersistentException {
		logger.info("listAllGlobalRoles(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listGlobalRolesByQuery("GlobalRoles.role = GlobalRoles.role", orderBy));
		
	}
	
	
}
