package com.nest.NestEmployeeApp.controller;

import com.nest.NestEmployeeApp.dao.EmployeeDao;
import com.nest.NestEmployeeApp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao empdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody Employee emp){
        List<Employee> employees = (List<Employee>) empdao.GetUserLogin(emp.getUsername(), emp.getPassword());
        HashMap<String,String> hashMap = new HashMap<>();
        if(employees.size() ==0 ){
            hashMap.put("status","failed");
        }else{
            hashMap.put("status","success");
            hashMap.put("userId",String.valueOf(employees.get(0).getId()));
        }
        return hashMap;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getEmployee")
    public List<Employee> GetEmployee(){
        return (List<Employee>) empdao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmployee", consumes = "application/json", produces = "application/json")
    public List<Employee> searchEmployee(@RequestBody Employee emp){
        return (List<Employee>) empdao.searchEmployee(emp.getEmpName());
    }
}
