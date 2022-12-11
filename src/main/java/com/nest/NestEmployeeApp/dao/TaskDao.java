package com.nest.NestEmployeeApp.dao;

import com.nest.NestEmployeeApp.models.Task;
import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Task, Integer> {

    @Query(value = "SELECT e.`emp_code`, e.`emp_name`, t.`task_description`, t.`task_status`, t.`task_title`, t.`task_complete_date`, t.`task_date` FROM `task` AS t JOIN `employee` AS e ON t.emp_id = e.id", nativeQuery = true)
    List<Map<String, String>> GetTask();

}
