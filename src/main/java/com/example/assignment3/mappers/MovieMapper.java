package com.example.assignment3.mappers;

import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Autowired
    protected MovieService movieService;

    public abstract MovieDTO movieToMovieDto(Movie movie);
    public abstract Movie movieToMovieDto(MovieDTO movie);
    public abstract Collection<MovieDTO> movieToMovieDto(Collection<Movie> movies);

}
