package com.example.SpringPetDatabase.services;

import com.example.SpringPetDatabase.entities.Pet;
import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);

    List<Pet> getAllPets();

    Pet getPetById(Long id);

    Pet updatePet(Long id, Pet updatedPet);

    Pet updatePetName(Long id, String name);

    void deletePetById(Long id);

    void deletePetsByName(String name);

    List<Pet> findPetsByAnimalType(String animalType);

    List<Pet> findPetsByBreed(String breed);

    List<Object[]> getNameAndBreed();

    Double getAverageAge();

    Integer getOldestAge();

    int getTotalPets();
}
