package com.example.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java.project.entity.Post;

public interface PostRepository extends
JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

}
