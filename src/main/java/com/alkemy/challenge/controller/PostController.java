package com.alkemy.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.challenge.dto.PostDto;
import com.alkemy.challenge.dto.PostDtoGetAll;
import com.alkemy.challenge.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping
	public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {

		PostDto dto = postService.savePost(postDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPost(@PathVariable Long id) {

		PostDto dto = postService.getPost(id);

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@GetMapping
	public ResponseEntity<List<PostDtoGetAll>> getPosts(@RequestParam(required = false) String tittle,
			@RequestParam(required = false) Long categoryId) {

		List<PostDtoGetAll> dtos = postService.getPostsFiltered(tittle, categoryId);

		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long id) {

		PostDto dto = postService.updatePost(postDto, id);

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id) {

		postService.deletePost(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
