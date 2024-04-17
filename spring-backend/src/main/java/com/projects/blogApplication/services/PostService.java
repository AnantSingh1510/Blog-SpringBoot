package com.projects.blogApplication.services;

import com.projects.blogApplication.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    void deletePost(Long id);
}
