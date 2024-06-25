package com.chaz8080.cruddemo.dao;

import java.util.List;

import com.chaz8080.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findByLastName(String lastName);

    List<Student> findAll();
}
