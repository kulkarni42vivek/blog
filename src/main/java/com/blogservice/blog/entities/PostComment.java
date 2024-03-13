package com.blogservice.blog.entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "post_comment")
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {
	@Id
	@SequenceGenerator(name = "post_comm_seq", sequenceName = "post_comm_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_comm_seq")
	private long commentId;
	private String comment;
	private Timestamp createdOn;
	private long postLikes;
	@Transient
	private Long postId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fkey_post_id", referencedColumnName = "post_id")
	private Post post;

}
