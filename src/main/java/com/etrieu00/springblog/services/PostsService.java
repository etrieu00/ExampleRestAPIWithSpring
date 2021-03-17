package com.etrieu00.springblog.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etrieu00.springblog.entities.Posts;
import com.etrieu00.springblog.entities.Users;
import com.etrieu00.springblog.repositories.PostsJPA;
import com.etrieu00.springblog.repositories.UsersJPA;
import com.etrieu00.springblog.dto.PostsResponse;

@Service
public class PostsService {
	private final PostsJPA postsJpa;
	private final UsersJPA usersJpa;
	
	@Autowired
	public PostsService(PostsJPA postsJpa,
						UsersJPA usersJpa) {
		this.postsJpa = postsJpa;
		this.usersJpa = usersJpa;
	}
	
	public List<PostsResponse> getAllPost() {
		List<Posts> posts = postsJpa.findAll();
		return posts.stream()
					.map(post -> 
						new PostsResponse(post.getPostId(),
										  post.getTitle(),
										  post.getBody(),
										  post.getUser() == null 
										  	? null 
								  			: post.getUser().getUserId()))
					.collect(Collectors.toList());
	}
	
	public PostsResponse getPost(Long id) {
		Posts posts = postsJpa.findById(id).orElse(null);
		return posts == null 
			? null 
			: new PostsResponse(posts.getPostId(), 
								posts.getTitle(),
								posts.getBody(),
								posts.getUser().getUserId());
	}
	
	public PostsResponse createNewPost(PostsResponse response) {
		Users user = null;
		if(response.getAuthor() != null) {
			user = usersJpa.findById(response.getAuthor())
						   .orElse(null);			
		} else {
			return null;
		}
		Posts posts = new Posts(response.getTitle(),
								response.getBody(),
								user);
		Posts newPost = postsJpa.save(posts);
		return new PostsResponse(newPost.getPostId(), 
								 newPost.getTitle(), 
								 newPost.getBody(),
								 newPost.getUser().getUserId());
	}
	
	public boolean updatePost(Long id, PostsResponse response) {
		Posts post = postsJpa.findById(id)
							 .orElse(null);
		if(post != null 
		&& post.getUser().getUserId() == response.getAuthor()) {
			post.setTitle(response.getTitle());
			post.setBody(response.getBody());
			return postsJpa.save(post) != null;
		} else {
			return false;
		}
	}
}
