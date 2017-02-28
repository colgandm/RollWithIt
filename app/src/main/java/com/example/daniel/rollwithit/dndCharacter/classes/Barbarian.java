package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MARTIAL_WEAPONS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MEDIUM_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.NONE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SHIELDS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SIMPLE_WEAPONS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.STRENGTH;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Barbarian extends Class {

    public Barbarian() {
        setClassType(ClassType.BARBARIAN);
        setArmorProficiencies(Arrays.asList(LIGHT_ARMOR, MEDIUM_ARMOR, SHIELDS));
        setWeaponProficiencies(Arrays.asList(SIMPLE_WEAPONS, MARTIAL_WEAPONS));
        setToolProficiencies(Collections.singletonList(NONE));
        setSavingThrows(Arrays.asList(STRENGTH, CONSTITUTION));
    }

    @Override
    public int getHPModifier() {
        return 7;
    }

    @Override
    public Dice getHitDice() {
        return new Dice(12);
    }

    @Override
    public int getLevelOneHitPoints() {
        return 12;
    }

}
