package com.example.springboot.dbproject.dao;

import com.example.springboot.dbproject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // Define field for entity manager
    private EntityManager entityManager;

    // Setup constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // Execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // Return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // Get employee
        Employee theEmployee = entityManager.find(Employee.class, id);

        // Return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        // Save employee, if the id of the entity is 0, it'll INSERT new, otherwise UPDATE
        Employee dbEmployee = entityManager.merge(employee);

        // Return the employee
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        // Find employee by id
        Employee theEmployee = entityManager.find(Employee.class, id);

        // Delete the employee by id
        entityManager.remove(theEmployee);
    }


}
