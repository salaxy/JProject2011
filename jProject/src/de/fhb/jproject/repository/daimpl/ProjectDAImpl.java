/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;

import de.fhb.jproject.data.Project;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.daoimpl.ProjectDAOImpl;

/**
 *
 * @author MacYser
 */
public class ProjectDAImpl  extends ProjectDAOImpl implements ProjectDA {
	private static final Logger logger = Logger.getLogger(ProjectDAImpl.class);
	
	public ProjectDAImpl(){
		logger.info(" new ProjectDAImpl()");
	}

	@Override
	public void delete(String projectName) throws PersistentException{
		logger.info("delete(String projectName)");
		logger.debug("String projectName("+projectName+")");
		delete(loadProjectByORMID(projectName));
	}
	@Override
	public List<Project> listAllProjects() throws PersistentException {
		logger.info("listAllProjects()");
		
		return Arrays.asList(listProjectByQuery("Project.name = Project.name", "Name"));
		
	}
	
	@Override
	public List<Project> listAllProjects(String orderBy) throws PersistentException {
		logger.info("listAllProjects(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listProjectByQuery("Project.name = Project.name", orderBy));
	}

	@Override
	public List<Project> listAllProjectsLike(String searchValue)throws PersistentException {
		logger.info("listAllProjectsLike(String searchValue)");
		logger.debug("String searchValue("+searchValue+")");
		
		return Arrays.asList(listProjectByQuery("Name LIKE '%"+searchValue+"%'","Name"));
	}
	
	
	
}
