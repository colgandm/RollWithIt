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
        TextView nbrOfSides = (TextView)fragmentView.findViewById(R.id.typeOfDie);
        nbrOfSides.setText(String.valueOf(numberOfSides));
        return fragmentView;
    }

    @Override
    public void rollSumWithModifier(View view) {
        // switch (((View)view.getParent()).getId()) {
        // case R.id.DiceRollerFragmentD4:
        // numberOfSides = 4;
        // break;
        // case R.id.DiceRollerFragmentD6:
        // numberOfSides = 6;
        // break;
        // case R.id.DiceRollerFragmentD8:
        // numberOfSides = 8;
        // break;
        // case R.id.DiceRollerFragmentD10:
        // numberOfSides = 10;
        // break;
        // case R.id.DiceRollerFragmentD12:
        // numberOfSides = 12;
        // break;
        // case R.id.DiceRollerFragmentD20:
        // numberOfSides = 20;
        // break;
        // case R.id.DiceRollerFragmentD100:
        // numberOfSides = 100;
        // break;
        // case R.id.DiceRollerFragmentDX:
        // numberOfSides = 101;
        // break;
        // default:
        // throw new RuntimeException("Unknown button ID");
        // }
        EditText nbrOfDice = (EditText)getView().findViewById(R.id.numberOfDie);
        EditText modifierValue = (EditText)getView().findViewById(R.id.modifierValue);
        TextView resultValue = (TextView)getView().findViewById(R.id.rollResult);

        int numberOfDice = Integer.valueOf(nbrOfDice.getText().toString());
        int modifier = Integer.valueOf(modifierValue.getText().toString());
        int result = diceRoller.rollSumWithModifier(numberOfDice, numberOfSides, modifier);

        resultValue.setText(String.valueOf(result));

    }

    private void createButtonOnListeners(View view) {
        Button rollButton = (Button)view.findViewById(R.id.rollButton);
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
