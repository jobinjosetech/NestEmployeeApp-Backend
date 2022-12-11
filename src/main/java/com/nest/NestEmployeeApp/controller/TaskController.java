package com.nest.NestEmployeeApp.controller;

import com.nest.NestEmployeeApp.dao.TaskDao;
import com.nest.NestEmployeeApp.models.Task;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    private TaskDao tdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addTask", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> AddEmployee(@RequestBody Task task){
        LocalDateTime now = LocalDateTime.now();
        task.setTaskStatus(false);
        task.setTaskDate(dtf.format(now));
        task.setTaskCompleteDate("Nil");
        tdao.save(task);
        HashMap<String, String> status = new HashMap<>();
        status.put("status","success");
        return status;
    }

    @GetMapping("/viewStatusTask")
    public List<Map<String, String>> ViewStatusTask(){
        System.out.println();
        return tdao.GetTask();
    }

}
