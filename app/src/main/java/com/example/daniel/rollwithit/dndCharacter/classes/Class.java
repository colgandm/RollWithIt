package com.example.daniel.rollwithit.dndCharacter.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.daniel.rollwithit.dndCharacter.Abilities;
import com.example.daniel.rollwithit.dndCharacter.Dice;

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
        typeToClassMap.put(ClassType.WARLOCK, new Warlock());
        typeToClassMap.put(ClassType.WIZARD, new Wizard());
    }

    private List<String> armorProficiencies = new ArrayList<>();
    private List<String> weaponProficiencies = new ArrayList<>();
    private List<String> toolProficiencies = new ArrayList<>();
    private List<String> savingThrows = new ArrayList<>();
    private List<String> skills = new ArrayList<>();
    private ClassType classType;
    private Map<ClassSkills, Abilities.AbilityType> skillToAbilityMap = new HashMap<>();

    public static Class getClassFromMap(ClassType classType) {
        return typeToClassMap.get(classType);
    }

    public String proficienciesToString() {
        return "Armor Proficiencies = " + armorProficiencies + "\n Weapon Proficiencies= " + weaponProficiencies
            + "\n Tool Proficiencies = " + toolProficiencies + "\n Saving Throws = " + savingThrows;
    }

    public ClassType getClassType() {
        return classType;
    }

    void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public String getClassTypeName() {
        return classType.name();
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

    public Dice getHitDice() {
        return new Dice(8);
    }

    public int getLevelOneHitPoints() {
        return 0;
    }

    public List<String> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(List<String> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public List<String> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(List<String> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public List<String> getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(List<String> toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public List<String> getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(List<String> savingThrows) {
        this.savingThrows = savingThrows;
    }

    public void addArmorProficiency(String armorProficiency) {
        this.armorProficiencies.add(armorProficiency);
    }

    public void removeArmorProficiency(String armorProficiency) {
        this.armorProficiencies.remove(armorProficiency);
    }

    public void addWeaponProficiency(String weaponProficiency) {
        this.weaponProficiencies.add(weaponProficiency);
    }

    public void removeWeaponProficiency(String weaponProficiency) {
        this.weaponProficiencies.remove(weaponProficiency);
    }

    public void addToolProficiency(String toolProficiency) {
        this.toolProficiencies.add(toolProficiency);
    }

    public void removeToolProficiency(String toolProficiency) {
        this.toolProficiencies.remove(toolProficiency);
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
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
        WARLOCK,
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
