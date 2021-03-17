package com.etrieu00.springblog.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.etrieu00.springblog.entities.Comments;
import com.etrieu00.springblog.entities.Posts;
import com.etrieu00.springblog.entities.Users;

public interface CommentsJPA extends JpaRepository<Comments,Long> {
	List<Comments> findAllCommentsByPost(Posts post);
	List<Comments> findAllCommentsByUser(Users user);
}
