package com.example.daniel.rollwithit.activities;

import java.util.ArrayList;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dialogs.CharacterSelectionDialogFragment;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.interfaces.SelectionDialogListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SelectionDialogListener {

    private static final String CHARACTER_NAME = "characterName";
    private static final String CHARACTERS = "characters";
    private static final String SELECTION_DIALOG = "selectionDialog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.create_random_character) {
            // startActivity(new Intent(this, DiceRollerActivity.class));
            Log.i("INFO", "Create Random Character");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCharacterSelected(String characterName) {
        startCharacterDisplayActivity(characterName);
    }

    public void startDiceRollerActivity(View view) {
        startActivity(new Intent(this, RollerActivity.class));
    }

    public void startCharacterCreationActivity(View view) {
        startActivity(new Intent(this, CreateCharacterActivity.class));
    }

    private void startCharacterDisplayActivity(String characterName) {
        startActivity(new Intent(this, CharacterDisplayActivity.class).putExtra(CHARACTER_NAME, characterName));
    }

    public void raiseCharacterSelectionDialog(View view) {
        CharacterDAO characterDAO = new CharacterDAO(getApplicationContext());
        ArrayList<Character> characterArrayList = characterDAO.getCharacter();
        CharacterSelectionDialogFragment characterSelectionDialogFragment = new CharacterSelectionDialogFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(CHARACTERS, characterArrayList);
        characterSelectionDialogFragment.setArguments(args);
        characterSelectionDialogFragment.show(getFragmentManager(), SELECTION_DIALOG);
    }

}
