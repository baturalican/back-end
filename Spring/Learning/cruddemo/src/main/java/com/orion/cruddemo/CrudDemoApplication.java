package com.orion.cruddemo;

import com.orion.cruddemo.dao.StudentDAO;
import com.orion.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			return runner -> {
				manageStudent(studentDAO);
			};
		}

	private void manageStudent(StudentDAO studentDAO) {
		// Create student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@doe.com");

		// Save student object to the database
		studentDAO.save(tempStudent);

		// Display the saved student id
		System.out.println("Saved student. Generated id is: " + tempStudent.getId());
	}
}
