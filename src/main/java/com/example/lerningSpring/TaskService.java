package com.example.lerningSpring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public TaskService() {                                // hier befüllen
        tasks.add(new Task(1L, "Spring lernen", false));
        tasks.add(new Task(2L, "Kaffee holen", true));
    }

    public List<Task> findAll() {
        return tasks;
    }

    private long nextId = 3;

    public Task create(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public Task findById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));

    }


}