package com.example.demoProject.film;

import javax.persistence.*; //persistence gebruiken, zo blijft alles werken als we van provider veranderen
import java.time.LocalDate;

@Entity
@Table
public class Film {
    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "film_sequence"
    )
    private Long id;
    private String title;
    private String regisseur;
    private Integer jaar;
    @Transient //niet opslaan in db want berekenbaar via jaar
    private Integer ouderdom;

    public Film() {
    }
    public Film(Long id, String title, String regisseur, Integer jaar) {
        this.id = id;
        this.title = title;
        this.regisseur = regisseur;
        this.jaar = jaar;
    }
    public Film(String title, String regisseur, Integer jaar) {
        this.title = title;
        this.regisseur = regisseur;
        this.jaar = jaar;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public Integer getJaar() { return jaar; }

    public void setJaar(int jaar) { this.jaar = jaar; }

    public Integer getOuderdom() { return LocalDate.now().getYear()-jaar; }

    public void setOuderdom(Integer ouderdom) { this.ouderdom = ouderdom; }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", regisseur='" + regisseur + '\'' +
                ", jaar=" + jaar +
                ", ouderdom=" + ouderdom +
                '}';
    }
}
