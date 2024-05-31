package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.data.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> getAllByPetsId(Long petId);

    List<Schedule> getAllByEmployeesId(Long employeeId);

    List<Schedule> findAllByPetsIdIn(List<Long> petIds);
}
