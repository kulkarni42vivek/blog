package com.blogservice.blog.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCommentDto {
	private long commentId;
	private int postId;
	private String comment;
	private Timestamp createdOn;
	private long postLikes;
}
