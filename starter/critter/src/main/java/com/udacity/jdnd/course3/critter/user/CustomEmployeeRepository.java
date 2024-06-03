package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.data.Employee;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface CustomEmployeeRepository {
    List<Employee> findEmployeesBySkillsAndDaysAvailable(Set<EmployeeSkill> skills, DayOfWeek day);
}

