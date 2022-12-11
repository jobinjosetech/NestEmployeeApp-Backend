package com.nest.NestEmployeeApp.dao;

import com.nest.NestEmployeeApp.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query(value = "SELECT `id`, `emp_code`, `emp_designation`, `emp_email`, `emp_name`, `emp_phone`, `password`, `username` FROM `employee` WHERE `username` = :username AND `password` = :password", nativeQuery = true)
    List<Employee> GetUserLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `emp_code`, `emp_designation`, `emp_email`, `emp_name`, `emp_phone`, `username`, `password` FROM `employee` WHERE `emp_name` LIKE %:name%", nativeQuery = true)
    List<Employee> searchEmployee(@Param("name") String name);


}
