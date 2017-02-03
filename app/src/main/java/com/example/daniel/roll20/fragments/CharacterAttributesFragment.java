package com.example.daniel.roll20.fragments;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.activities.CharacterDisplayActivity;
import com.example.daniel.roll20.database.CharacterDAO;
import com.example.daniel.roll20.dndCharacter.Character;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CharacterAttributesFragment extends Fragment implements View.OnClickListener {

    private CharacterDAO characterDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_attributes, container, false);
        characterDAO = new CharacterDAO(getActivity());
        loadCharacterFromDB(fragmentView);
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
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseDialog(attributeName);
    }

    private void loadCharacterFromDB(View view) {
        Character character = characterDAO.getCharacter().get(0);
        displayCharacterAttributes(character, view);
    }

    private void displayCharacterAttributes(Character character, View view) {
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

    public void reloadCharacterAttributes(View view) {
        characterDAO = new CharacterDAO(getActivity());
        Character character = characterDAO.getCharacter().get(0);
        displayCharacterAttributes(character, view);
    }

}
