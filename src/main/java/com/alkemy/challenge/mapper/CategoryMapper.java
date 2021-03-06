package com.alkemy.challenge.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.CategoryDto;
import com.alkemy.challenge.model.Category;

@Component
public class CategoryMapper {

	public Category toCategory(CategoryDto categoryDto) {

		Category category = new Category();

		category.setName(categoryDto.getName());

		return category;
	}

	public CategoryDto toCategoryDto(Category category) {

		CategoryDto categoryDto = new CategoryDto();

		if(category!=null) {
			
			categoryDto.setcId(category.getcId());
			
			categoryDto.setName(category.getName());
			
		}
	
		return categoryDto;
	}

}