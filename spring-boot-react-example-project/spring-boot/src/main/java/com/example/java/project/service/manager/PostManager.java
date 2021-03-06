package com.example.java.project.service.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.java.project.entity.Post;
import com.example.java.project.repository.PostRepository;
import com.example.java.project.requests.PostCreateRequest;
import com.example.java.project.requests.PostUpdateRequest;
import com.example.java.project.service.PostService;
import com.example.java.project.service.UserService;

@Service
public class PostManager implements PostService {

	private PostRepository postRepository;
	private UserService userService;

	public PostManager(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	@Override
	public List<Post> getAllPost(Optional<Long> userId) {
		if (userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}

	@Override
	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	@Override
	public Post createOnePost(PostCreateRequest newPostRequest) {
		var user = userService.getOneUserById(newPostRequest.getUserId());
		if (user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}

	@Override
	public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
		Optional<Post> post= postRepository.findById(postId);
		if(post.isPresent()) {
			var toUpdate = post.get();
			toUpdate.setText(postUpdateRequest.getText());
			toUpdate.setTitle(postUpdateRequest.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	@Override
	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}

}
