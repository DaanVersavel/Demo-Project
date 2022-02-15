package com.example.demoProject.film;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String title;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}
