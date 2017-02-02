package com.example.daniel.roll20.dialogs;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.database.CharacterDAO;
import com.example.daniel.roll20.dndCharacter.Character;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * A simple {@link Fragment} subclass.
 */

public class AttributeDialogFragment extends DialogFragment {

    private CharacterDAO characterDAO;
    private Character character;

    public AttributeDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        characterDAO = new CharacterDAO(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_attribute_dialog, null))
            .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int id) {
                    character = characterDAO.getCharacter().get(0);
                    character.setPlayerName("BOOM");
                    characterDAO.update(character);
                    System.out.println("New Value has been saved!");
                    saveNewAttribute();
                }

            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {
                    System.out.println("Canceled the attribute change!");
                }
            });
        return builder.create();
    }

    private void saveNewAttribute() {
        System.out.println("Attribute Updated!");
    }
}
