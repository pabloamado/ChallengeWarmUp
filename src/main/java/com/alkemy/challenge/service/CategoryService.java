package com.alkemy.challenge.service;

import com.alkemy.challenge.dto.CategoryDto;

public interface CategoryService {

	CategoryDto saveCategory(CategoryDto categoryDto);

	void deleteCategory(Long id);
}
