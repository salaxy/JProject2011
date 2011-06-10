package de.fhb.jproject.controller.web.actions.sources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.Sourcecode;
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
public class ShowAllSourceAction extends HttpRequestActionBase {

	private MainManager mainManager;
	private static final Logger logger = Logger.getLogger(ShowAllSourceAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void perform(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException{	
		HttpSession session = req.getSession();
		//Manager holen
		mainManager=(MainManager) session.getAttribute("mainManager");
		List<Sourcecode> sourcecodeList = null;
		Sourcecode sourcecode = null;
		int sourcecodeId = 0;
		try {		
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "int sourcecodeId(" + req.getParameter("sourcecodeId") + ")"
					);
			
			
			try {
				sourcecodeList=mainManager.getSourceManager().showAllSource((User)session.getAttribute("aktUser"), 
																   ((Project)session.getAttribute("aktProject")).getName());
			
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			try {
				//Wenn sourcecodeId == 0 dann gib mir den ersten
				if (0 == Integer.valueOf(req.getParameter("sourcecodeId"))) {
					sourcecodeId = sourcecodeList.get(0).getId();
				}else{
					sourcecodeId = Integer.valueOf(req.getParameter("sourcecodeId"));
				}
			} catch (IllegalArgumentException e) {
				throw new ProjectException("sourcecodeID ungültig "+e);
			}catch(NullPointerException e){
				logger.error("Keine Sourcecodes vorhanden!"+e.getMessage(), e);
			}
			
			
			
			try {
				sourcecode = mainManager.getSourceManager().showSource((User)session.getAttribute("aktUser"), 
						 ((Project)session.getAttribute("aktProject")).getName(),
						 sourcecodeId);
			}catch(NullPointerException e){
				logger.error(e.getMessage(), e);
			}
			
			//setzen der Parameter
			req.setAttribute("sourcecodeList", sourcecodeList);
			req.setAttribute("sourcecode", sourcecode);
			
			
			req.setAttribute("contentFile", "showAllSource.jsp");
		}catch (ProjectException e) {
			logger.error(e.getMessage(), e);
			req.setAttribute("contentFile", "error.jsp");
			req.setAttribute("errorString", e.getMessage());
		}
		
	}
}
