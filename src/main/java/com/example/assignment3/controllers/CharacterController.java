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
        Collection<CharacterDTO> characters = characterMapper.characterTocharacterDTO(
                characterService.findAll()
        );
        return ResponseEntity.ok(characters);
    }

    //get specific character
    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        CharacterDTO characterDTO = characterMapper.characterTocharacterDTO
                (characterService.findById(id));
        return ResponseEntity.ok(characterDTO);
    }


    //delete character
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}