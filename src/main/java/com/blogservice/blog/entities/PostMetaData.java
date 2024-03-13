package com.blogservice.blog.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
public class PostMetaData {
	
	@Id
	@SequenceGenerator(name = "po_m_seq" , sequenceName = "po_m_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "po_m_seq")
	private long metadataid;
	
	private String metaDataDetails;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(
			name = "post_fkey",
			referencedColumnName = "post_id"
			)
	private Post post;
}
