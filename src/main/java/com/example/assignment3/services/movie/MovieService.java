package com.example.assignment3.services.movie;

import com.example.assignment3.models.Movie;
import com.example.assignment3.services.CrudService;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer> {
    Collection<Movie> findAllByTitle(String title);
}
