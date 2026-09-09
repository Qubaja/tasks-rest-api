package com.example.lerningSpring;

public class Task {
    protected long id;
    private String titel;
    private boolean erledigt;


    public Task(long id, String titel, boolean erledigt) {
        this.id = id;
        this.titel = titel;
        this.erledigt = erledigt;
    }

    public long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public boolean isErledigt() {
        return erledigt;
    }
}
