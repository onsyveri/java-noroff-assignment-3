package com.example.assignment3.repositories;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    @Modifying
    @Query("update Movie m set m.franchise.franchise_id = ?2 where m.movie_id = ?1")
    void updateFranchiseById(int movieId, int franchiseId);

}
