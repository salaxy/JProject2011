package de.fhb.jproject.controller.web.actions.document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
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
 * Action, die beim Download eines Dokuments angesprochen wird
 *  <br/> <br/>
 * 
 * Parameter:  <br/>
 * Aktueller User: Session -> aktUser <br/>
 * Aktuelles Project: Session -> aktProject <br/>
 * documentId(Id des Documents): request -> documentId <br/>
 *  <br/>
 * 
 * Rechteüberprüfung für GUI: <br/>
 * keine <br/>
 *  <br/>
 * 
 * Managermethoden: <br/>
 * downloadDocu <br/>
 *  <br/>
 *  
 * Beispiel-Aufruf: <br/>
 * do=DownloadDocuAction&documentId=1  <br/>
 *  <br/>
 *  
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 * 
 */
public class DownloadDocuAction extends HttpRequestActionBase {

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
			logger.debug("Parameter: "
					+ "String documentId(" + req.getParameter("documentId")
					);

			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int documentId = 0;
			try {
				documentId = Integer.valueOf(req.getParameter("documentId"));
			} catch (NumberFormatException e) {
				logger.error("Konnte DocumentID nicht entziffern! ", e);
				throw new ProjectException("Ungültige DocumentID!");
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
			if(!mainManager.getGlobalRolesManager().isAllowedDownloadDocuAction(aktUser)){
				//RECHTE-ABFRAGE Projekt
				if(!mainManager.getProjectRolesManager().isAllowedDownloadDocuAction(aktUser, aktProject.getName())){
					throw new ProjectException("Sie haben keine Rechte zum download dieses Documents!");
				}			
			}
			//Manager in aktion
			myfile = mainManager.getDocumentManager().downloadDocu(documentId, aktProject.getName());
			
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
				logger.error("Konnte File nicht lesen! "+e.getMessage(), e);
				throw new ProjectException("Konnte File nicht lesen!");
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
					throw new ProjectException("Konnte Stream nicht schließen!");
				}
			}

		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
