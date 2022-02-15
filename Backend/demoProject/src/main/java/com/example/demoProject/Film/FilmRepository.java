package com.example.demoProject.film;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Film, Integer> {

}
