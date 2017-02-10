package com.example.daniel.rollwithit.dialogs;

import java.util.ArrayList;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.dndCharacter.Character;
import com.example.daniel.rollwithit.interfaces.SelectionDialogListener;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterSelectionDialogFragment extends DialogFragment {

    private SelectionDialogListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SelectionDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Selection dialog fragment failed!");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.fragment_character_selection_dialog, null);
        ArrayList<Character> characterArrayList = getArguments().getParcelableArrayList("characters");
        final ArrayAdapter<String> characterArrayAdapter = populateAdapter(characterArrayList);
        builder.setView(dialogView).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                System.out.println("Clicked No!");
                dialog.cancel();
            }
        }).setAdapter(characterArrayAdapter, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String strName = characterArrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                builderInner.setMessage(strName);
                builderInner.setTitle("Your Selected Item is");
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println("Clicked List!");
                        listener.onCharacterSelected(strName);
                        dialog.dismiss();
                    }
                });
                builderInner.show();
            }
        });
        return builder.create();
    }

    private ArrayAdapter<String> populateAdapter(ArrayList<Character> characterArrayList) {
        ArrayAdapter<String> characterArrayAdapter = new ArrayAdapter<>(getActivity(),
            android.R.layout.select_dialog_singlechoice);
        for (Character c : characterArrayList) {
            characterArrayAdapter.add(c.getCharacterName());
        }
        return characterArrayAdapter;
    }

}
