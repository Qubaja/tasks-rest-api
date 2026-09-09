package com.example.lerningSpring;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/tasks")
    public Task creat(@RequestBody Task task) {
        return service.create(task);
    }

    @GetMapping("/tasks/{id}")
    public Task one(@PathVariable Long id) {
        return service.findById(id);
    }
}


