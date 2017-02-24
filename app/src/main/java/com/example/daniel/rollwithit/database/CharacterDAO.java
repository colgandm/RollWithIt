package com.example.daniel.rollwithit.database;

import static com.example.daniel.rollwithit.utils.ConstAttributes.AGE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ALIGNMENT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ARMOUR;
import static com.example.daniel.rollwithit.utils.ConstAttributes.BACKGROUND;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARACTER_NAME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARISMA;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CLASS_TYPE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DEXTERITY;
import static com.example.daniel.rollwithit.utils.ConstAttributes.GENDER;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HEIGHT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HIT_POINTS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.INSPIRATION;
import static com.example.daniel.rollwithit.utils.ConstAttributes.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.LEVEL;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PLAYER_NAME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PROFICIENCY_BONUS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.RACE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.SPEED;
import static com.example.daniel.rollwithit.utils.ConstAttributes.STRENGTH;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WEIGHT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WISDOM;
import static com.example.daniel.rollwithit.utils.ConstAttributes.XP;

import java.util.ArrayList;

import com.example.daniel.rollwithit.dndCharacter.Abilities;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.dndCharacter.Character.Gender;
import com.example.daniel.rollwithit.dndCharacter.Defense;
import com.example.daniel.rollwithit.dndCharacter.Experience;
import com.example.daniel.rollwithit.dndCharacter.Range;
import com.example.daniel.rollwithit.dndCharacter.classes.Class;
import com.example.daniel.rollwithit.dndCharacter.classes.Class.ClassType;
import com.example.daniel.rollwithit.dndCharacter.races.Race;
import com.example.daniel.rollwithit.dndCharacter.races.Race.RaceType;
import com.example.daniel.rollwithit.utils.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CharacterDAO extends CharacterDBDAO {

    private static final String WHERE_CHARACTER_NAME_EQUALS = CHARACTER_NAME + " =?";
    private static final int DEFAULT_ABILITY_VALUE = 10;

    public CharacterDAO(Context context) {
        super(context);
    }

    public long save(Character character) {
        ContentValues values = new ContentValues();

        values.put(CHARACTER_NAME, character.getCharacterName());
        values.put(PLAYER_NAME, character.getPlayerName());
        values.put(CLASS_TYPE, character.getClassType().getClassTypeName());
        values.put(LEVEL, character.getLevel());
        values.put(BACKGROUND, character.getBackground());
        values.put(RACE, character.getRaceType().getRaceTypeName());
        values.put(ALIGNMENT, character.getAlignment());
        values.put(XP, character.getCharacterName());
        values.put(STRENGTH, character.getStrength());
        values.put(DEXTERITY, character.getDexterity());
        values.put(CONSTITUTION, character.getConstitution());
        values.put(INTELLIGENCE, character.getIntelligence());
        values.put(WISDOM, character.getWisdom());
        values.put(CHARISMA, character.getCharisma());
        values.put(INSPIRATION, character.getInspiration());
        values.put(PROFICIENCY_BONUS, character.getProficiencyBonus());
        values.put(ARMOUR, character.getArmor());
        values.put(SPEED, character.getSpeed());
        values.put(HIT_POINTS, character.getHitPoints().getValue());
        values.put(GENDER, character.getGender().toString());
        values.put(WEIGHT, character.getWeight());
        values.put(HEIGHT, character.getHeight());
        values.put(AGE, character.getAge());

        return database.insert(DataBaseHelper.CHARACTER_TABLE, null, values);
    }

    public ArrayList<Character> getCharacter() {
        ArrayList<Character> characters = new ArrayList<>();

        Cursor cursor = database.query(DataBaseHelper.CHARACTER_TABLE,
            new String[] {
                CHARACTER_NAME, PLAYER_NAME, CLASS_TYPE, LEVEL, BACKGROUND, RACE, ALIGNMENT, XP, STRENGTH, DEXTERITY,
                CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA, INSPIRATION, PROFICIENCY_BONUS, ARMOUR, SPEED, HIT_POINTS,
                GENDER, WEIGHT, HEIGHT, AGE },
            null, null, null, null, null);

        while (cursor.moveToNext()) {
            Character character = new Character();

            character.setCharacterName(cursor.getString(0));
            character.setPlayerName(cursor.getString(1));
            ClassType classType = Utils.determineClass(cursor.getString(2));
            character.setClassType(Class.getClassFromMap(classType));
            character.setLevel(cursor.getInt(3));
            character.setBackground(cursor.getString(4));
            RaceType raceType = Utils.determineRace(cursor.getString(5));
            character.setRaceType(Race.getRaceFromMap(raceType));
            character.setAlignment(cursor.getString(6));
            character.setXp(new Experience(cursor.getInt(7)));
            Abilities abilities = new Abilities(DEFAULT_ABILITY_VALUE);
            character.setAbilities(abilities);
            character.setStrength(cursor.getInt(8));
            character.setDexterity(cursor.getInt(9));
            character.setConstitution(cursor.getInt(10));
            character.setIntelligence(cursor.getInt(11));
            character.setWisdom(cursor.getInt(12));
            character.setCharisma(cursor.getInt(13));
            character.setInspiration(cursor.getInt(14));
            character.setProficiencyBonus(cursor.getInt(15));
            character.setArmor(new Defense());
            character.setDefense(cursor.getInt(16));
            character.setSpeed(cursor.getInt(17));
            character.setHitPoints(new Range(0, character.getClassType().getHPModifier(), Integer.MAX_VALUE));
            character.setHP(cursor.getInt(18));
            Gender gender = Utils.determineGender(cursor.getString(19));
            character.setGender(gender);
            character.setWeight(cursor.getInt(20));
            character.setHeight(cursor.getInt(21));
            character.setAge(cursor.getInt(22));

            characters.add(character);
        }
        cursor.close();
        return characters;
    }

    public long update(Character character) {
        ContentValues values = new ContentValues();

        values.put(CHARACTER_NAME, character.getCharacterName());
        values.put(PLAYER_NAME, character.getPlayerName());
        values.put(CLASS_TYPE, character.getClassType().getClassTypeName());
        values.put(LEVEL, character.getLevel());
        values.put(BACKGROUND, character.getBackground());
        values.put(RACE, character.getRaceType().getRaceTypeName());
        values.put(ALIGNMENT, character.getAlignment());
        values.put(XP, character.getCharacterName());
        values.put(STRENGTH, character.getStrength());
        values.put(DEXTERITY, character.getDexterity());
        values.put(CONSTITUTION, character.getConstitution());
        values.put(INTELLIGENCE, character.getIntelligence());
        values.put(WISDOM, character.getWisdom());
        values.put(CHARISMA, character.getCharisma());
        values.put(INSPIRATION, character.getInspiration());
        values.put(PROFICIENCY_BONUS, character.getProficiencyBonus());
        values.put(ARMOUR, character.getArmor());
        values.put(SPEED, character.getSpeed());
        values.put(HIT_POINTS, character.getHitPoints().getValue());
        values.put(GENDER, character.getGender().toString());
        values.put(WEIGHT, character.getWeight());
        values.put(HEIGHT, character.getHeight());
        values.put(AGE, character.getAge());

        return (long)database.update(DataBaseHelper.CHARACTER_TABLE, values, WHERE_CHARACTER_NAME_EQUALS,
            new String[] { String.valueOf(character.getCharacterName()) });
    }

    public int delete(Character character) {
        return database.delete(DataBaseHelper.CHARACTER_TABLE, WHERE_CHARACTER_NAME_EQUALS,
            new String[] { character.getCharacterName() + "" });
    }
}
