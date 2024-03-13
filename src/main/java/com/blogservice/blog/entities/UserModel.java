package com.blogservice.blog.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_mstr" , uniqueConstraints =@UniqueConstraint(name="email_cnstr", columnNames = "email_addr"))
public class UserModel {
	@Id
	@SequenceGenerator(name = "user_id_seq" , sequenceName = "user_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_id_seq")
	private long userId ;
	private String password ;
	private String firstName ;
	private String lastName ;
	private String mobile ;
	
	@Column(name = "email_addr" , nullable = false)
	private String email ;
	
	@Embedded
	AddressModel address;
}
