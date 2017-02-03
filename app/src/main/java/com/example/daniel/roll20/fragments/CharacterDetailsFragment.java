package com.example.daniel.roll20.fragments;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.database.CharacterDAO;
import com.example.daniel.roll20.dialogs.AttributeDialogFragment;
import com.example.daniel.roll20.dndCharacter.Character;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    @Override
    public void onClick(View v) {
        charAttributeClickHandler(v);
    }

    private void charAttributeClickHandler(View view) {
        AttributeDialogFragment dialog = new AttributeDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    private void loadCharacterFromDB(View view) {
        Character character = characterDAO.getCharacter().get(0);
        displayCharacterDetails(character, view);
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
    }

    private void createButtonOnListeners(View view) {
        TextView characterName = (TextView)view.findViewById(R.id.characterName);
        characterName.setOnClickListener(this);
    }
}
