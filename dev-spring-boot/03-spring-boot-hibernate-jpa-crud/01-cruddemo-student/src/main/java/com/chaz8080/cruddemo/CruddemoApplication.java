package com.chaz8080.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chaz8080.cruddemo.dao.StudentDAO;
import com.chaz8080.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student1 = new Student("Joe", "Go", "joe.go@gmail.com");
		Student student2 = new Student("Jay", "Bird", "jay@gmail.com");
		Student student3 = new Student("Jake", "Jill", "jake@gmail.com");

		System.out.println("Saving student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// System.out.println("Saved student with ID: " + student1.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Joe", "Schmo", "joe.schmo@gmail.com");

		System.out.println("Saving student...");
		studentDAO.save(student);

		System.out.println("Saved student with ID: " + student.getId());
	}
}
