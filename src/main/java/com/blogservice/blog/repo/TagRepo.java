package com.blogservice.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogservice.blog.entities.TagModel;

@Repository
public interface TagRepo  extends JpaRepository<TagModel, Long>{

}
