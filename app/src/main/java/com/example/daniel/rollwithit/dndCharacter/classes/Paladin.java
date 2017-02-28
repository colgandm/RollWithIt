package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.CHARISMA;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.HEAVY_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MARTIAL_WEAPONS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MEDIUM_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.NONE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SHIELDS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SIMPLE_WEAPONS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.WISDOM;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Paladin extends Class {

    public Paladin() {
        setClassType(ClassType.PALADIN);
        setArmorProficiencies(Arrays.asList(LIGHT_ARMOR, MEDIUM_ARMOR, HEAVY_ARMOR, SHIELDS));
        setWeaponProficiencies(Arrays.asList(SIMPLE_WEAPONS, MARTIAL_WEAPONS));
        setToolProficiencies(Collections.singletonList(NONE));
        setSavingThrows(Arrays.asList(CHARISMA, WISDOM));
    }

    @Override
    public int getHPModifier() {
        return 6;
    }

    @Override
    public Dice getHitDice() {
        return new Dice(10);
    }

    @Override
    public int getLevelOneHitPoints() {
        return 10;
    }

}
