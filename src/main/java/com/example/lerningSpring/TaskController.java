package com.example.lerningSpring;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService service;
    private final TaskRepository taskRepository;

    public TaskController(TaskService service, TaskRepository taskRepository) {
        this.service = service;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> tasks() {
        return service.findAll();
    }

    @PostMapping("/tasks")
    public Task creat(@Valid @RequestBody Task task) {
        return service.create(task);
    }

    @GetMapping("/tasks/{id}")
    public Task one(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id, @Valid @RequestBody Task task) {
        return service.update(id, task);
    }

}


