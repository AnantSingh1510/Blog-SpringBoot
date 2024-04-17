package com.projects.blogApplication.services;

import com.projects.blogApplication.entities.Author;
import com.projects.blogApplication.entities.Post;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    List<Post> getPostsByAuthor(Long authorId);
    Author createAuthor(Author author);
    Post createPost(Long authorId, Post post);
}
