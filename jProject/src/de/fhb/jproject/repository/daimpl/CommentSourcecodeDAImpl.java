/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.CommentSourcecode;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.CommentSourcecodeDA;
import de.fhb.jproject.repository.daoimpl.CommentSourcecodeDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class CommentSourcecodeDAImpl extends CommentSourcecodeDAOImpl implements CommentSourcecodeDA{

	private static final Logger logger = Logger.getLogger(CommentSourcecodeDAImpl.class);
	
	/**
	 * 
	 */
	public CommentSourcecodeDAImpl(){
		logger.info(" new CommentSourcecodeDAImpl()");
	}

	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<CommentSourcecode> listAllCommentSourcecodes() throws PersistentException {
		logger.info("listAllCommentSourcecodes()");
		
		return Arrays.asList(listCommentSourcecodeByQuery("CommentSourcecode.sourcecodeId = CommentSourcecode.sourcecodeId", "SourcecodeID"));
		
	}
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	@Override
	public List<CommentSourcecode> listAllCommentSourcecodes(String orderBy) throws PersistentException {
		logger.info("listAllCommentSourcecodes(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listCommentSourcecodeByQuery("CommentSourcecode.sourcecodeId = CommentSourcecode.sourcecodeId", orderBy));
		
	}
}
