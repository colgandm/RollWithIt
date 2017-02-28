package com.example.daniel.rollwithit.fragments;

import static java.lang.String.valueOf;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterStatsFragment extends Fragment implements View.OnClickListener {

    private static final String INITIATIVE = "Initiative";
    private static final String ARMOUR_CLASS = "Armour Class";
    private static final String LEVEL = "Level";
    private static final String CHAR_CREATION_TOAST = "Please Create a Character";

    private Character character;
    private CharacterDisplayActivity parentActivity;

    private TextView initiative;
    private TextView armourClass;
    private TextView level;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_stats, container, false);
        parentActivity = (CharacterDisplayActivity)getActivity();
        character = parentActivity.getCharacter();
        initialiseViews(fragmentView);
        displayCharacterDetails();
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
        parentActivity.raiseEditStatsDialog(attributeName);
    }

    private void initialiseViews(View view) {
        initiative = (TextView)view.findViewById(R.id.initiative_value);
        armourClass = (TextView)view.findViewById(R.id.armour_class_value);
        level = (TextView)view.findViewById(R.id.level_value);
    }

    private void displayCharacterDetails() {
        assert character != null;
        initiative.setText(valueOf(character.getInitiative()));
        armourClass.setText(valueOf(character.getArmor()));
        level.setText(valueOf(character.getLevel()));
    }

    private void createButtonOnListeners() {
        initiative.setOnClickListener(this);
        armourClass.setOnClickListener(this);
        level.setOnClickListener(this);
    }

    public void reloadCharacterStats(View view, int value, String attribute) {
        assert character != null;
        switch (attribute) {
        case INITIATIVE:
            character.setInitiative(value);
            break;
        case ARMOUR_CLASS:
            character.setDefense(value);
            break;
        case LEVEL:
            character.setLevel(value);
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        CharacterDAO characterDAO = new CharacterDAO(parentActivity);
        characterDAO.update(character);
        characterDAO.close();
        displayCharacterDetails();
    }
}
