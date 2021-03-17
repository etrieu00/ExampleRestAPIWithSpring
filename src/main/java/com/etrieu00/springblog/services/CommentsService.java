package com.etrieu00.springblog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etrieu00.springblog.dto.CommentsResponse;
import com.etrieu00.springblog.entities.Comments;
import com.etrieu00.springblog.entities.Posts;
import com.etrieu00.springblog.entities.Users;
import com.etrieu00.springblog.exceptions.CommentsException;
import com.etrieu00.springblog.exceptions.PostsException;
import com.etrieu00.springblog.repositories.CommentsJPA;
import com.etrieu00.springblog.repositories.PostsJPA;
import com.etrieu00.springblog.repositories.UsersJPA;

@Service
public class CommentsService {
	private final CommentsJPA commentsJpa;
	private final UsersJPA usersJpa;
	private final PostsJPA postsJpa;
	
	@Autowired
	public CommentsService(CommentsJPA commentsJpa, 
						   UsersJPA usersJpa, 
						   PostsJPA postsJpa) {
		this.commentsJpa = commentsJpa;
		this.usersJpa = usersJpa;
		this.postsJpa = postsJpa;
	}
	
	public CommentsResponse addNewComment(Long postId, 
										  CommentsResponse response) {
		Posts post = postsJpa.findById(postId).orElse(null);
		Users user = usersJpa.findById(response.getAuthor()).orElse(null);
		if(post != null
		&& user != null) {
			Comments savedComment = commentsJpa.save(new Comments(user, 
																  post,
																  response.getMessage()));
			return new CommentsResponse(savedComment.getCommentId(),
										savedComment.getUser().getUserId(),
									    savedComment.getPost().getPostId(),
									    savedComment.getMessage());
		} else {
			throw new PostsException("The post does not exist");
		}
	}
	
	public List<CommentsResponse> getAllCommentsForPost(Long postId){
		Posts post = postsJpa.findById(postId).orElse(null);
		if(post != null) {
			List<Comments> comments = commentsJpa.findAllCommentsByPost(post);
			return comments.stream()
						   .map(comment -> new CommentsResponse(comment.getCommentId(),
								   								comment.getUser().getUserId(),
															    comment.getPost().getPostId(),
															    comment.getMessage()))
						   .collect(Collectors.toList());
		} else {
			throw new PostsException("The post does not exist");
		}
	}
	
	public CommentsResponse editComment(Long postId, 
										Long commentId, 
										CommentsResponse response) {
		Posts post = postsJpa.findById(postId).orElse(null);
		Comments comment = commentsJpa.findById(commentId).orElse(null);
		Users user = usersJpa.findById(response.getAuthor()).orElse(null);
		if(post != null
		&& comment != null
		&& user != null
		&& comment.getPost().equals(post)
		&& comment.getCommentId() == commentId
		&& post.getPostId() == postId
		&& post.getUser().equals(user)
		&& comment.getUser().equals(user)) {
			comment.setMessage(response.getMessage());
			Comments newComment = commentsJpa.save(comment);
			return new CommentsResponse(newComment.getCommentId(),
										newComment.getUser().getUserId(),
										newComment.getPost().getPostId(),
										newComment.getMessage());
		} else {
			throw new CommentsException("The comment does not exist");
		}
	}
	
	public List<CommentsResponse> getAllCommentsForUser(Long userId){
		Users user = usersJpa.findById(userId).orElse(null);
		if(user != null ) {
			return user.getComments()
					   .stream()
					   .map(comment -> new CommentsResponse(comment.getCommentId(),
							   							   comment.getPost().getPostId(),
							   							   comment.getUser().getUserId(),
							   							   comment.getMessage()))
					   .collect(Collectors.toList());
		} else {
			return null;
		}
	}
}
