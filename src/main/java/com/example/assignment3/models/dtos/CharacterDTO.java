package com.example.assignment3.models.dtos;

import com.example.assignment3.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterDTO {
    private int character_id;
    private String full_name;
    private String alias;
    private String gender;
    private String picture;
    private Set<Movie> movies;

}
