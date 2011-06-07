/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.CommentTask;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.CommentTaskDA;
import de.fhb.jproject.repository.daoimpl.CommentTaskDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class CommentTaskDAImpl extends CommentTaskDAOImpl implements CommentTaskDA{
	private static final Logger logger = Logger.getLogger(CommentTaskDAImpl.class);
	
	public CommentTaskDAImpl(){
		logger.info(" new CommentTaskDAImpl()");
	}

	@Override
	public List<CommentTask> listAllCommentTasks() throws PersistentException {
		logger.info("listAllCommentTasks()");
		
		return Arrays.asList(listCommentTaskByQuery("CommentTask.taskId = CommentTask.taskId", "TaskID"));
		
	}
	@Override
	public List<CommentTask> listAllCommentTasks(String orderBy) throws PersistentException {
		logger.info("listAllCommentTasks(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listCommentTaskByQuery("CommentTask.taskId = CommentTask.taskId", orderBy));
		
	}
}
