package com.alkemy.challenge.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name ="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="categ_id")
	private Long cId;
	
	@Column(name ="categ_name")
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<Post> posts=new ArrayList<>();
	
	public Category() {}

}
