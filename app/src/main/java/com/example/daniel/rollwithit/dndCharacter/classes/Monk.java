package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.ARTISANS_TOOLS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DEXTERITY;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MUSICAL_INSTRUMENT;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.NONE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.OR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SHORT_SWORD;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SIMPLE_WEAPONS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.STRENGTH;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Monk extends Class {

    public Monk() {
        setClassType(ClassType.MONK);
        setArmorProficiencies(Collections.singletonList(NONE));
        setWeaponProficiencies(Arrays.asList(SIMPLE_WEAPONS, SHORT_SWORD));
        setToolProficiencies(Arrays.asList(MUSICAL_INSTRUMENT, OR, ARTISANS_TOOLS));
        setSavingThrows(Arrays.asList(STRENGTH, DEXTERITY));
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
