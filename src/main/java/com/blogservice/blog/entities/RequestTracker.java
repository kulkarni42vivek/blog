package com.blogservice.blog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "request_tracker")
public class RequestTracker {
	
	@Id 
	@Column(name = "id" )
	@SequenceGenerator(name = "request_seq" , sequenceName = "request_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "request_seq")
	int requestId ;
	
	@Column(name = "purpose")
	String requestPurpose;
	
	@Column(name = "body")
	String requestBody;
}
