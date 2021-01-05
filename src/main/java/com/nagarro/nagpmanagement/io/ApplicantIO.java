package com.nagarro.nagpmanagement.io;

import java.util.List;

import com.nagarro.nagpmanagement.enums.NAGPStatus;
import com.nagarro.nagpmanagement.model.ApplicantActivityRecord;

public class ApplicantIO {

	private int employee_id;
	private String name;
	private String email;
	private String number;
	private String batch_id;
	private String level_id;
	private List<ApplicantActivityRecord> applicant_activity_id;
	private NAGPStatus NAGP_status;
	private String password;

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public String getLevel_id() {
		return level_id;
	}

	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}

	public List<ApplicantActivityRecord> getApplicant_activity_id() {
		return applicant_activity_id;
	}

	public void setApplicant_activity_id(List<ApplicantActivityRecord> applicant_activity_id) {
		this.applicant_activity_id = applicant_activity_id;
	}

	public NAGPStatus getNAGP_status() {
		return NAGP_status;
	}

	public void setNAGP_status(NAGPStatus nAGP_status) {
		NAGP_status = nAGP_status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ApplicantIO [employee_id=" + employee_id + ", name=" + name + ", email=" + email + ", number=" + number
				+ ", batch_id=" + batch_id + ", level_id=" + level_id + ", applicant_activity_id="
				+ applicant_activity_id + ", NAGP_status=" + NAGP_status + ", password=" + password + "]";
	}

}
