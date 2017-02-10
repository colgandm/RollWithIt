package com.example.daniel.rollwithit.activities;

import java.util.ArrayList;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dialogs.CharacterSelectionDialogFragment;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.interfaces.SelectionDialogListener;
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

    public void raiseCharacterSelectionDialog(View view) {
        CharacterDAO characterDAO = new CharacterDAO(getApplicationContext());
        ArrayList<Character> characterArrayList = characterDAO.getCharacter();
        CharacterSelectionDialogFragment cSDF = new CharacterSelectionDialogFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("characters", characterArrayList);
        cSDF.setArguments(args);
        cSDF.show(getFragmentManager(), "selectionDialog");
    }

    private void loadCharacter(String characterName) {
        Intent characterDisplayIntent = new Intent(this, CharacterDisplayActivity.class);
        characterDisplayIntent.putExtra("characterName", characterName);
        startActivity(characterDisplayIntent);
    }

    @Override
    public void onCharacterSelected(String characterName) {
        loadCharacter(characterName);
    }
}
