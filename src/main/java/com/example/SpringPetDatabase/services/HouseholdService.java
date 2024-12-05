package com.example.SpringPetDatabase.services;
import com.example.SpringPetDatabase.entities.Household;
import java.util.List;
import java.util.Optional;

public interface HouseholdService {
    Household createHousehold(Household household);

    Household getHouseholdByEircode(String eircode);

    List<Household> getAllHouseholds();

    Household updateHousehold(String eircode, Household updatedHousehold);

    void deleteHouseholdByEircode(String eircode);

    Optional<Household> findHouseholdByEircodeWithPets(String eircode);

    List<Household> findHouseholdsWithNoPets();
    
}
