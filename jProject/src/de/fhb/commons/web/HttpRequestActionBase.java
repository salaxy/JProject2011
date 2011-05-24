package de.fhb.commons.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Aktion die durch Ableitung definiert werden muss.
 * 
 * Die Aktion fuehrt Operationen mit dem Modell aus, und 
 * bereitet die Daten fuer die Ausgabe auf. Als letzte Aktion sollte eine 
 * Aktion zu einer View den Request weiterleiten, wo dann das Ergebnis
 * der Aktion eingelesen und in eine (HTML-)Seite eingebunden wird.
 * 
 * @author berdux
 * @version 1.0
 */
public abstract class HttpRequestActionBase {


	/**
	 * Standard-Methode, die durch Servlet aufgerufen wird.
	 * 
	 * @param req aktueller Request der bearbeitet werden soll
	 * @param res Response-Objekt fuer die Weiterleitung zu dem View
	 * @throws ServletException 
	 */
	public abstract void perform(HttpServletRequest req, HttpServletResponse resp) throws ServletException;
	
	/**
	 * Kapselt das Weiterleiten zu einer weiteren Action oder View. Die Action/der View
	 * wird als Name angeben.
	 * 
	 * @param req aktueller Request der bearbeitet werden soll und in dem Ergebnisse der Action abgelegt sind
	 * @param resp  Response-Objekt zum Schreiben des Ergebnisses
	 * @param forwardName Name von Seite/JSP/Servlet, an die Kontrolle uebergeben wird
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String forwardName) throws ServletException, IOException {
		RequestDispatcher reqDis = req.getRequestDispatcher(forwardName);
		reqDis.forward(req, resp);
		
	}
    protected void errorforward(HttpServletRequest req, HttpServletResponse resp, String message){
        req.setAttribute("errorMessage", message);
        try {
            RequestDispatcher reqDis = req.getRequestDispatcher("/errorExample.jsp");
            reqDis.forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(HttpRequestActionBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpRequestActionBase.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
}
