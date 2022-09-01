package com.example.assignment3.controllers;
import com.example.assignment3.mappers.CharacterMapper;
import com.example.assignment3.models.Character;
import com.example.assignment3.models.dtos.CharacterDTO;
import com.example.assignment3.services.character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity getAll() {
        Collection<CharacterDTO> characters = characterMapper.characterToCharacterDTO(
                characterService.findAll()
        );
        return ResponseEntity.ok(characters);
    }


    //get specific character
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        Character chars = characterMapper.characterTocharacter
                (characterService.findById(id));
        return ResponseEntity.ok(chars);
    }



    @PutMapping("{id}") // PUT: localhost:8080/api/v1/students/1
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
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}