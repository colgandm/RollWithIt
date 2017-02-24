package com.example.daniel.rollwithit.dndCharacter.classes;

import com.example.daniel.rollwithit.dndCharacter.Abilities.AbilityType;

public class Fighter extends Class {

    public Fighter() {
        setClassType(ClassType.FIGHTER);
        getSkillToAbilityMap().put(ClassSkills.CLIMB, AbilityType.STRENGTH);
        getSkillToAbilityMap().put(ClassSkills.CRAFT, AbilityType.INTELLIGENCE);
        getSkillToAbilityMap().put(ClassSkills.HANDLE_ANIMAL, AbilityType.CHARISMA);
        getSkillToAbilityMap().put(ClassSkills.INTIMIDATE, AbilityType.CHARISMA);
        getSkillToAbilityMap().put(ClassSkills.JUMP, AbilityType.STRENGTH);
        getSkillToAbilityMap().put(ClassSkills.RIDE, AbilityType.DEXTERITY);
        getSkillToAbilityMap().put(ClassSkills.SWIM, AbilityType.STRENGTH);
    }

    @Override
    public int getLevelBonusToRoll(int level) {
        return level;
    }

    @Override
    public int getHPModifier() {
        return 10;
    }
}
