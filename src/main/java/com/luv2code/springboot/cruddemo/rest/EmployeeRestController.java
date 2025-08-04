package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // inject the employeeDAO
    public EmployeeRestController(EmployeeDAO theEmployDAO){
        employeeDAO = theEmployDAO;
    }

    @GetMapping("employee")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}
