
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
import android.widget.TextView;

public class StatsDialogFragments extends DialogFragment {

    private static final String ATTRIBUTE_NAME = "attributeName";
    private AttributeDialogListener listener;
    private String attributeName;
    private int attributeValue;
    private TextView editAttribute;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (AttributeDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Attaching dialog fragment failed!");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        attributeName = getArguments().getString(ATTRIBUTE_NAME);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.fragment_attribute_dialog, null);
        TextView textView = (TextView)dialogView.findViewById(R.id.attribute_dialog_text);
        textView.setText("Enter new " + attributeName + " value.");
        builder.setView(dialogView).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                editAttribute = (TextView)dialogView.findViewById(R.id.attribute_dialog_value);
                attributeValue = Integer.parseInt(editAttribute.getText().toString());
                listener.onCharacterAttributeUpdated(attributeValue, attributeName);
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}
