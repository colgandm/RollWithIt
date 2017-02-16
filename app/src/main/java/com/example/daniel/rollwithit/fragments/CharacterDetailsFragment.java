package com.example.daniel.rollwithit.fragments;

import static java.lang.Integer.parseInt;
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
public class CharacterDetailsFragment extends Fragment implements View.OnClickListener {

    private static final String PLAYER_NAME = "Player Name";
    private static final String CHARACTER_NAME = "Character Name";
    private static final String RACE = "Race";
    private static final String DND_CLASS = "Class";
    private static final String XP = "Experience Points";
    private static final String ALIGNMENT = "Alignment";
    private static final String BACKGROUND = "Background";
    private static final String CHAR_CREATION_TOAST = "Please Create a Character";

    private CharacterDAO characterDAO;
    private String characterName;

    private TextView dndClass;
    private TextView background;
    private TextView playerName;
    private TextView race;
    private TextView alignment;
    private TextView xp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_details, container, false);
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        characterDAO = new CharacterDAO(activity);
        characterName = activity.getCharacterName();
        Character character = loadCharacterFromDB(characterName);
        initialiseViews(fragmentView);
        displayCharacterDetails(character);
        createButtonOnListeners();
        return fragmentView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        String attributeName;
        switch (v.getId()) {
        case R.id.player_name_value:
            attributeName = PLAYER_NAME;
            break;
        case R.id.character_name_value:
            attributeName = CHARACTER_NAME;
            break;
        case R.id.race_value:
            attributeName = RACE;
            break;
        case R.id.dnd_class_value:
            attributeName = DND_CLASS;
            break;
        case R.id.xp_value:
            attributeName = XP;
            break;
        case R.id.background_value:
            attributeName = BACKGROUND;
            break;
        case R.id.alignment_value:
            attributeName = ALIGNMENT;
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        CharacterDisplayActivity activity = (CharacterDisplayActivity)getActivity();
        activity.raiseEditDetailsDialog(attributeName);
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
        dndClass = (TextView)view.findViewById(R.id.dnd_class_value);

        background = (TextView)view.findViewById(R.id.background_value);
        playerName = (TextView)view.findViewById(R.id.player_name_value);
        race = (TextView)view.findViewById(R.id.race_value);
        alignment = (TextView)view.findViewById(R.id.alignment_value);
        xp = (TextView)view.findViewById(R.id.xp_value);
    }

    private void displayCharacterDetails(Character character) {
        assert character != null;
        dndClass.setText(character.getDndClass());
        background.setText(character.getBackground());
        playerName.setText(character.getPlayerName());
        race.setText(character.getRace());
        alignment.setText(character.getAlignment());
        xp.setText(valueOf(character.getXp()));
        characterDAO.update(character);
    }

    private void createButtonOnListeners() {
        dndClass.setOnClickListener(this);
        background.setOnClickListener(this);
        playerName.setOnClickListener(this);
        race.setOnClickListener(this);
        xp.setOnClickListener(this);
        alignment.setOnClickListener(this);
    }

    public void reloadCharacterDetails(View view, String value, String attribute) {
        Character reloadedCharacter = loadCharacterFromDB(characterName);
        assert reloadedCharacter != null;
        switch (attribute) {
        case DND_CLASS:
            reloadedCharacter.setDndClass(value);
            break;
        case RACE:
            reloadedCharacter.setRace(value);
            break;
        case ALIGNMENT:
            reloadedCharacter.setAlignment(value);
            break;
        case BACKGROUND:
            reloadedCharacter.setBackground(value);
            break;
        case PLAYER_NAME:
            reloadedCharacter.setPlayerName(value);
            break;
        case XP:
            reloadedCharacter.setXp(parseInt(value));
            break;
        default:
            Log.i("Error", "Unknown Attribute");
        }
        displayCharacterDetails(reloadedCharacter);
    }
}
