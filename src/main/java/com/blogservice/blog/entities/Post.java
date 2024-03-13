package com.blogservice.blog.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@Column(name = "post_id")
	@SequenceGenerator(name = "po_seq", sequenceName = "po_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "po_seq")
	private int postId;
	private String authorId;
	private String title;
	private String headerImagePath;
	private String content;
	private boolean isPublished;
	private long likes;
	private long dislikes;
	private int postComments;


	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "post_tag_map",
        joinColumns = @JoinColumn(name = "post_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_code")
    )
    private Set<TagModel> tags = new HashSet<>();
	
}
