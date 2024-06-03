package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public List<Employee> findBySkillsAndDaysAvailable(Set<EmployeeSkill> skills, DayOfWeek day) {
        return employeeRepository.findEmployeesBySkillsAndDaysAvailable(skills, day);
    }

    public List<Employee> findAllByEmployeeIds(List<Long> employeeIds) {
        return employeeRepository.findAllById(employeeIds);
    }
}
