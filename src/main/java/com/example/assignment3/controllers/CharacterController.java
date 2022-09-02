package com.example.assignment3.controllers;
import com.example.assignment3.mappers.CharacterMapper;
import com.example.assignment3.models.Character;
import com.example.assignment3.models.dtos.character.CharacterDTO;
import com.example.assignment3.services.character.CharacterService;
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
@RequestMapping(value = "api/1/characters")
public class CharacterController {

    final
    CharacterService characterService;
    final
    CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }


    //get all characters
    @Operation(summary = "Get all characters")
    @GetMapping
    public ResponseEntity getAll() {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDTO(
                characterService.findAll()
        );
        return ResponseEntity.ok(characters);
    }


    @Operation(summary = "Get a character by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Character does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.assignment3.util.ApiErrorResponse.class)) })
    })
    //get specific character
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        Character chars = characterMapper.characterTocharacter
                (characterService.findById(id));
        return ResponseEntity.ok(chars);
    }

    @Operation(summary = "Adds new characters")
    @PostMapping
    public ResponseEntity add(@RequestBody Character character) {
        Character chars = characterService.add(character);
        URI location = URI.create("characters/" + chars.getCharacter_id());
        return ResponseEntity.created(location).build();
    }


    @Operation(summary = "Update a character")
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        // Validates if body is correct
        if(id != characterDTO.getCharacter_id())
            return ResponseEntity.badRequest().build();
        characterService.update(
                characterMapper.characterTocharacterDTO(characterDTO)
        );
        return ResponseEntity.noContent().build();
    }




    //delete character
    @Operation(summary = "Delete a character")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}