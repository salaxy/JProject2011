/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.CommentProject;
import de.fhb.jproject.repository.dao.CommentProjectDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface CommentProjectDA extends CommentProjectDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<CommentProject> listAllCommentProjects() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<CommentProject> listAllCommentProjects(String orderBy) throws PersistentException;
}
