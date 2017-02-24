package com.example.daniel.rollwithit.utils;

import static com.example.daniel.rollwithit.utils.ConstAttributes.BARBARIAN;
import static com.example.daniel.rollwithit.utils.ConstAttributes.BARD;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CLERIC;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DRUID;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DWARF;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ELF;
import static com.example.daniel.rollwithit.utils.ConstAttributes.FEMALE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.FIGHTER;
import static com.example.daniel.rollwithit.utils.ConstAttributes.GNOME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HALFLING;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HALF_ELF;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HALF_ORC;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HUMAN;
import static com.example.daniel.rollwithit.utils.ConstAttributes.MALE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.MONK;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PALADIN;
import static com.example.daniel.rollwithit.utils.ConstAttributes.RANGER;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ROGUE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.SORCERER;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WIZARD;

import com.example.daniel.rollwithit.dndCharacter.Character.Gender;
import com.example.daniel.rollwithit.dndCharacter.classes.Class.ClassType;
import com.example.daniel.rollwithit.dndCharacter.races.Race.RaceType;

public class Utils {

    public static ClassType determineClass(String dndClass) {
        switch (dndClass.toUpperCase()) {
        case BARBARIAN:
            return ClassType.BARBARIAN;
        case BARD:
            return ClassType.BARD;
        case CLERIC:
            return ClassType.CLERIC;
        case DRUID:
            return ClassType.DRUID;
        case FIGHTER:
            return ClassType.FIGHTER;
        case MONK:
            return ClassType.MONK;
        case PALADIN:
            return ClassType.PALADIN;
        case RANGER:
            return ClassType.RANGER;
        case ROGUE:
            return ClassType.ROGUE;
        case SORCERER:
            return ClassType.SORCERER;
        case WIZARD:
            return ClassType.WIZARD;
        default:
            return ClassType.DEFAULT;
        }
    }

    public static RaceType determineRace(String race) {
        switch (race.toUpperCase()) {
        case HUMAN:
            return RaceType.HUMAN;
        case DWARF:
            return RaceType.DWARF;
        case ELF:
            return RaceType.ELF;
        case GNOME:
            return RaceType.HUMAN;
        case HALF_ELF:
            return RaceType.HALFELF;
        case HALF_ORC:
            return RaceType.HALFORC;
        case HALFLING:
            return RaceType.HALFLING;
        default:
            return RaceType.DEFAULT;
        }
    }

    public static Gender determineGender(String gender) {
        switch (gender.toUpperCase()) {
        case FEMALE:
            return Gender.FEMALE;
        case MALE:
            return Gender.MALE;
        default:
            return Gender.MALE;
        }
    }
}
