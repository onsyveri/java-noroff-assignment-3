package com.example.assignment3.controllers;

import com.example.assignment3.repositories.CharacterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "api/1/characters")
public class CharacterController {
    private final CharacterRepository characterRepository;

    public CharacterController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(characterRepository.findAll());
    }
}
