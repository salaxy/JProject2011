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
}
