package com.nagarro.nagpmanagement.io;

public class ActivityPoints {

	int points;
	String activityName;
	public int totalPoints;

	public ActivityPoints(int points, String activityName) {
		this.points = points;
		this.activityName = activityName;
		this.totalPoints = 0;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

}
