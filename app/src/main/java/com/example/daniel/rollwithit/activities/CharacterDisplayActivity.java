package com.example.daniel.rollwithit.activities;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.dialogs.AttributeDialogFragment;
import com.example.daniel.rollwithit.dialogs.DetailsDialogFragment;
import com.example.daniel.rollwithit.dialogs.StatsDialogFragments;
import com.example.daniel.rollwithit.fragments.CharacterDetailsFragment;
import com.example.daniel.rollwithit.fragments.CharacterStatsFragment;
import com.example.daniel.rollwithit.interfaces.AttributeDialogListener;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CharacterDisplayActivity extends AppCompatActivity implements AttributeDialogListener {

    private static final String CHARACTER_NAME = "characterName";
    private static final String ATTRIBUTE_NAME = "attributeName";
    private static final String DETAIL_NAME = "detailName";
    private static final String STAT_NAME = "statName";
    private static final String ATTRIBUTE_DIALOG = "attributeDialog";
    private static final String DETAIL_DIALOG = "detailsDialog";
    private static final String STATS_DIALOG = "statsDialog";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private String characterName;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCharacterName(getIntent().getStringExtra(CHARACTER_NAME));
        setContentView(R.layout.activity_character_display);
        setExperienceBar();
        verifyStoragePermissions(this);
    }

    private void setExperienceBar() {
        ProgressBar experienceBar = (ProgressBar)findViewById(R.id.experience_bar);
        experienceBar.setProgress(determineLevelPercentage());

    }

    private int determineLevelPercentage() {
        return 95;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, DiceRollerActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCharacterAttributeUpdated(int value, String updatedAttribute) {
        // CharacterAttributesFragment characterAttributesFragment = (CharacterAttributesFragment) getFragmentManager()
        // .findFragmentById(R.id.character_attributes_fragment);
        // characterAttributesFragment.reloadCharacterAttributes(characterAttributesFragment.getView(), value,
        // updatedAttribute);
    }

    @Override
    public void onCharacterDetailUpdated(String value, String updatedAttribute) {
        CharacterDetailsFragment characterDetailsFragment = (CharacterDetailsFragment)getFragmentManager()
            .findFragmentById(R.id.character_details_fragment);
        characterDetailsFragment.reloadCharacterDetails(characterDetailsFragment.getView(), value, updatedAttribute);
    }

    @Override
    public void onCharacterStatsUpdated(int value, String updatedAttribute) {
        CharacterStatsFragment characterStatsFragment = (CharacterStatsFragment)getFragmentManager()
            .findFragmentById(R.id.character_stats_fragment);
        characterStatsFragment.reloadCharacterStats(characterStatsFragment.getView(), value, updatedAttribute);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void raiseEditAttributeDialog(String attributeName) {
        Bundle args = new Bundle();
        args.putString(ATTRIBUTE_NAME, attributeName);
        AttributeDialogFragment dialog = new AttributeDialogFragment();
        dialog.setArguments(args);
        dialog.show(getFragmentManager(), ATTRIBUTE_DIALOG);
    }

    public void raiseEditDetailsDialog(String detailName) {
        Bundle args = new Bundle();
        args.putString(DETAIL_NAME, detailName);
        DetailsDialogFragment dialog = new DetailsDialogFragment();
        dialog.setArguments(args);
        dialog.show(getFragmentManager(), DETAIL_DIALOG);
    }

    public void raiseEditStatsDialog(String statName) {
        Bundle args = new Bundle();
        args.putString(STAT_NAME, statName);
        StatsDialogFragments dialog = new StatsDialogFragments();
        dialog.setArguments(args);
        dialog.show(getFragmentManager(), STATS_DIALOG);
    }

    public void startDiceRollerActivity(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, DiceRollerActivity.class));
        }
    }

    public String getCharacterName() {
        return characterName;
    }

    private void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
