package com.example.SpringPetDatabase.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record petDTO(
        @NotBlank(message = "name is required")
        String name,

        @NotBlank(message = "animal type is required")
        String animalType,

        @NotBlank(message = "breed is required")
        String breed,

        @Min(value = 0, message = "age required")
        int age,

        @NotBlank(message = "code required")
        String householdEircode
) {}
