package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.CHARISMA;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DAGGERS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DARTS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_CROSSBOW;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.NONE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.QUARTERSTAFFS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SLINGS;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Sorcerer extends Class {

    public Sorcerer() {
        setClassType(ClassType.SORCERER);
        setArmorProficiencies(Collections.singletonList(NONE));
        setWeaponProficiencies(Arrays.asList(DAGGERS, DARTS, SLINGS, QUARTERSTAFFS, LIGHT_CROSSBOW));
        setToolProficiencies(Collections.singletonList(NONE));
        setSavingThrows(Arrays.asList(CONSTITUTION, CHARISMA));

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
