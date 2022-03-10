package com.example.java.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java.project.entity.Like;

public interface LikeRepository extends 
JpaRepository<Like, Long> {

	List<Like> findByUserIdAndPostId(Long userId, Long postId);

	List<Like> findByUserId(Long userId);

	List<Like> findByPostId(Long userId);

}
