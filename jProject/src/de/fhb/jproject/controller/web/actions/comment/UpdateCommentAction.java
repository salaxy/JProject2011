package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action die angesprochen wird wenn ein Kommentar geupdatet werden soll
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=UpdateComment&projectName=ProjectName&commentId=1&inhalt=aenderungInhalt
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class UpdateCommentAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(UpdateCommentAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		
		try {		
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int projectName(" + req.getParameter("projectName") + "), "
					+ "String commentId(" + req.getParameter("commentId") + ")"
					+ "int inhalt(" + req.getParameter("inhalt") + "), "
					);
			try{
				//Manager in aktion
				mainManager.getCommentManager().updateComment((User)session.getAttribute("aktUser")
						, req.getParameter("projectName")
						, Integer.valueOf(req.getParameter("commentId"))
						, req.getParameter("inhalt")
						);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}/*TODO IllegalArgumentE*/
			

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
