package com.nagarro.nagpmanagement.io;

public class ApplicantMonthlyReport {

	int employee_id;
	String email;
	String applicantName;
	int pointsEarned;
	int totalPoints;
	int totalActivitiesInProgress;
	String batchName;

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public int getPointsEarned() {
		return pointsEarned;
	}

	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getTotalActivitiesInProgress() {
		return totalActivitiesInProgress;
	}

	public void setTotalActivitiesInProgress(int totalActivitiesInProgress) {
		this.totalActivitiesInProgress = totalActivitiesInProgress;
	}

	@Override
	public String toString() {

		StringBuffer userReport = new StringBuffer();
		userReport.append("Hello\n");
		userReport.append(this.applicantName);
		userReport.append(",\nYour Employee Id is :");
		userReport.append(this.employee_id);
		userReport.append("and You have earned a total of ");
		userReport.append(this.pointsEarned);
		userReport.append("points. The maximum points which you can earn are :" + this.totalPoints);
		userReport.append("\nThere are Total " + this.totalActivitiesInProgress + " activities in progress");
		return userReport.toString();
//		return "ApplicantMonthlyReport [employee_id=" + employee_id + ", email=" + email + ", applicantName="
//				+ applicantName + ", pointsEarned=" + pointsEarned + ", totalPoints=" + totalPoints
//				+ ", totalActivitiesInProgress=" + totalActivitiesInProgress + ", batchName=" + batchName + "]";
	}

}
