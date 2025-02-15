package com.example.taskManager.controller;

import com.example.taskManager.model.Task;
import com.example.taskManager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

        @Autowired
        private TaskService taskService;


        @PostMapping
        public Task createTask(@RequestBody Task task){
            return taskService.createTask(task);
        }


    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }


//    @PutMapping("/{id}")
//    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
//        return ResponseEntity.ok(taskService.updateTask(id,taskDetails));
//    }

        @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        }


        @PatchMapping("/{id}/complete")
        public Task markTaskAsCompleted(@PathVariable Long id){
            return taskService.markTaskAsCompleted(id);
        }


        @GetMapping
        public Page<Task> getAllTasks(Pageable pageable){
            return taskService.getAllTasks(pageable);
        }
}
