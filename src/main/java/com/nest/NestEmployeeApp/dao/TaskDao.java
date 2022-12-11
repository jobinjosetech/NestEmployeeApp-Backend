package com.nest.NestEmployeeApp.dao;

import com.nest.NestEmployeeApp.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskDao extends CrudRepository<Task, Integer> {
}
