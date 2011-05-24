/**
 * "Visual Paradigm: D NT MDIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */


package de.fhb.jproject.data;

import de.fhb.jproject.repository.da.CommentDA;
import de.fhb.jproject.repository.da.CommentDocumentDA;
import de.fhb.jproject.repository.da.CommentProjectDA;
import de.fhb.jproject.repository.da.CommentSourcecodeDA;
import de.fhb.jproject.repository.da.CommentTaskDA;
import de.fhb.jproject.repository.da.DocumentDA;
import de.fhb.jproject.repository.da.GlobalRolesDA;
import de.fhb.jproject.repository.da.ICQDA;
import de.fhb.jproject.repository.da.MemberDA;
import de.fhb.jproject.repository.da.ProjectDA;
import de.fhb.jproject.repository.da.ProjectRolesDA;
import de.fhb.jproject.repository.da.SkypeDA;
import de.fhb.jproject.repository.da.SourcecodeDA;
import de.fhb.jproject.repository.da.TaskDA;
import de.fhb.jproject.repository.da.TelefonDA;
import de.fhb.jproject.repository.da.TerminDA;
import de.fhb.jproject.repository.da.UserDA;
import de.fhb.jproject.repository.daimpl.CommentSourcecodeDAImpl;
import de.fhb.jproject.repository.daimpl.CommentDocumentDAImpl;
import de.fhb.jproject.repository.daimpl.CommentProjectDAImpl;
import de.fhb.jproject.repository.daimpl.CommentTaskDAImpl;
import de.fhb.jproject.repository.daimpl.CommentDAImpl;
import de.fhb.jproject.repository.daimpl.DocumentDAImpl;
import de.fhb.jproject.repository.daimpl.GlobalRolesDAImpl;
import de.fhb.jproject.repository.daimpl.ICQDAImpl;
import de.fhb.jproject.repository.daimpl.MemberDAImpl;
import de.fhb.jproject.repository.daimpl.ProjectDAImpl;
import de.fhb.jproject.repository.daimpl.ProjectRolesDAImpl;
import de.fhb.jproject.repository.daimpl.SkypeDAImpl;
import de.fhb.jproject.repository.daimpl.SourcecodeDAImpl;
import de.fhb.jproject.repository.daimpl.TaskDAImpl;
import de.fhb.jproject.repository.daimpl.TelefonDAImpl;
import de.fhb.jproject.repository.daimpl.TerminDAImpl;
import de.fhb.jproject.repository.daimpl.UserDAImpl;



public class DAFactoryImpl extends DAFactory {
	private UserDA _userDA = new UserDAImpl();

	@Override
	public UserDA getUserDA() {
		return _userDA;
	}
	
	private ProjectDA _projectDA = new ProjectDAImpl();

	@Override
	public ProjectDA getProjectDA() {
		return _projectDA;
	}
	private SourcecodeDA _sourcecodeDA = new SourcecodeDAImpl();

	@Override
	public SourcecodeDA getSourcecodeDA() {
		return _sourcecodeDA;
	}
	private DocumentDA _documentDA = new DocumentDAImpl();

	@Override
	public DocumentDA getDocumentDA() {
		return _documentDA;
	}
	private ICQDA _iCQDA = new ICQDAImpl();

	@Override
	public ICQDA getICQDA() {
		return _iCQDA;
	}
	private SkypeDA _skypeDA = new SkypeDAImpl();

	@Override
	public SkypeDA getSkypeDA() {
		return _skypeDA;
	}
	private TelefonDA _telefonDA = new TelefonDAImpl();

	@Override
	public TelefonDA getTelefonDA() {
		return _telefonDA;
	}
	private CommentDA _commentDA = new CommentDAImpl();

	@Override
	public CommentDA getCommentDA() {
		return _commentDA;
	}
	private TaskDA _taskDA = new TaskDAImpl();

	@Override
	public TaskDA getTaskDA() {
		return _taskDA;
	}
	private MemberDA _memberDA = new MemberDAImpl();

	@Override
	public MemberDA getMemberDA() {
		return _memberDA;
	}
	private TerminDA _terminDA = new TerminDAImpl();

	@Override
	public TerminDA getTerminDA() {
		return _terminDA;
	}
	private CommentProjectDA _commentProjectDA = new CommentProjectDAImpl();

	@Override
	public CommentProjectDA getCommentProjectDA() {
		return _commentProjectDA;
	}
	private CommentSourcecodeDA _commentSourcecodeDA = new CommentSourcecodeDAImpl();

	@Override
	public CommentSourcecodeDA getCommentSourcecodeDA() {
		return _commentSourcecodeDA;
	}
	private CommentDocumentDA _commentDocumentDA = new CommentDocumentDAImpl();

	@Override
	public CommentDocumentDA getCommentDocumentDA() {
		return _commentDocumentDA;
	}
	private CommentTaskDA _commentTaskDA = new CommentTaskDAImpl();

	@Override
	public CommentTaskDA getCommentTaskDA() {
		return _commentTaskDA;
	}
	private ProjectRolesDA _rolesDA = new ProjectRolesDAImpl();

	@Override
	public ProjectRolesDA getProjectRolesDA() {
		return _rolesDA;
	}
	private GlobalRolesDA _globalRolesDA = new GlobalRolesDAImpl();

	@Override
	public GlobalRolesDA getGlobalRolesDA() {
		return _globalRolesDA;
	}

	
	
}

