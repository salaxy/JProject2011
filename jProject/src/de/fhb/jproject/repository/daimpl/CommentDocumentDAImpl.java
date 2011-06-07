/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.CommentDocument;
import de.fhb.jproject.repository.da.CommentDocumentDA;
import de.fhb.jproject.repository.daoimpl.CommentDocumentDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class CommentDocumentDAImpl extends CommentDocumentDAOImpl implements CommentDocumentDA{
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(CommentDocumentDAImpl.class);
	public CommentDocumentDAImpl() {
		logger.info(" new CommentDocumentDAImpl()");
	}
	@Override
	public List<CommentDocument> listAllCommentDocuments() throws PersistentException {
		logger.info("listAllCommentDocuments()");
		
		return Arrays.asList(listCommentDocumentByQuery("CommentDocument.documentId = CommentDocument.documentId", "DocumentID"));
		
	}
	@Override
	public List<CommentDocument> listAllCommentDocuments(String orderBy) throws PersistentException {
		logger.info("listAllCommentDocuments(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listCommentDocumentByQuery("CommentDocument.documentId = CommentDocument.documentId", orderBy));
		
	}
}
