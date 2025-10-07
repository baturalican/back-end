package com.example.springboot.dbproject.dao;

import com.example.springboot.dbproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
