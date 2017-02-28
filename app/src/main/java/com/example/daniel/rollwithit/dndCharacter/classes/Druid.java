package com.example.daniel.rollwithit.dndCharacter.classes;

import static com.example.daniel.rollwithit.utils.proficienciesConsts.CLUBS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DAGGERS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.DARTS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.HERBALISM_KIT;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.JAVELINS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.LIGHT_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MACES;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.MEDIUM_ARMOR;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.QUARTERSTAFFS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SCIMITARS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SHIELDS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SICKLES;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SLINGS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.SPEARS;
import static com.example.daniel.rollwithit.utils.proficienciesConsts.WISDOM;

import java.util.Arrays;
import java.util.Collections;

import com.example.daniel.rollwithit.dndCharacter.Dice;

public class Druid extends Class {

    public Druid() {
        setClassType(ClassType.DRUID);
        setArmorProficiencies(Arrays.asList(LIGHT_ARMOR, MEDIUM_ARMOR, SHIELDS));
        setWeaponProficiencies(Arrays.asList(CLUBS, DAGGERS, SPEARS, SLINGS, DARTS, JAVELINS, SPEARS, MACES,
            QUARTERSTAFFS, SCIMITARS, SICKLES));
        setToolProficiencies(Collections.singletonList(HERBALISM_KIT));
        setSavingThrows(Arrays.asList(INTELLIGENCE, WISDOM));
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
