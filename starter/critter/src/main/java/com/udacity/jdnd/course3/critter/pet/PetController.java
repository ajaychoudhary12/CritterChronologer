package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.data.Customer;
import com.udacity.jdnd.course3.critter.data.Pet;
import com.udacity.jdnd.course3.critter.user.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.user.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        Optional<Customer> optionalCustomer = customerService.findCustomer(petDTO.getOwnerId());
        if (optionalCustomer.isPresent()) {
            pet.setCustomer(optionalCustomer.get());
        } else {
            throw new CustomerNotFoundException();
        }

        Long id = petService.savePet(pet);
        petDTO.setId(id);
        return petDTO;
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Optional<Pet> optionalPet = petService.findPetById(petId);
        if (optionalPet.isPresent()) {
            PetDTO petDTO = new PetDTO();
            BeanUtils.copyProperties(optionalPet.get(), petDTO);
            petDTO.setOwnerId(optionalPet.get().getCustomer().getId());
            return petDTO;
        } else {
            throw new PetNotFoundException();
        }
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<Pet> pets = petService.getAllPets();
        return pets.stream().map(pet -> {
            PetDTO petDTO = new PetDTO();
            BeanUtils.copyProperties(pet, petDTO);
            petDTO.setId(pet.getId());
            petDTO.setOwnerId(pet.getCustomer().getId());
            return petDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        throw new UnsupportedOperationException();
    }
}
