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
 * Spezieller Kommentar zu einem Dokument
 */
public class CommentDocument implements Serializable {
	/**
	 * 
	 */
	public CommentDocument() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTDOCUMENT_COMMENT) {
			this.comment = (de.fhb.jproject.data.Comment) owner;
		}
		
		else if (key == de.fhb.jproject.data.ORMConstants.KEY_COMMENTDOCUMENT_DOCUMENT) {
			this.document = (de.fhb.jproject.data.Document) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
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
	
	private de.fhb.jproject.data.Document document;
	
	/**
	 * 
	 * @param value
	 */
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setCommentDocument(this);
			}
			else {
				lcomment.setCommentDocument(null);
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
	public void setDocument(de.fhb.jproject.data.Document value) {
		if (document != null) {
			document.commentDocument.remove(this);
		}
		if (value != null) {
			value.commentDocument.add(this);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public de.fhb.jproject.data.Document getDocument() {
		return document;
	}
	
	/**
	 * This method is for internal use only.
	 * 
	 * @param value 
	 */
	public void setORM_Document(de.fhb.jproject.data.Document value) {
		this.document = value;
	}
	
	private de.fhb.jproject.data.Document getORM_Document() {
		return document;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toString() {
		return String.valueOf(((getComment() == null) ? "" : String.valueOf(getComment().getORMID())));
	}
	
}
