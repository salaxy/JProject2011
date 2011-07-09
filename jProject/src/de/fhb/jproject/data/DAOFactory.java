/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */
package de.fhb.jproject.data;

import de.fhb.jproject.repository.dao.*;

/**
 * 
 * @author MacYser
 */
public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	/**
	 * 
	 * @return
	 */
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract UserDAO getUserDAO();
	/**
	 * 
	 * @return
	 */
	public abstract ProjectDAO getProjectDAO();
	/**
	 * 
	 * @return
	 */
	public abstract SourcecodeDAO getSourcecodeDAO();
	/**
	 * 
	 * @return
	 */
	public abstract DocumentDAO getDocumentDAO();
	/**
	 * 
	 * @return
	 */
	public abstract ICQDAO getICQDAO();
	/**
	 * 
	 * @return
	 */
	public abstract SkypeDAO getSkypeDAO();
	/**
	 * 
	 * @return
	 */
	public abstract TelefonDAO getTelefonDAO();
	/**
	 * 
	 * @return
	 */
	public abstract CommentDAO getCommentDAO();
	/**
	 * 
	 * @return
	 */
	public abstract TaskDAO getTaskDAO();
	/**
	 * 
	 * @return
	 */
	public abstract MemberDAO getMemberDAO();
	/**
	 * 
	 * @return
	 */
	public abstract TerminDAO getTerminDAO();
	/**
	 * 
	 * @return
	 */
	public abstract CommentProjectDAO getCommentProjectDAO();
	/**
	 * 
	 * @return
	 */
	public abstract CommentSourcecodeDAO getCommentSourcecodeDAO();
	/**
	 * 
	 * @return
	 */
	public abstract CommentDocumentDAO getCommentDocumentDAO();
	/**
	 * 
	 * @return
	 */
	public abstract CommentTaskDAO getCommentTaskDAO();
	/**
	 * 
	 * @return
	 */
	public abstract ProjectRolesDAO getProjectRolesDAO();
	/**
	 * 
	 * @return
	 */
	public abstract GlobalRolesDAO getGlobalRolesDAO();
}

