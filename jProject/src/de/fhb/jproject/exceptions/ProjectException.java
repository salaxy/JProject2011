package de.fhb.jproject.exceptions;

/**
 * Programmspezifische Exception zur Allgemeinen Fehlerbehandlung
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class ProjectException extends Exception {

	/**
	 * Konstruktor
	 */
	public ProjectException() {
		super();
	}
	
	/**
	 * Konstruktor mit Parameter fuer die Message
	 * @param string
	 */
	public ProjectException(String string) {
		super(string);
	}
	
}
