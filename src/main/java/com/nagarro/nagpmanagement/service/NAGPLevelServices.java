package com.nagarro.nagpmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.model.Nagplevel;
import com.nagarro.nagpmanagement.repository.NAGPLevelRepository;

@Service
public class NAGPLevelServices {

	@Autowired
	NAGPLevelRepository nlr;

	public Nagplevel findById(String id) {
		System.out.println("here");
		return nlr.getOne(id);
	}

	public List<Nagplevel> showAll() {
		return nlr.findAll();
	}

	public void edit(Nagplevel newData) {

		nlr.save(newData);
	}

	public void add(Nagplevel data) {
		nlr.save(data);
	}

	public void delete(String id) {
		nlr.deleteById(id);
	}

	public boolean checkAvailability(String id) {
		try {
			Nagplevel level = nlr.getOne(id);
			System.out.println(level);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
