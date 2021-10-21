package com.alkemy.challenge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alkemy.challenge.dto.PostDto;
import com.alkemy.challenge.dto.PostDtoGetAll;
import com.alkemy.challenge.mapper.PostMapper;
import com.alkemy.challenge.model.Post;
import com.alkemy.challenge.model.Specification.PostSpecification;
import com.alkemy.challenge.repository.PostRepository;
import com.alkemy.challenge.service.PostService;

public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	PostMapper postMapper;

	@Autowired
	PostSpecification postSpecification;

	@Override
	public PostDto savePost(PostDto postDto) {

		Post post = postMapper.toPost(postDto);

		post = postRepository.save(post);

		return postMapper.toPostDto(post);
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

		Post post = postRepository.getById(id);

		postMapper.refreshValues(post, postDto);

		post = postRepository.save(post);

		return postMapper.toPostDto(post);
	}

	@Override
	public void deletePost(Long id) {

		postRepository.deleteById(id);

	}

}
