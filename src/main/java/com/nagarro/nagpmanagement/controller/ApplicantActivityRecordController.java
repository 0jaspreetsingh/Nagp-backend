package com.nagarro.nagpmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.io.ApplicantActivityIO;
import com.nagarro.nagpmanagement.io.ApplicantActivityRecordIO;
import com.nagarro.nagpmanagement.model.ApplicantActivityRecord;
import com.nagarro.nagpmanagement.service.ActivityServices;
import com.nagarro.nagpmanagement.service.ApplicantActivityServices;
import com.nagarro.nagpmanagement.service.ApplicantServices;
import com.nagarro.nagpmanagement.service.BatchServices;
import com.nagarro.nagpmanagement.service.NAGPLevelServices;

@RestController
@CrossOrigin(origins = "*")
public class ApplicantActivityRecordController {

	@Autowired
	ApplicantServices as;

	@Transient
	@Autowired
	NAGPLevelServices nl;

	@Transient
	@Autowired
	BatchServices bs;

	@Autowired
	ActivityServices act;

	@Autowired
	ApplicantActivityServices aas;

	@PostMapping(value = NAGPconstants.ADD_APPLICANT_ACTIVITY)
	public String add(@RequestBody ApplicantActivityRecordIO recordIo) throws IOException {
		ApplicantActivityRecord record = new ApplicantActivityRecord();
		record.setActivity_id(act.getByid(recordIo.getActivity_id()));
		record.setAssignee(as.getById(recordIo.getEmployee_id()));
		record.setLevel_id(nl.findById(recordIo.getLevel_id()));
		record.setCompletiondate(recordIo.getCompletiondate());
		record.setDescription(recordIo.getDescription());
		record.setDocument(recordIo.getDocument());
		record.setDonedate(recordIo.getDonedate());
		record.setPoints(recordIo.getPoints());
		record.setStartdate(recordIo.getStartdate());
		record.setStatus(recordIo.getStatus());
		return aas.add(record);
	}

	@GetMapping(value = NAGPconstants.GET_ALL_APPLICANT_ACTIVITY)
	public List<ApplicantActivityRecord> findAll() {
		return aas.getAll();
	}

	@PostMapping(value = NAGPconstants.GET_APPLICANT_ACTIVITY_FILTER_BY_EMPLOYEE_ID)
	public List<ApplicantActivityIO> filterbyEmployeeId(@RequestBody String employee_id) {
		return aas.filterByEmployeeId(employee_id);
	}

	@PostMapping(value = NAGPconstants.IS_APPLICANT_ACTIVITY_PRESENT)
	public List<ApplicantActivityRecord> isRecordPresent(@RequestBody ApplicantActivityRecordIO recordIo) {
		ApplicantActivityRecord record = new ApplicantActivityRecord();
		record.setActivity_id(act.getByid(recordIo.getActivity_id()));
		record.setAssignee(as.getById(recordIo.getEmployee_id()));
		record.setLevel_id(nl.findById(recordIo.getLevel_id()));
		record.setCompletiondate(recordIo.getCompletiondate());
		record.setDescription(recordIo.getDescription());
		record.setDocument(recordIo.getDocument());
		record.setDonedate(recordIo.getDonedate());
		record.setPoints(recordIo.getPoints());
		record.setStartdate(recordIo.getStartdate());
		record.setStatus(recordIo.getStatus());
		return aas.isRecordPresentforApplicant(record); // return ApplicantActivityRecord if record is present

	}

	@PostMapping(value = NAGPconstants.CHANGE_APPLICANT_ACTIVITY_STATUS)
	public ApplicantActivityIO changeStatus(@RequestBody String statusDetails) {
		System.out.println(statusDetails);
		int score = 0;
		String ans[] = statusDetails.split(" ");
		if ("COMPLETED".equals(ans[1])) {
			score = Integer.parseInt(ans[2]);
		}
		return aas.changeStatus(Integer.parseInt(ans[0]), ans[1], score);
	}
}
