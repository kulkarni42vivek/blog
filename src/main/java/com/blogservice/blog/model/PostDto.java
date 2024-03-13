package com.blogservice.blog.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.blogservice.blog.entities.TagModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder 
public class PostDto {
	private int postId;
	private String authorId;
	private String title;
	private String headerImagePath;
	private String content;
	private boolean isPublished;
	private long likes;
	private long dislikes;
	private int postComments;
	private List<Long> tags ;
}
