package com.example.daniel.rollwithit.dialogs;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.interfaces.AttributeDialogListener;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */

public class DetailsDialogFragment extends DialogFragment {

    private static final String DETAIL_NAME = "detailName";
    private AttributeDialogListener listener;
    private String detailName;
    private String detailValue;
    private TextView editDetail;

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
        detailName = getArguments().getString(DETAIL_NAME);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.fragment_detail_dialog, null);
        TextView textView = (TextView)dialogView.findViewById(R.id.dialogText);
        textView.setText("Enter new " + detailName + " value.");
        builder.setView(dialogView).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                editDetail = (TextView)dialogView.findViewById(R.id.detailValue);
                detailValue = editDetail.getText().toString();
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
}
