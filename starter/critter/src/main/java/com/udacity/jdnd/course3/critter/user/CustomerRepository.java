package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.data.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByPetsId(long petId);
}
