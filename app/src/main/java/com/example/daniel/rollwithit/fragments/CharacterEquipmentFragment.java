package com.example.daniel.rollwithit.fragments;

import com.example.daniel.rollwithit.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterEquipmentFragment extends Fragment implements View.OnClickListener {

    private static final String TOAST_TEST = "Test Toast";
    private TextView characterEquipment;

    public CharacterEquipmentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_equipment, container, false);
        initialiseViews(fragmentView);
        createButtonOnListeners();
        return fragmentView;
    }

    private void initialiseViews(View fragmentView) {
        characterEquipment = (TextView)fragmentView.findViewById(R.id.characterEquipment);
    }

    private void createButtonOnListeners() {
        characterEquipment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), TOAST_TEST, Toast.LENGTH_SHORT).show();

    }
}
