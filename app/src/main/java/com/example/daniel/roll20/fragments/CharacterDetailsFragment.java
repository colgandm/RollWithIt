package com.example.daniel.roll20.fragments;

import static com.example.daniel.roll20.utils.ConstAttributes.ALIGNMENT;
import static com.example.daniel.roll20.utils.ConstAttributes.BACKGROUND;
import static com.example.daniel.roll20.utils.ConstAttributes.CHARACTER_NAME;
import static com.example.daniel.roll20.utils.ConstAttributes.DND_CLASS;
import static com.example.daniel.roll20.utils.ConstAttributes.PLAYER_NAME;
import static com.example.daniel.roll20.utils.ConstAttributes.RACE;
import static com.example.daniel.roll20.utils.ConstAttributes.XP;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.activities.CharacterDisplayActivity;
import com.example.daniel.roll20.database.CharacterDAO;
import com.example.daniel.roll20.dndCharacter.Character;

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
public class CharacterDetailsFragment extends Fragment implements View.OnClickListener {

    private CharacterDAO characterDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_details, container, false);
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
        case R.id.playerName:
            attributeName = "Player Name";
            break;
        case R.id.characterName:
            attributeName = "Character Name";
            break;
        case R.id.race:
            attributeName = "Race";
            break;
        case R.id.dndClass:
            attributeName = "Class";
            break;
        case R.id.xp:
            attributeName = "Experience Point";
            break;
        case R.id.alignment:
            attributeName = "Alignment";
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseDetailsDialog(attributeName);
    }

    private void loadCharacterFromDB(View view) {
        if (characterDAO.getCharacter().size() == 0) {
            Toast.makeText(getActivity(), "Please Create a Character", Toast.LENGTH_SHORT).show();
        } else {
            Character character = characterDAO.getCharacter().get(0);
            displayCharacterDetails(character, view);
        }
    }

    private void displayCharacterDetails(Character character, View view) {
        TextView characterName = (TextView)view.findViewById(R.id.characterName);
        characterName.setText(character.getCharacterName());

        TextView dndClass = (TextView)view.findViewById(R.id.dndClass);
        dndClass.setText(character.getDnDClass());

        TextView background = (TextView)view.findViewById(R.id.background);
        background.setText(character.getBackground());

        TextView playerName = (TextView)view.findViewById(R.id.playerName);
        playerName.setText(character.getPlayerName());

        TextView Race = (TextView)view.findViewById(R.id.Race);
        Race.setText(character.getRace());

        TextView alignment = (TextView)view.findViewById(R.id.alignment);
        alignment.setText(character.getAlignment());

        TextView xp = (TextView)view.findViewById(R.id.xp);
        xp.setText(String.valueOf(character.getXp()));

        characterDAO.update(character);
    }

    private void createButtonOnListeners(View view) {
        TextView characterName = (TextView)view.findViewById(R.id.characterName);
        characterName.setOnClickListener(this);

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

    public void reloadCharacterDetails(View view, int value, String attribute) {
        characterDAO = new CharacterDAO(getActivity());
        Character character = characterDAO.getCharacter().get(0);

        switch (attribute.toLowerCase()) {
        case CHARACTER_NAME:
            character.setStrength(value);
            break;
        case DND_CLASS:
            character.setDexterity(value);
            break;
        case RACE:
            character.setConstitution(value);
            break;
        case ALIGNMENT:
            character.setIntelligence(value);
            break;
        case BACKGROUND:
            character.setWisdom(value);
            break;
        case XP:
            character.setCharisma(value);
            break;
        case PLAYER_NAME:
            character.setCharisma(value);
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        displayCharacterDetails(character, view);
    }

}
