package com.example.daniel.rollwithit.dndCharacter;

public class Abilities {

    private static final int MINIMUM_ABILITY_VALUE = 1;
    private static final int MAXIMUM_ABILITY_VALUE = 20;
    private Range strength, dexterity, constitution, intelligence, wisdom, charisma;

    public Abilities(int defaultValue) {
        strength = createAbility(defaultValue);
        dexterity = createAbility(defaultValue);
        constitution = createAbility(defaultValue);
        intelligence = createAbility(defaultValue);
        wisdom = createAbility(defaultValue);
        charisma = createAbility(defaultValue);
    }

    public Abilities(int s, int d, int con, int i, int w, int c) {
        strength = createAbility(s);
        dexterity = createAbility(d);
        constitution = createAbility(con);
        intelligence = createAbility(i);
        wisdom = createAbility(w);
        charisma = createAbility(c);
    }

    private Range createAbility(int defaultValue) {
        return new Range(MINIMUM_ABILITY_VALUE, defaultValue, MAXIMUM_ABILITY_VALUE);
    }

    public int getStrength() {
        return strength.getValue();
    }

    public void setStrength(int strength) {
        this.strength.setValue(strength);
    }

    public int getDexterity() {
        return dexterity.getValue();
    }

    public void setDexterity(int dexterity) {
        this.dexterity.setValue(dexterity);
    }

    public int getConstitution() {
        return constitution.getValue();
    }

    public void setConstitution(int constitution) {
        this.constitution.setValue(constitution);
    }

    public int getWisdom() {
        return wisdom.getValue();
    }

    public void setWisdom(int wisdom) {
        this.wisdom.setValue(wisdom);
    }

    public int getIntelligence() {
        return intelligence.getValue();
    }

    public void setIntelligence(int intelligence) {
        this.intelligence.setValue(intelligence);
    }

    public int getCharisma() {
        return charisma.getValue();
    }

    public void setCharisma(int charisma) {
        this.charisma.setValue(charisma);
    }

    public int getModifier(int value) {
        return value / 2 - 5;
    }

    public enum AbilityType {
        STRENGTH,
        DEXTERITY,
        CONSTITUTION,
        WISDOM,
        INTELLIGENCE,
        CHARISMA
    }

}
