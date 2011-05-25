package de.fhb.commons.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.catalina.servlets.WebdavServlet;

/**
 * @author berdux
 *
 */
public abstract class HttpServletControllerBase extends HttpServlet {
	protected HashMap actions;
	  
	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig conf) throws ServletException {
			HttpRequestActionBase action = null;
			actions = new HashMap();
			
		    // ... erzeuge deine Aktionen
		    // action = new MyAction();
			// ... und fuege Sie unter dem aufzurufenden Namen 
			// der HashMap hinzu. Es handelt sich hier um eine 
			// vereinfachte Factory, die eine Aktion ueber die 
			// Namensgebung zurueck liefert
		    // actions.put("meineAktion", action);
		    // ... und das mit allen Aktionen, die durch das 
			// Servelt verwaltet werden sollen
		    // ...  
	}
	
	  
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws IOException, ServletException {
	
	    // Zunaechst wird die URL analysiert,
		// um die Operation, die ausgefueht werden soll zu bestimmen
	    String op = getOperation(req);
	    // dann wird die entsprechende Aktion aus der Map geholt ...
	    HttpRequestActionBase action = (HttpRequestActionBase)actions.get(op);
	    // ... und angestossen
	    action.perform(req, resp);
	}
	  
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws IOException, ServletException {
	
	    // Zunaechst wird die URL analysiert,
		// um die Operation, die ausgefueht werden soll zu bestimmen
	    String op = getOperation(req);
	    // dann wird die entsprechende Aktion aus der Map geholt ...
	    HttpRequestActionBase action = (HttpRequestActionBase)actions.get(op);
	    // ... und angestossen
	    action.perform(req, resp);
	}
	
	/** Methode muss noch definiert werden, um die Kennung der 
	  * Operation aus der URL zu lesen
	  * @param req Http-Request
	  * @return Name der Aktion, die ausgefuehrt werden soll
	  */
	protected abstract String getOperation(HttpServletRequest req);
}
