package com.example.assignment3.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_id;
    @Column(length = 50, nullable = false)
    private String full_name;
    @Column(length = 50)
    private String alias;
    @Column(length = 30)
    private String gender;
    @Column(length = 2083)
    private String picture;
    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movies;
}
