package com.example.daniel.roll20.dndCharacter;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Serializable, Parcelable {

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
        super();
    }

    private Character(Parcel in) {
        super();
        this.playerName = in.readString();
        this.characterName = in.readString();
        this.dnDClass = in.readString();
        this.level = in.readInt();
        this.xp = in.readInt();
        this.race = in.readString();
        this.background = in.readString();
        this.alignment = in.readString();
        this.hitPoints = in.readInt();
        this.armourClass = in.readInt();
        this.speed = in.readInt();
        this.proficiencyBonus = in.readInt();
        this.strength = in.readInt();
        this.dexterity = in.readInt();
        this.constitution = in.readInt();
        this.intelligence = in.readInt();
        this.wisdom = in.readInt();
        this.charisma = in.readInt();
        this.initiative = in.readInt();
    }

    public Character(String characterName) {
        this.characterName = characterName;
    }

    public Character(String playerName, String characterName, String dnDClass, int level, int xp, String race,
            String background, String alignment, int hitPoints, int armourClass, int speed, int proficiencyBonus,
            int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int initiative) {
        this.playerName = playerName;
        this.characterName = characterName;
        this.dnDClass = dnDClass;
        this.level = level;
        this.xp = xp;
        this.race = race;
        this.background = background;
        this.alignment = alignment;
        this.hitPoints = hitPoints;
        this.armourClass = armourClass;
        this.speed = speed;
        this.proficiencyBonus = proficiencyBonus;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.initiative = initiative;
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
        System.out.print("Character Name :" + this.characterName + "\n" + "Armour Class :" + this.armourClass + "\n"
            + "Proficiency Bonus :" + this.proficiencyBonus + "\n" + "Speed :" + this.speed + "\n" + "Hit Points :"
            + this.hitPoints + "\n" + "Level :" + this.level + "\n" + "Experience Points :" + this.xp + "\n");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getArmourClass());
        parcel.writeInt(getCharisma());
        parcel.writeInt(getConstitution());
        parcel.writeInt(getDexterity());
        parcel.writeInt(getArmourClass());
        parcel.writeInt(getHitPoints());
        parcel.writeInt(getInitiative());
        parcel.writeInt(getIntelligence());
        parcel.writeInt(getLevel());
        parcel.writeInt(getProficiencyBonus());
        parcel.writeInt(getSpeed());
        parcel.writeInt(getStrength());
        parcel.writeInt(getWisdom());
        parcel.writeInt(getXp());
        parcel.writeString(getAlignment());
        parcel.writeString(getBackground());
        parcel.writeString(getCharacterName());
        parcel.writeString(getDnDClass());
        parcel.writeString(getPlayerName());
        parcel.writeString(getRace());

    }

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {

        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {
            return new Character[size];
        }
    };
}
