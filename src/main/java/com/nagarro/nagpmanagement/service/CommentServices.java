package com.nagarro.nagpmanagement.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.model.Comment;
import com.nagarro.nagpmanagement.repository.CommentRepository;

@Service
public class CommentServices {

	@Autowired
	CommentRepository commentRepo;

	public List<Comment> getAllComments(int activityRecord) {
		return commentRepo.getComments(activityRecord);
	}

	public List<Comment> postComment(Comment comment) {
		comment.setTimestamp(Calendar.getInstance().getTimeInMillis());
		commentRepo.save(comment);
		return getAllComments(comment.getActivityRecord());
	}
}
