/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.CommentSourcecode;
import de.fhb.jproject.repository.dao.CommentSourcecodeDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface CommentSourcecodeDA extends CommentSourcecodeDAO{
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<CommentSourcecode> listAllCommentSourcecodes() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<CommentSourcecode> listAllCommentSourcecodes(String orderBy) throws PersistentException;
}
