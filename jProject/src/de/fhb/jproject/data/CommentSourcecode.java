/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package de.fhb.jproject.data;

import java.io.Serializable;
/**
 * Spezieller Kommentar zu einem Sourcecode
 */
public class CommentSourcecode implements Serializable {
	/**
	 * 
	 */
	public CommentSourcecode() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTSOURCECODE_COMMENT) {
			this.comment = (de.fhb.jproject.data.Comment) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTSOURCECODE_SOURCECODE) {
			this.sourcecode = (de.fhb.jproject.data.Sourcecode) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private de.fhb.jproject.data.Sourcecode sourcecode;
	
	private de.fhb.jproject.data.Comment comment;
	
	private int commentId;
	
	/**
	 * 
	 * @param value
	 */
	public void setCommentId(int value) {
		this.commentId = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCommentId() {
		return commentId;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setCommentSourcecode(this);
			}
			else {
				lcomment.setCommentSourcecode(null);
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Comment getComment() {
		return comment;
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Comment getORMID() {
		return getComment();
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setSourcecode(de.fhb.jproject.data.Sourcecode value) {
		if (sourcecode != null) {
			sourcecode.commentSourcecode.remove(this);
		}
		if (value != null) {
			value.commentSourcecode.add(this);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Sourcecode getSourcecode() {
		return sourcecode;
	}
	
	/**
	 * This method is for internal use only.
	 * 
	 * @param value 
	 */
	public void setORM_Sourcecode(de.fhb.jproject.data.Sourcecode value) {
		this.sourcecode = value;
	}
	
	private de.fhb.jproject.data.Sourcecode getORM_Sourcecode() {
		return sourcecode;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(((getComment() == null) ? "" : String.valueOf(getComment().getORMID())));
	}
	
}
