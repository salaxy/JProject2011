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

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract UserDAO getUserDAO();
	public abstract ProjectDAO getProjectDAO();
	public abstract SourcecodeDAO getSourcecodeDAO();
	public abstract DocumentDAO getDocumentDAO();
	public abstract ICQDAO getICQDAO();
	public abstract SkypeDAO getSkypeDAO();
	public abstract TelefonDAO getTelefonDAO();
	public abstract CommentDAO getCommentDAO();
	public abstract TaskDAO getTaskDAO();
	public abstract MemberDAO getMemberDAO();
	public abstract TerminDAO getTerminDAO();
	public abstract CommentProjectDAO getCommentProjectDAO();
	public abstract CommentSourcecodeDAO getCommentSourcecodeDAO();
	public abstract CommentDocumentDAO getCommentDocumentDAO();
	public abstract CommentTaskDAO getCommentTaskDAO();
	public abstract ProjectRolesDAO getProjectRolesDAO();
	public abstract GlobalRolesDAO getGlobalRolesDAO();
}

