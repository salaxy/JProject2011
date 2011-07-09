/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.ProjectRoles;
import de.fhb.jproject.repository.dao.ProjectRolesDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface ProjectRolesDA extends ProjectRolesDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<ProjectRoles> listAllProjectRoles() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<ProjectRoles> listAllProjectRoles(String orderBy) throws PersistentException;
}
