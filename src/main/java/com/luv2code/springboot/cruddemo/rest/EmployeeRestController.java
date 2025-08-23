package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject the employeeDAO
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @GetMapping("employee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // Retrieve the data from db
    @GetMapping("employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        Employee employee = employeeService.findByID(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found "+ employeeId);
        }

        return employee;
    }

    //Add or Insert new data to the db
    @PostMapping("employee")
    public Employee save(@RequestBody Employee theEmployee){
        // if the user passes id in json ....set it to zero
        // to force save the record in db.....instead of update
        theEmployee.setId(0);

        Employee newEmp = employeeService.save(theEmployee);

        return newEmp;
    }

    // Update the existing data in the db
    @PutMapping("employee")
    public Employee updateEmp(@RequestBody Employee theEmployee){

        Employee newEmp = employeeService.save(theEmployee);

        return newEmp;
    }

    // Delete the data from the db
    @DeleteMapping("employee/{employeeId}")
    public String deleteEmp(@PathVariable int employeeId){

        Employee emp = employeeService.findByID(employeeId);
        if(emp == null){
            throw new RuntimeException("Employee id not found "+ employeeId);
    }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
    // Update the partial data in db as per requirement



}
