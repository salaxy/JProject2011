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
public class CheckString {
	private static final Logger logger = Logger.getLogger(CheckString.class);
	
	public CheckString(){
		logger.setLevel(Level.DEBUG);
	}
	public void checkIT(String valueName, String stringToCheck) throws ProjectException{
		if ((valueName != null) && (stringToCheck !=null)) {
			char [] charToCheck = null;
			
			charToCheck = stringToCheck.toCharArray();
			boolean accepted = false;
			int x = 0;
			for (char c : charToCheck) {
				accepted = false;
				x = (int)c;
				logger.debug("Char: "+c);
				logger.debug("Value: "+x);
				//Ist es eine Nummer? (48-57)
				if(x<58 && x>47){
					accepted = true;
				}
				//Ist es ein Buchstabe von A-Z (65-90)
				if (accepted || (x<91 && x>64)) {
					accepted = true;
				}
				//Ist es ein Buchstabe von a-z (97-122)
				if (accepted || (x<123 && x>96)) {
					accepted = true;
				}

				if(!accepted){
					throw new ProjectException("Ungültiger "+valueName+"! Folgende Zeichen sind zugelassen: a-z, A-Z und 0-9");
				}
			}
		}else{
			throw new ProjectException("Unerlaubtes null-Value! "+valueName);
		}
		
	}
}
