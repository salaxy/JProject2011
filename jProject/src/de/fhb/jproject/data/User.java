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
 * Der User stellt jeglichen Benutzer des System dar mit nötigen Daten zum Einloggen und zum Identifizieren.
 */
public class User implements Serializable {
	public User() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_USER_MEMBER) {
			return ORM_member;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_USER_COMMENT) {
			return ORM_comment;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_USER_ICQ) {
			return ORM_iCQ;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_USER_SKYPE) {
			return ORM_skype;
		}
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_USER_TELEFON) {
			return ORM_telefon;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String loginName;
	
	private String password;
	
	private String vorname;
	
	private String nachname;
	
	private String sprache = "Deutsch";
	
	private String globalRole = "Member";
	
	private java.util.Set ORM_member = new java.util.HashSet();
	
	private java.util.Set ORM_comment = new java.util.HashSet();
	
	private java.util.Set ORM_iCQ = new java.util.HashSet();
	
	private java.util.Set ORM_skype = new java.util.HashSet();
	
	private java.util.Set ORM_telefon = new java.util.HashSet();
	
	public void setLoginName(String value) {
		this.loginName = value;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public String getORMID() {
		return getLoginName();
	}
	
	/**
	 * Passwort zum Einloggen in das System
	 */
	public void setPassword(String value) {
		this.password = value;
	}
	
	/**
	 * Passwort zum Einloggen in das System
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Vorname des Useres
	 */
	public void setVorname(String value) {
		this.vorname = value;
	}
	
	/**
	 * Vorname des Useres
	 */
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * Nachname des Users
	 */
	public void setNachname(String value) {
		this.nachname = value;
	}
	
	/**
	 * Nachname des Users
	 */
	public String getNachname() {
		return nachname;
	}
	
	/**
	 * Spracheinstellung des Users
	 */
	public void setSprache(String value) {
		this.sprache = value;
	}
	
	/**
	 * Spracheinstellung des Users
	 */
	public String getSprache() {
		return sprache;
	}
	
	/**
	 * Globale Rolle des Users im System
	 */
	public void setGlobalRole(String value) {
		this.globalRole = value;
	}
	
	/**
	 * Globale Rolle des Users im System
	 */
	public String getGlobalRole() {
		return globalRole;
	}
	
	private void setORM_Member(java.util.Set value) {
		this.ORM_member = value;
	}
	
	private java.util.Set getORM_Member() {
		return ORM_member;
	}
	
	public final de.fhb.jproject.data.MemberSetCollection member = new de.fhb.jproject.data.MemberSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_USER_MEMBER, de.fhb.jproject.data.ORMConstants.KEY_MEMBER_USER, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Comment(java.util.Set value) {
		this.ORM_comment = value;
	}
	
	private java.util.Set getORM_Comment() {
		return ORM_comment;
	}
	
	public final de.fhb.jproject.data.CommentSetCollection comment = new de.fhb.jproject.data.CommentSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_USER_COMMENT, de.fhb.jproject.data.ORMConstants.KEY_COMMENT_USER, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_iCQ(java.util.Set value) {
		this.ORM_iCQ = value;
	}
	
	private java.util.Set getORM_iCQ() {
		return ORM_iCQ;
	}
	
	public final de.fhb.jproject.data.ICQSetCollection iCQ = new de.fhb.jproject.data.ICQSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_USER_ICQ, de.fhb.jproject.data.ORMConstants.KEY_ICQ_USERLOGINNAME, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Skype(java.util.Set value) {
		this.ORM_skype = value;
	}
	
	private java.util.Set getORM_Skype() {
		return ORM_skype;
	}
	
	public final de.fhb.jproject.data.SkypeSetCollection skype = new de.fhb.jproject.data.SkypeSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_USER_SKYPE, de.fhb.jproject.data.ORMConstants.KEY_SKYPE_USERLOGINNAME, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Telefon(java.util.Set value) {
		this.ORM_telefon = value;
	}
	
	private java.util.Set getORM_Telefon() {
		return ORM_telefon;
	}
	
	public final de.fhb.jproject.data.TelefonSetCollection telefon = new de.fhb.jproject.data.TelefonSetCollection(this, _ormAdapter, de.fhb.jproject.data.ORMConstants.KEY_USER_TELEFON, de.fhb.jproject.data.ORMConstants.KEY_TELEFON_USERLOGINNAME, de.fhb.jproject.data.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getLoginName());
	}
	
}
