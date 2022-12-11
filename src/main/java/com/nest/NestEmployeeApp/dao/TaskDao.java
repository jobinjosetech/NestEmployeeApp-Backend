package com.nest.NestEmployeeApp.dao;

import com.nest.NestEmployeeApp.models.Employee;
import com.nest.NestEmployeeApp.models.Task;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Any;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface TaskDao extends CrudRepository<Task, Integer> {

    @Query(value = "SELECT e.`emp_code`, e.`emp_name`, t.`task_description`, t.`task_status`, t.`task_title`, t.`task_complete_date`, t.`task_date` FROM `task` AS t JOIN `employee` AS e ON t.emp_id = e.id", nativeQuery = true)
    List<Map<String, String>> GetTask();

    @Query(value = "SELECT `id`, `emp_id`, `task_description`, `task_status`, `task_title`, `task_complete_date`, `task_date` FROM `task` WHERE `emp_id` = :empId ORDER BY `task_date` ASC", nativeQuery = true)
    List<Task> GetEmpTask(@Param("empId") Integer empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `task` SET `task_status`= :taskStatus, `task_complete_date` = :date WHERE `id` = :id", nativeQuery = true)
    void UpdateStatus(@Param("id") Integer id, @Param("taskStatus") Boolean taskStatus, @Param("date") String date);

    @Query(value = "SELECT e.`emp_code`, e.`emp_name`, t.`task_description`, t.`task_status`, t.`task_title`, t.`task_complete_date`, t.`task_date` FROM `task` AS t JOIN `employee` AS e ON t.emp_id = e.id WHERE e.emp_name LIKE %:name%", nativeQuery = true)
    List<Map<String, String>> SearchTask(@Param("name") String name);


}
