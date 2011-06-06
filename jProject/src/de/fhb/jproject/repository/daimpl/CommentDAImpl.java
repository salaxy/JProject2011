/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.CommentDA;
import de.fhb.jproject.repository.daoimpl.CommentDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class CommentDAImpl extends CommentDAOImpl implements CommentDA {
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(CommentDAImpl.class);
	
	public CommentDAImpl(){
		logger.info(" new CommentDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.fatal("Kann Session nicht anlegen! ", ex);
        }
	}
	public List<Comment> listAllComments() throws PersistentException {
		logger.info("listAllComments()");
		
		return Arrays.asList(listCommentByQuery("Comment.id = Comment.id", "ID"));
		
	}
	public List<Comment> listAllComments(String orderBy) throws PersistentException {
		logger.info("listAllComments(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listCommentByQuery("Comment.id = Comment.id", orderBy));
		
	}
	

	
	
}
