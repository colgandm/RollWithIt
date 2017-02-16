package com.example.daniel.rollwithit.fragments;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.interfaces.OnFragmentInteractionListener;
import com.example.daniel.rollwithit.utils.DiceRoller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DiceRollerFragment extends Fragment implements OnFragmentInteractionListener, View.OnClickListener {

    private final DiceRoller diceRoller = new DiceRoller();

    private int numberOfSides;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_dice_roller, container, false);
        createButtonOnListeners(fragmentView);
        TextView nbrOfSides = (TextView)fragmentView.findViewById(R.id.type_of_die);
        nbrOfSides.setText(String.valueOf(numberOfSides));
        return fragmentView;
    }

    @Override
    public void rollSumWithModifier(View view) {
        EditText nbrOfDice = (EditText)getView().findViewById(R.id.number_of_die);
        EditText modifierValue = (EditText)getView().findViewById(R.id.modifier_value);
        TextView resultValue = (TextView)getView().findViewById(R.id.roll_result);

        int numberOfDice = Integer.valueOf(nbrOfDice.getText().toString());
        int modifier = Integer.valueOf(modifierValue.getText().toString());
        int result = diceRoller.rollSumWithModifier(numberOfDice, numberOfSides, modifier);

        resultValue.setText(String.valueOf(result));
    }

    private void createButtonOnListeners(View view) {
        Button rollButton = (Button)view.findViewById(R.id.roll_button);
        rollButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        rollSumWithModifier(v);
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

}
