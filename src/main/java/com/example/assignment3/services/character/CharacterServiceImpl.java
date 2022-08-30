package com.example.assignment3.services.character;

import com.example.assignment3.models.Character;
import com.example.assignment3.repositories.CharacterRepository;

import java.util.Collection;

public class CharacterServiceImpl implements CharacterService {



    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();

    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return null;
    }

    @Override
    public Character update(Character entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Character entity) {

    }
}
