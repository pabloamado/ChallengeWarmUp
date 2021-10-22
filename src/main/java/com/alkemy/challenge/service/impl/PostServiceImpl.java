package com.alkemy.challenge.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.challenge.Exception.BodyDtoException;
import com.alkemy.challenge.Exception.msg.ErrorMsg;
import com.alkemy.challenge.dto.PostDto;
import com.alkemy.challenge.dto.PostDtoGetAll;
import com.alkemy.challenge.mapper.PostMapper;
import com.alkemy.challenge.model.Post;
import com.alkemy.challenge.model.Specification.PostSpecification;
import com.alkemy.challenge.repository.PostRepository;
import com.alkemy.challenge.security.model.User;
import com.alkemy.challenge.security.service.UserService;
import com.alkemy.challenge.service.PostService;
import com.alkemy.challenge.validator.DtoValidator;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	PostMapper postMapper;

	@Autowired
	PostSpecification postSpecification;

	@Autowired
	DtoValidator dtoValidator;

	@Autowired
	UserService userService;

	@Override
	public PostDto savePost(PostDto postDto, String username) {

		// it wont be null because the security filter previously took care of validate
		// the jwt
		User user = userService.findUserByEmail(username);

		if (dtoValidator.postDtoIsValid(postDto)) {

			Post post = postMapper.toPost(postDto, user.getUserId());

			post = postRepository.save(post);

			return postMapper.toPostDto(post);

		}

		throw new BodyDtoException(ErrorMsg.dtoBodyNotValidMsg());

	}

	@Override
	public PostDto getPost(Long id) {

		Post post = postRepository.getById(id);

		return postMapper.toPostDto(post);
	}

	@Override
	public List<PostDtoGetAll> getPostsFiltered(String tittle, Long categoryId) {

		List<Post> posts = postRepository.findAll(postSpecification.getByFilters(tittle, categoryId));

		return postMapper.toPostDtoGetAllList(posts);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Long id) {

		if (dtoValidator.postDtoIsValid(postDto)) {

			Post post = postRepository.getById(id);

			postMapper.refreshValues(post, postDto);

			post = postRepository.save(post);

			return postMapper.toPostDto(post);

		} else {

			throw new BodyDtoException(ErrorMsg.dtoBodyNotValidMsg());

		}

	}

	@Override
	public void deletePost(Long id) {

		if (postRepository.existsById(id)) {

			postRepository.deleteById(id);

		} else {

			throw new EntityNotFoundException(ErrorMsg.postNotFoundMsg(id));

		}

	}

}
