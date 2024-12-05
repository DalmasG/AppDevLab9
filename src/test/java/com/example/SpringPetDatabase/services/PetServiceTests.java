//generated tests as asked in lab 5

package com.example.SpringPetDatabase.services;
import com.example.SpringPetDatabase.entities.Household;
import com.example.SpringPetDatabase.entities.Pet;
import com.example.SpringPetDatabase.exception.PetNotFoundException;
import com.example.SpringPetDatabase.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class PetServiceTests {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePet() {
        Household household = new Household("H123", 3, 5, true, null);
        Pet pet = new Pet(null, "Buddy", "Dog", "Golden Retriever", 3, household);
        when(petRepository.save(pet)).thenReturn(new Pet(1L, "Buddy", "Dog", "Golden Retriever", 3, household));

        Pet savedPet = petService.createPet(pet);

        assertNotNull(savedPet.getId());
        assertEquals("Buddy", savedPet.getName());
        verify(petRepository, times(1)).save(pet);
    }

    @Test
    void testGetPetById() {
        Household household = new Household("H123", 3, 5, true, null);
        Pet pet = new Pet(1L, "Buddy", "Dog", "Golden Retriever", 3, household);
        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        Pet foundPet = petService.getPetById(1L);

        assertEquals("Buddy", foundPet.getName());
        verify(petRepository, times(1)).findById(1L);
    }

    @Test
    void testGetPetById_NotFound() {
        when(petRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PetNotFoundException.class, () -> petService.getPetById(1L));
    }
}
