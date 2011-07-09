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
 * ICQ stellt eine Adresse für einen Messenger dar.
 */
public class ICQ implements Serializable {
	/**
	 * 
	 */
	public ICQ() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_ICQ_USERLOGINNAME) {
			this.userLoginName = (de.fhb.jproject.data.User) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private de.fhb.jproject.data.User userLoginName;
	
	private String icqNumber;
	
	/**
	 * 
	 * @param value
	 */
	public void setIcqNumber(String value) {
		this.icqNumber = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getIcqNumber() {
		return icqNumber;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getORMID() {
		return getIcqNumber();
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setUserLoginName(de.fhb.jproject.data.User value) {
		if (userLoginName != null) {
			userLoginName.iCQ.remove(this);
		}
		if (value != null) {
			value.iCQ.add(this);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.User getUserLoginName() {
		return userLoginName;
	}
	
	/**
	 * This method is for internal use only.
	 * 
	 * @param value 
	 */
	public void setORM_UserLoginName(de.fhb.jproject.data.User value) {
		this.userLoginName = value;
	}
	
	private de.fhb.jproject.data.User getORM_UserLoginName() {
		return userLoginName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(getIcqNumber());
	}
	
}
