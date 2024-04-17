package com.projects.blogApplication.services.Impl;

import com.projects.blogApplication.entities.Author;
import com.projects.blogApplication.entities.Post;
import com.projects.blogApplication.repositories.AuthorRepository;
import com.projects.blogApplication.repositories.PostRepository;
import com.projects.blogApplication.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getPostsByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author != null){
            return author.getPosts();
        }
        return null;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Post createPost(Long authorId, Post post) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + authorId));

        post.setAuthor(author);
        post.setCreatedAt(LocalDateTime.now()); // Set current timestamp

        return postRepository.save(post);
    }
}
