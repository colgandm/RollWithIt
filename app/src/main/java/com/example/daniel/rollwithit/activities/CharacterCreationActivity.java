package com.example.daniel.rollwithit.activities;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dndCharacter.Abilities;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.dndCharacter.classes.Class.ClassType;
import com.example.daniel.rollwithit.dndCharacter.races.Race.RaceType;
import com.example.daniel.rollwithit.utils.DiceRoller;
import com.example.daniel.rollwithit.utils.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CharacterCreationActivity extends AppCompatActivity {

    private static final String ERROR = "ERROR";
    private static final String BLANK = "";
    private static final int ZERO = 0;
    private static final String CHARACTER_CREATION_ERROR = "Error saving character during character creation.";

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private final DiceRoller diceRoller = new DiceRoller();
    private Character character;
    private CharacterDAO characterDAO;

    private EditText characterName;
    private EditText playerName;
    private EditText strength;
    private EditText dexterity;
    private EditText constitution;
    private EditText intelligence;
    private EditText wisdom;
    private EditText charisma;

    private Spinner dndClass;
    private Spinner background;
    private Spinner race;
    private Spinner alignment;

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
        setContentView(R.layout.activity_create_character);
        verifyStoragePermissions(this);
        initialiseViews();
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
        RaceType raceType = Utils.determineRace(race.getSelectedItem().toString());
        ClassType classType = Utils.determineClass(dndClass.getSelectedItem().toString());
        String name = characterName.getText().toString();
        character = new Character(name, classType, raceType);

        character.setPlayerName(playerName.getText().toString());
        character.setBackground(background.getSelectedItem().toString());
        character.setAlignment(alignment.getSelectedItem().toString());
        character.setLevel(ZERO);
        character.setInspiration(ZERO);

        Abilities abilities = new Abilities(10);
        abilities.setStrength(getNullSafeValue(strength.getText()));
        abilities.setDexterity(getNullSafeValue(dexterity.getText()));
        abilities.setConstitution(getNullSafeValue(constitution.getText()));
        abilities.setIntelligence(getNullSafeValue(intelligence.getText()));
        abilities.setWisdom(getNullSafeValue(wisdom.getText()));
        abilities.setCharisma(getNullSafeValue(charisma.getText()));
        character.setAbilities(abilities);

    }

    private int getNullSafeValue(Editable value) {
        return value.toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(value.toString());
    }

    private void initialiseViews() {
        characterName = ((EditText)findViewById(R.id.character_name_value));
        playerName = ((EditText)findViewById(R.id.player_name_value));
        strength = ((EditText)findViewById(R.id.strength_value));
        dexterity = ((EditText)findViewById(R.id.dexterity_value));
        constitution = ((EditText)findViewById(R.id.constitution_value));
        intelligence = ((EditText)findViewById(R.id.intelligence_value));
        wisdom = ((EditText)findViewById(R.id.wisdom_value));
        charisma = ((EditText)findViewById(R.id.charisma_value));
        dndClass = ((Spinner)findViewById(R.id.dnd_class_value));
        race = ((Spinner)findViewById(R.id.race_value));
        background = ((Spinner)findViewById(R.id.background_value));
        alignment = ((Spinner)findViewById(R.id.alignment_value));
        initializeSpinners();
    }

    private void initializeSpinners() {
        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this, R.array.class_array,
            android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(this, R.array.race_array,
            android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> alignmentAdapter = ArrayAdapter.createFromResource(this, R.array.alignment_array,
            android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> backgroundAdapter = ArrayAdapter.createFromResource(this, R.array.background_array,
            android.R.layout.simple_spinner_item);

        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alignmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        backgroundAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dndClass.setAdapter(classAdapter);
        race.setAdapter(raceAdapter);
        background.setAdapter(backgroundAdapter);
        alignment.setAdapter(alignmentAdapter);
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
