package com.nagarro.nagpmanagement.controller;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.io.ActivityPointsList;
import com.nagarro.nagpmanagement.io.ApplicantIO;
import com.nagarro.nagpmanagement.model.Applicant;
import com.nagarro.nagpmanagement.model.Batch;
import com.nagarro.nagpmanagement.model.Nagplevel;
import com.nagarro.nagpmanagement.service.ApplicantServices;
import com.nagarro.nagpmanagement.service.BatchServices;
import com.nagarro.nagpmanagement.service.NAGPLevelServices;
import com.nagarro.nagpmanagement.storage.Properties;
import com.nagarro.nagpmanagement.util.SessionKeyGenerator;

@RestController
@CrossOrigin(origins = "*")
public class ApplicantController {

	@Autowired
	ApplicantServices as;

	@Transient
	@Autowired
	NAGPLevelServices nl;

	@Transient
	@Autowired
	BatchServices bs;

	@PostMapping(value = NAGPconstants.ADD_APPLCANT)
	public void add(@RequestBody ApplicantIO applicantIo) {

		System.out.println(applicantIo);
		Applicant applicant = new Applicant();
		Batch batch = bs.findById(applicantIo.getBatch_id());
		applicant.setBatch(batch);
		applicant.setEmail(applicantIo.getEmail());
		applicant.setEmployee_id(applicantIo.getEmployee_id());
		Nagplevel level = nl.findById(applicantIo.getLevel_id());
		applicant.setLevel(level);
		applicant.setNAGP_status(applicantIo.getNAGP_status());
		applicant.setName(applicantIo.getName());
		applicant.setNumber(applicantIo.getNumber());
		applicant.setPassword(applicantIo.getPassword());

		System.out.println(applicant);
		as.add(applicant);

	}

	@GetMapping(value = NAGPconstants.GET_ALL_APPLICANTS)
	public ResponseEntity<List<Applicant>> showAll() {
		return new ResponseEntity<>(as.showAll(), HttpStatus.OK);
	}

	@PutMapping(value = NAGPconstants.EDIT_APPLICANTS)
	public void edit(@RequestBody ApplicantIO applicantIo) {
		System.out.println(applicantIo);
		Applicant applicant = new Applicant();
		Batch batch = bs.findById(applicantIo.getBatch_id());
		applicant.setBatch(batch);
		applicant.setEmail(applicantIo.getEmail());
		applicant.setEmployee_id(applicantIo.getEmployee_id());
		Nagplevel level = nl.findById(applicantIo.getLevel_id());
		applicant.setLevel(level);
		applicant.setNAGP_status(applicantIo.getNAGP_status());
		applicant.setName(applicantIo.getName());
		applicant.setNumber(applicantIo.getNumber());
		applicant.setPassword(applicantIo.getPassword());

		System.out.println(applicant);
		as.edit(applicant);
	}

	@CrossOrigin
	@RequestMapping(value = NAGPconstants.APPLICANT_LOGIN, method = RequestMethod.POST)
	public ResponseEntity<Applicant> authenticate(@RequestBody ApplicantIO applicantIo) {

		System.out.println(applicantIo.getEmployee_id() + "  " + applicantIo.getPassword());
		if (as.authenticate(applicantIo.getEmployee_id(), applicantIo.getPassword())) {
			String sessionKey = SessionKeyGenerator.generateKey();
			// save key in hashmap
			Properties.addSessionKey(applicantIo.getEmail(), sessionKey);
			return new ResponseEntity<>(as.getById(applicantIo.getEmployee_id()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}

	@CrossOrigin
	@RequestMapping(value = NAGPconstants.GET_POINTS)
	public ResponseEntity<ActivityPointsList> getPoints(@RequestBody ApplicantIO applicantIo) {
		System.out.println(applicantIo.getEmployee_id() + " " + applicantIo.getLevel_id());

		return new ResponseEntity<ActivityPointsList>(as.getPointsArray(applicantIo), HttpStatus.OK);
	}
}
