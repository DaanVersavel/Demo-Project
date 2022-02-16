package com.example.demoProject.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)

public class FilmController {

    private final FilmService filmService;

    @Autowired

    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Film> getFilms(){
        return filmService.getFilms();
    }

    @PostMapping

    public void registerNewFilm(@RequestBody Film film){
        filmService.addNewFilm(film);
    }

    @DeleteMapping(path="{filmId}")

    public void deleteFilm(@PathVariable("filmId")Long filmId){
        filmService.deleteFilm(filmId);
    }

    @PutMapping(path="{filmId}")

    public void updateFilm(
            @PathVariable("filmId") Long filmId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String regisseur){
        filmService.updateFilm(filmId, title, regisseur);
    }
}



