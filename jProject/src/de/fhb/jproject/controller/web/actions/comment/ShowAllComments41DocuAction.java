package de.fhb.jproject.controller.web.actions.comment;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Comment;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;


/**
 * Action die angesprochen wenn zu einem Dokument alle Kommentare angezeigt werden
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=ShowAllComments41Docu&documentId=1&projectName=ProjectName
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class ShowAllComments41DocuAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllComments41DocuAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException {
		
		HttpSession session = req.getSession();		
		List<Comment> commentList=null;
		
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");

		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					+ "String documentId(" + req.getParameter("documentId") + ")"
					);	
					
			//Manager in aktion
			try{
				commentList=mainManager.getCommentManager().showAllComments41Docu((User)session.getAttribute("aktUser"),
					req.getParameter("projectName")
					,Integer.valueOf(req.getParameter("documentId"))
					);
				
			}catch(IllegalArgumentException e){
				throw new ProjectException("DokumentId fehlerhaft! "+ e.getMessage());
			}
			
//			for( Comment c : commentList){
//				System.out.println("Comment: "+ c.getId()+" "+ c.getEntry());
//			}		
			
			
			//setzen der Parameter
			req.setAttribute("commentList", commentList);
			req.setAttribute("contentFile", "comment.jsp");
			

		}catch (ProjectException e) {
			
			logger.error(e.getMessage());
			req.setAttribute("contentFile", e.getMessage());
			req.setAttribute("errorString", e.getMessage());
			
		}catch(NullPointerException e){
			
			logger.error(e.getMessage());
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
			
		}
	}
}
