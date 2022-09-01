package com.example.assignment3.mappers;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.dtos.CharacterDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {
    public abstract Character characterTocharacter(Character character);

    public abstract Character characterTocharacterDTO(CharacterDTO character);

    public abstract Collection<CharacterDTO> characterToCharacterDTO (Collection<Character> characters);


}
