/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.commons;

import de.fhb.jproject.exceptions.ProjectException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author MacYser
 */
public class CheckPassword {
	private static final Logger logger = Logger.getLogger(CheckString.class);
	private final int PASSWORD_LENGTH = 5;
	
	public CheckPassword(){
		logger.setLevel(Level.DEBUG);
	}
	public void checkIT(String passwort, String passwortWdhl) throws ProjectException{
		/*
		 * Passwort-Überprüfung
		 */
		/* Überprüfen ob Passwort-Parameter angegeben sind */
		if(passwort==null||passwortWdhl==null){
			throw new ProjectException("Kein Passwort oder Passwort-Wiederholung angegeben!");
		}
		/* Überprüfen ob Passwort und PasswortWdhl gleich sind */
		if(!passwort.equals(passwortWdhl)){
			throw new ProjectException("Passwort und Passwort-Wiederholung sind unterschiedlich!");
		}

		/* Überprüfen ob Passwort mind. 5 Zeichen lang ist */
		if(passwort.length() < PASSWORD_LENGTH){
			throw new ProjectException("Das Passwort muss mind. 5 Zeichen lang sein!");
		}
	}
}
