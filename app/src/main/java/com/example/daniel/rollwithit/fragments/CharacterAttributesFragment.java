package com.example.daniel.rollwithit.fragments;

import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARISMA;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DEXTERITY;
import static com.example.daniel.rollwithit.utils.ConstAttributes.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.STRENGTH;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WISDOM;

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
public class CharacterAttributesFragment extends Fragment implements View.OnClickListener {

    private CharacterDAO characterDAO;
    private String characterName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_attributes, container, false);
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        characterDAO = new CharacterDAO(activity);
        characterName = activity.getCharacterName();
        Character character = loadCharacterFromDB(characterName);
        displayCharacterAttributes(character, fragmentView);
        createButtonOnListeners(fragmentView);
        return fragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        String attributeName;
        switch (v.getId()) {
        case R.id.strengthShield:
            attributeName = "Strength";
            break;
        case R.id.dexterityShield:
            attributeName = "Dexterity";
            break;
        case R.id.constitutionShield:
            attributeName = "Constitution";
            break;
        case R.id.intelligenceShield:
            attributeName = "Intelligence";
            break;
        case R.id.wisdomShield:
            attributeName = "Wisdom";
            break;
        case R.id.charismaShield:
            attributeName = "Charisma";
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseAttributeDialog(attributeName);
    }

    private Character loadCharacterFromDB(String characterName) {
        ArrayList<Character> characters = characterDAO.getCharacter();
        if (characters.size() == 0) {
            Toast.makeText(getActivity(), "Please Create a Character", Toast.LENGTH_SHORT).show();
        } else {
            for (Character character : characters) {
                if (characterName.equals(character.getCharacterName())) {
                    return character;
                }
            }
        }
        return null;
    }

    private void displayCharacterAttributes(Character character, View view) {
        assert character != null;
        TextView strength = (TextView)view.findViewById(R.id.strengthShield);
        strength.setText(String.valueOf(character.getStrength()));

        TextView dexterity = (TextView)view.findViewById(R.id.dexterityShield);
        dexterity.setText(String.valueOf(character.getDexterity()));

        TextView constitution = (TextView)view.findViewById(R.id.constitutionShield);
        constitution.setText(String.valueOf(character.getConstitution()));

        TextView intelligence = (TextView)view.findViewById(R.id.intelligenceShield);
        intelligence.setText(String.valueOf(character.getIntelligence()));

        TextView wisdom = (TextView)view.findViewById(R.id.wisdomShield);
        wisdom.setText(String.valueOf(character.getWisdom()));

        TextView charisma = (TextView)view.findViewById(R.id.charismaShield);
        charisma.setText(String.valueOf(character.getCharisma()));

        characterDAO.update(character);
    }

    private void createButtonOnListeners(View view) {
        TextView strengthAtt = (TextView)view.findViewById(R.id.strengthShield);
        strengthAtt.setOnClickListener(this);

        TextView dexterityAtt = (TextView)view.findViewById(R.id.dexterityShield);
        dexterityAtt.setOnClickListener(this);

        TextView constitutionAtt = (TextView)view.findViewById(R.id.constitutionShield);
        constitutionAtt.setOnClickListener(this);

        TextView intelligenceAtt = (TextView)view.findViewById(R.id.intelligenceShield);
        intelligenceAtt.setOnClickListener(this);

        TextView wisdomAtt = (TextView)view.findViewById(R.id.wisdomShield);
        wisdomAtt.setOnClickListener(this);

        TextView charismaAtt = (TextView)view.findViewById(R.id.charismaShield);
        charismaAtt.setOnClickListener(this);
    }

    public void reloadCharacterAttributes(View view, int value, String attribute) {
        Character reloadedCharacter = loadCharacterFromDB(characterName);
        assert reloadedCharacter != null;
        switch (attribute.toLowerCase()) {
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