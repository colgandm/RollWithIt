package com.example.daniel.roll20.dndCharacter;

public class Character {

    private String playerName;
    private String characterName;
    private String dnDClass;
    private int level;
    private int xp;
    private String race;
    private String background;
    private String alignment;
    private int hitPoints;
    private int armourClass;
    private int speed;
    private int proficiencyBonus;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int initiative;

    public Character() {
    }

    public Character(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getDnDClass() {
        return dnDClass;
    }

    public void setDnDClass(String dnDClass) {
        this.dnDClass = dnDClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

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

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void printAttributes() {
        String temp = "\n \t Strength :" + String.valueOf(strength) + "\n" + "\t Dexterity :"
            + String.valueOf(dexterity) + "\n" + "\t Constitution :" + String.valueOf(constitution) + "\n"
            + "\t Intelligence :" + String.valueOf(intelligence) + "\n" + "\t Wisdom :" + String.valueOf(wisdom) + "\n";
        System.out.print(temp);
    }

    public void printCharacterSheet() {
        System.out.print("Character Name :" + this.characterName + "\n" + "Aroumr Class :" + this.armourClass + "\n"
            + "Proficieny Bonus :" + this.proficiencyBonus + "\n" + "Speed :" + this.speed + "\n" + "Hit Points :"
            + this.hitPoints + "\n" + "Level :" + this.level + "\n" + "Experience Points :" + this.xp + "\n");
    }

}
