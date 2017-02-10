package com.example.daniel.roll20.fragments;

import java.util.ArrayList;

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

    private static final String PLAYER_NAME = "Player Name";
    private static final String CHARACTER_NAME = "Character Name";
    private static final String RACE = "Race";
    private static final String DND_CLASS = "Class";
    private static final String XP = "Experience Points";
    private static final String ALIGNMENT = "Alignment";
    private static final String BACKGROUND = "Background";

    private CharacterDAO characterDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_details, container, false);
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        characterDAO = new CharacterDAO(activity);
        loadCharacterFromDB(fragmentView, activity.getCharacterName());
        createButtonOnListeners(fragmentView);
        return fragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        String attributeName;
        switch (v.getId()) {
        case R.id.playerName:
            attributeName = PLAYER_NAME;
            break;
        case R.id.characterName:
            attributeName = CHARACTER_NAME;
            break;
        case R.id.Race:
            attributeName = RACE;
            break;
        case R.id.dndClass:
            attributeName = DND_CLASS;
            break;
        case R.id.xp:
            attributeName = XP;
            break;
        case R.id.background:
            attributeName = BACKGROUND;
            break;
        case R.id.alignment:
            attributeName = ALIGNMENT;
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseDetailsDialog(attributeName);
    }

    private void loadCharacterFromDB(View view, String characterName) {
        ArrayList<Character> characters = characterDAO.getCharacter();
        if (characters.size() == 0) {
            Toast.makeText(getActivity(), "Please Create a Character", Toast.LENGTH_SHORT).show();
        } else {
            for (Character character : characters) {
                if (characterName.equals(character.getCharacterName())) {
                    displayCharacterDetails(character, view);
                    break;
                }
            }
        }
    }

    private void displayCharacterDetails(Character character, View view) {
        TextView characterName = (TextView)view.findViewById(R.id.characterName);
        characterName.setText(character.getCharacterName());

        TextView dndClass = (TextView)view.findViewById(R.id.dndClass);
        dndClass.setText(character.getDndClass());

        TextView background = (TextView)view.findViewById(R.id.background);
        background.setText(character.getBackground());

        TextView playerName = (TextView)view.findViewById(R.id.playerName);
        playerName.setText(character.getPlayerName());

        TextView race = (TextView)view.findViewById(R.id.Race);
        race.setText(character.getRace());

        TextView alignment = (TextView)view.findViewById(R.id.alignment);
        alignment.setText(character.getAlignment());

        TextView xp = (TextView)view.findViewById(R.id.xp);
        xp.setText(String.valueOf(character.getXp()));

        characterDAO.update(character);
    }

    private void createButtonOnListeners(View view) {
        TextView characterName = (TextView)view.findViewById(R.id.characterName);
        characterName.setOnClickListener(this);

        TextView dndClass = (TextView)view.findViewById(R.id.dndClass);
        dndClass.setOnClickListener(this);

        TextView background = (TextView)view.findViewById(R.id.background);
        background.setOnClickListener(this);

        TextView playerName = (TextView)view.findViewById(R.id.playerName);
        playerName.setOnClickListener(this);

        TextView race = (TextView)view.findViewById(R.id.Race);
        race.setOnClickListener(this);

        TextView xp = (TextView)view.findViewById(R.id.xp);
        xp.setOnClickListener(this);

        TextView alignment = (TextView)view.findViewById(R.id.alignment);
        alignment.setOnClickListener(this);
    }

    public void reloadCharacterDetails(View view, String value, String attribute) {
        characterDAO = new CharacterDAO(getActivity());
        Character character = characterDAO.getCharacter().get(0);

        switch (attribute) {
        case CHARACTER_NAME:
            character.setCharacterName(value);
            break;
        case DND_CLASS:
            character.setDndClass(value);
            break;
        case RACE:
            character.setRace(value);
            break;
        case ALIGNMENT:
            character.setAlignment(value);
            break;
        case BACKGROUND:
            character.setBackground(value);
            break;
        case PLAYER_NAME:
            character.setPlayerName(value);
            break;
        case XP:
            Log.i("Steady", "XP Attribute");
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        displayCharacterDetails(character, view);
    }

}
