package com.example.assignment3.mappers;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.franchise.FranchiseDTO;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.services.franchise.FranchiseService;
import com.example.assignment3.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Autowired
    protected MovieService movieService;

    public abstract MovieDTO movieToMovieDto(Movie movie);

    public abstract Collection<MovieDTO> movieToMovieDto(Collection<Movie> movies);

    public abstract MovieDTO movieTitleDto (String title);

    // Custom mappings
    @Named("movieIdToMovie")
    Movie mapIdToMovie(int id) {
        return movieService.findById(id);
    }

}
