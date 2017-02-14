package com.example.daniel.rollwithit.activities;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.utils.DiceRoller;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CreateCharacterActivity extends AppCompatActivity {

    private static final String ERROR = "ERROR";
    private static final String BLANK = "";
    private static final String CHARACTER_CREATION_ERROR = "Error saving character during character creation.";

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private final DiceRoller diceRoller = new DiceRoller();
    private Character character;
    private CharacterDAO characterDAO;

    private EditText characterName;
    private EditText playerName;
    private EditText dndClass;
    private EditText background;
    private EditText race;
    private EditText alignment;
    private EditText strength;
    private EditText dexterity;
    private EditText constitution;
    private EditText intelligence;
    private EditText wisdom;
    private EditText charisma;
    private EditText armourClass;
    private EditText speed;
    private EditText hitPoints;
    private EditText level;
    private EditText xp;
    private EditText proficiencyBonus;

    private static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        characterDAO = new CharacterDAO(getApplicationContext());
        character = new Character();
        initialiseViews();
        setContentView(R.layout.activity_create_character);
        verifyStoragePermissions(this);
    }

    public void saveNewCharacter(@SuppressWarnings("UnusedParameters") View view) {
        createNewCharacter();
        if (characterDAO.save(character) < 0) {
            Log.e(ERROR, CHARACTER_CREATION_ERROR);
        }
        characterDAO.close();
        finish();
    }

    private void createNewCharacter() {
        character.setCharacterName(characterName.getText().toString());
        character.setPlayerName(playerName.getText().toString());
        character.setDndClass(dndClass.getText().toString());
        character.setRace(race.getText().toString());
        character.setBackground(background.getText().toString());
        character.setAlignment(alignment.getText().toString());
        character
            .setLevel(level.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(level.getText().toString()));
        character.setXp(xp.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(xp.getText().toString()));
        character.setHitPoints(
            hitPoints.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(hitPoints.getText().toString()));
        character.setArmourClass(
            armourClass.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(armourClass.getText().toString()));
        character
            .setSpeed(speed.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(speed.getText().toString()));
        character.setProficiencyBonus(proficiencyBonus.getText().toString().equalsIgnoreCase(BLANK) ? 0
            : parseInt(proficiencyBonus.getText().toString()));
        character.setStrength(
            strength.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(strength.getText().toString()));
        character.setDexterity(
            dexterity.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(dexterity.getText().toString()));
        character.setConstitution(constitution.getText().toString().equalsIgnoreCase(BLANK) ? 0
            : parseInt(constitution.getText().toString()));
        character.setIntelligence(intelligence.getText().toString().equalsIgnoreCase(BLANK) ? 0
            : parseInt(intelligence.getText().toString()));
        character
            .setWisdom(wisdom.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(wisdom.getText().toString()));
        character.setCharisma(
            charisma.getText().toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(charisma.getText().toString()));
    }

    private void initialiseViews() {
        characterName = ((EditText)findViewById(R.id.characterName));
        playerName = ((EditText)findViewById(R.id.playerName));
        dndClass = ((EditText)findViewById(R.id.dndClass));
        race = ((EditText)findViewById(R.id.race));
        background = ((EditText)findViewById(R.id.background));
        alignment = ((EditText)findViewById(R.id.alignment));
        strength = ((EditText)findViewById(R.id.strength));
        dexterity = ((EditText)findViewById(R.id.dexterity));
        constitution = ((EditText)findViewById(R.id.constitution));
        intelligence = ((EditText)findViewById(R.id.intelligence));
        wisdom = ((EditText)findViewById(R.id.wisdom));
        charisma = ((EditText)findViewById(R.id.charisma));
        armourClass = ((EditText)findViewById(R.id.armourClass));
        speed = ((EditText)findViewById(R.id.speed));
        hitPoints = ((EditText)findViewById(R.id.hitPoints));
        level = ((EditText)findViewById(R.id.level));
        xp = ((EditText)findViewById(R.id.xp));
        proficiencyBonus = ((EditText)findViewById(R.id.proficiencyBonus));
    }

    public void rollCharacterAttributes(@SuppressWarnings("UnusedParameters") View view) {
        strength.setText(valueOf(diceRoller.roll4d6DropLowest()));
        dexterity.setText(valueOf(diceRoller.roll4d6DropLowest()));
        constitution.setText(valueOf(diceRoller.roll4d6DropLowest()));
        intelligence.setText(valueOf(diceRoller.roll4d6DropLowest()));
        wisdom.setText(valueOf(diceRoller.roll4d6DropLowest()));
        charisma.setText(valueOf(diceRoller.roll4d6DropLowest()));
    }
}
