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

import org.orm.*;

/**
 * 
 * @author MacYser
 */
public class TelefonSetCollection extends org.orm.util.ORMSet {
	/**
	 * 
	 * @param owner
	 * @param adapter
	 * @param ownerKey
	 * @param targetKey
	 * @param collType
	 */
	public TelefonSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	/**
	 * 
	 * @param owner
	 * @param adapter
	 * @param ownerKey
	 * @param collType
	 */
	public TelefonSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persisten objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(Telefon value) {
		if (value != null) {
			super.add(value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(Telefon value) {
		super.remove(value, value._ormAdapter);
	}
	
	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Telefon value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public Telefon[] toArray() {
		return (Telefon[]) super.toArray(new Telefon[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>telNumber</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Telefon[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>telNumber</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Telefon[] toArray(String propertyName, boolean ascending) {
		return (Telefon[]) super.toArray(new Telefon[size()], propertyName, ascending);
	}
	
	/**
	 * 
	 * @return
	 * @throws PersistentException
	 */
	protected PersistentManager getPersistentManager() throws PersistentException {
		return de.fhb.jproject.data.JProjectPersistentManager.instance();
	}
	
}

