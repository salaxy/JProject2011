package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;
import javax.servlet.http.HttpSession;


/**
 * Action die angesprochen wird wenn ein Project kommentiert wird
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=CommentProject&projectName=ProjectName&inhalt=KickOffStarted!
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class CommentProjectAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(CommentProjectAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		HttpSession session = req.getSession();
		//Controller holen
		mainController=(MainControl) session.getAttribute("mainController");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + "), "
					+ "String inhalt(" + req.getParameter("inhalt") + ")"
					);
		
			//Controller in aktion
			mainController.getCommentController().commentProject((User)session.getAttribute("aktUser"), 
																 req.getParameter("projectName"), 
																 req.getParameter("inhalt"));
			
			

		}catch (ProjectException e) {
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jspf");
			req.setAttribute("errorString", e.getMessage());
		}catch(NullPointerException e){
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jspf");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}

}
