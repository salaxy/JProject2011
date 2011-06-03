package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.project.AddMemberAction;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;


/**
 * Action die angesprochen wird wenn eine Aufgabe einem Projekt hingefügt wird
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 * STATUS:  FREIGEGEBEN 
 * 
 * JProjectServlet?do=AddNewTask&projectName=ProjectName&titel=TestAufgabe&aufgabenStellung=Tue%20dies%20und%20das!&time=2011-06-02
 *  
 */
public class AddNewTaskAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(AddNewTaskAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + "), "
					+ "String titel(" + req.getParameter("titel") + ")"
					+ "String aufgabenStellung(" + req.getParameter("aufgabenStellung") + ")"
					+ "String time(" + req.getParameter("time") + ")"
					);
			
			//Controller holen
			mainController=(MainControl) req.getSession().getAttribute("mainController");
		
			//Controller in aktion
			mainController.getTaskcontroller().addNewTask( req.getParameter("projectName"),
					req.getParameter("titel"),
					req.getParameter("aufgabenStellung"),
					//yyyy-mm-dd <<< muss sooo aussehen
					req.getParameter("time")
					);
			
			
			//forwarden zum JSP
			forward(req, resp, "/AddNewTask.jsp");

		}catch (ProjectException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}catch (IOException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
            
		}catch(NullPointerException e){
			
			e.printStackTrace();
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
            
		}
		
	}
}
