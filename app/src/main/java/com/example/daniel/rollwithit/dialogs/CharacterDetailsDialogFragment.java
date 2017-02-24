package com.example.daniel.rollwithit.dialogs;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.interfaces.AttributeDialogListener;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CharacterDetailsDialogFragment extends DialogFragment {

    private static final String DETAIL_NAME = "detailName";
    private AttributeDialogListener listener;
    private String detailName;
    private String detailValue;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> arrayAdapter;

    public CharacterDetailsDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (AttributeDialogListener)context;
        } catch (ClassCastException e) {
            throw new RuntimeException(context.toString() + "\"Attaching dialog fragment failed!r");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_fragment_edit_character_details, null);
        spinner = (Spinner)dialogView.findViewById(R.id.detail_spinner_value);
        detailName = getArguments().getString(DETAIL_NAME);
        initializeSpinners();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView textView = (TextView)dialogView.findViewById(R.id.detail_dialog_text);
        textView.setText("Enter new " + detailName + " value.");
        builder.setView(dialogView).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                detailValue = spinner.getSelectedItem().toString();
                listener.onCharacterDetailUpdated(detailValue, detailName);
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return builder.create();
    }

    private void initializeSpinners() {
        switch (detailName) {
        case "Alignment":
            arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.alignment_array,
                android.R.layout.simple_spinner_item);
            break;
        case "Background":
            arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.background_array,
                android.R.layout.simple_spinner_item);
            break;
        case "Class":
            arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.class_array,
                android.R.layout.simple_spinner_item);
            break;
        case "Race":
            arrayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.race_array,
                android.R.layout.simple_spinner_item);
            break;
        }
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }

}
