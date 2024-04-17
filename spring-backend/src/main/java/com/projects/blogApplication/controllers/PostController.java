package com.projects.blogApplication.controllers;

import com.projects.blogApplication.entities.Post;
import com.projects.blogApplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.ok("Deleted");
    }
}
