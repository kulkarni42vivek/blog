package com.blogservice.blog.controlr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogservice.blog.entities.TagModel;
import com.blogservice.blog.service.PostService;
import com.blogservice.blog.service.TagService;

@RestController
public class TagController {
	
	@Autowired
    private TagService tagService;
	
	@GetMapping
	public List<TagModel> getAllTags(){
		return tagService.getAllTags();
	}
	
	@PostMapping
	public List<TagModel> getPostByTag(@RequestBody TagModel tag ){
		return tagService.getPostByTag(tag);
	}
	
}
