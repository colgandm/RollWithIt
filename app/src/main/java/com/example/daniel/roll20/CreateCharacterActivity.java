package com.example.daniel.roll20;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.daniel.roll20.dndCharacter.CharAttributes;
import com.example.daniel.roll20.dndCharacter.Character;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateCharacterActivity extends AppCompatActivity {

    protected Character character = new Character("Toby");
    protected CharAttributes charAttributes = new CharAttributes();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaTutorial/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createAndSaveCharacter(View view) {
        createCharacter();
        saveCharacterToXml();
    }

    protected void createCharacter() {
        charAttributes.setStrength(retrieveCharacterAttributes("strength"));
        charAttributes.setDexterity(retrieveCharacterAttributes("dexterity"));
        charAttributes.setConstitution(retrieveCharacterAttributes("constitution"));
        charAttributes.setIntelligence(retrieveCharacterAttributes("intelligence"));
        charAttributes.setWisdom(retrieveCharacterAttributes("wisdom"));
        charAttributes.setCharisma(retrieveCharacterAttributes("charisma"));

        character.setCharacterName(retrieveStringCharacterAttributes("characterName"));
        character.setProficienyBonus(retrieveCharacterAttributes("proficiencyBonus"));
        character.setAroumrClass(retrieveCharacterAttributes("armourClass"));
        character.setSpeed(retrieveCharacterAttributes("speed"));
        character.setSpeed(retrieveCharacterAttributes("hitPoints"));
        character.setLevel(retrieveCharacterAttributes("level"));
        character.setXp(retrieveCharacterAttributes("xp"));
        character.setCharAttributes(charAttributes);

        character.printCharacterSheet();
    }

    private void saveCharacterToXml() {
        writeToFile("Yo Todd");
    }

    private String retrieveStringCharacterAttributes(String attribute) {
        switch (attribute) {
            case "characterName":
                return ((EditText) findViewById(R.id.characterName)).getText().toString();
            default:
                return "default";
        }
    }

    private Integer retrieveCharacterAttributes(String attribute) {
        switch (attribute) {
            case "strength":
                return Integer.valueOf(((EditText) findViewById(R.id.strength)).getText().toString());
            case "dexterity":
                return Integer.valueOf(((EditText) findViewById(R.id.dexterity)).getText().toString());
            case "constitution":
                return Integer.valueOf(((EditText) findViewById(R.id.constitution)).getText().toString());
            case "intelligence":
                return Integer.valueOf(((EditText) findViewById(R.id.intelligence)).getText().toString());
            case "wisdom":
                return Integer.valueOf(((EditText) findViewById(R.id.wisdom)).getText().toString());
            case "charisma":
                return Integer.valueOf(((EditText) findViewById(R.id.charisma)).getText().toString());
            case "proficiencyBonus":
                return Integer.valueOf(((EditText) findViewById(R.id.proficiencyBonus)).getText().toString());
            case "armourClass":
                return Integer.valueOf(((EditText) findViewById(R.id.armourClass)).getText().toString());
            case "speed":
                return Integer.valueOf(((EditText) findViewById(R.id.speed)).getText().toString());
            case "hitPoints":
                return Integer.valueOf(((EditText) findViewById(R.id.hitPoints)).getText().toString());
            case "level":
                return Integer.valueOf(((EditText) findViewById(R.id.level)).getText().toString());
            case "xp":
                return Integer.valueOf(((EditText) findViewById(R.id.xp)).getText().toString());
            default:
                return Integer.valueOf(0);
        }
    }

    public void writeToFile(String data) {
        verifyStoragePermissions(this);

        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/download");
        dir.mkdirs();
        File file = new File(dir, "myData.txt");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(data);
            pw.flush();
            pw.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

}
