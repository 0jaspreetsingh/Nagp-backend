package com.nagarro.nagpmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.nagpmanagement.model.Activity;
import com.nagarro.nagpmanagement.model.Applicant;
import com.nagarro.nagpmanagement.model.ApplicantActivityRecord;
import com.nagarro.nagpmanagement.model.Nagplevel;

@Repository
public interface ApplicantActivityRepository extends JpaRepository<ApplicantActivityRecord, Integer> {

	@Query("from ApplicantActivityRecord where employee_id=:employee_id")
	List<ApplicantActivityRecord> filterByEmployeeId(@Param("employee_id") String employee_id);

	@Query("from ApplicantActivityRecord where activity_id=:activity_id and assignee=:assignee and  level_id=:level_id")
	List<ApplicantActivityRecord> isRecordAlreadyPresent(@Param("activity_id") Activity activity_id,
			@Param("assignee") Applicant assignee, @Param("level_id") Nagplevel level_id);

	@Query("SELECT COUNT(employee_id) from ApplicantActivityRecord where employee_id=:employee_id")
	int getnumberOfActivitiesInProgress(int employee_id);

//	@Query("from ApplicantActivityRecord where employee_id=:employee_id")
//	List<ApplicantActivityRecord> getApplicantActivityData(@Param("employee_id") String employee_id);
//	@Query(value = "SELECT sum(points) FROM applicant_activity_record where employee_id =:employee_id and level_id=:level_id",nativeQuery = true)
//	Double getPoints(@RequestParam("employee_id") int employee_id,@RequestParam("level_id") String level_id);
}
