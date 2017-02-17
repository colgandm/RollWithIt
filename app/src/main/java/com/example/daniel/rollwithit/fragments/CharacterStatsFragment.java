package com.example.daniel.rollwithit.fragments;

import static java.lang.String.valueOf;

import java.util.ArrayList;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.activities.CharacterDisplayActivity;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dndCharacter.Character;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterStatsFragment extends Fragment implements View.OnClickListener {

    private static final String INITIATIVE = "Initiative";
    private static final String ARMOUR_CLASS = "Armour Class";
    private static final String LEVEL = "Level";
    private static final String CHAR_CREATION_TOAST = "Please Create a Character";

    private CharacterDAO characterDAO;
    private String charactersName;

    private TextView initiative;
    private TextView armourClass;
    private TextView level;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_stats, container, false);
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        characterDAO = new CharacterDAO(activity);
        charactersName = activity.getCharacterName();
        Character character = loadCharacterFromDB(charactersName);
        initialiseViews(fragmentView);
        displayCharacterDetails(character, fragmentView);
        createButtonOnListeners();
        return fragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        String attributeName;
        switch (v.getId()) {
        case R.id.initiative_value:
            attributeName = INITIATIVE;
            break;
        case R.id.armour_class_value:
            attributeName = ARMOUR_CLASS;
            break;
        case R.id.level_value:
            attributeName = LEVEL;
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseEditStatsDialog(attributeName);
    }

    private Character loadCharacterFromDB(String characterName) {
        ArrayList<Character> characters = characterDAO.getCharacter();
        if (characters.size() == 0) {
            Toast.makeText(getActivity(), CHAR_CREATION_TOAST, Toast.LENGTH_SHORT).show();
        } else {
            for (Character character : characters) {
                if (characterName.equals(character.getCharacterName())) {
                    return character;
                }
            }
        }
        return null;
    }

    private void initialiseViews(View view) {
        initiative = (TextView)view.findViewById(R.id.initiative_value);
        armourClass = (TextView)view.findViewById(R.id.armour_class_value);
        level = (TextView)view.findViewById(R.id.level_value);

    }

    private void displayCharacterDetails(Character character, View view) {
        assert character != null;
        initiative.setText(valueOf(character.getInitiative()));
        armourClass.setText(valueOf(character.getArmourClass()));
        level.setText(valueOf(character.getLevel()));
        characterDAO.update(character);
    }

    private void createButtonOnListeners() {
        initiative.setOnClickListener(this);
        armourClass.setOnClickListener(this);
        level.setOnClickListener(this);

    }

    public void reloadCharacterStats(View view, int value, String attribute) {
        Character reloadedCharacter = loadCharacterFromDB(charactersName);
        assert reloadedCharacter != null;
        switch (attribute) {
        case INITIATIVE:
            reloadedCharacter.setInitiative(value);
            break;
        case ARMOUR_CLASS:
            reloadedCharacter.setArmourClass(value);
            break;
        case LEVEL:
            reloadedCharacter.setLevel(value);
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        displayCharacterDetails(reloadedCharacter, view);
    }

}
