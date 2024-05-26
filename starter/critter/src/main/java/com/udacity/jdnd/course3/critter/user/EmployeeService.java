package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Long saveEmployee(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    public Optional<Employee> findEmployee(Long id) {
        return employeeRepository.findById(id);
    }
}
