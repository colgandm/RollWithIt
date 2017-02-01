package com.example.daniel.roll20.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.daniel.roll20.R;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttributeDialogFragment extends DialogFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {

        View theView = inflater.inflate(R.layout.fragment_attribute_dialog, container, false);

        View yesButton = theView.findViewById(R.id.btnYes);
        yesButton.setOnClickListener(this);
        yesButton.requestFocus();

        View noButton = theView.findViewById(R.id.btnNo);
        noButton.setOnClickListener(this);

        return theView;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getActivity(), "enter a text here", LENGTH_SHORT).show();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
            }

        });

        return builder.create();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        switch (viewId) {
        case R.id.btnYes:
            break;
        case R.id.btnNo:
            break;

        }
        dismiss();
    }
}
