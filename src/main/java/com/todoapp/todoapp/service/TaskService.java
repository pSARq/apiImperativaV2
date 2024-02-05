package com.todoapp.todoapp.service;

import com.todoapp.todoapp.exceptions.TodoException;
import com.todoapp.todoapp.mapper.TaskInDTOToTask;
import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.persistence.entity.TaskStatusEnum;
import com.todoapp.todoapp.persistence.repository.TaskRepository;
import com.todoapp.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskInDTOToTask taskInDTOToTask;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask taskInDTOToTask) {
        this.taskRepository = taskRepository;
        this.taskInDTOToTask = taskInDTOToTask;
    }

    public Task save(TaskInDTO taskInDTO) {
        Task task = taskInDTOToTask.map(taskInDTO);
        return this.taskRepository.save(task);
    }

    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatusEnum(TaskStatusEnum taskStatusEnum) {
        return this.taskRepository.findAllByTaskStatusEnum(taskStatusEnum);
    }

    @Transactional
    public void markTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new TodoException("Task not found", HttpStatus.NOT_FOUND);
        }

        this.taskRepository.markTaskAsFinished(id);
    }

    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new TodoException("Task not found", HttpStatus.NOT_FOUND);
        }

        this.taskRepository.deleteById(id);
    }

}
