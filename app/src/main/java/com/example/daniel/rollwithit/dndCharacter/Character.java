package com.example.daniel.rollwithit.dndCharacter;

import java.io.Serializable;

import com.example.daniel.rollwithit.dndCharacter.classes.Class;
import com.example.daniel.rollwithit.dndCharacter.classes.Class.ClassType;
import com.example.daniel.rollwithit.dndCharacter.classes.Fighter;
import com.example.daniel.rollwithit.dndCharacter.classes.Rogue;
import com.example.daniel.rollwithit.dndCharacter.races.Human;
import com.example.daniel.rollwithit.dndCharacter.races.Race;
import com.example.daniel.rollwithit.dndCharacter.races.Race.RaceType;
import com.example.daniel.rollwithit.utils.DiceRoller;
import com.example.daniel.rollwithit.utils.Utils;

import android.os.Parcel;
import android.os.Parcelable;

public class Character implements Serializable, Parcelable {

    public static final Parcelable.Creator<Character> CREATOR = new Parcelable.Creator<Character>() {

        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    private String characterName;
    private Class classType;
    private int level;
    private String background;
    private String playerName;
    private Race raceType;
    private String alignment;
    private Experience xp;
    private Abilities abilities;
    private int inspiration;
    private int proficiencyBonus;
    private Defense armor;
    private int initiative;
    private int speed;
    private Range hitPoints;
    private Gender gender;
    private int weight;
    private int height;
    private int age;

    public Character() {
        super();
    }

    private Character(Parcel in) {
        super();
        this.characterName = in.readString();
        this.classType = Class.getClassFromMap(Utils.determineClass(in.readString()));
        this.level = in.readInt();
        this.background = in.readString();
        this.playerName = in.readString();
        this.raceType = Race.getRaceFromMap(Utils.determineRace(in.readString()));
        this.alignment = in.readString();
        this.xp = new Experience(in.readInt());
        int strength = in.readInt();
        int dex = in.readInt();
        int con = in.readInt();
        int intelligence = in.readInt();
        int wisdom = in.readInt();
        int charisma = in.readInt();
        this.abilities = new Abilities(strength, dex, con, intelligence, wisdom, charisma);
        this.inspiration = in.readInt();
        this.proficiencyBonus = in.readInt();
        this.armor = new Defense();
        setDefense(in.readInt());
        this.initiative = in.readInt();
        this.speed = in.readInt();
        this.hitPoints = new Range(0, in.readInt(), Integer.MAX_VALUE);
        this.gender = Utils.determineGender(in.readString());
        this.weight = in.readInt();
        this.height = in.readInt();
        this.age = in.readInt();

    }

    public Character(String name) {
        this(name, ClassType.DEFAULT, RaceType.DEFAULT);
    }

    // Constructor for creating a new Character
    public Character(String name, ClassType classType, RaceType raceType) {
        this.setCharacterName(name);
        this.classType = Class.getClassFromMap(classType);
        this.raceType = Race.getRaceFromMap(raceType);
        this.hitPoints = new Range(0, this.classType.getHPModifier(), Integer.MAX_VALUE);
        this.setArmor(new Defense());
        this.abilities = new Abilities(10);
        this.xp = new Experience(0);
        this.speed = this.raceType.getSpeed();
        this.setAge(generateAge());
        this.setWeight(generateWeight());
        this.setHeight(generateHeight());
        this.setGender(Gender.MALE);
        this.proficiencyBonus = getProficiencyBonus();
        this.initiative = getInitiative();
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Class getClassType() {
        return classType;
    }

    public void setClassType(Class classType) {
        this.classType = classType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Race getRaceType() {
        return raceType;
    }

    public void setRaceType(Race raceType) {
        this.raceType = raceType;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public Experience getXp() {
        return xp;
    }

    public void setXp(Experience xp) {
        this.xp = xp;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int level) {
        this.proficiencyBonus = (int)(Math.ceil(level / 4) + 1);
    }

    public int getArmor() {
        return Math.max(0, armor.getArmor() + abilities.getModifier(abilities.getDexterity()));
    }

    public void setArmor(Defense armor) {
        this.armor = armor;
    }

    public void setDefense(int defense) {
        armor.setArmor(defense);
    }

    public int getInitiative() {
        switch (this.abilities.getDexterity()) {
        case 10:
        case 11:
            return 0;
        case 12:
        case 13:
            return 1;
        case 14:
        case 15:
            return 2;
        case 16:
        case 17:
            return 3;
        case 18:
        case 19:
            return 4;
        case 20:
            return 5;

        default:
            return 0;
        }
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Range getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Range hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weights) {
        this.weight = weights;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStrength() {
        return abilities.getStrength();
    }

    public void setStrength(int strength) {
        abilities.setStrength(strength);
    }

    public int getDexterity() {
        return abilities.getDexterity();
    }

    public void setDexterity(int dexterity) {
        abilities.setDexterity(dexterity);
    }

    public int getConstitution() {
        return abilities.getConstitution();
    }

    public void setConstitution(int constitution) {
        abilities.setConstitution(constitution);
    }

    public int getWisdom() {
        return abilities.getWisdom();
    }

    public void setWisdom(int wisdom) {
        abilities.setWisdom(wisdom);
    }

    public int getIntelligence() {
        return abilities.getIntelligence();
    }

    public void setIntelligence(int intelligence) {
        abilities.setIntelligence(intelligence);
    }

    public int getCharisma() {
        return abilities.getCharisma();
    }

    public void setCharisma(int charisma) {
        abilities.setCharisma(charisma);
    }

    private int getCurrentXP() {
        return xp.getTotalExperience();
    }

    public void addExperience(int points) {
        int oldLevel = getLevel();

        xp.addToExperience(points);

        int levelsGained = getLevel() - oldLevel;
        for (int level = 0; level < levelsGained; level++) { // only if level gained
            levelGained();
        }

    }

    private void levelGained() {
        hitPoints.add(classType.getHPModifier() + abilities.getModifier(getConstitution()));
    }

    private int generateAge() {
        if ((raceType.getClass() == Human.class) && (classType.getClass().equals(Rogue.class))) {
            return DiceRoller.roll(1, 4, 15);
        } else {
            if ((raceType.getClass() == Human.class) && classType.getClass().equals(Fighter.class)) {
                return DiceRoller.roll(1, 6, 15);
            }
        }
        return 0;
    }

    // TODO Write method to generate Weight
    private int generateWeight() {
        if ((raceType.getClass() == Human.class) && (classType.getClass().equals(Rogue.class))) {
            return DiceRoller.roll(1, 4, 15);
        } else {
            if ((raceType.getClass() == Human.class) && classType.getClass().equals(Fighter.class)) {
                return DiceRoller.roll(1, 6, 15);
            }
        }
        return 0;
    }

    // TODO Write method to generate Height
    private int generateHeight() {
        if ((raceType.getClass() == Human.class) && (classType.getClass().equals(Rogue.class))) {
            return DiceRoller.roll(1, 4, 15);
        } else {
            if ((raceType.getClass() == Human.class) && classType.getClass().equals(Fighter.class)) {
                return DiceRoller.roll(1, 6, 15);
            }
        }
        return 0;
    }

    public void decrementHP(int hp) {
        hitPoints.add(-hp);
    }

    private int getHP() {

        if (hitPoints.getValue() == 0) {
            return 0;
        }

        int constitutionModifier = abilities.getModifier(abilities.getConstitution());
        if (hitPoints.getValue() + constitutionModifier < 1) {
            return 1;
        }

        return hitPoints.getValue() + constitutionModifier;
    }

    public void setHP(int hitPoints) {
        this.hitPoints.setValue(hitPoints);
    }

    public boolean isDead() {
        return getHP() <= 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(getCharacterName());
        parcel.writeString(getClassType().toString());
        parcel.writeInt(getLevel());
        parcel.writeString(getBackground());
        parcel.writeString(getPlayerName());
        parcel.writeString(getRaceType().getRaceTypeName());
        parcel.writeString(getAlignment());
        parcel.writeInt(getCurrentXP());
        parcel.writeInt(getStrength());
        parcel.writeInt(getDexterity());
        parcel.writeInt(getConstitution());
        parcel.writeInt(getIntelligence());
        parcel.writeInt(getWisdom());
        parcel.writeInt(getCharisma());
        parcel.writeInt(getInspiration());
        parcel.writeInt(getProficiencyBonus());
        parcel.writeInt(getArmor());
        parcel.writeInt(getInitiative());
        parcel.writeInt(getSpeed());
        parcel.writeInt(getHP());
        parcel.writeString(getGender().toString());
        parcel.writeInt(getWeight());
        parcel.writeInt(getHeight());
        parcel.writeInt(getAge());
    }

    public enum Gender {
        MALE,
        FEMALE
    }

}
