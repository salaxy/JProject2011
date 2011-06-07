package de.fhb.jproject.controller.web.actions.sources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class ShowAllSourceAction extends HttpRequestActionBase {


	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		//TODO ALLE GLOBALEN ACTIONS IN DER ART BEARBEITEN
		//hier alles rein, was für die Aktion notwendig ist
		//daten holen
		//externe API abfragen
		
		/*TODO DELETE ACTION
		ShowSourceAction showSourceAction = new ShowSourceAction();
		showSourceAction.perform(req, resp);
		
		 * 
		 */
		// bo benutzen
		req.setAttribute("xxx", "yyy");
		
		req.setAttribute("contentFile", "showAllSource.jsp");
		
		
		/*
		 * catch(Exception e){
		 *	req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		 * }
		 */
		
	}
}
