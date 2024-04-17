package com.projects.blogApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(nullable = true)
    private LocalDateTime createdAt;

}
