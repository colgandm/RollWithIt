package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.CHARISMA;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DEXTERITY;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.HAND_CROSSBOW;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LONG_SWORD;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MUSICAL_INSTRUMENT;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.RAPIER;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SHORT_SWORD;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SIMPLE_WEAPONS;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Bard extends Class {

    public Bard() {
        setClassType(ClassType.BARD);
        setArmorProficiencies(Collections.singletonList(LIGHT_ARMOR));
        setWeaponProficiencies(Arrays.asList(SIMPLE_WEAPONS, HAND_CROSSBOW, SHORT_SWORD, LONG_SWORD, RAPIER));
        setToolProficiencies(Collections.singletonList(MUSICAL_INSTRUMENT));
        setSavingThrows(Arrays.asList(CHARISMA, DEXTERITY));
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
