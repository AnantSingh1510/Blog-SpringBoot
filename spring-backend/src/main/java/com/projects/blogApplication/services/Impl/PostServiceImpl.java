package com.projects.blogApplication.services.Impl;

import com.projects.blogApplication.entities.Post;
import com.projects.blogApplication.repositories.PostRepository;
import com.projects.blogApplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
