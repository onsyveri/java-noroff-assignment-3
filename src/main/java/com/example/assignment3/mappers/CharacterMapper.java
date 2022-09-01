package com.example.assignment3.mappers;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.dtos.CharacterDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterDTO characterTocharacterDTO(Character character);

    public abstract Collection<CharacterDTO> characterTocharacterDTO (Collection<Character> characters);




}
