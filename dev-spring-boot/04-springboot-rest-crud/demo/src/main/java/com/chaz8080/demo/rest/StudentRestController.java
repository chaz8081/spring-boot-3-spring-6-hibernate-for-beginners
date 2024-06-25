package com.chaz8080.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Jeff", "Probst"));
        students.add(new Student("Ray", "Man"));
        students.add(new Student("Chaz", "80HD"));

        this.students = students;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        if (studentId >= students.size() || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return this.students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exc) {

        StudentErrorResponse err = new StudentErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

}