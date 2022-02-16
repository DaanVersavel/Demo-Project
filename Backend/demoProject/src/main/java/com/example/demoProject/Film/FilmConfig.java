package com.example.demoProject.film;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    CommandLineRunner commandLineRunner(FilmRepository repository){
        return args -> {
            Film theWolfOfWallStreet = new Film("The Wolf of Wall Street","Martin Scorsese",2013);
            Film inception = new Film("Inception","Christopher Nolan", 2010);

            repository.saveAll(List.of(theWolfOfWallStreet, inception));
        };
    }
}
