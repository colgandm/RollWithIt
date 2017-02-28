package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.HEAVY_ARMOR;
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

public class Fighter extends Class {

    public Fighter() {
        setClassType(ClassType.FIGHTER);
        setArmorProficiencies(Arrays.asList(LIGHT_ARMOR, MEDIUM_ARMOR, HEAVY_ARMOR, SHIELDS));
        setWeaponProficiencies(Arrays.asList(SIMPLE_WEAPONS, MARTIAL_WEAPONS));
        setToolProficiencies(Collections.singletonList(NONE));
        setSavingThrows(Arrays.asList(STRENGTH, CONSTITUTION));
    }

    @Override
    public int getLevelBonusToRoll(int level) {
        return level;
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
