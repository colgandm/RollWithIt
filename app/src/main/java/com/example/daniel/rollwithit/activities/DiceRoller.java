package com.example.daniel.rollwithit.activities;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.fragments.DiceRollerFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class DiceRoller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_dice_roller);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        createDiceRollers();
    }

    private void createDiceRollers() {
        DiceRollerFragment fragmentD4 = new DiceRollerFragment();
        fragmentD4.setNumberOfSides(4);

        DiceRollerFragment fragmentD6 = new DiceRollerFragment();
        fragmentD6.setNumberOfSides(6);

        DiceRollerFragment fragmentD8 = new DiceRollerFragment();
        fragmentD8.setNumberOfSides(8);

        DiceRollerFragment fragmentD10 = new DiceRollerFragment();
        fragmentD10.setNumberOfSides(10);

        DiceRollerFragment fragmentD12 = new DiceRollerFragment();
        fragmentD12.setNumberOfSides(12);

        DiceRollerFragment fragmentD20 = new DiceRollerFragment();
        fragmentD20.setNumberOfSides(20);

        getSupportFragmentManager().beginTransaction()
            .add(R.id.diceRollerContainer, fragmentD4, "fragmentD4")
            .add(R.id.diceRollerContainer, fragmentD6, "fragmentD6")
            .add(R.id.diceRollerContainer, fragmentD8, "fragmentD8")
            .add(R.id.diceRollerContainer, fragmentD10, "fragmentD10")
            .add(R.id.diceRollerContainer, fragmentD12, "fragmentD12")
            .add(R.id.diceRollerContainer, fragmentD20, "fragmentD20")
                .commit();
    }
}

