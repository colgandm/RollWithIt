package com.example.daniel.rollwithit.fragments;

import com.example.daniel.rollwithit.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterEquipmentFragment extends Fragment implements View.OnClickListener {

    public CharacterEquipmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_equipment, container, false);
        createButtonOnListeners(fragmentView);
        return fragmentView;
    }

    private void createButtonOnListeners(View view) {
        // TextView characterEquipment = (TextView)view.findViewById(R.id.characterEquipment);
        // characterEquipment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
