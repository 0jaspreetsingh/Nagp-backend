package com.nagarro.nagpmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nagpmanagement.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String> {

}
