package com.example.assignment3.controllers;

import com.example.assignment3.mappers.MovieMapper;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.repositories.MovieRepository;
import com.example.assignment3.services.movie.MovieService;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/1/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping // GET: localhost:8080/api/v1/movies
    public ResponseEntity getAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(
                movieService.findAll()
        );
        return ResponseEntity.ok(movies);
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/movies/1
    public ResponseEntity getById(@PathVariable int id) {
        MovieDTO movies = movieMapper.movieToMovieDto(
                movieService.findById(id)
        );
        return ResponseEntity.ok(movies);
    }


}
