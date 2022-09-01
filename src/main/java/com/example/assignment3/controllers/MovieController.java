package com.example.assignment3.controllers;

import com.example.assignment3.mappers.MovieMapper;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.repositories.MovieRepository;
import com.example.assignment3.services.movie.MovieService;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/students/1
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Movie movie) {
        movieService.add(movie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*@GetMapping("{title}") // GET: localhost:8080/api/v1/movies/title
    public ResponseEntity getByTitle(@PathVariable String title) {
        MovieDTO movies = (MovieDTO) movieMapper.movieToMovieDto(
                movieService.findAllByTitle(title)
        );
        return ResponseEntity.ok(movies);
    }*/

}
