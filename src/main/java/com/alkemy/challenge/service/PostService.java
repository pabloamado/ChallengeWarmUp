package com.alkemy.challenge.service;

import java.util.List;

import com.alkemy.challenge.dto.PostDto;
import com.alkemy.challenge.dto.PostDtoGetAll;


public interface PostService  {

	PostDto savePost(PostDto postDto);
	
	PostDto getPost (Long id);
	
	List<PostDtoGetAll> getPostsFiltered(String tittle, Long categoryId);
	
	PostDto updatePost (PostDto postDto, Long id);
	
	void deletePost (Long id);
	
}
