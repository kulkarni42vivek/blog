package com.blogservice.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogservice.blog.entities.TagModel;
import com.blogservice.blog.repo.PostRepo;
import com.blogservice.blog.repo.TagRepo;

@Service
public class TagService {
	
	@Autowired
	TagRepo tagRepo;
	
	@Autowired
	PostRepo postRepo;

	public List<TagModel> getAllTags() {
		return tagRepo.findAll();
	}

	public List<TagModel> getPostByTag(TagModel tag) {
		return postRepo.findByTagCode(tag.getTagCode());
	}

}
