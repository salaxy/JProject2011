/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.daoimpl.MemberDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class MemberDAImpl  extends MemberDAOImpl implements MemberDA {
	private static final Logger logger = Logger.getLogger(MemberDAImpl.class);
	
	/**
	 * 
	 */
	public MemberDAImpl(){
		logger.info(" new MemberDAImpl()");
	}

	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<Member> listAllMembers() throws PersistentException {
		logger.info("listAllMembers()");
		//SELECT * FROM `Member` WHERE NOT Project IS NULL Order By Project
		return Arrays.asList(listMemberByQuery("NOT Project IS NULL", "Project"));
	}
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<Member> listAllMembers(String orderBy) throws PersistentException {
		logger.info("listAllMembers(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listMemberByQuery("NOT Project IS NULL", orderBy));
		
	}
	
	
}
