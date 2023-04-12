package com.aucasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aucasa.model.Activity;
import com.aucasa.model.Post;
import com.aucasa.service.ActivityService;
import com.aucasa.service.PostService;

@RestController
@RequestMapping("/aucasa/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/new")
	public String createPost(@RequestBody Post post) {
		
		return postService.createPost(post);
	}
	@PostMapping("/update")
   public String updateActivity(@RequestBody Post post) {
		Post pst =postService.findPostById(post.getId());
		pst.setDescription(post.getDescription());
		
		pst.setPostDate(post.getPostDate());
		
		return postService.createPost(pst);
	}

    @GetMapping("/delete/{id}")
   public String deletePost(@PathVariable(value = "id") long id) {
	   return postService.deletePost(id);
   }
    
    @GetMapping("/all")
    public List<Post> findAllPost(){
    	return postService.allPost();
    }
}
