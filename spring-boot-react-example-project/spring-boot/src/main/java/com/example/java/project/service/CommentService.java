package com.example.java.project.service;

import java.util.List;
import java.util.Optional;

import com.example.java.project.entity.Comment;
import com.example.java.project.requests.CommentCreateRequest;
import com.example.java.project.requests.CommentUpdateRequest;

public interface CommentService {

	List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

	Comment getOneCommentById(Long commentId);

	Comment createOneComment(CommentCreateRequest request);

	Comment updateOneCommentById(Long commentId, CommentUpdateRequest request);

	void deleteOneCommentById(Long commentId);

}
