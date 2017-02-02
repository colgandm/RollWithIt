package com.example.daniel.roll20.activities;

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

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.database.CharacterDAO;
import com.example.daniel.roll20.dndCharacter.Character;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CreateCharacterActivity extends AppCompatActivity {

    private Character character;
    private CharacterDAO characterDAO;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };

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
        characterDAO.save(character);
        finish();
    }

    private void createCharacter() {
        character.setPlayerName(retrieveStringCharacterAttributes(PLAYER_NAME));
        character.setCharacterName(retrieveStringCharacterAttributes(CHARACTER_NAME));
        character.setDnDClass(retrieveStringCharacterAttributes(DND_CLASS));
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
            return ((EditText)findViewById(R.id.dnDClass)).getText().toString();
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
            return Integer.valueOf(((EditText)findViewById(R.id.level)).getText().toString());
        case XP:
            return Integer.valueOf(((EditText)findViewById(R.id.xp)).getText().toString());
        case HIT_POINTS:
            return Integer.valueOf(((EditText)findViewById(R.id.hitPoints)).getText().toString());
        case ARMOUR_CLASS:
            return Integer.valueOf(((EditText)findViewById(R.id.armourClass)).getText().toString());
        case SPEED:
            return Integer.valueOf(((EditText)findViewById(R.id.speed)).getText().toString());
        case PROFICIENCY_BONUS:
            return Integer.valueOf(((EditText)findViewById(R.id.proficiencyBonus)).getText().toString());
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
        default:
            return 0;
        }
    }

    private static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }
}
