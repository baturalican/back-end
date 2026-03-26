package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.model.Student;
import org.springframework.ui.Model;

public class StudentController {
    public String showForm(Model theModel) {
        // Create a student object
        Student theStudent = new Student();

        // Add student to the model
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }
}
