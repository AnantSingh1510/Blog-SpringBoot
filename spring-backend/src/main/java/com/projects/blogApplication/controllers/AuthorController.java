package com.projects.blogApplication.controllers;

import com.projects.blogApplication.entities.Author;
import com.projects.blogApplication.entities.Post;
import com.projects.blogApplication.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
//@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsByAuthor(@PathVariable Long id) {
        return authorService.getPostsByAuthor(id);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Author createdAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @PostMapping("/{authorId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable Long authorId, @RequestBody Post post) {
        Post createdPost = authorService.createPost(authorId, post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }
}
