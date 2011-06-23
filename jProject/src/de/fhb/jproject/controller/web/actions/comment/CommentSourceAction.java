package de.fhb.jproject.controller.web.actions.comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import org.apache.log4j.Level;


/**
 * Action die angesprochen wird wenn ein Sourcecode kommentiert wird
 * 
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=CommentSource&sourcecodeId=1&inhalt=GuterSource
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
public class CommentSourceAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(CommentSourceAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{
		logger.setLevel(Level.DEBUG);
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int sourcecodeId(" + req.getParameter("sourcecodeId") + "), "
					+ "String entry(" + req.getParameter("entry") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int sourcecodeId = 0;
			try {
				sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte SourcecodeID nicht entziffern! ", e);
				throw new ProjectException("Ungültige SourcecodeID!");
			}
			String entry = req.getParameter("entry");
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			if(!mainManager.getGlobalRolesManager().isAllowedCommentSourceAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedCommentSourceAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum hinzufuegen eines SourcecodeComments!");
				}			
			}
			//Manager in aktion
			mainManager.getCommentManager().commentSource(aktUser, sourcecodeId, entry);
			
			try {
				String[] param = new String[1];
				param[0] = "sourcecodeId="+sourcecodeId;
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllSource", param);
			} catch (IOException e) {
				logger.error("Konnte Redirect nicht ausführen! "+e.getMessage(), e);
			}
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
