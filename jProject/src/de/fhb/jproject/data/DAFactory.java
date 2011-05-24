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

public abstract class DAFactory {
	private static DAFactory _factory = new DAFactoryImpl();
	
	public static DAFactory getDAFactory() {
		return _factory;
	}
	
	public abstract UserDA getUserDA();
	public abstract ProjectDA getProjectDA();
	public abstract SourcecodeDA getSourcecodeDA();
	public abstract DocumentDA getDocumentDA();
	public abstract ICQDA getICQDA();
	public abstract SkypeDA getSkypeDA();
	public abstract TelefonDA getTelefonDA();
	public abstract CommentDA getCommentDA();
	public abstract TaskDA getTaskDA(); 
	public abstract MemberDA getMemberDA();
	public abstract TerminDA getTerminDA();
	public abstract CommentProjectDA getCommentProjectDA();
	public abstract CommentSourcecodeDA getCommentSourcecodeDA();
	public abstract CommentDocumentDA getCommentDocumentDA();
	public abstract CommentTaskDA getCommentTaskDA();
	public abstract ProjectRolesDA getProjectRolesDA();
	public abstract GlobalRolesDA getGlobalRolesDA();
}

