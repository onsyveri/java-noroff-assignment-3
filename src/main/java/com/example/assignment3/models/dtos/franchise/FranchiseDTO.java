package com.example.assignment3.models.dtos.franchise;

import com.example.assignment3.models.Movie;
import lombok.Data;

import java.util.ArrayList;

@Data
public class FranchiseDTO {
    private int franchise_id;
    private String description;
    private String franchise_name;
    //private ArrayList<Movie> movies;
}
