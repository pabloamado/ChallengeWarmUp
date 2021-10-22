package com.alkemy.challenge.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.Exception.BodyDtoException;
import com.alkemy.challenge.Exception.msg.ErrorMsg;
import com.alkemy.challenge.dto.CategoryDto;
import com.alkemy.challenge.mapper.CategoryMapper;
import com.alkemy.challenge.model.Category;
import com.alkemy.challenge.repository.CategoryRepository;
import com.alkemy.challenge.service.CategoryService;
import com.alkemy.challenge.validator.DtoValidator;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	DtoValidator dtoValidator;

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {

		if (dtoValidator.categoryDtoIsValid(categoryDto)) {

			Category category = categoryMapper.toCategory(categoryDto);

			category = categoryRepository.save(category);

			return categoryMapper.toCategoryDto(category);

		}

		throw new BodyDtoException(ErrorMsg.dtoBodyNotValidMsg());

	}

	public void deleteCategory(Long id) {

		if (categoryRepository.existsById(id)) {

			categoryRepository.deleteById(id);

		} else {

			throw new EntityNotFoundException(ErrorMsg.categoryNotFoundMsg(id));

		}

	}
}
