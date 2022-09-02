package com.example.assignment3.repositories;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
