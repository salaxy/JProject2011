/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.repository.da.DocumentDA;
import de.fhb.jproject.repository.daoimpl.DocumentDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class DocumentDAImpl  extends DocumentDAOImpl implements DocumentDA {
	private static final Logger logger = Logger.getLogger(DocumentDAImpl.class);
	
	public DocumentDAImpl(){
		logger.info(" new DocumentDAImpl()");
	}

	@Override
	public List<Document> listAllDocuments() throws PersistentException {
		logger.info("listAllDocuments()");
		
		return Arrays.asList(listDocumentByQuery("Document.id = Document.id", "ID"));
		
	}
	@Override
	public List<Document> listAllDocuments(String orderBy) throws PersistentException {
		logger.info("listAllDocuments(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listDocumentByQuery("Document.id = Document.id", orderBy));
		
	}
	
}
