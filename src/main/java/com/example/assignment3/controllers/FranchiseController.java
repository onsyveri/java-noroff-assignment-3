package com.example.assignment3.controllers;

import com.example.assignment3.mappers.FranchiseMapper;
import com.example.assignment3.models.dtos.franchise.FranchiseDTO;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/1/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping // GET: localhost:8080/api/v1/franchises
    public ResponseEntity getAll() {
        Collection<FranchiseDTO> franchises = franchiseMapper.franchiseToFranchiseDto(
                franchiseService.findAll()
        );
        return ResponseEntity.ok(franchises);
    }

    @GetMapping("{id}") // GET: localhost:8080/api/v1/franchises/1
    public ResponseEntity getById(@PathVariable int id) {
        FranchiseDTO franchises = franchiseMapper.franchiseToFranchiseDto(
                franchiseService.findById(id)
        );
        return ResponseEntity.ok(franchises);
    }
}
