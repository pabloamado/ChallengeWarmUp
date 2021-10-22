package com.alkemy.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.alkemy.challenge.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>, JpaSpecificationExecutor<Post>{

	List<Post> findAll(Specification<Post> specification);
}
