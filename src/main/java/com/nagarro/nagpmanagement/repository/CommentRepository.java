package com.nagarro.nagpmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagpmanagement.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query(value = "SELECT * FROM Comment where activity_record=:activity_record ORDER BY timestamp DESC", nativeQuery = true)
	List<Comment> getComments(@Param("activity_record") int activity_record);

}
