package com.blogservice.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CommentToComment {
	@Id
	@Column(name = "comm_comment_id")
	@SequenceGenerator(name = "comment_c_seq", sequenceName = "comment_c_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_c_seq")
	private int commentId ;
	
	private int commentDesc ;
	private int likes ;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "main_commentId",referencedColumnName="commentId") 
	private PostComment postcomment;
}
