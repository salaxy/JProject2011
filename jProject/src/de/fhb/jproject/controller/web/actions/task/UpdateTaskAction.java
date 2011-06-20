package de.fhb.jproject.controller.web.actions.task;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainManager;
import java.sql.Date;
import javax.servlet.http.HttpSession;


/**
 * Action die angesprochen wird, wenn eine Task/Aufgabe geupdated wird
 * 
 * Hinweise: 
 * es sollen nur die parameter die geaendert werden mitgeben werden, andere komplett weglassen
 * d.h. also kein leerstring mitgeben sondern den parameter gar nicht uebergebn
 * so das z.b wenn der titel nicht geaendert wird req.getParameter("titel")=null ergibt
 * taskid und projectName sind aber pflichtparameter!!!
 * 
 * @micha ist auch wichtig wenn man z.b. nicht will das etwas drin steht, dann kann man dann einen leerstring mitgebn
 * also ueberpruefe ich nciht auf leerstring, weil das ja auch gewollt sein koennte,
 * gib mir irgentwann mal rueckmeldung ob das so umsetzen kannst, es waere ein leichtes es spaeter noch zu aendern
 * XXX diese nachricht spaeter loeschen
 * 
 * !!!Parameter "done" MUSS entweder der String "true" oder "false" sein!!!
 * !!!Parameter "date" MUSS die Form "yyyy-mm-dd" haben!!!
 *  
 * STATUS:	FREIGEGEBEN 
 * URL: 	JProjectServlet?do=UpdateTask&projectName=ProjectName&taskId=5&titel=DeineAufgabe&date=2011-06-10&done=true
 * @author  Andy Klay <klay@fh-brandenburg.de> 
 * 
 */
public class UpdateTaskAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(UpdateTaskAction.class);

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
					+ "String projectName(" + req.getParameter("projectName") + "), "
					+ "int taskId(" + req.getParameter("taskId") + ")"
					+ "String titel(" + req.getParameter("titel") + ")"
					+ "String aufgabenStellung(" + req.getParameter("aufgabenStellung") + ")"
					+ "Date date(" + req.getParameter("date") + ")"
					+ "boolean done(" + req.getParameter("done") + ")"
					);
			
			//Parameter laden
			String aktUser = (String) session.getAttribute("aktUser");
			Project aktProject = (Project)session.getAttribute("aktProject");
			int taskId = 0;
			try {
				taskId = Integer.valueOf(req.getParameter("taskId"));
			} catch (NumberFormatException e) {
				logger.error(e.getMessage(), e);
			}
			String titel = req.getParameter("titel");
			String aufgabenstellung = req.getParameter("aufgabenstellung");
			//yyyy-mm-dd <<< muss sooo aussehen
			Date date = null;
			try {
				date = Date.valueOf(req.getParameter("date"));
			} catch (IllegalArgumentException e) {
				logger.info(e.getMessage(), e);
			}
			boolean done = Boolean.getBoolean(req.getParameter("done"));
			
			//EINGABEFEHLER ABFANGEN
			//abfrage ob user eingeloggt
			if(aktUser == null){
				throw new ProjectException("Sie sind nicht eingeloggt!");
			}
			//RECHTE-ABFRAGE Global
			try{
				if(!mainManager.getGlobalRolesManager().isAllowedUpdateTaskAction(aktUser)){
					//RECHTE-ABFRAGE Projekt
					if(!mainManager.getProjectRolesManager().isAllowedUpdateTaskAction(aktUser, aktProject.getName())){
						throw new ProjectException("Sie haben keine Rechte zum Updaten dieses Tasks!");
					}			
				}
				//Manager in aktion
				mainManager.getTaskManager().updateTask(aktProject.getName(), taskId, titel, aufgabenstellung, date, done);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			
			
			try {
				super.redirect(req, resp, (String)session.getAttribute("aktServlet"), "ShowAllTasks", null);
			} catch (IOException e) {
				logger.error("Konnte Redirect nicht ausführen! "+e.getMessage(), e);
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
