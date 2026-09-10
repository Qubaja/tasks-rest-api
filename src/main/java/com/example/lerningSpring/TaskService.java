package com.example.lerningSpring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }


    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public void delete(Long id) {

        if (!(taskRepository.existsById(id))) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    public Task update(Long id, Task task) {
        Task temp =  findById(id);
        temp.setTitel(task.getTitel());
        temp.setErledigt(task.isErledigt());
        return taskRepository.save(temp);
    }

}