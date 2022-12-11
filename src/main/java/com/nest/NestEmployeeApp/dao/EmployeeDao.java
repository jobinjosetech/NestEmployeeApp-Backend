package com.nest.NestEmployeeApp.dao;

import com.nest.NestEmployeeApp.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query(value = "SELECT `id`, `emp_code`, `emp_designation`, `emp_email`, `emp_name`, `emp_phone`, `password`, `username` FROM `employee` WHERE `username` = :username AND `password` = :password", nativeQuery = true)
    List<Employee> GetUserLogin(@Param("username") String username, @Param("password") String password);
}
