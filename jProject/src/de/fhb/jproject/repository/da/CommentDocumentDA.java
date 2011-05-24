/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.CommentDocument;
import de.fhb.jproject.repository.dao.CommentDocumentDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface CommentDocumentDA extends CommentDocumentDAO{
	public List<CommentDocument> listAllCommentDocuments() throws PersistentException;
	public List<CommentDocument> listAllCommentDocuments(String orderBy) throws PersistentException;
}
