package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Long saveCustomer(Customer customer) {
        return repository.save(customer).getId();
    }

    public Optional<Customer> findCustomer(long id) {
        return repository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer findCustomerByPetId(long petId) {
        return repository.findByPetsId(petId);
    }
}
