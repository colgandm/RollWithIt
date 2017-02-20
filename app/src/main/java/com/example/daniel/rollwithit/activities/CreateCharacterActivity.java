package com.example.daniel.rollwithit.activities;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.utils.CharacterUtils;
import com.example.daniel.rollwithit.utils.DiceRoller;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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
    private EditText initiative;

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
        character = new Character();
        setContentView(R.layout.activity_create_character);
        verifyStoragePermissions(this);
        initialiseViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.character_creation_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.auto_fill) {
            // startActivity(new Intent(this, DiceRollerActivity.class));
            Log.i("INFO", "Auto fill Character");
            autoFillCharacter(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        character.setDndClass(dndClass.getSelectedItem().toString());
        character.setRace(race.getSelectedItem().toString());
        character.setBackground(background.getSelectedItem().toString());
        character.setAlignment(alignment.getSelectedItem().toString());
        character.setLevel(getNullSafeValue(level.getText()));
        character.setXp(getNullSafeValue(xp.getText()));
        character.setHitPoints(getNullSafeValue(hitPoints.getText()));
        character.setArmourClass(getNullSafeValue(armourClass.getText()));
        character.setSpeed(getNullSafeValue(speed.getText()));
        character.setProficiencyBonus(getNullSafeValue(proficiencyBonus.getText()));
        character.setStrength(getNullSafeValue(strength.getText()));
        character.setDexterity(getNullSafeValue(dexterity.getText()));
        character.setConstitution(getNullSafeValue(constitution.getText()));
        character.setIntelligence(getNullSafeValue(intelligence.getText()));
        character.setWisdom(getNullSafeValue(wisdom.getText()));
        character.setCharisma(getNullSafeValue(charisma.getText()));
        character.setInitiative(getNullSafeValue(initiative.getText()));
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
        armourClass = ((EditText)findViewById(R.id.armour_class_value));
        speed = ((EditText)findViewById(R.id.speed_value));
        hitPoints = ((EditText)findViewById(R.id.hit_points_value));
        level = ((EditText)findViewById(R.id.level_value));
        xp = ((EditText)findViewById(R.id.xp_value));
        proficiencyBonus = ((EditText)findViewById(R.id.proficiency_bonus_value));
        initiative = ((EditText)findViewById(R.id.initiative_value));

        dndClass = ((Spinner)findViewById(R.id.dnd_class_value));
        race = ((Spinner)findViewById(R.id.race_value));
        background = ((Spinner)findViewById(R.id.background_value));
        alignment = ((Spinner)findViewById(R.id.alignment_value));
    }

    public void rollCharacterAttributes(@SuppressWarnings("UnusedParameters") View view) {
        strength.setText(valueOf(diceRoller.roll4d6DropLowest()));
        dexterity.setText(valueOf(diceRoller.roll4d6DropLowest()));
        constitution.setText(valueOf(diceRoller.roll4d6DropLowest()));
        intelligence.setText(valueOf(diceRoller.roll4d6DropLowest()));
        wisdom.setText(valueOf(diceRoller.roll4d6DropLowest()));
        charisma.setText(valueOf(diceRoller.roll4d6DropLowest()));
    }

    private void autoFillCharacter(Activity activity) {
        CharacterUtils characterUtils = new CharacterUtils();
        characterUtils.createNewCharacter(activity);
    }
}
