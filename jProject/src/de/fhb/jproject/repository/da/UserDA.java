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
	/**
	 * 
	 * @param loginName
	 * @throws PersistentException
	 */
	public void delete(String loginName) throws PersistentException;
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<User> listAllUsers() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<User> listAllUsers(String orderBy) throws PersistentException;
	/**
	 * 
	 * @param searchValue
	 * @return
	 * @throws PersistentException
	 */
	public List<User> listAllUsersLike(String searchValue) throws PersistentException;
}
