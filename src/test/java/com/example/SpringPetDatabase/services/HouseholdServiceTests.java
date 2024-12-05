//generated tests
package com.example.SpringPetDatabase.services;

import com.example.SpringPetDatabase.entities.Household;
import com.example.SpringPetDatabase.repositories.HouseholdRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HouseholdServiceTests {

    @Mock
    private HouseholdRepository householdRepository;

    @InjectMocks
    private HouseholdServiceImpl householdService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateHousehold() {
        // Arrange
        Household household = new Household("H123", 3, 5, true, null);
        when(householdRepository.save(household)).thenReturn(household);

        // Act
        Household savedHousehold = householdService.createHousehold(household);

        // Assert
        assertNotNull(savedHousehold);
        assertEquals("H123", savedHousehold.getEircode());
        verify(householdRepository, times(1)).save(household);
    }

    @Test
    void testGetHouseholdByEircode() {
        // Arrange
        Household household = new Household("H123", 3, 5, true, null);
        when(householdRepository.findById("H123")).thenReturn(Optional.of(household));

        // Act
        Household foundHousehold = householdService.getHouseholdByEircode("H123");

        // Assert
        assertEquals("H123", foundHousehold.getEircode());
        verify(householdRepository, times(1)).findById("H123");
    }

    @Test
    void testGetHouseholdByEircode_NotFound() {
        // Arrange
        when(householdRepository.findById("H123")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> householdService.getHouseholdByEircode("H123"));
    }

    @Test
    void testUpdateHousehold() {
        // Arrange
        Household existingHousehold = new Household("H123", 3, 5, true, null);
        Household updatedHousehold = new Household("H123", 4, 6, false, null);
        when(householdRepository.findById("H123")).thenReturn(Optional.of(existingHousehold));
        when(householdRepository.save(existingHousehold)).thenReturn(updatedHousehold);

        // Act
        Household result = householdService.updateHousehold("H123", updatedHousehold);

        // Assert
        assertEquals(4, result.getNumberOfOccupants());
        assertEquals(6, result.getMaxNumberOfOccupants());
        assertFalse(result.isOwnerOccupied());
    }

    @Test
    void testDeleteHouseholdByEircode() {
        // Act
        householdService.deleteHouseholdByEircode("H123");

        // Assert
        verify(householdRepository, times(1)).deleteById("H123");
    }

    @Test
    void testFindHouseholdByEircodeWithPets() {
        Household household = new Household("H123", 3, 5, true, new ArrayList<>());
        when(householdRepository.findByEircodeWithPets("H123")).thenReturn(Optional.of(household));

        Optional<Household> result = householdService.findHouseholdByEircodeWithPets("H123");

        assertTrue(result.isPresent());
        assertEquals("H123", result.get().getEircode());
        verify(householdRepository, times(1)).findByEircodeWithPets("H123");
    }

    @Test
    void testFindHouseholdsWithNoPets() {
        List<Household> households = new ArrayList<>();
        households.add(new Household("H001", 2, 3, true, null));
        when(householdRepository.findHouseholdsWithNoPets()).thenReturn(households);

        List<Household> result = householdService.findHouseholdsWithNoPets();

        assertEquals(1, result.size());
        assertEquals("H001", result.get(0).getEircode());
        verify(householdRepository, times(1)).findHouseholdsWithNoPets();
    }
}
