/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.GlobalRoles;
import de.fhb.jproject.repository.dao.GlobalRolesDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface GlobalRolesDA extends GlobalRolesDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<GlobalRoles> listAllGlobalRoles() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<GlobalRoles> listAllGlobalRoles(String orderBy) throws PersistentException;
}
