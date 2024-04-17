package com.projects.blogApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;
}
