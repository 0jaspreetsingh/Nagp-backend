package com.nagarro.nagpmanagement.model;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Batch {

	@Id
	@Size(max = 20)
	@Column(length = 20, name = "batch_id")
	private String batch_id;

	@JsonIgnore
	@OneToMany(mappedBy = "batch")
	private List<Activity> activities;

	private int year;

	private String technology;

	private String description;

	private int qualification_points;

	private String startdate;

	@OneToMany(mappedBy = "batch")
	private List<Applicant> applicant;

	private String generateKey() {
		Random random = new Random();
		String key = "B" + random.nextInt(10) + Calendar.getInstance().getTimeInMillis();
		return key;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		if (batch_id.equals("") || batch_id == null || batch_id.trim().isEmpty()) {
			this.batch_id = generateKey();
		} else {
			batch_id = batch_id.trim();
			this.batch_id = batch_id;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQualification_points() {
		return qualification_points;
	}

	public void setQualification_points(int qualification_points) {
		this.qualification_points = qualification_points;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

}
