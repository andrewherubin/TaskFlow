package io.github.andrewherubin.taskflow.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import io.github.andrewherubin.taskflow.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}