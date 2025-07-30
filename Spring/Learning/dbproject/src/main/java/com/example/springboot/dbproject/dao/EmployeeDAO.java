package com.example.springboot.dbproject.dao;

import com.example.springboot.dbproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
