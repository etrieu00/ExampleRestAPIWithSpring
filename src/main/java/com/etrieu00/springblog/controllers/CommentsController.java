package com.etrieu00.springblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.etrieu00.springblog.dto.CommentsResponse;
import com.etrieu00.springblog.services.CommentsService;

@RestController
public class CommentsController implements BaseController {
	private final CommentsService commentsService;
	
	@Autowired
	public CommentsController(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	@GetMapping("/posts/{id}/comments")
	public ResponseEntity<List<CommentsResponse>> getAllCommentsForPost(@PathVariable("id") Long id) {
		return new ResponseEntity<List<CommentsResponse>>(commentsService.getAllCommentsForPost(id),
														  HttpStatus.OK);
	}
	
	@PostMapping("/posts/{post_id}/comments")
	public ResponseEntity<CommentsResponse> addNewCommentToPost(@PathVariable("post_id") Long postId,
												 				@RequestBody CommentsResponse request) {
		return new ResponseEntity<CommentsResponse>(commentsService.addNewComment(postId, request),
				  									HttpStatus.OK);
	}
	
	@PutMapping("/posts/{post_id}/comments/{comment_id}")
	public ResponseEntity<CommentsResponse> editComment(@PathVariable("post_id") Long postId,
														@PathVariable("comment_id") Long commentId,
														@RequestBody CommentsResponse response) {
		return new ResponseEntity<CommentsResponse>(commentsService.editComment(postId, commentId, response),
													HttpStatus.OK);
	}	
}
