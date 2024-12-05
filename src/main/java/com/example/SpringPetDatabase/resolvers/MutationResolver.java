package com.example.SpringPetDatabase.resolvers;

import com.example.SpringPetDatabase.dto.HouseholdInput;
import com.example.SpringPetDatabase.entities.Household;
import com.example.SpringPetDatabase.services.HouseholdService;
import com.example.SpringPetDatabase.services.PetService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final HouseholdService householdService;
    private final PetService petService;

    public MutationResolver(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    public Household createHousehold(HouseholdInput householdInput) {
        Household household = new Household(
            householdInput.getEircode(),
            householdInput.getNumberOfOccupants(),
            householdInput.getMaxNumberOfOccupants(),
            householdInput.getOwnerOccupied(),
            null 
        );
        return householdService.createHousehold(household);
    }

    public String deleteHousehold(String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return "Household with eircode " + eircode + " deleted successfully.";
    }

    public String deletePet(Long id) {
        petService.deletePetById(id);
        return "Pet with ID " + id + " deleted successfully.";
    }
}