package com.example.daniel.rollwithit.dndCharacter.classes;

public class Rogue extends Class {

    public Rogue() {
        setClassType(ClassType.ROGUE);
    }

    @Override
    public int getCritMultiplier() {
        return 3;
    }
}
