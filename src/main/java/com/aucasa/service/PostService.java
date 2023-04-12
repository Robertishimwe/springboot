package com.aucasa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aucasa.model.Activity;
import com.aucasa.model.Post;
import com.aucasa.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	
	public String createPost(Post post) {
		
		repository.save(post);
		return "post added successfully";
	}
	public String deletePost(long  postId) {
		
		repository.deleteById(postId);
		return "post added successfully";
		
	}
	
	public String updatePost(Post post) {
		
		Post currentPost = repository.findById(post.getId()).get();
		currentPost.setDescription(post.getDescription());
		currentPost.setPostDate(post.getPostDate());
		repository.save(currentPost);
		return "Post updated";
		
	}
	
	public List<Post> allPost(){
		
		return repository.findAll();
	}
	
	public Post findPostById(long id) {
		return repository.findById(id).get();
	}
}
