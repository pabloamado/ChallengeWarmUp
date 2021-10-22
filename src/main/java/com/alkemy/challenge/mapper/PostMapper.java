package com.alkemy.challenge.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.challenge.dto.PostDto;
import com.alkemy.challenge.dto.PostDtoGetAll;
import com.alkemy.challenge.model.Post;

@Component
public class PostMapper {
	
	@Autowired 
	CategoryMapper categoryMapper;

	public Post toPost(PostDto postDto, Long userId) {

		Post post = new Post();
		post.setUserId(userId);
		refreshPost(post, postDto);
		
		return post;
	}

	public PostDto toPostDto(Post post) {
		
		PostDto postDto=new PostDto();
		
		if(post!=null) {
			
			postDto.setId(post.getpId());
			postDto.setTittle(post.getTittle());
			postDto.setContent(post.getContent());
			postDto.setImg(post.getImg());
			postDto.setCreationDate(post.getCreationDate());
			postDto.setCategoryId(post.getCategoryId());
			postDto.setUserId(post.getUserId());
			
		}
		
		return postDto;
	}
	
	public void refreshValues(Post post, PostDto postDto) {
		
		
		
			refreshPost(post, postDto);
		
	}
	
	private void refreshPost(Post post, PostDto postDto) {
		
		if(post!=null) {
			
			post.setTittle(postDto.getTittle());
			post.setContent(postDto.getContent());
			post.setImg(postDto.getImg());
			post.setCategoryId(postDto.getCategoryId());
			post.setCreationDate(postDto.getCreationDate());
		}
	}

	public List<PostDtoGetAll> toPostDtoGetAllList(List<Post> posts) {
		
		List<PostDtoGetAll> dtos=new ArrayList<>();

		if(posts!=null) {
			
			for(Post p:posts) {
				
				PostDtoGetAll postDtoGetAll=new PostDtoGetAll();
				
				postDtoGetAll.setId(p.getpId());
				postDtoGetAll.setTittle(p.getTittle());
				postDtoGetAll.setImg(p.getImg());
				postDtoGetAll.setCreationDate(p.getCreationDate());
				postDtoGetAll.setCategoryDto(categoryMapper.toCategoryDto(p.getCategory()));
			
				dtos.add(postDtoGetAll);
			}
			
		}
		
		return dtos;
	}
	
}
