package com.example.java.project.service.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.java.project.entity.Like;
import com.example.java.project.repository.LikeRepository;
import com.example.java.project.requests.LikeCreateRequest;
import com.example.java.project.service.LikeService;
import com.example.java.project.service.PostService;
import com.example.java.project.service.UserService;

@Service
public class LikeManager implements LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	

	public LikeManager(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}

	@Override
	public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}else if(userId.isPresent()) {
			return likeRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId.get());
		}
		return likeRepository.findAll();
	}

	@Override
	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	@Override
	public Like createOneLike(LikeCreateRequest request) {
		var user = userService.getOneUserById(request.getId());
		var post=postService.getOnePostById(request.getPostId());
		if(user !=null && post !=null) {
			var likeToSave=new Like();
			likeToSave.setId(request.getId());
			likeToSave.setUser(user);
			likeToSave.setPost(post);
			return likeRepository.save(likeToSave);
		}else
		return null;
	}

	@Override
	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
		
	}
	
}
