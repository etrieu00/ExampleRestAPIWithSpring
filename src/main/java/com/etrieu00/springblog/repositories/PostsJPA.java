package com.etrieu00.springblog.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.etrieu00.springblog.entities.Posts;

public interface PostsJPA extends JpaRepository<Posts,Long> {
	Posts findPostsByComments(Long id);
	List<Posts> findAllPostsByUser(Long id);
}
