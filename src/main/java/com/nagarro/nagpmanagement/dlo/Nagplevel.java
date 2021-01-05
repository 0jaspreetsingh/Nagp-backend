package com.nagarro.nagpmanagement.dlo;

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
public class Nagplevel {
	@Id
	@Size(max=20)
	@Column(length=20,name="level_id")
	private String level_id;

	private int number;

	private String name;

	private String description;	

	private int qualification_points;
	
	//@Basic(fetch=FetchType.EAGER)
	@JsonIgnore
	@OneToMany(mappedBy="level")
	List<Activity> activities;
	
	@JsonIgnore
	@OneToMany(mappedBy="level")
	private List<Applicant> applicant;
	
//	@OneToMany(mappedBy="level_id")
//	private ApplicantActivityRecord aar;

//	@Override
//	public String toString() {
//		return "Nagplevel [level_id=" + level_id + ", number=" + number + ", name=" + name + ", description="
//				+ description + ", qualification_points=" + qualification_points + ", activities=" + activities
//				+ ", applicant=" + applicant + "]";
//	}
	
	public int getNumber() {
		return number;
	}

	public String getLevel_id() {
		return level_id;
	}

	private String generateKey() {
//		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		Date date = new Date();
//		return 		dateFormat.format(date);
		Random random = new Random();
		String key = "L" + random.nextInt(10) + Calendar.getInstance().getTimeInMillis();
		return key;

	}
	
	public void setLevel_id(String level_id) {
		if(level_id.equals("")||level_id==null||level_id.trim().isEmpty()) {
			this.level_id=generateKey();
		}else {
			level_id= level_id.trim();
			this.level_id = level_id;			
		}
		
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

//	public Applicant getApplicant() {
//		return applicant;
//	}
//
//	public void setApplicant(Applicant applicant) {
//		this.applicant = applicant;
//	}

	public void setNumber(int number) {
		this.number = number;
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

	public int getQualification_points() {
		return qualification_points;
	}

	public void setQualification_points(int qualification_points) {
		this.qualification_points = qualification_points;
	}

}
