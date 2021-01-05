package com.nagarro.nagpmanagement.io;

public class ActivityIO {
	private String activity_id;
	private String level;
	private String batch;
	private String name;
	private String description;
	private int points;
	private int max_qualification;

	public String getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
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

	public void setMax_qualification(int max_qualification) {
		this.max_qualification = max_qualification;
	}

	@Override
	public String toString() {
		return "ActivityIO [activity_id=" + activity_id + ", level=" + level + ", batch=" + batch + ", name=" + name
				+ ", description=" + description + ", points=" + points + ", max_qualification=" + max_qualification
				+ "]";
	}

}
