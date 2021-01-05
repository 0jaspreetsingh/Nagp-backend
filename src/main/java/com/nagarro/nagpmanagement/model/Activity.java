package com.nagarro.nagpmanagement.model;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Activity {

	@Id
	@Size(max = 20)
	@Column(length = 20, name = "activity_id", unique = true)
	private String activity_id;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private Nagplevel level;

	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;

	@OneToMany(mappedBy = "activity_id")
	private List<ApplicantActivityRecord> aar;

	private String name;

	private String description;

	private int points;

	private int max_qualification;

	public String getActivity_id() {
		return activity_id;
	}

	private String generateKey() {
		Random random = new Random();
		String key = "A" + random.nextInt(10) + Calendar.getInstance().getTimeInMillis();
		return key;
	}

	public void setActivity_id(String activity_id) {
		if (activity_id.equals("") || activity_id == null || activity_id.trim().isEmpty()) {
			this.activity_id = generateKey();
		} else {
			activity_id = activity_id.trim();
			this.activity_id = activity_id;
		}
	}

	public Nagplevel getLevel() {
		return level;
	}

	public void setLevel(String level_id) {
		Nagplevel level = new Nagplevel();
		level.setLevel_id(level_id);
		this.level = level;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(String batch_id) {
		Batch batch = new Batch();
		batch.setBatch_id(batch_id);
		this.batch = batch;
	}

	public List<ApplicantActivityRecord> getAar() {
		return aar;
	}

	public void setAar(List<ApplicantActivityRecord> aar) {
		this.aar = aar;
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

	public int getMax_qualification() {
		return max_qualification;
	}

	public void setLevel(Nagplevel level) {
		this.level = level;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public void setMax_qualification(int max_qualification) {
		this.max_qualification = max_qualification;
	}

	@Override
	public String toString() {
		return "Activity [activity_id=" + activity_id + ", level=" + level + ", batch=" + batch + ", aar=" + aar
				+ ", name=" + name + ", description=" + description + ", points=" + points + ", max_qualification="
				+ max_qualification + "]";
	}

}
