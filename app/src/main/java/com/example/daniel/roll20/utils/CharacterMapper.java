package com.example.daniel.roll20.utils;

import android.os.Environment;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.example.daniel.roll20.dndCharacter.Character;

/**
 * Created by daniel on 19/01/17.
 */
public class CharacterMapper {
    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
    File file = new File(path, "/" + "characterData.txt");

    public void writeCharacterToFile(Character character) throws IOException {
        Map<String, String> characterDetails = CharacterToMap(character);
        Properties properties = new Properties();
        properties.putAll(characterDetails);
        properties.store(new FileOutputStream(file), null);
        System.out.println("Success!");
    }

    public Character ReadCharacterToFile() throws IOException {
        Map<String, String> characterDetails = new HashMap<>();
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        for (String key : properties.stringPropertyNames()) {
            characterDetails.put(key, properties.get(key).toString());
        }
        return MapToCharacter(characterDetails);
    }

    private Character MapToCharacter(Map<String, String> characterDetails) {
        Character character = new Character();

        character.setProficiencyBonus(Integer.parseInt(characterDetails.get(PROFICIENCY_BONUS)));
        character.setArmourClass(Integer.parseInt(characterDetails.get(ARMOUR_CLASS)));
        character.setSpeed(Integer.parseInt(characterDetails.get(SPEED)));
        character.setHitPoints(Integer.parseInt(characterDetails.get(HIT_POINTS)));
        character.setLevel(Integer.parseInt(characterDetails.get(LEVEL)));
        character.setXp(Integer.parseInt(characterDetails.get(XP)));
        character.setCharacterName(characterDetails.get(CHARACTER_NAME));
        character.setPlayerName(characterDetails.get(PLAYER_NAME));
        character.setDnDClass(characterDetails.get(DND_CLASS));
        character.setBackground(characterDetails.get(BACKGROUND));
        character.setRace(characterDetails.get(RACE));
        character.setAlignment(characterDetails.get(ALIGNMENT));
        character.setStrength(Integer.parseInt(characterDetails.get(STRENGTH)));
        character.setDexterity(Integer.parseInt(characterDetails.get(DEXTERITY)));
        character.setConstitution(Integer.parseInt(characterDetails.get(CONSTITUTION)));
        character.setIntelligence(Integer.parseInt(characterDetails.get(INTELLIGENCE)));
        character.setWisdom(Integer.parseInt(characterDetails.get(WISDOM)));
        character.setCharisma(Integer.parseInt(characterDetails.get(CHARISMA)));

        return character;
    }

    private Map<String, String> CharacterToMap(Character character) {

        Map<String, String> characterDetails = new HashMap<>();
        characterDetails.put(PROFICIENCY_BONUS, String.valueOf(character.getProficiencyBonus()));
        characterDetails.put(ARMOUR_CLASS, String.valueOf(character.getArmourClass()));
        characterDetails.put(SPEED, String.valueOf(character.getSpeed()));
        characterDetails.put(HIT_POINTS, String.valueOf(character.getHitPoints()));
        characterDetails.put(LEVEL, String.valueOf(character.getLevel()));
        characterDetails.put(XP, String.valueOf(character.getXp()));
        characterDetails.put(CHARACTER_NAME, character.getCharacterName());
        characterDetails.put(PLAYER_NAME, character.getPlayerName());
        characterDetails.put(DND_CLASS, character.getDnDClass());
        characterDetails.put(BACKGROUND, character.getBackground());
        characterDetails.put(RACE, character.getRace());
        characterDetails.put(ALIGNMENT, character.getAlignment());
        characterDetails.put(STRENGTH, String.valueOf(character.getStrength()));
        characterDetails.put(DEXTERITY, String.valueOf(character.getDexterity()));
        characterDetails.put(CONSTITUTION, String.valueOf(character.getConstitution()));
        characterDetails.put(INTELLIGENCE, String.valueOf(character.getIntelligence()));
        characterDetails.put(WISDOM, String.valueOf(character.getWisdom()));
        characterDetails.put(CHARISMA, String.valueOf(character.getCharisma()));

        return characterDetails;
    }

}
