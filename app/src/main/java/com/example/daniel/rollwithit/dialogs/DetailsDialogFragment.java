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

    private AttributeDialogListener listener;
    private String detailName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (AttributeDialogListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "attaching d fragment failed!");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        detailName = getArguments().getString("detailName");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.fragment_detail_dialog, null);
        TextView textView = (TextView)dialogView.findViewById(R.id.dialogText);
        textView.setText("Enter new " + detailName + " value.");
        builder.setView(dialogView).setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                TextView editAttribute = (TextView)dialogView.findViewById(R.id.detailValue);
                String attributeValue = editAttribute.getText().toString();
                listener.onUpdatedDetail(attributeValue, detailName);
                dialog.dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                System.out.println("Canceled the attribute change!");
                dialog.cancel();
            }
        });
        return builder.create();
    }
}
