package com.nagarro.nagpmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.model.Batch;
import com.nagarro.nagpmanagement.repository.BatchRepository;

@Service
public class BatchServices {

	@Autowired
	BatchRepository br;

	public Batch findById(String id) {
		System.out.println("in bls");
		return br.getOne(id);
	}

	public void add(Batch batch) {
		br.save(batch);
	}

	public List<Batch> showAll() {
		return br.findAll();
	}

	public void edit(Batch newBatch) {
		br.save(newBatch);

	}

	public void delete(String id) {
		br.deleteById(id);
	}

	public boolean checkAvailability(String batch_id) {
		try {
			Batch batch = br.getOne(batch_id);
			System.out.println(batch);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
