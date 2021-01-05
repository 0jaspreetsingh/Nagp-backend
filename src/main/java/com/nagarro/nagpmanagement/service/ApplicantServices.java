package com.nagarro.nagpmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.io.ActivityPoints;
import com.nagarro.nagpmanagement.io.ActivityPointsList;
import com.nagarro.nagpmanagement.io.ApplicantIO;
import com.nagarro.nagpmanagement.model.Applicant;
import com.nagarro.nagpmanagement.model.ApplicantActivityRecord;
import com.nagarro.nagpmanagement.repository.ApplicantActivityRepository;
import com.nagarro.nagpmanagement.repository.ApplicantRepository;

@Service
public class ApplicantServices {

	@Autowired
	ApplicantRepository ar;

	@Autowired
	ApplicantActivityRepository aar;

	public Applicant getById(int employee_id) {
		return ar.getOne(employee_id);
	}

	public boolean authenticate(int employee_id, String password) {
		return ar.match(employee_id, password) != null ? true : false;
	}

	public void add(Applicant applicant) {
		ar.save(applicant);
	}

	public List<Applicant> showAll() {
		return ar.findAll();
	}

	public void edit(Applicant newApplicant) {
		ar.save(newApplicant);
	}

	public void delete(int id) {
		ar.deleteById(id);
	}

	public void changePassword(int id, String newPassword) {
		ar.changePassword(id, newPassword);
	}

	public Double getPoints(ApplicantIO applicantIo) {
		double points = 0;
		List<ApplicantActivityRecord> list = aar.findAll();
		System.out.println(list);
		for (ApplicantActivityRecord record : list) {
			if (record.getAssignee().getEmployee_id() == applicantIo.getEmployee_id()
					&& record.getLevel_id().getLevel_id().equals(applicantIo.getLevel_id())) {
				points += record.getPoints();
			}
		}
		return points;
	}

//	public List<ActivityPoints> getPointsArray(ApplicantIO applicantIo) {
//		int points = 0;
//		List<ApplicantActivityRecord> list = aar.findAll();
//		List<ActivityPoints> activityPoints = new ArrayList<ActivityPoints>();
//		System.out.println(list);
//		for (ApplicantActivityRecord record : list) {
//			if (record.getAssignee().getEmployee_id() == applicantIo.getEmployee_id()
//					&& record.getLevel_id().getLevel_id().equals(applicantIo.getLevel_id())) {
//				ActivityPoints activityPoint = new ActivityPoints(record.getPoints(),
//						record.getActivity_id().getName());
//				points += record.getPoints();
//				activityPoint.totalPoints = points;
//				activityPoints.add(activityPoint);
//			}
//		}
//		return activityPoints;
//	}

	public ActivityPointsList getPointsArray(ApplicantIO applicantIo) {
		List<ApplicantActivityRecord> list = aar.findAll();
		ActivityPointsList activityPoints = new ActivityPointsList();
		System.out.println(list);
		for (ApplicantActivityRecord record : list) {
			if (record.getAssignee().getEmployee_id() == applicantIo.getEmployee_id()
					&& record.getLevel_id().getLevel_id().equals(applicantIo.getLevel_id())) {
				activityPoints.points.add(record.getPoints());
				activityPoints.activityName.add(record.getActivity_id().getName());
				activityPoints.totalPoints += record.getPoints();
			}
		}
		return activityPoints;
	}
}
