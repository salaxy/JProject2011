/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Project;
import de.fhb.jproject.repository.dao.ProjectDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface ProjectDA extends ProjectDAO{
	/**
	 * 
	 * @param projectName
	 * @throws PersistentException
	 */
	public void delete(String projectName) throws PersistentException;
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	public List<Project> listAllProjects() throws PersistentException;
	/**
	 * 
	 * @param orderBy
	 * @return
	 * @throws PersistentException
	 */
	public List<Project> listAllProjects(String orderBy) throws PersistentException;
	/**
	 * 
	 * @param searchValue
	 * @return
	 * @throws PersistentException
	 */
	public List<Project> listAllProjectsLike(String searchValue) throws PersistentException;
}
