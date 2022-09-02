package com.example.assignment3.services;

import com.example.assignment3.models.Character;

import java.util.Collection;

public interface CrudService <T, ID> {
    // Generic CRUD
    Character findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    void delete(T entity);
}