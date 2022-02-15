package com.example.demoProject.Film;

import org.springframework.data.repository.CrudRepository;

import com.example.demoProject.Film.Filmclass;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Filmclass, Integer> {

}
