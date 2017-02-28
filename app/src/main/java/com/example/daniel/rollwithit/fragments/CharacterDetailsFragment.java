package com.example.daniel.rollwithit.fragments;

import static com.example.daniel.rollwithit.dndCharacter.classes.Class.getClassFromMap;
import static com.example.daniel.rollwithit.dndCharacter.races.Race.getRaceFromMap;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.activities.CharacterDisplayActivity;
import com.example.daniel.rollwithit.database.CharacterDAO;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.dndCharacter.Experience;
import com.example.daniel.rollwithit.utils.Utils;

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
public class CharacterDetailsFragment extends Fragment implements View.OnClickListener {

    private static final String PLAYER_NAME = "Player Name";
    private static final String CHARACTER_NAME = "Character Name";
    private static final String RACE = "Race";
    private static final String DND_CLASS = "Class";
    private static final String XP = "Experience Points";
    private static final String ALIGNMENT = "Alignment";
    private static final String BACKGROUND = "Background";
    private static final String CHAR_CREATION_TOAST = "Please Create a Character";

    private Character character;
    private CharacterDisplayActivity parentActivity;

    private TextView dndClass;
    private TextView background;
    private TextView playerName;
    private TextView race;
    private TextView alignment;
    private TextView xp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_details, container, false);
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
        case R.id.race_value:
            attributeName = RACE;
            parentActivity.raiseEditCharacterDetailsDialog(attributeName);
            return;
        case R.id.dnd_class_value:
            attributeName = DND_CLASS;
            parentActivity.raiseEditCharacterDetailsDialog(attributeName);
            return;
        case R.id.background_value:
            attributeName = BACKGROUND;
            parentActivity.raiseEditCharacterDetailsDialog(attributeName);
            return;
        case R.id.alignment_value:
            attributeName = ALIGNMENT;
            parentActivity.raiseEditCharacterDetailsDialog(attributeName);
            return;
        case R.id.xp_value:
            attributeName = XP;
            break;
        case R.id.player_name_value:
            attributeName = PLAYER_NAME;
            break;
        case R.id.character_name_value:
            attributeName = CHARACTER_NAME;
            break;
        default:
            throw new RuntimeException("Unknown button ID");
        }
        parentActivity.raiseEditDetailsDialog(attributeName);
    }

    private void initialiseViews(View view) {
        dndClass = (TextView)view.findViewById(R.id.dnd_class_value);
        background = (TextView)view.findViewById(R.id.background_value);
        playerName = (TextView)view.findViewById(R.id.player_name_value);
        race = (TextView)view.findViewById(R.id.race_value);
        alignment = (TextView)view.findViewById(R.id.alignment_value);
        xp = (TextView)view.findViewById(R.id.xp_value);
    }

    private void displayCharacterDetails() {
        assert character != null;
        dndClass.setText(character.getClassType().getClassTypeName());
        background.setText(character.getBackground());
        playerName.setText(character.getPlayerName());
        race.setText(character.getRaceType().getRaceTypeName());
        alignment.setText(character.getAlignment());
        xp.setText(valueOf(character.getXp().getTotalExperience()));
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
        assert character != null;
        switch (attribute) {
        case DND_CLASS:
            character.setClassType(getClassFromMap(Utils.determineClass(value)));
            break;
        case RACE:
            character.setRaceType(getRaceFromMap(Utils.determineRace(value)));
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
            character.setXp(new Experience(parseInt(value)));
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
