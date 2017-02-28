package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.DAGGERS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DARTS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_CROSSBOW;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.NONE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.QUARTERSTAFFS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SLINGS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.WISDOM;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Wizard extends Class {

    public Wizard() {
        setClassType(ClassType.WIZARD);

        setArmorProficiencies(Collections.singletonList(NONE));
        setWeaponProficiencies(Arrays.asList(DAGGERS, DARTS, SLINGS, QUARTERSTAFFS, LIGHT_CROSSBOW));
        setToolProficiencies(Collections.singletonList(NONE));
        setSavingThrows(Arrays.asList(INTELLIGENCE, WISDOM));
    }

    @Override
    public int getHPModifier() {
        return 4;
    }

    @Override
    public Dice getHitDice() {
        return new Dice(6);
    }

    @Override
    public int getLevelOneHitPoints() {
        return 6;
    }

}
