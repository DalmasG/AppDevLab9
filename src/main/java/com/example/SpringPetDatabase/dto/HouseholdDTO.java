package com.example.SpringPetDatabase.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HouseholdDTO(
        @NotBlank(message = "code is required")
        String eircode,

        @Min(value = 1, message = "occupant required")
        int numberOfOccupants,

        @Max(value = 10, message = "max occupant exceeded")
        int maxNumberOfOccupants,

        @NotNull(message = "occupied required")
        Boolean ownerOccupied
) {}
