package com.example.lerningSpring;

public class  TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id) {
        super("Task " + id + " nicht gefunden");
    }
}
