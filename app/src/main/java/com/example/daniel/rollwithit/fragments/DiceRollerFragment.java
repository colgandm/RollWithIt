package com.example.daniel.rollwithit.fragments;

import static java.lang.Integer.parseInt;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.interfaces.OnFragmentInteractionListener;
import com.example.daniel.rollwithit.utils.DiceRoller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DiceRollerFragment extends Fragment implements OnFragmentInteractionListener, View.OnClickListener {

    private static final String BLANK = "";
    private final DiceRoller diceRoller = new DiceRoller();
    private int numberOfSides;
    private TextView resultValue;
    private EditText nbrOfDice;
    private EditText modifierValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_dice_roller, container, false);
        initializeViews(fragmentView);
        return fragmentView;
    }

    private void initializeViews(View fragmentView) {
        TextView typeOfDie = (TextView)fragmentView.findViewById(R.id.type_of_die);
        typeOfDie.setText(String.valueOf(numberOfSides));
        resultValue = (TextView)fragmentView.findViewById(R.id.roll_result);
        nbrOfDice = (EditText)fragmentView.findViewById(R.id.number_of_die);
        modifierValue = (EditText)fragmentView.findViewById(R.id.modifier_value);
        Button rollButton = (Button)fragmentView.findViewById(R.id.roll_button);
        rollButton.setOnClickListener(this);
    }

    @Override
    public void rollSumWithModifier(View view) {
        int numberOfDice = getNullSafeValue(nbrOfDice.getText());
        int modifier = getNullSafeValue(modifierValue.getText());
        int result = diceRoller.rollSumWithModifier(numberOfDice, numberOfSides, modifier);
        resultValue.setText(String.valueOf(result));
    }

    private int getNullSafeValue(Editable value) {
        return value.toString().equalsIgnoreCase(BLANK) ? 0 : parseInt(value.toString());
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
