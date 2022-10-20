package com.rest.webservices.socialmediademo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rest.webservices.socialmediademo.models.Post;

@Component
public interface PostRepository extends JpaRepository<Post, Integer> {

}
