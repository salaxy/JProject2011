/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Termin;
import de.fhb.jproject.repository.dao.TerminDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface TerminDA extends TerminDAO{
	public List<Termin> listAllTermine() throws PersistentException;
	public List<Termin> listAllTermine(String orderBy) throws PersistentException;
}
