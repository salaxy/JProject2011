/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Sourcecode;
import de.fhb.jproject.repository.dao.SourcecodeDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface SourcecodeDA extends SourcecodeDAO{
	public List<Sourcecode> listAllSourcecodes() throws PersistentException;
	public List<Sourcecode> listAllSourcecodes(String orderBy) throws PersistentException;
}
