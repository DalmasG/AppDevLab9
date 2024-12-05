package com.example.SpringPetDatabase.dto;

public class Statistics {
    private int totalPets;
    private int totalHouseholds;

    public Statistics(int totalPets, int totalHouseholds) {
        this.totalPets = totalPets;
        this.totalHouseholds = totalHouseholds;
    }

    public int getTotalPets() {
        return totalPets;
    }

    public void setTotalPets(int totalPets) {
        this.totalPets = totalPets;
    }

    public int getTotalHouseholds() {
        return totalHouseholds;
    }

    public void setTotalHouseholds(int totalHouseholds) {
        this.totalHouseholds = totalHouseholds;
    }
}
