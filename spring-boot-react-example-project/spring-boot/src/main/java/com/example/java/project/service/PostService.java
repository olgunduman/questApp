package com.example.java.project.service;

import java.util.List;
import java.util.Optional;

import com.example.java.project.entity.Post;
import com.example.java.project.requests.PostCreateRequest;
import com.example.java.project.requests.PostUpdateRequest;

public interface PostService {

	List<Post> getAllPost(Optional<Long> userId);

	Post getOnePostById(Long postId);

	Post createOnePost(PostCreateRequest newPostRequest);

	Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest);

	void deleteOnePostById(Long postId);

	
}
