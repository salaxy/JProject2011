/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Skype;
import de.fhb.jproject.repository.dao.SkypeDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface SkypeDA extends SkypeDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<Skype> listAllSkypes() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<Skype> listAllSkypes(String orderBy) throws PersistentException;
}
