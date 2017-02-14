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

public class CharacterAttributesFragment extends Fragment implements View.OnClickListener {

    private static final String STRENGTH = "Strength";
    private static final String DEXTERITY = "Dexterity";
    private static final String CONSTITUTION = "Constitution";
    private static final String INTELLIGENCE = "Intelligence";
    private static final String WISDOM = "Wisdom";
    private static final String CHARISMA = "Charisma";

    private static final String CHAR_CREATION_TOAST = "Please Create a Character";

    private CharacterDAO characterDAO;
    private String characterName;

    private TextView strength;
    private TextView dexterity;
    private TextView constitution;
    private TextView intelligence;
    private TextView wisdom;
    private TextView charisma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_attributes, container, false);
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        characterDAO = new CharacterDAO(activity);
        characterName = activity.getCharacterName();
        Character character = loadCharacterFromDB(characterName);
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
        case R.id.strengthShield:
            attributeName = STRENGTH;
            break;
        case R.id.dexterityShield:
            attributeName = DEXTERITY;
            break;
        case R.id.constitutionShield:
            attributeName = CONSTITUTION;
            break;
        case R.id.intelligenceShield:
            attributeName = INTELLIGENCE;
            break;
        case R.id.wisdomShield:
            attributeName = WISDOM;
            break;
        case R.id.charismaShield:
            attributeName = CHARISMA;
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseEditAttributeDialog(attributeName);
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

    public void initialiseViews(View view) {
        strength = (TextView)view.findViewById(R.id.strengthShield);
        dexterity = (TextView)view.findViewById(R.id.dexterityShield);
        constitution = (TextView)view.findViewById(R.id.constitutionShield);
        intelligence = (TextView)view.findViewById(R.id.intelligenceShield);
        wisdom = (TextView)view.findViewById(R.id.wisdomShield);
        charisma = (TextView)view.findViewById(R.id.charismaShield);
    }

    private void displayCharacterAttributes(Character character, View view) {
        assert character != null;
        strength.setText(valueOf(character.getStrength()));
        dexterity.setText(valueOf(character.getDexterity()));
        constitution.setText(valueOf(character.getConstitution()));
        intelligence.setText(valueOf(character.getIntelligence()));
        wisdom.setText(valueOf(character.getWisdom()));
        charisma.setText(valueOf(character.getCharisma()));
        characterDAO.update(character);
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
        Character reloadedCharacter = loadCharacterFromDB(characterName);
        assert reloadedCharacter != null;
        switch (attribute) {
        case STRENGTH:
            reloadedCharacter.setStrength(value);
            break;
        case DEXTERITY:
            reloadedCharacter.setDexterity(value);
            break;
        case CONSTITUTION:
            reloadedCharacter.setConstitution(value);
            break;
        case INTELLIGENCE:
            reloadedCharacter.setIntelligence(value);
            break;
        case WISDOM:
            reloadedCharacter.setWisdom(value);
            break;
        case CHARISMA:
            reloadedCharacter.setCharisma(value);
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        displayCharacterAttributes(reloadedCharacter, view);
    }

}
