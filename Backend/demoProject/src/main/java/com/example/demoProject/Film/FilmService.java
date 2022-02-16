package com.example.demoProject.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //This class is a Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilms(){ return filmRepository.findAll(); }

    public void addNewFilm(Film film) {
        Optional<Film> filmOptional = filmRepository.findFilmByTitle(film.getTitle());
        if(filmOptional.isPresent()){
            throw new IllegalStateException("title taken");
        }
        filmRepository.save(film);
    }

    public void deleteFilm(Long filmId) {
        boolean exists = filmRepository.existsById(filmId);
        if(!exists){
            throw new IllegalStateException(("film with id " + filmId + " does not exist"));
        }
        filmRepository.deleteById(filmId);
    }

    @Transactional //geen query nodig van repository, setters gebruiken voor tabel te updaten
    public void updateFilm(Long filmId, String title, String regisseur){
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new IllegalStateException(
                "film with id " + filmId + " does nog exist"));
        if(regisseur != null && regisseur.length() > 0 && !Objects.equals(film.getRegisseur(), regisseur)){
            film.setRegisseur(regisseur);
        }
        if(title!= null && title.length()>0 && !Objects.equals(film.getTitle(), title)){
            Optional<Film> filmOptional = filmRepository.findFilmByTitle(title);
            if(filmOptional.isPresent()){
                throw new IllegalStateException("title taken");
            }
            film.setTitle(title);
        }
    }
}
