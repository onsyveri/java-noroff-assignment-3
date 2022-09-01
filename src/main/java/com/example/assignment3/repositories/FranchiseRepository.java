package com.example.assignment3.repositories;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
