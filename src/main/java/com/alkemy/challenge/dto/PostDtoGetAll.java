package com.alkemy.challenge.dto;

import java.time.LocalDate;

public class PostDtoGetAll {

	private Long id;
	private String tittle;
	private String img;
	private CategoryDto categoryDto;
	private LocalDate creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

}
