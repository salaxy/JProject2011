/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Document;
import de.fhb.jproject.repository.dao.DocumentDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface DocumentDA extends DocumentDAO{
	public List<Document> listAllDocuments() throws PersistentException;
	public List<Document> listAllDocuments(String orderBy) throws PersistentException;
}
