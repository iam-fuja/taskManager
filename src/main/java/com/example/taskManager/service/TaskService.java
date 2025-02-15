package com.example.taskManager.service;


import com.example.taskManager.model.Task;
import com.example.taskManager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task createTask(Task task){
        return taskRepository.save(task);
    }


    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task ID not found"));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setCompleted(taskDetails.isCompleted());
        task.setCategory(taskDetails.getCategory());
        return taskRepository.save(task);
    }


    public void deleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }


    public Task markTaskAsCompleted(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(true);
        return  taskRepository.save(task);
    }


    public Page<Task> getAllTasks(Pageable pageable){
        return taskRepository.findAll(pageable);

    }
}
