package com.blogservice.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogservice.blog.entities.Post;
import com.blogservice.blog.entities.TagModel;
import com.blogservice.blog.entities.UserModel;
import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByAuthorId(String i);

	@Query("SELECT p FROM Post p JOIN p.tags t WHERE t.tagCode = :tagCode")
	List<TagModel> findByTagCode(@Param("tagCode") long tagCode);

}
