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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.model.Batch;
import com.nagarro.nagpmanagement.service.BatchServices;

@RestController
@CrossOrigin
public class BatchController {

	@Autowired
	BatchServices bs;

	@RequestMapping(value = NAGPconstants.ADD_BATCH, method = RequestMethod.POST)
	public void add(@RequestBody Batch batch) {
		bs.add(batch);
	}

	@GetMapping(value = NAGPconstants.GET_ALL_BATCHES)
	public ResponseEntity<List<Batch>> showAll() {
		return new ResponseEntity<>(bs.showAll(), HttpStatus.OK);
	}

	@PutMapping(value = NAGPconstants.EDIT_BATCH)
	public void edit(@RequestBody Batch batch) {
		bs.edit(batch);
	}

	@DeleteMapping(value = NAGPconstants.BATCH)
	public void delete(@RequestParam String id) {
		bs.delete(id);
	}

	@PostMapping(value = NAGPconstants.IS_BATCH_ID_AVAILABLE)
	public boolean checkIfAvailable(@RequestBody String batch_id) {
		System.out.println(batch_id);
		return bs.checkAvailability(batch_id);
	}
}
