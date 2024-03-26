package br.com.api.joyapi.entity;

import java.sql.Date;

import br.com.api.joyapi.entity.enums.GenderEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class Person {
	@Id
	@GeneratedValue	(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@Column(nullable = false, unique = true)
	private String username;

	private String password;
	
	private String photo;
	
	private GenderEnum gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(nullable = false, unique = true)
	private String email;
	
}
