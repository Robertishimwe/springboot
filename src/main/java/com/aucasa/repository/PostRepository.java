package com.aucasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aucasa.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
