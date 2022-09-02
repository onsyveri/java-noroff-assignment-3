package com.example.assignment3.mappers;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.franchise.FranchiseDTO;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.services.franchise.FranchiseService;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class FranchiseMapper {

    @Autowired
    protected FranchiseService franchiseService;

    public abstract FranchiseDTO franchiseToFranchiseDto(Franchise franchise);

    public abstract Collection<FranchiseDTO> franchiseToFranchiseDto(Collection<Franchise> franchises);

    public abstract FranchiseDTO franchiseNameDto (String name);

}
