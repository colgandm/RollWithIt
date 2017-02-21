package com.example.daniel.rollwithit.dndCharacter.classes;

import java.util.HashMap;
import java.util.Map;

import com.example.daniel.rollwithit.dndCharacter.Abilities;

public class Class {

    private static Map<ClassType, Class> typeToClassMap;

    static {
        typeToClassMap = new HashMap<>();
        typeToClassMap.put(ClassType.DEFAULT, new Class());
        typeToClassMap.put(ClassType.BARBARIAN, new Barbarian());
        typeToClassMap.put(ClassType.BARD, new Bard());
        typeToClassMap.put(ClassType.CLERIC, new Cleric());
        typeToClassMap.put(ClassType.DRUID, new Druid());
        typeToClassMap.put(ClassType.FIGHTER, new Fighter());
        typeToClassMap.put(ClassType.MONK, new Monk());
        typeToClassMap.put(ClassType.PALADIN, new Paladin());
        typeToClassMap.put(ClassType.RANGER, new Ranger());
        typeToClassMap.put(ClassType.ROGUE, new Rogue());
        typeToClassMap.put(ClassType.SORCERER, new Sorcerer());
        typeToClassMap.put(ClassType.WIZARD, new Wizard());
    }

    private Map<ClassSkills, Abilities.AbilityType> skillToAbilityMap = new HashMap<ClassSkills, Abilities.AbilityType>();

    public static Class getClassFromMap(ClassType type) {
        return typeToClassMap.get(type);
    }

    public int getHPModifier() {
        return 5;
    }

    public int getCritMultiplier() {
        return 2;
    }

    public int getLevelBonusToRoll(int level) {
        return (int)Math.floor(level / 2);
    }

    public Map<ClassSkills, Abilities.AbilityType> getSkillToAbilityMap() {
        return skillToAbilityMap;
    }

    public void setSkillToAbilityMap(Map<ClassSkills, Abilities.AbilityType> skillToAbilityMap) {
        this.skillToAbilityMap = skillToAbilityMap;
    }

    public enum ClassType {
        DEFAULT,
        BARBARIAN,
        BARD,
        CLERIC,
        DRUID,
        FIGHTER,
        MONK,
        PALADIN,
        RANGER,
        ROGUE,
        SORCERER,
        WIZARD
    }

    enum ClassSkills {
        CLIMB,
        CRAFT,
        HANDLE_ANIMAL,
        INTIMIDATE,
        JUMP,
        RIDE,
        SWIM
    }
}
