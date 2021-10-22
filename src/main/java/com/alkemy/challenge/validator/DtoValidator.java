package com.alkemy.challenge.validator;

import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.CategoryDto;
import com.alkemy.challenge.dto.PostDto;

@Component
public class DtoValidator {

	public boolean categoryDtoIsValid(CategoryDto categoryDto) {

		if (postDtoStringIsValid(categoryDto.getName())) {

			return true;
		}

		return false;
	}

	public boolean postDtoIsValid(PostDto postDto) {

		if (postDtoStringIsValid(postDto.getTittle()) && postDtoStringIsValid(postDto.getContent())
				&& postDtoImgIsValid(postDto.getImg()) && postDtoIdValid(postDto.getCategoryId())
				&& postDto.getCreationDate() != null) {

			return true;
		}

		return false;
	}

	private boolean postDtoStringIsValid(String body) {

		return body != null && !body.isBlank();

	}

	private boolean postDtoImgIsValid(String img) {

		if (postDtoStringIsValid(img)) {

			if (img.substring(img.length() - 4).equals(".jpg") || img.substring(img.length() - 4).equals(".png")) {

				return true;
			}
		}

		return false;

	}

	private boolean postDtoIdValid(Long id) {

		return id != null && id >= 1;
	}

}
