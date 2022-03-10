package com.example.java.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Data
@Getter
@Setter
public class User {

	@Id
	private Long id;
	private String userName;
	private String password;
	
	
	
	
	
}
