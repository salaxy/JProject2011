/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.daimpl;

import de.fhb.jproject.data.JProjectPersistentManager;
import de.fhb.jproject.data.Task;
import de.fhb.jproject.repository.da.TaskDA;
import de.fhb.jproject.repository.daoimpl.TaskDAOImpl;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.orm.PersistentException;
import org.orm.PersistentSession;

/**
 *
 * @author MacYser
 */
public class TaskDAImpl  extends TaskDAOImpl implements TaskDA {
	private PersistentSession session = null;
	private static final Logger logger = Logger.getLogger(TaskDAImpl.class);
	
	public TaskDAImpl(){
		logger.info(" new TaskDAImpl()");
		try {
            session = JProjectPersistentManager.instance().getSession();
        } catch (PersistentException ex) {
            //Kann session nicht anlegen.
            logger.error("Kann Session nicht anlegen! ", ex);// TODO maybe FATAL
        }
	}

	public List<Task> listAllTasks() throws PersistentException {
		logger.info("listAllTasks()");
	
		return Arrays.asList(listTaskByQuery("Task.id = Task.id", "ID"));
		
	}
	public List<Task> listAllTasks(String orderBy) throws PersistentException {
		logger.info("listAllTasks(String orderBy)");
		logger.debug("String orderBy("+orderBy+")");
		
		return Arrays.asList(listTaskByQuery("Task.id = Task.id", orderBy));
		
	}
	
}
