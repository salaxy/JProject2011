/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import de.fhb.jproject.data.DAFactory;
import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.daoimpl.ProjectDAOImpl;

/**
 *
 * @author MacYser
 */
public class ProjectDAImpl  extends ProjectDAOImpl implements ProjectDA {
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(ProjectDAImpl.class);
	
	public ProjectDAImpl(){
		logger.info(" new ProjectDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.fatal("Kann Session nicht anlegen! ", ex);
        }
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
	
	
	
}
