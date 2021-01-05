package com.nagarro.nagpmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.nagpmanagement.model.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

	@Query("update Applicant a set a.password=:newPassword where employee_id=:id")
	public void changePassword(@Param("id") int id, @Param("newPassword") String newPassword);

	@Query("from Applicant where employee_id=:employee_id and password =:password")
	Applicant match(@Param("employee_id") int employee_id, @Param("password") String password);
}
