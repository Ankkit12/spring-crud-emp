package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findByID(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
