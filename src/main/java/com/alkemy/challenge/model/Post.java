package com.alkemy.challenge.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alkemy.challenge.security.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="post")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private Long pId;
	
	@Column(name="post_tittle")
	private String tittle;
	
	@Column(name="post_content")
	private String content;
	
	@Column(name="post_img")
	private String img;
	
	@Column(name="post_creation_date")
	private LocalDate creationDate;
		
	@Column(name="post_user_id")
	private Long userId;
	
	@Column(name="post_category_id")
	private Long categoryId;
	
	@ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="post_user_id", insertable=false,updatable=false)
	private User user;
	
	@ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="post_category_id", insertable=false,updatable=false)
	private Category category;
	
	public Post() {}
}
