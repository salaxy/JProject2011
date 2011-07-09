/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Member;
import de.fhb.jproject.repository.dao.MemberDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface MemberDA extends MemberDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<Member> listAllMembers() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<Member> listAllMembers(String orderBy) throws PersistentException;
}
