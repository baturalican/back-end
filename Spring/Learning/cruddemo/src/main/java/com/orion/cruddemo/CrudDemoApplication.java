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
//				createStudent(studentDAO);
//				createMultipleStudents(studentDAO);
				readStudent(studentDAO);
			};
		}

	private void readStudent(StudentDAO studentDAO) {
		int id = 3;
		// Read student with certain id
		Student myStudent = studentDAO.findById(id);
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John", "Doe", "john@doe.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@public.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@applebum.com");

		// Save the student objects to the database
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@doe.com");

		// Save student object to the database
		studentDAO.save(tempStudent);

		// Display the saved student id
		System.out.println("Saved student. Generated id is: " + tempStudent.getId());
	}
}