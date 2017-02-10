package com.example.daniel.roll20.activities;

import java.util.ArrayList;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.database.CharacterDAO;
import com.example.daniel.roll20.dialogs.CharacterSelectionDialogFragment;
import com.example.daniel.roll20.dndCharacter.Character;
import com.example.daniel.roll20.interfaces.SelectionDialogListener;
import com.idescout.sql.SqlScoutServer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SelectionDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SqlScoutServer.create(this, getPackageName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToDiceRoller(View view) {
        Intent diceRollerIntent = new Intent(this, RollerActivity.class);
        startActivity(diceRollerIntent);
    }

    public void createCharacter(View view) {
        Intent characterCreationIntent = new Intent(this, CreateCharacterActivity.class);
        startActivity(characterCreationIntent);
    }

    public void loadCharacter(String characterName) {
        Intent characterDisplayIntent = new Intent(this, CharacterDisplayActivity.class);
        characterDisplayIntent.putExtra("characterName", characterName);
        startActivity(characterDisplayIntent);
    }

    public void raiseCharacterSelectionDialog(View view) {
        CharacterDAO characterDAO = new CharacterDAO(getApplicationContext());
        ArrayList<Character> characterArrayList = characterDAO.getCharacter();
        CharacterSelectionDialogFragment cSDF = new CharacterSelectionDialogFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("characters", characterArrayList);
        cSDF.setArguments(args);
        cSDF.show(getFragmentManager(), "selectionDialog");
    }

    @Override
    public void onCharacterSelected(String characterName) {
        loadCharacter(characterName);
    }
}
