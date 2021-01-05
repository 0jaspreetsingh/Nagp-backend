package com.nagarro.nagpmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.nagpmanagement.model.Nagplevel;

@Repository
public interface NAGPLevelRepository extends JpaRepository<Nagplevel, String> {

}
