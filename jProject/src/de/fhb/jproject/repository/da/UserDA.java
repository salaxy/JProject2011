/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.User;
import de.fhb.jproject.repository.dao.UserDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface UserDA extends UserDAO{
	public void delete(String loginName) throws PersistentException;
	public List<User> listAllUsers() throws PersistentException;
	public List<User> listAllUsers(String orderBy) throws PersistentException;
}
