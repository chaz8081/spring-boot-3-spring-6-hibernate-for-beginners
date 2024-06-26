package com.chaz8080.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaz8080.cruddemo.entity.Employee;

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
