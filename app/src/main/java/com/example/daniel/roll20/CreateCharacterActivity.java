package com.example.daniel.roll20;

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

import java.io.IOException;

import com.example.daniel.roll20.dndCharacter.Character;
import com.example.daniel.roll20.utils.CharacterMapper;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class CreateCharacterActivity extends AppCompatActivity {

    private CharacterMapper characterMapper = new CharacterMapper();
    protected Character character = new Character();

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        verifyStoragePermissions(this);
    }

    public void createAndSaveCharacter(View view) throws IOException {
        createCharacter();
        characterMapper.writeCharacterToFile(character);
    }

    protected void createCharacter() {
        character.setCharacterName(retrieveStringCharacterAttributes(CHARACTER_NAME));
        character.setPlayerName(retrieveStringCharacterAttributes(PLAYER_NAME));
        character.setBackground(retrieveStringCharacterAttributes(BACKGROUND));
        character.setAlignment(retrieveStringCharacterAttributes(ALIGNMENT));
        character.setRace(retrieveStringCharacterAttributes(RACE));
        character.setDnDClass(retrieveStringCharacterAttributes(DND_CLASS));
        character.setProficiencyBonus(retrieveCharacterAttributes(PROFICIENCY_BONUS));
        character.setArmourClass(retrieveCharacterAttributes(ARMOUR_CLASS));
        character.setSpeed(retrieveCharacterAttributes(SPEED));
        character.setSpeed(retrieveCharacterAttributes(HIT_POINTS));
        character.setLevel(retrieveCharacterAttributes(LEVEL));
        character.setXp(retrieveCharacterAttributes(XP));
        character.setStrength(retrieveCharacterAttributes(STRENGTH));
        character.setDexterity(retrieveCharacterAttributes(DEXTERITY));
        character.setConstitution(retrieveCharacterAttributes(CONSTITUTION));
        character.setIntelligence(retrieveCharacterAttributes(INTELLIGENCE));
        character.setWisdom(retrieveCharacterAttributes(WISDOM));
        character.setCharisma(retrieveCharacterAttributes(CHARISMA));
        // For Debug, look into using logs
        character.printCharacterSheet();
    }

    private String retrieveStringCharacterAttributes(String attribute) {
        switch (attribute) {
        case CHARACTER_NAME:
            return ((EditText)findViewById(R.id.characterName)).getText().toString();
        case DND_CLASS:
            return ((EditText)findViewById(R.id.dnDClass)).getText().toString();
        case BACKGROUND:
            return ((EditText)findViewById(R.id.background)).getText().toString();
        case RACE:
            return ((EditText)findViewById(R.id.race)).getText().toString();
        case ALIGNMENT:
            return ((EditText)findViewById(R.id.alignment)).getText().toString();
        case PLAYER_NAME:
            return ((EditText)findViewById(R.id.playerName)).getText().toString();
        default:
            return "default";
        }
    }

    private Integer retrieveCharacterAttributes(String attribute) {
        switch (attribute) {
        case STRENGTH:
            return Integer.valueOf(((EditText)findViewById(R.id.strength)).getText().toString());
        case DEXTERITY:
            return Integer.valueOf(((EditText)findViewById(R.id.dexterity)).getText().toString());
        case CONSTITUTION:
            return Integer.valueOf(((EditText)findViewById(R.id.constitution)).getText().toString());
        case INTELLIGENCE:
            return Integer.valueOf(((EditText)findViewById(R.id.intelligence)).getText().toString());
        case WISDOM:
            return Integer.valueOf(((EditText)findViewById(R.id.wisdom)).getText().toString());
        case CHARISMA:
            return Integer.valueOf(((EditText)findViewById(R.id.charisma)).getText().toString());
        case PROFICIENCY_BONUS:
            return Integer.valueOf(((EditText)findViewById(R.id.proficiencyBonus)).getText().toString());
        case ARMOUR_CLASS:
            return Integer.valueOf(((EditText)findViewById(R.id.armourClass)).getText().toString());
        case SPEED:
            return Integer.valueOf(((EditText)findViewById(R.id.speed)).getText().toString());
        case HIT_POINTS:
            return Integer.valueOf(((EditText)findViewById(R.id.hitPoints)).getText().toString());
        case LEVEL:
            return Integer.valueOf(((EditText)findViewById(R.id.level)).getText().toString());
        case XP:
            return Integer.valueOf(((EditText)findViewById(R.id.xp)).getText().toString());
        default:
            return Integer.valueOf(0);
        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

}
