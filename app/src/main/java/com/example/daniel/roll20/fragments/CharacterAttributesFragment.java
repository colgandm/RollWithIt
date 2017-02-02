package com.example.daniel.roll20.fragments;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.dialogs.AttributeDialogFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CharacterAttributesFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_attributes, container, false);

        TextView strengthAtt = (TextView)fragmentView.findViewById(R.id.strengthShield);
        strengthAtt.setOnClickListener(this);

        return fragmentView;
    }

    private void charAttributeClickHandler(View view) {
        AttributeDialogFragment dialog = new AttributeDialogFragment();
        dialog.show(getFragmentManager(), "dialog");
    }

    @Override
    public void onClick(View v) {
        charAttributeClickHandler(v);
    }
}
