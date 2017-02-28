package com.example.daniel.rollwithit.activities;

import static java.lang.Integer.parseInt;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.utils.DiceRoller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RollerActivity extends AppCompatActivity {

    private static final String BLANK = "";
    private static final String NUMBER_OF_ROLLS_BLANK = "Please enter the number of rolls";
    private static final String NUMBER_OF_ROLLS_TOO_HIGH = "Please enter a reasonable number of rolls David";

    private final DiceRoller diceRoller = new DiceRoller();
    private Spinner diceSpinner;
    private EditText numOfRollText;
    private TextView rollResult;
    private TextView rollTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roller);
        diceSpinner = (Spinner)findViewById(R.id.dice_spinner);
        numOfRollText = (EditText)findViewById(R.id.number_of_rolls);
        rollResult = (TextView)findViewById(R.id.roll_result);
        rollTotal = (TextView)findViewById(R.id.roll_total);
        initializeSpinner();
        // doMaths();
    }

    private void doMaths() {
        System.out.println("Level 1 : " + (Math.ceil((double)1 / 4) + 1));
        System.out.println("Level 2 : " + (Math.ceil((double)2 / 4) + 1));
        System.out.println("Level 3 : " + (Math.ceil((double)3 / 4) + 1));
        System.out.println("Level 4 : " + (Math.ceil((double)4 / 4) + 1));
        System.out.println("Level 5 : " + (Math.ceil((double)5 / 4) + 1));
        System.out.println("Level 6 : " + (Math.ceil((double)6 / 4) + 1));
        System.out.println("Level 7 : " + (Math.ceil((double)7 / 4) + 1));
        System.out.println("Level 8 : " + (Math.ceil((double)8 / 4) + 1));
        System.out.println("Level 9 : " + (Math.ceil((double)9 / 4) + 1));
        System.out.println("Level 10 : " + (Math.ceil((double)10 / 4) + 1));
        System.out.println("Level 11 : " + (Math.ceil((double)11 / 4) + 1));
        System.out.println("Level 12 : " + (Math.ceil((double)12 / 4) + 1));
        System.out.println("Level 13 : " + (Math.ceil((double)13 / 4) + 1));
        System.out.println("Level 14 : " + (Math.ceil((double)14 / 4) + 1));
        System.out.println("Level 15 : " + (Math.ceil((double)15 / 4) + 1));
        System.out.println("Level 16 : " + (Math.ceil((double)16 / 4) + 1));
        System.out.println("Level 17 : " + (Math.ceil((double)17 / 4) + 1));
        System.out.println("Level 18 : " + (Math.ceil((double)18 / 4) + 1));
        System.out.println("Level 19 : " + (Math.ceil((double)19 / 4) + 1));
        System.out.println("Level 20 : " + (Math.ceil((double)20 / 4) + 1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dice_roller_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
        case R.id.action_settings:
            startActivity(new Intent(this, DiceRollerActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeSpinner() {
        ArrayAdapter<CharSequence> diceAdapter = ArrayAdapter.createFromResource(this, R.array.dice_array,
            android.R.layout.simple_spinner_item);
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceSpinner.setAdapter(diceAdapter);
    }

    public void rollDice(View view) {
        hideSoftKeyboard(this, view);
        if (BLANK.equals(numOfRollText.getText().toString())) {
            Toast.makeText(this, NUMBER_OF_ROLLS_BLANK, Toast.LENGTH_SHORT).show();
            return;
        } else if (parseInt(numOfRollText.getText().toString()) > 100) {
            Toast.makeText(this, NUMBER_OF_ROLLS_TOO_HIGH, Toast.LENGTH_SHORT).show();
            return;
        }
        int numOfSides = parseInt(diceSpinner.getSelectedItem().toString());
        int numOfRolls = parseInt(numOfRollText.getText().toString());

        rollResult.setText(diceRoller.allRolls(numOfRolls, numOfSides));
        rollTotal.setText(diceRoller.totalOfRolls(numOfRolls, numOfSides));
    }

    private void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

}
