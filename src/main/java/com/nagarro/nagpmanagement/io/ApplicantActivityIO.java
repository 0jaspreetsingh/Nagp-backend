package com.nagarro.nagpmanagement.io;

import org.springframework.stereotype.Component;

import com.nagarro.nagpmanagement.model.Nagplevel;

@Component
public class ApplicantActivityIO {

	private int applicantActvityId;
	private String activity_id;
	private String status;
	private int score;
	private int employee_id;
	private String Document;
	private String startdate;
	private String donedate;
	private String completiondate;
	private Nagplevel level;
	private String name;
	private String description;
	private int points;

	public int getApplicantActvityId() {
		return applicantActvityId;
	}

	public void setApplicantActvityId(int applicantActvityId) {
		this.applicantActvityId = applicantActvityId;
	}

	public String getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(String activity_id) {
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

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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

	public Nagplevel getLevel() {
		return level;
	}

	public void setLevel(Nagplevel level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
