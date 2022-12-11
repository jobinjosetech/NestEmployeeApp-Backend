package com.nest.NestEmployeeApp.controller;

import com.nest.NestEmployeeApp.dao.TaskDao;
import com.nest.NestEmployeeApp.models.Employee;
import com.nest.NestEmployeeApp.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TaskController {

    @Autowired
    private TaskDao tdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTask", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> AddEmployee(@RequestBody Task task){
        task.setTaskStatus(false);
        tdao.save(task);
        HashMap<String, String> status = new HashMap<>();
        status.put("status","success");
        return status;
    }

}
