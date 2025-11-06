package io.github.andrewherubin.taskflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.andrewherubin.taskflow.exception.TaskNotFoundException;
import io.github.andrewherubin.taskflow.model.Task;
import io.github.andrewherubin.taskflow.repository.TaskRepository;

@Service
public class TaskService {
    
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existing = taskRepository.findById(id)
            .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existing.setName(updatedTask.getName());
        existing.setDescription(updatedTask.getDescription());
        existing.setDueDate(updatedTask.getDueDate());
        existing.setStatus(updatedTask.getStatus());

        return taskRepository.save(existing);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}