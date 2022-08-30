package com.example.assignment3.controllers;

import com.example.assignment3.models.Character;
import com.example.assignment3.repositories.CharacterRepository;
import com.example.assignment3.services.character.CharacterService;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/1/characters")
public class CharacterController {
    private final CharacterRepository characterRepository;



    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @GetMapping
    public ResponseEntity <Collection<Character>> getAll() {
        return ResponseEntity.ok(characterRepository.findAll());
    }



    @GetMapping("{id}")
    public ResponseEntity findOne(@PathVariable int id){
        return ResponseEntity.ok(characterRepository.findById(id));
    }



}
