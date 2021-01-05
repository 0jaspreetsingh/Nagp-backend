package com.nagarro.nagpmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.io.ActivityIO;
import com.nagarro.nagpmanagement.io.ApplicantIO;
import com.nagarro.nagpmanagement.model.Activity;
import com.nagarro.nagpmanagement.service.ActivityServices;

@RestController
@CrossOrigin
public class ActivityController {

	@Autowired
	ActivityServices activityServices;

	@GetMapping(value = NAGPconstants.GET_ALL_ACTIVITIES)
	public List<Activity> showAll() {
		System.out.println(activityServices.showAll());
		return activityServices.showAll();
	}

	@PostMapping(value = NAGPconstants.ADD_ACTIVITY)
	public void add(@RequestBody ActivityIO activityIo) {
		System.out.println(activityIo);
		Activity activity = new Activity();
		activity.setActivity_id(activityIo.getActivity_id());
		activity.setBatch(activityIo.getBatch());
		activity.setDescription(activityIo.getDescription());
		activity.setLevel(activityIo.getLevel());
		activity.setMax_qualification(activityIo.getMax_qualification());
		activity.setName(activityIo.getName());
		activity.setPoints(activityIo.getPoints());
		activityServices.add(activity);
	}

	@PutMapping(value = NAGPconstants.EDIT_ACTIVITY)
	public void edit(@RequestBody ActivityIO activityIo) {
		System.out.println(activityIo);
		Activity activity = new Activity();
		activity.setActivity_id(activityIo.getActivity_id());
		activity.setBatch(activityIo.getBatch());
		activity.setDescription(activityIo.getDescription());
		activity.setLevel(activityIo.getLevel());
		activity.setMax_qualification(activityIo.getMax_qualification());
		activity.setName(activityIo.getName());
		activity.setPoints(activityIo.getPoints());
		activityServices.edit(activity);
	}

	@PostMapping(value = NAGPconstants.IS_ACTIVITY_ID_AVAILABLE)
	public boolean checkIfAvailable(@RequestBody String activity_id) {
		System.out.println(activity_id);
		return activityServices.checkAvailability(activity_id);
	}

	@PostMapping(value = NAGPconstants.FILTER_ACTIVITY)
	public List<Activity> getApplicantActivities(@RequestBody ApplicantIO applicantIo) {
		System.out.println(applicantIo.getBatch_id() + " " + applicantIo.getLevel_id());
		System.out.println("Filter activity");
		return activityServices.getApplicantActivities(applicantIo.getLevel_id(), applicantIo.getBatch_id());
	}
}
