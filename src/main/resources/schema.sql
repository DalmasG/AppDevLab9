CREATE TABLE pets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    animal_type VARCHAR(255) NOT NULL,
    breed VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

-- Create the Household table
CREATE TABLE household (
    eircode VARCHAR(8) PRIMARY KEY,
    number_of_occupants INT NOT NULL,
    max_number_of_occupants INT NOT NULL,
    owner_occupied BIT NOT NULL
);

-- Modify the pets table to include a foreign key to the Household table
ALTER TABLE pets ADD COLUMN household_eircode VARCHAR(8);

ALTER TABLE pets
ADD CONSTRAINT fk_household
FOREIGN KEY (household_eircode)
REFERENCES household(eircode);
