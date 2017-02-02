package com.example.daniel.roll20.database;

import static com.example.daniel.roll20.utils.constantAttributes.ALIGNMENT;
import static com.example.daniel.roll20.utils.constantAttributes.ARMOUR_CLASS;
import static com.example.daniel.roll20.utils.constantAttributes.BACKGROUND;
import static com.example.daniel.roll20.utils.constantAttributes.CHARACTER_NAME;
import static com.example.daniel.roll20.utils.constantAttributes.CHARISMA;
import static com.example.daniel.roll20.utils.constantAttributes.CONSTITUTION;
import static com.example.daniel.roll20.utils.constantAttributes.DEXTERITY;
import static com.example.daniel.roll20.utils.constantAttributes.DND_CLASS;
import static com.example.daniel.roll20.utils.constantAttributes.HIT_POINTS;
import static com.example.daniel.roll20.utils.constantAttributes.INTELLIGENCE;
import static com.example.daniel.roll20.utils.constantAttributes.LEVEL;
import static com.example.daniel.roll20.utils.constantAttributes.PLAYER_NAME;
import static com.example.daniel.roll20.utils.constantAttributes.PROFICIENCY_BONUS;
import static com.example.daniel.roll20.utils.constantAttributes.RACE;
import static com.example.daniel.roll20.utils.constantAttributes.SPEED;
import static com.example.daniel.roll20.utils.constantAttributes.STRENGTH;
import static com.example.daniel.roll20.utils.constantAttributes.WISDOM;
import static com.example.daniel.roll20.utils.constantAttributes.XP;

import java.util.ArrayList;

import com.example.daniel.roll20.dndCharacter.Character;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CharacterDAO extends CharacterDBDAO {

    private static final String WHERE_CHARACTER_NAME_EQUALS = CHARACTER_NAME + " =?";

    public CharacterDAO(Context context) {
        super(context);
    }

    public long save(Character character) {
        ContentValues values = new ContentValues();
        values.put(CHARACTER_NAME, character.getCharacterName());
        values.put(PLAYER_NAME, character.getPlayerName());
        values.put(BACKGROUND, character.getBackground());
        values.put(ALIGNMENT, character.getAlignment());
        values.put(RACE, character.getRace());
        values.put(DND_CLASS, character.getDnDClass());
        values.put(PROFICIENCY_BONUS, character.getProficiencyBonus());
        values.put(ARMOUR_CLASS, character.getArmourClass());
        values.put(SPEED, character.getSpeed());
        values.put(HIT_POINTS, character.getHitPoints());
        values.put(LEVEL, character.getLevel());
        values.put(XP, character.getCharacterName());
        values.put(STRENGTH, character.getStrength());
        values.put(DEXTERITY, character.getDexterity());
        values.put(CONSTITUTION, character.getConstitution());
        values.put(INTELLIGENCE, character.getIntelligence());
        values.put(WISDOM, character.getWisdom());
        values.put(CHARISMA, character.getCharisma());
        return database.insert(DataBaseHelper.CHARACTER_TABLE, null, values);
    }

    public ArrayList<Character> getCharacter() {
        ArrayList<Character> characters = new ArrayList<>();

        Cursor cursor = database.query(DataBaseHelper.CHARACTER_TABLE,
            new String[] {
                CHARACTER_NAME, PLAYER_NAME, BACKGROUND, ALIGNMENT, RACE, DND_CLASS, PROFICIENCY_BONUS, ARMOUR_CLASS,
                SPEED, HIT_POINTS, LEVEL, XP, STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA },
            null, null, null, null, null);

        while (cursor.moveToNext()) {
            Character character = new Character();
            character.setCharacterName(cursor.getString(0));
            character.setPlayerName(cursor.getString(1));
            character.setBackground(cursor.getString(2));
            character.setAlignment(cursor.getString(3));
            character.setRace(cursor.getString(4));
            character.setDnDClass(cursor.getString(5));
            character.setProficiencyBonus(cursor.getInt(6));
            character.setArmourClass(cursor.getInt(7));
            character.setSpeed(cursor.getInt(8));
            character.setHitPoints(cursor.getInt(9));
            character.setLevel(cursor.getInt(10));
            character.setXp(cursor.getInt(11));
            character.setStrength(cursor.getInt(12));
            character.setDexterity(cursor.getInt(13));
            character.setConstitution(cursor.getInt(14));
            character.setIntelligence(cursor.getInt(15));
            character.setWisdom(cursor.getInt(16));
            character.setCharisma(cursor.getInt(17));

            characters.add(character);
        }
        cursor.close();
        return characters;
    }

    public long update(Character character) {
        ContentValues values = new ContentValues();

        values.put(CHARACTER_NAME, character.getCharacterName());
        values.put(PLAYER_NAME, character.getPlayerName());
        values.put(BACKGROUND, character.getBackground());
        values.put(ALIGNMENT, character.getAlignment());
        values.put(RACE, character.getRace());
        values.put(DND_CLASS, character.getDnDClass());
        values.put(PROFICIENCY_BONUS, character.getProficiencyBonus());
        values.put(ARMOUR_CLASS, character.getArmourClass());
        values.put(SPEED, character.getSpeed());
        values.put(HIT_POINTS, character.getHitPoints());
        values.put(LEVEL, character.getLevel());
        values.put(XP, character.getCharacterName());
        values.put(STRENGTH, character.getStrength());
        values.put(DEXTERITY, character.getDexterity());
        values.put(CONSTITUTION, character.getConstitution());
        values.put(INTELLIGENCE, character.getIntelligence());
        values.put(WISDOM, character.getWisdom());
        values.put(CHARISMA, character.getCharisma());

        return (long)database.update(DataBaseHelper.CHARACTER_TABLE, values, WHERE_CHARACTER_NAME_EQUALS,
            new String[] { String.valueOf(character.getCharacterName()) });

    }

    public int delete(Character character) {
        return database.delete(DataBaseHelper.CHARACTER_TABLE, WHERE_CHARACTER_NAME_EQUALS,
            new String[] { character.getCharacterName() + "" });
    }

}
