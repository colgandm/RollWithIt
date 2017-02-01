package com.example.daniel.roll20.fragments;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.dialogs.AttributeDialogFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CharacterAttributesFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_character_attributes, container, false);

        TextView strengthAtt = (TextView)fragmentView.findViewById(R.id.strengthShield);
        strengthAtt.setOnClickListener(this);

        return fragmentView;
    }

    public void charAttributeClickHandler(View view) {
        FragmentManager fm = getFragmentManager();
        AttributeDialogFragment attributeDialogFragment = new AttributeDialogFragment();

        attributeDialogFragment.show(fm, "MyDialog");

        System.out.println("I pressed the button");
    }

    @Override
    public void onClick(View v) {
        charAttributeClickHandler(v);
    }

    public void onMenuDialog() {

    }
}
