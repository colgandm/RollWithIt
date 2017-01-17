package com.example.daniel.roll20.dndCharacter;

/**
 * Created by daniel on 17/01/17.
 */

public class Character {

    private int proficienyBonus;
    private int aroumrClass;
    private int speed;
    private int hitPoints;
    private int level;
    private int xp;
    private String characterName;
    private String playerName;

    private DnDClass dnDClass;
    private Background background;
    private Race race;
    private Alignment alignment;
    private CharAttributes charAttributes;
    private Equipment equipment;

    public Character(String characterName) {
        this.characterName = characterName;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public DnDClass getDnDClass() {
        return dnDClass;
    }

    public void setDnDClass(DnDClass dnDClass) {
        this.dnDClass = dnDClass;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public CharAttributes getCharAttributes() {
        return charAttributes;
    }

    public void setCharAttributes(CharAttributes charAttributes) {
        this.charAttributes = charAttributes;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getProficienyBonus() {
        return proficienyBonus;
    }

    public void setProficienyBonus(int proficienyBonus) {
        this.proficienyBonus = proficienyBonus;
    }

    public int getAroumrClass() {
        return aroumrClass;
    }

    public void setAroumrClass(int aroumrClass) {
        this.aroumrClass = aroumrClass;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
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

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void printCharacterSheet() {
        System.out.print("Character Name :" + this.characterName + "\n" +
                "Character Attributes :" + this.charAttributes.printAttributes() + "\n" +
                "Aroumr Class :" + this.aroumrClass + "\n" +
                "Proficieny Bonus :" + this.proficienyBonus + "\n" +
                "Speed :" + this.speed + "\n" +
                "Hit Points :" + this.hitPoints + "\n" +
                "Level :" + this.level + "\n" +
                "Experience Points :" + this.xp + "\n" );
    }
}
