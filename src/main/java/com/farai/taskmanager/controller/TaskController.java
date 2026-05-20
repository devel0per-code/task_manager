package com.farai.taskmanager.controller;

import com.farai.taskmanager.model.Task;
import com.farai.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

import com.farai.taskmanager.model.Task;
import com.farai.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {


    @Autowired
    private  TaskRepository taskRepository;

    

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @PostMapping
    public Task creatTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public  void deleteTask(@PathVariable long id){
        taskRepository.deleteById(id);
    }
}
