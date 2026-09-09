package com.example.lerningSpring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;




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
}


