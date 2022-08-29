package com.example.assignment3.models;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    @Column(length = 50, nullable = false)
    private String movie_title;
    @Column(length = 200)
    private String genre;
    @Column(nullable = false)
    private int realese_year;
    @Column(length = 50, nullable = false)
    private String director;
    @Column(length = 2083)
    private String picture;
    @Column(length = 2083)
    private String link;
}
