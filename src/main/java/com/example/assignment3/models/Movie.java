package com.example.assignment3.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 200)
    private String genre;
    @Column(nullable = false)
    private int realese_year;
    @Column(length = 50, nullable = false)
    private String director;
    @Column(length = 2083)
    private String picture;
    @Column(length = 2083)
    private String trailer;
    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;
    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    /*@JsonGetter("characters")
    public List<Integer> jsonGetCharacters() {
        if(characters != null)
            return characters.stream().map(s -> s.getCharacter_id())
                    .collect(Collectors.toList());
        return null;
    }*/
}
