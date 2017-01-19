package com.example.daniel.roll20;

import java.io.IOException;

import com.example.daniel.roll20.dndCharacter.Character;
import com.example.daniel.roll20.utils.CharacterMapper;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class CharacterDisplayActivity extends AppCompatActivity {

    protected Character character = new Character("Toby");
    private CharacterMapper characterMapper = new CharacterMapper();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_display);
        verifyStoragePermissions(this);
        try {
            loadCharacterFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void loadCharacterFromFile() throws IOException {
        character = characterMapper.ReadCharacterToFile();
        character.printCharacterSheet();
    }

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }
}
