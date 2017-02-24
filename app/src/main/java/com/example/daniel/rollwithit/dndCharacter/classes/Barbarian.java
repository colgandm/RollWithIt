package com.example.daniel.rollwithit.dndCharacter.classes;

public class Barbarian extends Class {

    public Barbarian() {
        setClassType(ClassType.BARBARIAN);
    }

    @Override
    public int getLevelBonusToRoll(int level) {
        return level;
    }

    @Override
    public int getHPModifier() {
        return 10;
    }
}
