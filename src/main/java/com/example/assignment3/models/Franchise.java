package com.example.assignment3.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    @Column(length = 50, nullable = false)
    private String franchise_name;
    @Column(length = 300)
    private String description;
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
