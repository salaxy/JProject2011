/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.repository.da;

import de.fhb.jproject.data.Task;
import de.fhb.jproject.repository.dao.TaskDAO;
import java.util.List;
import org.orm.PersistentException;

/**
 *
 * @author MacYser
 */
public interface TaskDA extends TaskDAO{
	public List<Task> listAllTasks() throws PersistentException;
	public List<Task> listAllTasks(String orderBy) throws PersistentException;
}
