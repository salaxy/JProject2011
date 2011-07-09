/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.ICQ;
import de.fhb.jproject.repository.dao.ICQDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface ICQDA extends ICQDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<ICQ> listAllICQs() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<ICQ> listAllICQs(String orderBy) throws PersistentException;
}
