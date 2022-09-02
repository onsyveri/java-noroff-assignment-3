package com.example.assignment3.models.dtos.movie;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.Franchise;
import lombok.Data;

import java.util.Set;

@Data
public class MovieDTO {
    private int movie_id;
    private String title;
    private String genre;
    private int realese_year;
    private String director;
    private String picture;
    private String trailer;
    //private Franchise franchise;
}
