/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Comment;
import de.fhb.jproject.repository.dao.CommentDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface CommentDA extends CommentDAO{
	public List<Comment> listAllComments() throws PersistentException;
	public List<Comment> listAllComments(String orderBy) throws PersistentException;
	
	public List<Comment> listAllCommentsToDocument(int documentId) throws PersistentException;
	public List<Comment> listAllCommentsToSourcecode(int sourcecodeId) throws PersistentException;
	public List<Comment> listAllCommentsToTask(int taskId) throws PersistentException;
	public List<Comment> listAllCommentsToProject(String projectName) throws PersistentException;
}
