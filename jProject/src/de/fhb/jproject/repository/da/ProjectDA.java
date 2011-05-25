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
	public void delete(String projectName) throws PersistentException;
	public List<Project> listAllProjects() throws PersistentException;
	public List<Project> listAllProjects(String orderBy) throws PersistentException;
	List<Project> listAllOwnProjects(String userLoginName)throws PersistentException;
}
