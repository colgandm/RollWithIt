package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.DEXTERITY;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.HAND_CROSSBOW;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LONG_SWORD;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.RAPIER;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SHORT_SWORD;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SIMPLE_WEAPONS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.THIEVES_TOOLS;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Rogue extends Class {

    public Rogue() {
        setClassType(ClassType.ROGUE);
        setArmorProficiencies(Collections.singletonList(LIGHT_ARMOR));
        setWeaponProficiencies(Arrays.asList(SIMPLE_WEAPONS, HAND_CROSSBOW, SHORT_SWORD, LONG_SWORD, RAPIER));
        setToolProficiencies(Collections.singletonList(THIEVES_TOOLS));
        setSavingThrows(Arrays.asList(DEXTERITY, INTELLIGENCE));
    }

    @Override
    public int getCritMultiplier() {
        return 3;
    }

    @Override
    public int getHPModifier() {
        return 5;
    }

    @Override
    public Dice getHitDice() {
        return new Dice(8);
    }

    @Override
    public int getLevelOneHitPoints() {
        return 8;
    }

}
