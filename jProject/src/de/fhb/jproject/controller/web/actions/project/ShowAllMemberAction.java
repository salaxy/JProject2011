package de.fhb.jproject.controller.web.actions.project;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import de.fhb.commons.web.HttpRequestActionBase;
import de.fhb.jproject.data.Member;
import de.fhb.jproject.data.Project;
import de.fhb.jproject.data.User;
import de.fhb.jproject.exceptions.ProjectException;
import de.fhb.jproject.manager.MainControl;
import javax.servlet.http.HttpSession;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author Andy Klay <klay@fh-brandenburg.de>
 * 
 * STATUS: Voerst FREIGEGEBEN (Nulleintrag fehler)
 */
public class ShowAllMemberAction extends HttpRequestActionBase {

	private MainControl mainController;
	private static final Logger logger = Logger.getLogger(ShowAllMemberAction.class);

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		HttpSession session = req.getSession();
		//Controller holen
		mainController=(MainControl) session.getAttribute("mainController");
		List<Member> memberList=null;
		
		try {				
			
			//Debugprint
			logger.info("perform(HttpServletRequest req, HttpServletResponse resp)");
			logger.debug("Parameter: "
					+ "String projectName(" + req.getParameter("projectName") + ")"
					);	
			
		
			//Controller in aktion
			memberList=mainController.getProjectContoller().showAllMember((User)session.getAttribute("aktUser"), 
																		  req.getParameter("projectName"));
			
			for( Member m : memberList){
				System.out.println("Member: "+ m.getUser().getLoginName()+" "+m.getProject().getName()+" "+m.getProjectRole());
			}		
			
			//setzen der Parameter
			req.setAttribute("memberList", memberList);
			

		}catch (ProjectException e) {
			logger.error(e.getMessage());
		}catch(NullPointerException e){
			logger.error(e.getMessage());			
		}
	}
}
