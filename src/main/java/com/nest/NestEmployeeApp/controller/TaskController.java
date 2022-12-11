package com.nest.NestEmployeeApp.controller;

import com.nest.NestEmployeeApp.dao.TaskDao;
import com.nest.NestEmployeeApp.models.Employee;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/viewStatusTask")
    public List<Map<String, String>> ViewStatusTask(){
        System.out.println();
        return tdao.GetTask();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewTask", consumes = "application/json", produces = "application/json")
    public List<Task> ViewTask(@RequestBody Task task){
        return (List<Task>) tdao.GetEmpTask(task.getEmpId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateStatus", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UpdateTaskStatus(@RequestBody Task task){
        LocalDateTime now = LocalDateTime.now();
        tdao.UpdateStatus(task.getId(), task.isTaskStatus(), dtf.format(now));
        HashMap<String, String> status = new HashMap<>();
        status.put("status","success");
        return status;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllTask")
    public List<Map<String, String>> ViewAllTask(){
        List<Map<String, String>> result = (List<Map<String, String>>) tdao.GetTask();
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchTask", consumes = "application/json", produces = "application/json")
    public List<Map<String, String>> searchTask(@RequestBody Employee emp){
        return (List<Map<String, String>>) tdao.SearchTask(emp.getEmpName());
    }

}
