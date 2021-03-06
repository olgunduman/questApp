package com.example.java.project.service;

import java.util.List;
import java.util.Optional;

import com.example.java.project.entity.Like;
import com.example.java.project.requests.LikeCreateRequest;

public interface LikeService {

	List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);

	Like getOneLikeById(Long likeId);

	Like createOneLike(LikeCreateRequest request);

	void deleteOneLikeById(Long likeId);

}
