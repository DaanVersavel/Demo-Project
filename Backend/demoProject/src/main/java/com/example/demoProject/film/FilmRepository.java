package com.example.demoProject.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository //This class is a Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

    @Query("SELECT s from Film s WHERE s.title = ?1")
    Optional<Film> findFilmByTitle(String title);
}
