package com.example.daniel.roll20.activities;

import com.example.daniel.roll20.R;
import com.idescout.sql.SqlScoutServer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SqlScoutServer.create(this, getPackageName());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    public void goToDiceRoller(View view) {
        Intent diceRollerIntent = new Intent(this, RollerActivity.class);
        startActivity(diceRollerIntent);
    }

    public void createCharacter(View view) {
        Intent characterCreationIntent = new Intent(this, CreateCharacterActivity.class);
        startActivity(characterCreationIntent);
    }

    public void loadCharacter(View view) {
        Intent characterDisplayIntent = new Intent(this, CharacterDisplayActivity.class);
        startActivity(characterDisplayIntent);
    }
}
