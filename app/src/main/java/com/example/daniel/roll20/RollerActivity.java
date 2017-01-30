package com.example.daniel.roll20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.daniel.roll20.utils.DiceRoller;

public class RollerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roller);
        initializeSpinner();
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeSpinner() {
        // Dice Spinner
        Spinner diceSpinner = (Spinner)findViewById(R.id.dice_spinner);
        ArrayAdapter<CharSequence> diceAdapter = ArrayAdapter.createFromResource(this, R.array.dice_array,
            android.R.layout.simple_spinner_item);
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceSpinner.setAdapter(diceAdapter);
    }

    public void rollDice(View view) {

        Spinner diceSpinner = (Spinner)findViewById(R.id.dice_spinner);
        int numOfSides = Integer.parseInt(diceSpinner.getSelectedItem().toString());

        EditText numOfRollText = (EditText)findViewById(R.id.numberOfRolls);
        int numOfRolls = Integer.parseInt(numOfRollText.getText().toString());

        DiceRoller diceRoller = new DiceRoller();
        int[] result = diceRoller.roll(numOfRolls, numOfSides);

        TextView rollResult = (TextView)findViewById(R.id.roll_result);
        rollResult.setText(prettyPrint(result));

        TextView rollTotal = (TextView)findViewById(R.id.roll_total);
        rollTotal.setText(totalPrint(result));
    }

    private String prettyPrint(int[] results) {
        String resultString = "Results : ";
        for (int result : results) {
            resultString += result + " ";
        }
        return resultString;
    }

    private String totalPrint(int[] results) {
        int resultsTotal = 0;
        for (int result : results) {
            resultsTotal += result;
        }
        return "Total : " + String.valueOf(resultsTotal);
    }

}
