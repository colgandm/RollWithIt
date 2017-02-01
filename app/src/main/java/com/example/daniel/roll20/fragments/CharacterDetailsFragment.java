package com.example.daniel.roll20.fragments;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.interfaces.XmlClickable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterDetailsFragment extends Fragment implements View.OnClickListener {

    public CharacterDetailsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_details, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}
