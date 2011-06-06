package de.fhb.jproject.controller.web.actions.comment;

import java.io.IOException;

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
 * Action die angesprochen wird wenn ein Sourcecode kommentiert wird
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=CommentSource&sourcecodeId=1&inhalt=GuterSource
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class CommentSourceAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(CommentSourceAction.class);

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
					+ "String sourcecodeId(" + req.getParameter("sourcecodeId") + "), "
					+ "String inhalt(" + req.getParameter("inhalt") + ")"
					);
			
			//Controller holen
			mainController=(MainControl) req.getSession().getAttribute("mainController");
		
			//Controller in aktion
			mainController.getCommentController().commentSource((User)session.getAttribute("aktUser"), req.getParameter("sourcecodeId"),
					req.getParameter("inhalt"));
			
			
			//forwarden zum JSP
//			forward(req, resp, "/CommentSourceAction.jsp");

		}catch (ProjectException e) {
			
			
			logger.error(e.getMessage());
			errorforward(req, resp, e.getMessage());
			
		}/*catch (IOException e) {
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
            
		}*/catch(NullPointerException e){
			
			
			logger.error(e.getMessage());
            errorforward(req, resp, e.getMessage());
            
		}
	}
}
