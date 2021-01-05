package com.nagarro.nagpmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.model.Comment;
import com.nagarro.nagpmanagement.service.CommentServices;

@RestController
@CrossOrigin
public class CommentController {

	@Autowired
	CommentServices commentService;

	@PostMapping(value = NAGPconstants.POST_COMMENT)
	public List<Comment> postComment(@RequestBody Comment commentbody) {
		System.out.println(commentbody);
		return commentService.postComment(commentbody);
	}

	@PostMapping(value = NAGPconstants.GET_ALL_COMMENTS)
	public List<Comment> getAllComments(@RequestBody int activityRecord) {
		return commentService.getAllComments(activityRecord);
	}
}
