/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.ProjectRoles;
import de.fhb.jproject.repository.da.ProjectRolesDA;
import de.fhb.jproject.repository.daoimpl.ProjectRolesDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class ProjectRolesDAImpl  extends ProjectRolesDAOImpl implements ProjectRolesDA {
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(ProjectRolesDAImpl.class);
	
	public ProjectRolesDAImpl(){
		logger.info(" new ProjectRolesDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.error("Kann Session nicht anlegen! ", ex);// TODO maybe FATAL
        }
	}

	public List<ProjectRoles> listAllProjectRoles() throws PersistentException {
		logger.info("listAllProjectRoles()");
		
		return Arrays.asList(listProjectRolesByQuery("ProjectRoles.role = ProjectRoles.role", "Role"));
		
	}
	public List<ProjectRoles> listAllProjectRoles(String orderBy) throws PersistentException {
		logger.info("listAllProjectRoles(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listProjectRolesByQuery("ProjectRoles.role = ProjectRoles.role", orderBy));
		
	}

	
}
