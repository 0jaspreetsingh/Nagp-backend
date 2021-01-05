package com.nagarro.nagpmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.model.Nagplevel;
import com.nagarro.nagpmanagement.service.NAGPLevelServices;

@RestController
@CrossOrigin
public class LevelController {

	@Autowired
	NAGPLevelServices ls;

	@PostMapping(value = NAGPconstants.ADD_LEVEL)
	public void add(@RequestBody Nagplevel level) {
		System.out.println(level);
		ls.add(level);
	}

	@GetMapping(value = NAGPconstants.GET_ALL_LEVELS)
	public ResponseEntity<List<Nagplevel>> showAll() {
		return new ResponseEntity<>(ls.showAll(), HttpStatus.OK);
	}

	@PutMapping(value = NAGPconstants.EDIT_LEVEL)
	public void edit(@RequestBody Nagplevel level) {
		ls.edit(level);
	}

	@DeleteMapping(value = NAGPconstants.LEVEL)
	public void delete(@RequestParam String id) {
		ls.delete(id);
	}

	@PostMapping(value = NAGPconstants.IS_LEVEL_ID_AVAILABLE)
	public boolean checkIfAvailable(@RequestBody String level_id) {
		System.out.println(level_id);
		return ls.checkAvailability(level_id);
	}

	@PostMapping(value = NAGPconstants.GET_LEVEL_BY_ID)
	public ResponseEntity<Nagplevel> getLevel(@RequestBody String level_id) {
		return new ResponseEntity<Nagplevel>(ls.findById(level_id), HttpStatus.OK);
	}
}
