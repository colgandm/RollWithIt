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

public class CharacterAttributesFragment extends Fragment implements View.OnClickListener {

    private static final String STRENGTH = "Strength";
    private static final String DEXTERITY = "Dexterity";
    private static final String CONSTITUTION = "Constitution";
    private static final String INTELLIGENCE = "Intelligence";
    private static final String WISDOM = "Wisdom";
    private static final String CHARISMA = "Charisma";
    private static final String CHAR_CREATION_TOAST = "Please Create a Character";

    private Character character;
    private CharacterDisplayActivity parentActivity;

    private TextView strength;
    private TextView dexterity;
    private TextView constitution;
    private TextView intelligence;
    private TextView wisdom;
    private TextView charisma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_attributes, container, false);
        parentActivity = (CharacterDisplayActivity)getActivity();
        character = parentActivity.getCharacter();
        initialiseViews(fragmentView);
        displayCharacterAttributes(character, fragmentView);
        createButtonOnListeners();
        return fragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        String attributeName;
        switch (v.getId()) {
        case R.id.strength_shield:
            attributeName = STRENGTH;
            break;
        case R.id.dexterity_shield:
            attributeName = DEXTERITY;
            break;
        case R.id.constitution_shield:
            attributeName = CONSTITUTION;
            break;
        case R.id.intelligence_shield:
            attributeName = INTELLIGENCE;
            break;
        case R.id.wisdom_shield:
            attributeName = WISDOM;
            break;
        case R.id.charisma_shield:
            attributeName = CHARISMA;
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        parentActivity.raiseEditAttributeDialog(attributeName);
    }

    private void initialiseViews(View view) {
        strength = (TextView)view.findViewById(R.id.strength_shield);
        dexterity = (TextView)view.findViewById(R.id.dexterity_shield);
        constitution = (TextView)view.findViewById(R.id.constitution_shield);
        intelligence = (TextView)view.findViewById(R.id.intelligence_shield);
        wisdom = (TextView)view.findViewById(R.id.wisdom_shield);
        charisma = (TextView)view.findViewById(R.id.charisma_shield);
    }

    private void displayCharacterAttributes(Character character, View view) {
        assert character != null;
        strength.setText(valueOf(character.getStrength()));
        dexterity.setText(valueOf(character.getDexterity()));
        constitution.setText(valueOf(character.getConstitution()));
        intelligence.setText(valueOf(character.getIntelligence()));
        wisdom.setText(valueOf(character.getWisdom()));
        charisma.setText(valueOf(character.getCharisma()));
    }

    private void createButtonOnListeners() {
        strength.setOnClickListener(this);
        dexterity.setOnClickListener(this);
        constitution.setOnClickListener(this);
        intelligence.setOnClickListener(this);
        wisdom.setOnClickListener(this);
        charisma.setOnClickListener(this);
    }

    public void reloadCharacterAttributes(View view, int value, String attribute) {
        switch (attribute) {
        case STRENGTH:
            character.setStrength(value);
            break;
        case DEXTERITY:
            character.setDexterity(value);
            break;
        case CONSTITUTION:
            character.setConstitution(value);
            break;
        case INTELLIGENCE:
            character.setIntelligence(value);
            break;
        case WISDOM:
            character.setWisdom(value);
            break;
        case CHARISMA:
            character.setCharisma(value);
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        CharacterDAO characterDAO = new CharacterDAO(parentActivity);
        characterDAO.update(character);
        characterDAO.close();
        displayCharacterAttributes(character, view);
    }

}
