package com.nest.NestEmployeeApp.controller;

import com.nest.NestEmployeeApp.dao.EmployeeDao;
import com.nest.NestEmployeeApp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao empdao;

    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody Employee emp){
        List<Employee> employees = (List<Employee>) empdao.GetUserLogin(emp.getUsername(), emp.getPassword());
        HashMap<String,String> hashMap = new HashMap<>();
        if(employees.size() ==0 ){
            hashMap.put("status","failed");
        }else{
            hashMap.put("status","success");
        }
        return hashMap;
    }

}
