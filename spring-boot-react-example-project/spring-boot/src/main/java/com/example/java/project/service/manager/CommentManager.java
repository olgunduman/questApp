package com.example.java.project.service.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.java.project.entity.Comment;
import com.example.java.project.repository.CommentRepository;
import com.example.java.project.requests.CommentCreateRequest;
import com.example.java.project.requests.CommentUpdateRequest;
import com.example.java.project.service.CommentService;
import com.example.java.project.service.PostService;
import com.example.java.project.service.UserService;

@Service
public class CommentManager implements CommentService {

	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	

	public CommentManager(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	@Override
	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}else
			return commentRepository.findAll();
	}

	@Override
	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	@Override
	public Comment createOneComment(CommentCreateRequest request) {
		var user=userService.getOneUserById(request.getUserId());
		var post=postService.getOnePostById(request.getPostId());
		if(user !=null && post !=null) {
			var commentToSave=new Comment();
			commentToSave.setId(request.getId());
			commentToSave.setText(request.getText());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			return commentRepository.save(commentToSave);
		}else
		return null;
	}

	@Override
	public Comment updateOneCommentById(Long commentId,CommentUpdateRequest request) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			var commentToUpdate=comment.get();
			commentToUpdate.setText(request.getText());
			return commentRepository.save(commentToUpdate);
		}else
			return null;
	}

	@Override
	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}
	
}
