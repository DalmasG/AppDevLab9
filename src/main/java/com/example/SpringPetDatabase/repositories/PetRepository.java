package com.example.SpringPetDatabase.repositories;

import com.example.SpringPetDatabase.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface PetRepository extends JpaRepository<Pet, Long> {
    void deleteByNameIgnoreCase(String name);

    List<Pet> findByAnimalTypeIgnoreCase(String animalType);

    List<Pet> findByBreedOrderByAge(String breed);

    @Query("SELECT p.name, p.animalType, p.breed FROM Pet p")
    List<Object[]> findNameAndBreed();

    @Query("SELECT AVG(p.age) FROM Pet p")
    Double findAverageAge();

    @Query("SELECT MAX(p.age) FROM Pet p")
    Integer findOldestAge();
}
