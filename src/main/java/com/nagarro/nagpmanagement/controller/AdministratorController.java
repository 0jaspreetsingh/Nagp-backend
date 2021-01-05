package com.nagarro.nagpmanagement.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.model.Administrator;
import com.nagarro.nagpmanagement.service.AdminServices;
import com.nagarro.nagpmanagement.storage.Properties;
import com.nagarro.nagpmanagement.util.SessionKeyGenerator;

@RestController
public class AdministratorController {

	@Autowired
	AdminServices as;

	@CrossOrigin
	@RequestMapping(value = NAGPconstants.ADMIN_LOGIN, method = RequestMethod.POST)
	public ResponseEntity<String> authenticate(@RequestBody Administrator admin) {
		// System.out.println(admin.getUsername() + " " + admin.getPassword());
		// System.out.println("AFAFAHDSLFADJSHF");
		if (as.authenticate(admin.getUsername(), admin.getPassword())) {
			String sessionKey = SessionKeyGenerator.generateKey();
			// save key in hashmap
			Properties.addSessionKey(admin.getUsername(), sessionKey);
			return new ResponseEntity<>(sessionKey, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid", HttpStatus.UNAUTHORIZED);
		}
//		 return as.authenticate(admin.getUsername(), admin.getPassword()) ? new
//		 ResponseEntity<>("True", HttpStatus.OK)
//		 : new ResponseEntity<>("False", HttpStatus.UNAUTHORIZED);
		// return as.authenticate(admin.getUsername(), admin.getPassword()) ? true :
		// false;

	}

	@CrossOrigin
	@RequestMapping(value = NAGPconstants.GENERATE_REPORT, method = RequestMethod.POST)
	public ResponseEntity<String> generateReport(@RequestBody String userandkey) throws IOException {
		String data[] = userandkey.split(" ");
		String username = data[0];
		String sessionKey = data[1];
		if (Properties.getSessionKey(username) != null && Properties.getSessionKey(username).equals(sessionKey)) {
			// generate report
			System.out.println("Generate Report");
			as.createAndOrganiseReports();
			// as.getApplicantReport("2");
			return new ResponseEntity<String>("Report generted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("An error occoured while generating report", HttpStatus.UNAUTHORIZED);
		}
	}

}
