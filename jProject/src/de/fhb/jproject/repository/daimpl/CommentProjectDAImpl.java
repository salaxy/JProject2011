/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.CommentProject;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.CommentProjectDA;
import de.fhb.jproject.repository.daoimpl.CommentProjectDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;


/**
 *
 * @author MacYser
 */
public class CommentProjectDAImpl extends CommentProjectDAOImpl implements CommentProjectDA{

	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(CommentProjectDAImpl.class);
	
	public CommentProjectDAImpl(){
		logger.info(" new CommentProjectDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.error("Kann Session nicht anlegen! ", ex);// TODO maybe FATAL
        }
	}

	public List<CommentProject> listAllCommentProjects() throws PersistentException {
		logger.info("listAllCommentProjects()");
		
		return Arrays.asList(listCommentProjectByQuery("CommentProject.projectName = CommentProject.projectName", "ProjectName"));
		
	}
	public List<CommentProject> listAllCommentProjects(String orderBy) throws PersistentException {
		logger.info("listAllCommentProjects(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listCommentProjectByQuery("CommentProject.projectName = CommentProject.projectName", orderBy));
		
	}
}
