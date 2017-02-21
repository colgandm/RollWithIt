package com.example.daniel.rollwithit.dndCharacter;

public class Experience {

    private Range totalExperience = new Range(0, 0, 20);

    public Experience(int experience) {
        this.totalExperience.setValue(experience);
    }

    public int getTotalExperience() {
        return totalExperience.getValue();
    }

    public void addToExperience(int value) {
        totalExperience.add(value);
    }

    public int getLevel() {
        // Change method
        return 1;
    }
}
