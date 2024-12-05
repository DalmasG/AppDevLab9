//generated tests as asked in Lab 5

package com.example.SpringPetDatabase.services;

import com.example.SpringPetDatabase.entities.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PetServiceIntegrationTests {

    @Autowired
    private PetService petService;

    @Test
    void testCreateAndRetrievePet() {
        
        List<Pet> pets = petService.getAllPets();
        assertEquals(10, pets.size()); 

        
        petService.createPet(new Pet(null, "Shadow", "Dog", "Husky", 2));

        
        pets = petService.getAllPets();
        assertEquals(11, pets.size());
        assertTrue(pets.stream().anyMatch(pet -> pet.getName().equals("Shadow")));
    }

    @Test
    void testFindPetsByAnimalType() {

        List<Pet> dogs = petService.findPetsByAnimalType("Dog");

        assertEquals(3, dogs.size());
        assertTrue(dogs.stream().anyMatch(pet -> pet.getName().equals("Buddy")));
        assertTrue(dogs.stream().anyMatch(pet -> pet.getName().equals("Charlie")));
        assertTrue(dogs.stream().anyMatch(pet -> pet.getName().equals("Max")));
    }

    @Test
    void testDeletePetById() {
        
        Pet pet = petService.getPetById(1L);
        petService.deletePetById(pet.getId());


        List<Pet> pets = petService.getAllPets();
        assertEquals(9, pets.size()); 
        assertFalse(pets.stream().anyMatch(p -> p.getId().equals(1L)));
    }
}
