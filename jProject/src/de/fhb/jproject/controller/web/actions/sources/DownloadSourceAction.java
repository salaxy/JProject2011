package de.fhb.jproject.controller.web.actions.sources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.controller.web.actions.document.ShowAllDocuAction;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class DownloadSourceAction extends HttpRequestActionBase {


	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllDocuAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			/*TODO logger.debug("Parameter: "
					+ "String documentId(" + req.getParameter("documentId") + "), "
					+ "String inhalt(" + req.getParameter("inhalt") + ")"
					);
			*/
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int sourcecodeId = 0;
			try {
				sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
			BufferedInputStream buf=null;
			ServletOutputStream myOut=null;
			File myfile = null;
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedDownloadSourceAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedDownloadSourceAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum downloaden dieses Sourcecodes!");
					}			
				}
				//Manager in aktion
				myfile = mainManager.getSourceManager().downloadSource(sourcecodeId, aktProject.getName());
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			try{

				myOut = resp.getOutputStream( );


				//set response headers
				resp.setContentType("text/plain");

				resp.addHeader("Content-Disposition", 
							   "attachment; filename="+myfile.getName());

				resp.setContentLength( (int) myfile.length( ) );

				FileInputStream input = new FileInputStream(myfile);
				buf = new BufferedInputStream(input);
				int readBytes = 0;

				//read from the file; write to the ServletOutputStream
				while((readBytes = buf.read( )) != -1){
					myOut.write(readBytes);
				}
			} catch (IOException e){
				logger.error("Konnte File nicht schreiben! "+e.getMessage(), e);
			} finally {
				//close the input/output streams
				try {
					if (myOut != null){
						myOut.close( );
					}
					if (buf != null){
						buf.close( );
					}
				} catch (IOException e) {
					logger.error("Konnte Stream nicht schließen! "+e.getMessage(), e);
				}
			}

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
	}
}
