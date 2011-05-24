/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.CommentTask;
import de.fhb.jproject.repository.dao.CommentTaskDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface CommentTaskDA extends CommentTaskDAO{
	public List<CommentTask> listAllCommentTasks() throws PersistentException;
	public List<CommentTask> listAllCommentTasks(String orderBy) throws PersistentException;
}
