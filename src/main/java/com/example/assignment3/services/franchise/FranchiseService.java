package com.example.assignment3.services.franchise;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.services.CrudService;

public interface FranchiseService extends CrudService<Franchise, Integer> {
    void updateById(int movieId, int franchiseId);
}
