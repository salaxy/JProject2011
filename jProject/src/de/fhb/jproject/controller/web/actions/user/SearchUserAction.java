package de.fhb.jproject.controller.web.actions.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhb.commons.web.HttpRequestActionBase;


/**
 * Action, die alle mitgeschickten Parameter ausgibt: 
 * <parametername>: <value>
 * 
 * @author klay
 */
public class SearchUserAction extends HttpRequestActionBase {

//	private JProjectBO logic;

	/* (non-Javadoc)
	 * @see de.fhb.music.controller.we.actions.HttpRequestActionBase#perform(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void perform(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException {
		
		//Business-object holen
//		logic=(JProjectBO) req.getSession().getAttribute("logic");
//		
//		//informationen holen
//		int  nr=Integer.parseInt(req.getParameter("nr"));
//		
//		
//		List<CDVO> cdList=logic.showCDs();
//		
//		req.setAttribute("aktcd", logic.getAktuelleCD());
//		req.setAttribute("cdlist", cdList);
//		
//		try {
//			forward(req, resp, "json.jsp");
//		} catch (IOException e) {
//			
//			
//		}
		
	}
}
