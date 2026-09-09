package com.example.lerningSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public List<Task> tasks() {
        return service.findAll();
    }
    @GetMapping("/titel")
    public List<Task> id(){

    }

}
