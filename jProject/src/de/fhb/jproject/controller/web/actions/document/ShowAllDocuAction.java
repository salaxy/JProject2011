package de.fhb.jproject.controller.web.actions.document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Document;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class ShowAllDocuAction extends HttpRequestActionBase {

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
		List<Document> documentList = null;
		Document document = null;
		int documentId = 0;
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int documentId(" + req.getParameter("taskId") + ")"
					);
			
			
			try {
				documentList=mainManager.getDocumentManager().showAllDocu((User)session.getAttribute("aktUser"), 
																   ((Project)session.getAttribute("aktProject")).getName());
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			try {
				//Wenn documentId == 0 dann gib mir den ersten
				if (0 == Integer.valueOf(req.getParameter("documentId"))) {
					documentId = documentList.get(0).getId();
				}else{
					documentId = Integer.valueOf(req.getParameter("documentId"));
				}
			} catch (IllegalArgumentException e) {
				throw new ProjectException("DocumentID ungültig "+e);
			}catch(NullPointerException e){
				logger.error("Keine Dokumente vorhanden!"+e.getMessage(), e);
			}
			
			
			
			try {
				document = mainManager.getDocumentManager().showDocu((User)session.getAttribute("aktUser"), 
						 ((Project)session.getAttribute("aktProject")).getName(),
						 documentId);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			//setzen der Parameter
			req.setAttribute("documentList", documentList);
			req.setAttribute("document", document);
			
			
			req.setAttribute("contentFile", "showAllDocu.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
