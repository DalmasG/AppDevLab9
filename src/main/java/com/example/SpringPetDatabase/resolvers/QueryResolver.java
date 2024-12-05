package com.example.SpringPetDatabase.resolvers;

import com.example.SpringPetDatabase.entities.Household;
import com.example.SpringPetDatabase.entities.Pet;
import com.example.SpringPetDatabase.services.HouseholdService;
import com.example.SpringPetDatabase.services.PetService;
import com.example.SpringPetDatabase.dto.Statistics;

import graphql.kickstart.tools.GraphQLQueryResolver;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final HouseholdService householdService;
    private final PetService petService;

    public QueryResolver(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    public List<Pet> getAllPetsByAnimalType(String animalType) {
        return petService.findPetsByAnimalType(animalType);
    }

    public Household getHousehold(String eircode) {
        return householdService.getHouseholdByEircode(eircode);
    }

    public Pet getPet(Long id) {
        return petService.getPetById(id);
    }

    public Statistics getStatistics() {
        return new Statistics(
            petService.getTotalPets(),
            householdService.getTotalHouseholds()
        );
    }
}
