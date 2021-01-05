package com.nagarro.nagpmanagement.dlo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagarro.nagpmanagement.enums.NAGPStatus;
import com.nagarro.nagpmanagement.service.BatchServices;
import com.nagarro.nagpmanagement.service.NAGPLevelServices;

@Component
@Entity
public class Applicant {
	@Transient
	@Autowired
	NAGPLevelServices nl;

	@Transient
	@Autowired
	BatchServices bs;

	@Id
	@GeneratedValue
	private int employee_id;
	private String name;
	private String email;
	private String number;
	@ManyToOne
	@JoinColumn(name = "batch_id")
	@Autowired
	private Batch batch;
	@ManyToOne
	@JoinColumn(name = "level_id")
	@Autowired
	private Nagplevel level;

	@JsonIgnore
	@OneToMany(mappedBy = "assignee")
	private List<ApplicantActivityRecord> applicant_activity_id;

	private NAGPStatus NAGP_status;
	private String password;
	
	
	@Override
	public String toString() {
		return "Applicant [nl=" + nl + ", bs=" + bs + ", employee_id=" + employee_id + ", name=" + name + ", email="
				+ email + ", number=" + number + ", batch=" + batch + ", level=" + level + ", applicant_activity_id="
				+ applicant_activity_id + ", NAGP_status=" + NAGP_status + ", password=" + password + "]";
	}

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

	public Batch getBatch() {
		return batch;
	}

	public Nagplevel getLevel() {
		return level;
	}

	public List<ApplicantActivityRecord> getApplicant_activity_id() {
		return applicant_activity_id;
	}

	public void setApplicant_activity_id(List<ApplicantActivityRecord> applicant_activity_id) {
		this.applicant_activity_id = applicant_activity_id;
	}

//	public void setBatch(String batch_id) {
//
////	    Batch batch = new Batch();
////	    batch.setBatch_id(batch_id);
////	    this.batch=batch;
//		this.batch = bs.findById(batch_id);
//	}
//
//	public void setLevel(String level_id) {
////		System.out.println(level_id);
////		Nagplevel level= new Nagplevel();
////		level.setLevel_id(level_id);
////		System.out.println(level);
////		
////		this.level =level;
//		this.level= nl.findById(level_id);
//		
//	}

	public String getPassword() {
		return password;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public void setLevel(Nagplevel level) {
		this.level = level;
	}

	public NAGPStatus getNAGP_status() {
		return NAGP_status;
	}

	public void setNAGP_status(NAGPStatus nAGP_status) {
		NAGP_status = nAGP_status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
