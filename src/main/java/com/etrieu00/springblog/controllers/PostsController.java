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
import com.etrieu00.springblog.dto.PostsResponse;
import com.etrieu00.springblog.services.PostsService;

@RestController
public class PostsController implements BaseController {
	private final PostsService postsService;
	
	@Autowired
	public PostsController(PostsService postsService) {
		this.postsService = postsService;
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostsResponse>> getAllBlogPost() {
		List<PostsResponse> posts = postsService.getAllPost();
		return new ResponseEntity<List<PostsResponse>>(posts, 
													   HttpStatus.OK);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<?> createNewBlogPost(@RequestBody PostsResponse request) {
		PostsResponse response = postsService.createNewPost(request);
		return response != null
			? new ResponseEntity<PostsResponse>(response, 
										 HttpStatus.CREATED) 
			: new ResponseEntity<String>("Failed to create post", 
										 HttpStatus.FORBIDDEN);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<String> updateNewBlogPost(@PathVariable("id") Long id, 
													@RequestBody PostsResponse request) {
		return postsService.updatePost(id, request) 
			? new ResponseEntity<String>("Post updated", 
										 HttpStatus.OK) 
			: new ResponseEntity<String>("Failed to update post", 
										 HttpStatus.FORBIDDEN);
	}
	
}
