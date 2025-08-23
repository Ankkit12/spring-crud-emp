package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.Access;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    // Create entitymanager entity
    private EntityManager entityManager;

    // Create constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create the query
        TypedQuery<Employee> Query = entityManager.createQuery("from Employee", Employee.class);


        // store the result
        List<Employee> employees = Query.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findByID(int theId) {
        // get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;

    }

    @Override
    public void deleteById(int theId) {
        // find the emp
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove the emp
        entityManager.remove(theEmployee);
    }
}
