package com.alkemy.challenge.validator;

import com.alkemy.challenge.dto.CategoryDto;
import com.alkemy.challenge.dto.PostDto;

public class DtoValidator {

	public boolean categoryDtoIsValid(CategoryDto categoryDto) {

		if (categoryDto.getName() != null && !categoryDto.getName().isBlank()) {

			return true;
		}

		return false;
	}

	public boolean postDtoIsValid(PostDto postDto) {

		if (postDtoStringIsValid(postDto.getTittle()) && postDtoStringIsValid(postDto.getContent())
				&& postDtoImgIsValid(postDto) && postDtoIdValid(postDto.getCategoryId())
				&& postDtoIdValid(postDto.getUserId()) && postDto.getCreationDate() != null) {

			return true;
		}

		return false;
	}

	private boolean postDtoStringIsValid(String body) {

		return body != null && !body.isBlank();

	}

	private boolean postDtoImgIsValid(PostDto postDto) {

		String img = postDto.getImg();

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
