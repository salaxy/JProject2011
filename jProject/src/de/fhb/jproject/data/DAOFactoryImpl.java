/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */
package de.fhb.jproject.data;

import de.fhb.jproject.repository.daoimpl.*;
import de.fhb.jproject.repository.dao.*;

/**
 * 
 * @author MacYser
 */
public class DAOFactoryImpl extends DAOFactory {
	private UserDAO _userDAO = new UserDAOImpl();
	/**
	 * 
	 * @return
	 */
	public UserDAO getUserDAO() {
		return _userDAO;
	}
	
	private ProjectDAO _projectDAO = new ProjectDAOImpl();
	/**
	 * 
	 * @return
	 */
	public ProjectDAO getProjectDAO() {
		return _projectDAO;
	}
	
	private SourcecodeDAO _sourcecodeDAO = new SourcecodeDAOImpl();
	/**
	 * 
	 * @return
	 */
	public SourcecodeDAO getSourcecodeDAO() {
		return _sourcecodeDAO;
	}
	
	private DocumentDAO _documentDAO = new DocumentDAOImpl();
	/**
	 * 
	 * @return
	 */
	public DocumentDAO getDocumentDAO() {
		return _documentDAO;
	}
	
	private ICQDAO _iCQDAO = new ICQDAOImpl();
	/**
	 * 
	 * @return
	 */
	public ICQDAO getICQDAO() {
		return _iCQDAO;
	}
	
	private SkypeDAO _skypeDAO = new SkypeDAOImpl();
	/**
	 * 
	 * @return
	 */
	public SkypeDAO getSkypeDAO() {
		return _skypeDAO;
	}
	
	private TelefonDAO _telefonDAO = new TelefonDAOImpl();
	/**
	 * 
	 * @return
	 */
	public TelefonDAO getTelefonDAO() {
		return _telefonDAO;
	}
	
	private CommentDAO _commentDAO = new CommentDAOImpl();
	/**
	 * 
	 * @return
	 */
	public CommentDAO getCommentDAO() {
		return _commentDAO;
	}
	
	private TaskDAO _taskDAO = new TaskDAOImpl();
	/**
	 * 
	 * @return
	 */
	public TaskDAO getTaskDAO() {
		return _taskDAO;
	}
	
	private MemberDAO _memberDAO = new MemberDAOImpl();
	/**
	 * 
	 * @return
	 */
	public MemberDAO getMemberDAO() {
		return _memberDAO;
	}
	
	private TerminDAO _terminDAO = new TerminDAOImpl();
	/**
	 * 
	 * @return
	 */
	public TerminDAO getTerminDAO() {
		return _terminDAO;
	}
	
	private CommentProjectDAO _commentProjectDAO = new CommentProjectDAOImpl();
	/**
	 * 
	 * @return
	 */
	public CommentProjectDAO getCommentProjectDAO() {
		return _commentProjectDAO;
	}
	
	private CommentSourcecodeDAO _commentSourcecodeDAO = new CommentSourcecodeDAOImpl();
	/**
	 * 
	 * @return
	 */
	public CommentSourcecodeDAO getCommentSourcecodeDAO() {
		return _commentSourcecodeDAO;
	}
	
	private CommentDocumentDAO _commentDocumentDAO = new CommentDocumentDAOImpl();
	/**
	 * 
	 * @return
	 */
	public CommentDocumentDAO getCommentDocumentDAO() {
		return _commentDocumentDAO;
	}
	
	private CommentTaskDAO _commentTaskDAO = new CommentTaskDAOImpl();
	/**
	 * 
	 * @return
	 */
	public CommentTaskDAO getCommentTaskDAO() {
		return _commentTaskDAO;
	}
	
	private ProjectRolesDAO _projectRolesDAO = new ProjectRolesDAOImpl();
	/**
	 * 
	 * @return
	 */
	public ProjectRolesDAO getProjectRolesDAO() {
		return _projectRolesDAO;
	}
	
	private GlobalRolesDAO _globalRolesDAO = new GlobalRolesDAOImpl();
	/**
	 * 
	 * @return
	 */
	public GlobalRolesDAO getGlobalRolesDAO() {
		return _globalRolesDAO;
	}
	
}

