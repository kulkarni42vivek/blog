package com.blogservice.blog.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "tag_mstr")
@NoArgsConstructor
@AllArgsConstructor
public class TagModel {
	@Id
	@SequenceGenerator(name = "tag_seq", sequenceName = "tag_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
	@Column(name = "tag_code")
	private long tagCode;
	private String tagName;
	private String tagDesc;

	@ManyToMany(mappedBy = "tags")
	private Set<Post> posts = new HashSet<>();
}
