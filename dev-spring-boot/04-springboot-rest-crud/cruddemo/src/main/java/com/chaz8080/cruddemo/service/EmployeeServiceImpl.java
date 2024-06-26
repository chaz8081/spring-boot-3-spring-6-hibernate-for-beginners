package com.chaz8080.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chaz8080.cruddemo.dao.EmployeeRepository;
import com.chaz8080.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        }

        throw new RuntimeException("Employee ID not found: " + id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }

}
