package com.nagarro.nagpmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;
	private String comment;
	private long timestamp;
	private String owner;
	private int activityRecord;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getActivityRecord() {
		return activityRecord;
	}

	public void setActivityRecord(int activityRecord) {
		this.activityRecord = activityRecord;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", timestamp=" + timestamp + ", owner="
				+ owner + ", activityRecord=" + activityRecord + "]";
	}

}
