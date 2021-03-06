/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.fhb.jproject.controller.web;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.commons.web.HttpServletControllerBase;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41DocuAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41ProjectAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41SourceAction;
import de.fhb.jproject.controller.web.actions.comment.ShowAllComments41TaskAction;
import de.fhb.jproject.controller.web.actions.document.AddNewDocuAction;
import de.fhb.jproject.controller.web.actions.document.DownloadDocuAction;
import de.fhb.jproject.controller.web.actions.document.UpdateDocuAction;
import de.fhb.jproject.controller.web.actions.sources.AddNewSourceAction;
import de.fhb.jproject.controller.web.actions.sources.DownloadSourceAction;
import de.fhb.jproject.controller.web.actions.sources.UpdateSourceAction;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.MemberSetCollection;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

/**
 * 
 * DataServlet ist zum Verwalten von POST Requests.
 * Dieses Servlet is spezialisiert auf alle Anfragen die speziell die Übermittlung von Daten/JSONObjekte betreffen.
 * 
 * @author  Michael Koppen <koppen@fh-brandenburg.de>
 * @author  Tino Reuschel <reuschel@fh-brandenburg.de>
 * @author  Andy Klay <klay@fh-brandenburg.de>
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServletControllerBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(JProjectServlet.class);
	/** 
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param req 
	 * @param resp 
	 * @param session 
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		if (!(session.getAttribute("aktUser")==null)) {	
			synchronized(session){
				
				String aktUser = (String) session.getAttribute("aktUser");
				MemberSetCollection ownProjectList = null;
				System.out.println("MainManager: "+session.getAttribute("mainManager"));
				
				try {
					if(!mainManager.getGlobalRolesManager().isAllowedShowAllOwnProjectsAction(aktUser)){
						throw new ProjectException("Sie haben keine Rechte zum anzeigen aller eigenen Projekte!");		
					}
					//Manager in aktion
					ownProjectList = mainManager.getProjectManager().showAllOwnProjects(aktUser);
				} catch (ProjectException ex) {
					logger.error(ex.getMessage(), ex);
					req.setAttribute("contentFile", "error.jsp");
					req.setAttribute("errorString", ex.getMessage());
				} catch(NullPointerException e){
					logger.error(e.getMessage(), e);
				}
				//Show all other loggedIn-Stuff...
				//Session fuer topNaviLinks
				session.setAttribute("ownProjectSet", ownProjectList.getCollection());


			}
		}
	}

	/** 
	 * Handles the HTTP <code>GET</code> method.
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
		List<FileItem> fields = null;
		String ops = "";
		System.out.println("OP: "+req.getParameter("do"));
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			mainManager = (MainManager)session.getAttribute("mainManager");
			//Player fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
		}
		
		if (isMultipartContent) {
				
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				
				fields = upload.parseRequest(req);
			} catch (FileUploadException e) {
				System.out.println("Failed to Parse Data");
			}
			for (FileItem fileItem : fields) {
				System.out.println("FieldName: "+fileItem.getFieldName());
				if (fileItem.getFieldName().equals("do")) {
					System.out.println("name: "+fileItem.getString());
					ops = fileItem.getString();
				}

			}
			req.setAttribute("data", fields);
			
			
			// Zunaechst wird die URL analysiert,
			// um die Operation, die ausgefueht werden soll zu bestimmen
			String op = ops;
			// dann wird die entsprechende Aktion aus der Map geholt ...
			HttpRequestActionBase action = (HttpRequestActionBase)actions.get(op);
			// ... und angestossen
			try {
				action.perform(req, resp);
				processRequest(req, resp, session);
			} catch (NullPointerException e) {
				logger.error(e.getMessage(), e);
				req.setAttribute("triedLogin", true);
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", "ERROR 404 - Konnte Seite nicht finden!");
			}
			logger.info("sending contentFile: "+req.getAttribute("contentFile"));
			logger.info("sending naviFile: "+req.getAttribute("naviFile"));

			if (resp.getHeader("Location") == null) {
				RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
				reqDisp.forward(req, resp);
			}
			
		}else{
			super.doGet(req, resp);
		}
		logger.info("--------------------------------------------------------------------------------------");
		
	}

	/** 
	 * Handles the HTTP <code>POST</code> method.
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(req);
		List<FileItem> fields = null;
		String ops = "";
		System.out.println("OP: "+req.getParameter("do"));
		//Session holen
		HttpSession session = req.getSession();
		synchronized(session){
			mainManager = (MainManager)session.getAttribute("mainManager");
			//Player fuer die Session erzeugen falls noch nicht erzeugt
			if (session.getAttribute("mainManager") == null) {
				mainManager = new MainManager();

				//HttpSession ist nicht Threadsave deswegn Synchronized

				session.setAttribute("aktUser", null);
				session.setAttribute("mainManager", mainManager);
			}
		}
		
		if (isMultipartContent) {
				
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				
				fields = upload.parseRequest(req);
			} catch (FileUploadException e) {
				System.out.println("Failed to Parse Data");
			}
			for (FileItem fileItem : fields) {
				System.out.println("FieldName: "+fileItem.getFieldName());
				if (fileItem.getFieldName().equals("do")) {
					System.out.println("name: "+fileItem.getString());
					ops = fileItem.getString();
				}

			}
			req.setAttribute("data", fields);
			
			
			// Zunaechst wird die URL analysiert,
			// um die Operation, die ausgefueht werden soll zu bestimmen
			String op = ops;
			// dann wird die entsprechende Aktion aus der Map geholt ...
			HttpRequestActionBase action = (HttpRequestActionBase)actions.get(op);
			// ... und angestossen
			try {
				action.perform(req, resp);
				processRequest(req, resp, session);
			} catch (NullPointerException e) {
				logger.error(e.getMessage(), e);
				req.setAttribute("triedLogin", true);
				req.setAttribute("contentFile", "error.jsp");
				req.setAttribute("errorString", "ERROR 404 - Konnte Seite nicht finden!");
			}
			logger.info("sending contentFile: "+req.getAttribute("contentFile"));
			logger.info("sending naviFile: "+req.getAttribute("naviFile"));

			if (resp.getHeader("Location") == null) {
				RequestDispatcher reqDisp = req.getRequestDispatcher("index.jsp");
				reqDisp.forward(req, resp);
			}
			
		}else{
			super.doPost(req, resp);
		}
		logger.info("--------------------------------------------------------------------------------------");
	}
	// <editor-fold defaultstate="collapsed" desc="Click on the + sign on the left to edit the code.">
	/** 
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}

	@Override
	protected String getOperation(HttpServletRequest req) {
		return req.getParameter("do");
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhb.music.controller.web.HttpServletManagerBase#init(javax.servlet
	 * .ServletConfig)
	 */
	public void init(ServletConfig conf) throws ServletException {
		super.init();
		HttpRequestActionBase action = null;
		actions = new HashMap();
		
		//Actions hinzufuegen
		
		// !!! Kommentar Actions !!!
		
		action = new ShowAllComments41DocuAction();
		actions.put("ShowAllComments41Docu", action);
		
		action = new ShowAllComments41ProjectAction();
		actions.put("ShowAllComments41Project", action);
		
		action = new ShowAllComments41SourceAction();
		actions.put("ShowAllComments41Source", action);
		
		action = new ShowAllComments41TaskAction();
		actions.put("ShowAllComments41Task", action);
		
		// !!! Dokument Actions !!!
		
		action = new AddNewDocuAction();
		actions.put("AddNewDocu", action);
			
		action = new DownloadDocuAction();
		actions.put("DownloadDocu", action);
		
		action = new UpdateDocuAction();
		actions.put("UpdateDocu", action);
		
		// !!! Source Actions !!!
		
		
		action = new AddNewSourceAction();
		actions.put("AddNewSource", action);		
		
		action = new DownloadSourceAction();
		actions.put("DownloadSource", action);	
		
		action = new UpdateSourceAction();
		actions.put("UpdateSource", action);	
		
		
	}// </editor-fold>
}
