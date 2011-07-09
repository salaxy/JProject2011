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

/**
 * 
 * @author MacYser
 */
public abstract class DAFactory {
	private static DAFactory _factory = new DAFactoryImpl();
	
	/**
	 * 
	 * @return
	 */
	public static DAFactory getDAFactory() {
		return _factory;
	}
	
	/**
	 * 
	 * @return
	 */
	public abstract UserDA getUserDA();
	/**
	 * 
	 * @return
	 */
	public abstract ProjectDA getProjectDA();
	/**
	 * 
	 * @return
	 */
	public abstract SourcecodeDA getSourcecodeDA();
	/**
	 * 
	 * @return
	 */
	public abstract DocumentDA getDocumentDA();
	/**
	 * 
	 * @return
	 */
	public abstract ICQDA getICQDA();
	/**
	 * 
	 * @return
	 */
	public abstract SkypeDA getSkypeDA();
	/**
	 * 
	 * @return
	 */
	public abstract TelefonDA getTelefonDA();
	/**
	 * 
	 * @return
	 */
	public abstract CommentDA getCommentDA();
	/**
	 * 
	 * @return
	 */
	public abstract TaskDA getTaskDA(); 
	/**
	 * 
	 * @return
	 */
	public abstract MemberDA getMemberDA();
	/**
	 * 
	 * @return
	 */
	public abstract TerminDA getTerminDA();
	/**
	 * 
	 * @return
	 */
	public abstract CommentProjectDA getCommentProjectDA();
	/**
	 * 
	 * @return
	 */
	public abstract CommentSourcecodeDA getCommentSourcecodeDA();
	/**
	 * 
	 * @return
	 */
	public abstract CommentDocumentDA getCommentDocumentDA();
	/**
	 * 
	 * @return
	 */
	public abstract CommentTaskDA getCommentTaskDA();
	/**
	 * 
	 * @return
	 */
	public abstract ProjectRolesDA getProjectRolesDA();
	/**
	 * 
	 * @return
	 */
	public abstract GlobalRolesDA getGlobalRolesDA();
}

