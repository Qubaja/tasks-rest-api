package com.example.lerningSpring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titel;
    private boolean erledigt;

    public Task(){}

    public Task(Long id, String titel, boolean erledigt) {
        this.id = id;
        this.titel = titel;
        this.erledigt = erledigt;
    }


    public Long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    public void setId(Long id) {
        this.id=id;
    }
}
