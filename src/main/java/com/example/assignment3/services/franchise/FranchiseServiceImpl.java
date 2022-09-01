package com.example.assignment3.services.franchise;

import com.example.assignment3.exceptions.FranchiseNotFoundException;
import com.example.assignment3.models.Franchise;
import com.example.assignment3.repositories.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService{

    private final FranchiseRepository franchiseRepository;
    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Franchise entity) {

    }
}
