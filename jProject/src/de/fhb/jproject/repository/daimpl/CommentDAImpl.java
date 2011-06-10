/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;

import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.CommentDocument;
import de.fhb.jproject.data.CommentProject;
import de.fhb.jproject.data.CommentSourcecode;
import de.fhb.jproject.data.CommentTask;
import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.repository.da.CommentDA;
import de.fhb.jproject.repository.daoimpl.CommentDAOImpl;

/**
 *
 * @author MacYser
 */
public class CommentDAImpl extends CommentDAOImpl implements CommentDA {
	private static final Logger logger = Logger.getLogger(CommentDAImpl.class); 
	
	public CommentDAImpl(){
		logger.info(" new CommentDAImpl()");
	}
	
	@Override
	public List<Comment> listAllComments() throws PersistentException {
		logger.info("listAllComments()");
		
		return Arrays.asList(listCommentByQuery("Comment.id = Comment.id", "ID"));
		
	}
	
	@Override
	public List<Comment> listAllComments(String orderBy) throws PersistentException {
		logger.info("listAllComments(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listCommentByQuery("Comment.id = Comment.id", orderBy));
	}
	
	
	@Override
	public List<Comment> listAllCommentsToDocument(int documentId)throws PersistentException {
		logger.info("listAllCommentsToDocument(int documentId)");
		logger.debug("int documentId("+documentId+")");
		
		List<Comment> list=new ArrayList<Comment>();
		CommentDocument[] commentDocuments=null;
		
		//holen der commentDocument
		commentDocuments=DAFactory.getDAFactory().getCommentDocumentDA().listCommentDocumentByQuery("DocumentID="+documentId,"CommentID" );

		//holen der comments selbst
		for(int i=0;i<commentDocuments.length;i++){
			//zur liste hinzufuegen
			list.add(getCommentByORMID(commentDocuments[i].getCommentId()));
		}
		
		return list;
	}
	
	
	@Override
	public List<Comment> listAllCommentsToSourcecode(int sourcecodeId)throws PersistentException {
		logger.info("listAllCommentsToSourcecode(int sourcecodeId)");
		logger.debug("int sourcecodeId("+sourcecodeId+")");
		
		
		List<Comment> list=new ArrayList<Comment>();
		CommentSourcecode[] commentSourcecodes=null;
		
		//holen der commentSourcecodes
		commentSourcecodes=DAFactory.getDAFactory().getCommentSourcecodeDA().listCommentSourcecodeByQuery("SourcecodeID="+sourcecodeId,"CommentID" );

		//holen der comments selbst
		for(int i=0;i<commentSourcecodes.length;i++){
			//zur liste hinzufuegen
			list.add(getCommentByORMID(commentSourcecodes[i].getCommentId()));
		}
		
		return list;
	}

	@Override
	public List<Comment> listAllCommentsToTask(int taskId)throws PersistentException {
		logger.info("listAllCommentsToTask(int taskId)");
		logger.debug("int taskId("+taskId+")");
		
		List<Comment> list=new ArrayList<Comment>();
		CommentTask[] commentTasks=null;
		
		//holen der commentTask
		commentTasks=DAFactory.getDAFactory().getCommentTaskDA().listCommentTaskByQuery("TaskID="+taskId,"CommentID" );

		//holen der comments selbst
		for(int i=0;i<commentTasks.length;i++){
			//zur liste hinzufuegen
			list.add(getCommentByORMID(commentTasks[i].getCommentId()));
		}
		
		return list;
	}
	
	@Override
	public List<Comment> listAllCommentsToProject(String projectName)throws PersistentException {
		logger.info("listAllCommentsToProject(String projectName)");
		logger.debug("String projectName("+projectName+")");
		
		List<Comment> list=new ArrayList<Comment>();
		CommentProject[] commentProjects=null;
		
		//holen der commentProject
		commentProjects=DAFactory.getDAFactory().getCommentProjectDA().listCommentProjectByQuery("project='"+projectName+"'","CommentID" );

		//holen der comments selbst
		for(int i=0;i<commentProjects.length;i++){
			//zur liste hinzufuegen
			list.add(getCommentByORMID(commentProjects[i].getCommentId()));
		}
		
		return list;
	}
	

	
	
}
