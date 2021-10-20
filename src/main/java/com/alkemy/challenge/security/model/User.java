package com.alkemy.challenge.security.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alkemy.challenge.model.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long uId;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password")
	private String password;
	
	@OneToMany(mappedBy="userId")
	private Set<Post> posts=new HashSet<>();
	
}
