package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Define endpoint for "/students" to return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Ahsoka", "Avti"));
        theStudents.add(new Student("Helen", "Smith"));
        theStudents.add(new Student("Mario", "Rossi"));

        return theStudents;
    }

}
