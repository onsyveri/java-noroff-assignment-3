package com.example.assignment3.controllers;

import com.example.assignment3.mappers.MovieMapper;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.character.CharacterDTO;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.services.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/1/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    //get all movies
    @Operation(summary = "Get all movies")
    @GetMapping // GET: localhost:8080/api/1/movies
    public ResponseEntity getAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDto(
                movieService.findAll()
        );
        return ResponseEntity.ok(movies);
    }

    //get a specific movie
    @Operation(summary = "Get a movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Movie does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.assignment3.util.ApiErrorResponse.class)) })
    })
    @GetMapping("{id}") // GET: localhost:8080/api/1/movies/1
    public ResponseEntity getById(@PathVariable int id) {
        MovieDTO movies = movieMapper.movieToMovieDto(
                movieService.findById(id)
        );
        return ResponseEntity.ok(movies);
    }

    //delete a movie by id
    @Operation(summary = "Delete a movie by ID")
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/1/movies/1
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //update a movie
    @Operation(summary = "Update a movie")
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        // Validates if body is correct
        if(id != movieDTO.getMovie_id())
            return ResponseEntity.badRequest().build();
        movieService.update(
                movieMapper.movieToMovieDto(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }

    //add a movie
    @Operation(summary = "Add a movie")
    @PostMapping // POST: localhost:8080/api/1/movies
    public ResponseEntity add(@RequestBody Movie movie) {
        Movie mov = movieService.add(movie);
        URI location = URI.create("movies/" + mov.getMovie_id());
        return ResponseEntity.created(location).build();
    }

}
