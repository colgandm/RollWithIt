package com.example.daniel.roll20.dndCharacter;

/**
 * Created by daniel on 17/01/17.
 */
public class CharAttributes {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String printAttributes() {
        String temp = "\n \t Strength :" + String.valueOf(strength) + "\n" +
                "\t Dexterity :" + String.valueOf(dexterity) + "\n" +
                "\t Constitution :" + String.valueOf(constitution) + "\n" +
                "\t Intelligence :" + String.valueOf(intelligence) + "\n" +
                "\t Wisdom :" + String.valueOf(wisdom) + "\n";
        return temp;
    }
}
