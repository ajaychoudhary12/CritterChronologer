package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.data.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findEmployeesBySkillsAndDaysAvailable(Set<EmployeeSkill> skills, DayOfWeek day) {
        String jpql = "SELECT e FROM Employee e WHERE :day MEMBER OF e.daysAvailable " +
                "AND (SELECT COUNT(s) FROM e.skills s WHERE s IN :skills) >= :skillsSize";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("day", day);
        query.setParameter("skills", skills);
        query.setParameter("skillsSize", (long) skills.size());
        return query.getResultList();
    }
}

