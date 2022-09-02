package com.example.assignment3.controllers;

import com.example.assignment3.mappers.FranchiseMapper;
import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dtos.character.CharacterDTO;
import com.example.assignment3.models.dtos.franchise.FranchiseDTO;
import com.example.assignment3.models.dtos.movie.MovieDTO;
import com.example.assignment3.services.franchise.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    //get all franchises
    @Operation(summary = "Get all franchises")
    @GetMapping // GET: localhost:8080/api/1/franchises
    public ResponseEntity getAll() {
        Collection<FranchiseDTO> franchises = franchiseMapper.franchiseToFranchiseDto(
                franchiseService.findAll()
        );
        return ResponseEntity.ok(franchises);
    }

    //get a specific franchise
    @Operation(summary = "Get a franchise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Franchise does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.assignment3.util.ApiErrorResponse.class)) })
    })
    @GetMapping("{id}") // GET: localhost:8080/api/1/franchises/1
    public ResponseEntity getById(@PathVariable int id) {
        FranchiseDTO franchises = franchiseMapper.franchiseToFranchiseDto(
                franchiseService.findById(id)
        );
        return ResponseEntity.ok(franchises);
    }

    //update a franchise
    @Operation(summary = "Update a franchise")
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        // Validates if body is correct
        if(id != franchiseDTO.getFranchise_id())
            return ResponseEntity.badRequest().build();
        franchiseService.update(
                franchiseMapper.franchiseToFranchiseDto(franchiseDTO)
        );
        return ResponseEntity.noContent().build();
    }

    //add a franchise
    @Operation(summary = "Add a franchise")
    @PostMapping // POST: localhost:8080/api/1/franchises
    public ResponseEntity add(@RequestBody Franchise franchise) {
        Franchise fran = franchiseService.add(franchise);
        URI location = URI.create("franchises/" + fran.getFranchise_id());
        return ResponseEntity.created(location).build();
    }

    //delete a movie by id
    @Operation(summary = "Delete a franchise by ID")
    @DeleteMapping("{id}") // DELETE: localhost:8080/api/1/franchises/1
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
