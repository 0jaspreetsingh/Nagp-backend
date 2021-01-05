package com.nagarro.nagpmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ApplicantActivityRecord {

	@Id
	@GeneratedValue
	private int applicantActvityId;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private Nagplevel level_id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "activity_id")
	private Activity activity_id;

	private String status;

	private int score;
	private int points;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Applicant assignee;

	private String Description;
	private String Document;

	private String startdate;
	private String donedate;
	private String completiondate;

	public int getApplicantActvityId() {
		return applicantActvityId;
	}

	public void setApplicantActvityId(int applicantActvityId) {
		this.applicantActvityId = applicantActvityId;
	}

	public Nagplevel getLevel_id() {
		return level_id;
	}

	public void setLevel_id(Nagplevel level_id) {
		this.level_id = level_id;
	}

	public Activity getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Activity activity_id) {
		this.activity_id = activity_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Applicant getAssignee() {
		return assignee;
	}

	public void setAssignee(Applicant assignee) {
		this.assignee = assignee;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDocument() {
		return Document;
	}

	public void setDocument(String document) {
		Document = document;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getDonedate() {
		return donedate;
	}

	public void setDonedate(String donedate) {
		this.donedate = donedate;
	}

	public String getCompletiondate() {
		return completiondate;
	}

	public void setCompletiondate(String completiondate) {
		this.completiondate = completiondate;
	}
}
