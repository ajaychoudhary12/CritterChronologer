package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.data.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepository repository;

    public Long saveSchedule(Schedule schedule) {
        return repository.save(schedule).getId();
    }

    public List<Schedule> getAllSchedules() {
        return repository.findAll();
    }

    public List<Schedule> getAllSchedulesByPet(Long petId) {
        return repository.getAllByPetsId(petId);
    }

    public List<Schedule> getAllSchedulesByEmployee(Long employeeId) {
        return repository.getAllByEmployeesId(employeeId);
    }

    public List<Schedule> getAllSchedulesByPetIds(List<Long> petIds) {
        return repository.findAllByPetsIdIn(petIds);
    }
}
