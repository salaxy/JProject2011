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

public class CommentSourcecode {
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
	
	private int sourcecodeId;
	
	public void setSourcecodeId(int value) {
		this.sourcecodeId = value;
	}
	
	public int getSourcecodeId() {
		return sourcecodeId;
	}
	
	private de.fhb.jproject.data.Comment comment;
	
	public void setComment(de.fhb.jproject.data.Comment value) {
		if (this.comment != value) {
			de.fhb.jproject.data.Comment lcomment = this.comment;
			this.comment = value;
			if (value != null) {
				comment.setSourcecode(this);
			}
			else {
				lcomment.setSourcecode(null);
			}
		}
	}
	
	public de.fhb.jproject.data.Comment getComment() {
		return comment;
	}
	
	public void setSourcecode(de.fhb.jproject.data.Sourcecode value) {
		if (sourcecode != null) {
			sourcecode.comment_Sourcecode.remove(this);
		}
		if (value != null) {
			value.comment_Sourcecode.add(this);
		}
	}
	
	public de.fhb.jproject.data.Sourcecode getSourcecode() {
		return sourcecode;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Sourcecode(de.fhb.jproject.data.Sourcecode value) {
		this.sourcecode = value;
	}
	
	private de.fhb.jproject.data.Sourcecode getORM_Sourcecode() {
		return sourcecode;
	}
	
	public de.fhb.jproject.data.Sourcecode getORMID() {
		return getSourcecode();
	}
	
	public String toString() {
		return String.valueOf(((getSourcecode() == null) ? "" : String.valueOf(getSourcecode().getORMID())));
	}
	
}
