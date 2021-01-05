package com.nagarro.nagpmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.model.Activity;
import com.nagarro.nagpmanagement.repository.ActivityRepository;

@Service
public class ActivityServices {

	@Autowired
	ActivityRepository ar;

	public Activity getByid(String id) {
		return ar.getOne(id);
	}

	public void add(Activity activity) {
		ar.save(activity);
	}

	public List<Activity> showAll() {
		return ar.findAll();
	}

	public void edit(Activity newActivity) {
		ar.save(newActivity);
	}

	public void delete(String id) {
		ar.deleteById(id);
	}

	public List<Activity> getApplicantActivities(String level_id, String batch_id) {
		return ar.match(level_id, batch_id);
	}

	public boolean checkAvailability(String activity_id) {
		try {
			Activity activity = ar.getOne(activity_id);
			System.out.println(activity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
