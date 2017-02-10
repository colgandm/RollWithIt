package com.example.daniel.rollwithit.activities;

import static com.example.daniel.rollwithit.utils.ConstAttributes.ALIGNMENT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ARMOUR_CLASS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.BACKGROUND;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARACTER_NAME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARISMA;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DEXTERITY;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DND_CLASS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HIT_POINTS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.LEVEL;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PLAYER_NAME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PROFICIENCY_BONUS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.RACE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.SPEED;
import static com.example.daniel.rollwithit.utils.ConstAttributes.STRENGTH;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WISDOM;
import static com.example.daniel.rollwithit.utils.ConstAttributes.XP;

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

    private final DiceRoller diceRoller = new DiceRoller();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private Character character;
    private CharacterDAO characterDAO;

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
    }

    public void createAndSaveCharacter(View view) {
        createCharacter();
        if (characterDAO.save(character) < 0) {
            Log.i("Error", "Error saving character during character creation.");
        }
        characterDAO.close();
        finish();
    }

    public void rollCharacterAttributes(View view) {

        EditText strength = (EditText)findViewById(R.id.strength);
        strength.setText(String.valueOf(diceRoller.roll4d6DropLowest()));

        EditText dexterity = (EditText)findViewById(R.id.dexterity);
        dexterity.setText(String.valueOf(diceRoller.roll4d6DropLowest()));

        EditText constitution = (EditText)findViewById(R.id.constitution);
        constitution.setText(String.valueOf(diceRoller.roll4d6DropLowest()));

        EditText intelligence = (EditText)findViewById(R.id.intelligence);
        intelligence.setText(String.valueOf(diceRoller.roll4d6DropLowest()));

        EditText wisdom = (EditText)findViewById(R.id.wisdom);
        wisdom.setText(String.valueOf(diceRoller.roll4d6DropLowest()));

        EditText charisma = (EditText)findViewById(R.id.charisma);
        charisma.setText(String.valueOf(diceRoller.roll4d6DropLowest()));
    }

    private void createCharacter() {
        character.setPlayerName(retrieveStringCharacterAttributes(PLAYER_NAME));
        character.setCharacterName(retrieveStringCharacterAttributes(CHARACTER_NAME));
        character.setDndClass(retrieveStringCharacterAttributes(DND_CLASS));
        character.setLevel(retrieveCharacterAttributes(LEVEL));
        character.setXp(retrieveCharacterAttributes(XP));
        character.setRace(retrieveStringCharacterAttributes(RACE));
        character.setBackground(retrieveStringCharacterAttributes(BACKGROUND));
        character.setAlignment(retrieveStringCharacterAttributes(ALIGNMENT));
        character.setHitPoints(retrieveCharacterAttributes(HIT_POINTS));
        character.setArmourClass(retrieveCharacterAttributes(ARMOUR_CLASS));
        character.setSpeed(retrieveCharacterAttributes(SPEED));
        character.setProficiencyBonus(retrieveCharacterAttributes(PROFICIENCY_BONUS));
        character.setStrength(retrieveCharacterAttributes(STRENGTH));
        character.setDexterity(retrieveCharacterAttributes(DEXTERITY));
        character.setConstitution(retrieveCharacterAttributes(CONSTITUTION));
        character.setIntelligence(retrieveCharacterAttributes(INTELLIGENCE));
        character.setWisdom(retrieveCharacterAttributes(WISDOM));
        character.setCharisma(retrieveCharacterAttributes(CHARISMA));
    }

    private String retrieveStringCharacterAttributes(String attribute) {
        switch (attribute) {
        case PLAYER_NAME:
            return ((EditText)findViewById(R.id.playerName)).getText().toString();
        case CHARACTER_NAME:
            return ((EditText)findViewById(R.id.characterName)).getText().toString();
        case DND_CLASS:
            return ((EditText)findViewById(R.id.dndClass)).getText().toString();
        case RACE:
            return ((EditText)findViewById(R.id.race)).getText().toString();
        case BACKGROUND:
            return ((EditText)findViewById(R.id.background)).getText().toString();
        case ALIGNMENT:
            return ((EditText)findViewById(R.id.alignment)).getText().toString();
        default:
            return "default";
        }
    }

    private Integer retrieveCharacterAttributes(String attribute) {
        switch (attribute) {
        case LEVEL:
            return (((EditText)findViewById(R.id.level)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.level)).getText().toString());
        case XP:
            return (((EditText)findViewById(R.id.xp)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.xp)).getText().toString());
        case HIT_POINTS:
            return (((EditText)findViewById(R.id.hitPoints)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.hitPoints)).getText().toString());
        case ARMOUR_CLASS:
            return (((EditText)findViewById(R.id.armourClass)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.armourClass)).getText().toString());
        case SPEED:
            return (((EditText)findViewById(R.id.speed)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.speed)).getText().toString());
        case PROFICIENCY_BONUS:
            return (((EditText)findViewById(R.id.proficiencyBonus)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.proficiencyBonus)).getText().toString());
        case STRENGTH:
            return (((EditText)findViewById(R.id.strength)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.strength)).getText().toString());
        case DEXTERITY:
            return (((EditText)findViewById(R.id.dexterity)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.dexterity)).getText().toString());
        case CONSTITUTION:
            return (((EditText)findViewById(R.id.constitution)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.constitution)).getText().toString());
        case INTELLIGENCE:
            return (((EditText)findViewById(R.id.intelligence)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.intelligence)).getText().toString());
        case WISDOM:
            return (((EditText)findViewById(R.id.wisdom)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.wisdom)).getText().toString());
        case CHARISMA:
            return (((EditText)findViewById(R.id.charisma)).getText().toString().equalsIgnoreCase("")) ? 0
                : Integer.valueOf(((EditText)findViewById(R.id.charisma)).getText().toString());
        default:
            return 0;
        }
    }
}
