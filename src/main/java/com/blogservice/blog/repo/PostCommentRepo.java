package com.blogservice.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogservice.blog.entities.PostComment;
import java.util.List;
import com.blogservice.blog.entities.Post;


public interface PostCommentRepo extends JpaRepository<PostComment, Long>{
	List<PostComment> findByPost_PostId(long id);
}
