package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.data.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Long savePet(Pet pet) {
        return petRepository.save(pet).getId();
    }

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
