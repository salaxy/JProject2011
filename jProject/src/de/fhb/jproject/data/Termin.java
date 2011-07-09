/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package de.fhb.jproject.data;

import java.io.Serializable;
/**
 * Ein Termin ist ein festgelegtes Kalenderdatum.
 */
public class Termin implements Serializable {
	/**
	 * 
	 */
	public Termin() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_TERMIN_TASK) {
			return ORM_task;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private java.util.Date termin;
	
	private java.util.Set ORM_task = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getORMID() {
		return getId();
	}
	
	/**
	 * Datum
	 * 
	 * @param value 
	 */
	public void setTermin(java.util.Date value) {
		this.termin = value;
	}
	
	/**
	 * Datum
	 * 
	 * @return 
	 */
	public java.util.Date getTermin() {
		return termin;
	}
	
	private void setORM_Task(java.util.Set value) {
		this.ORM_task = value;
	}
	
	private java.util.Set getORM_Task() {
		return ORM_task;
	}
	
	/**
	 * 
	 */
	public final de.fhb.jproject.data.TaskSetCollection task = new de.fhb.jproject.data.TaskSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_TERMIN_TASK, de.fhb.jproject.data.ORMConstants.KEY_TASK_TERMIN, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(getId());
	}
	
}
