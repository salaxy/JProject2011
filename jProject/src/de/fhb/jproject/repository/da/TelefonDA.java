/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Telefon;
import de.fhb.jproject.repository.dao.TelefonDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface TelefonDA extends TelefonDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<Telefon> listAllTelefons() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<Telefon> listAllTelefons(String orderBy) throws PersistentException;
}
