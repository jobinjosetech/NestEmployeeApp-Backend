package com.nest.NestEmployeeApp.dao;

import com.nest.NestEmployeeApp.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Employee, Integer> {
}
