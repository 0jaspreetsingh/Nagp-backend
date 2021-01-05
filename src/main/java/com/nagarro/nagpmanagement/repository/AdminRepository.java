package com.nagarro.nagpmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.nagpmanagement.model.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

	@Query("from Administrator where username=:username and password =:password")
	Administrator match(@Param("username") String username, @Param("password") String password);
}
