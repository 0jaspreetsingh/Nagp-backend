package com.nagarro.nagpmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.nagpmanagement.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {

	@Query("from Activity where level_id=:level_id and batch_id=:batch_id")
	List<Activity> match(@Param("level_id") String level_id, @Param("batch_id") String batch_id);

}
