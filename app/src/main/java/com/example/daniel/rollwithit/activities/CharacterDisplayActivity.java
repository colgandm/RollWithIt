package com.example.daniel.rollwithit.activities;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.dialogs.AttributeDialogFragment;
import com.example.daniel.rollwithit.dialogs.DetailsDialogFragment;
import com.example.daniel.rollwithit.fragments.CharacterAttributesFragment;
import com.example.daniel.rollwithit.fragments.CharacterDetailsFragment;
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

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CharacterDisplayActivity extends AppCompatActivity implements AttributeDialogListener {

    private static final String CHARACTER_NAME = "characterName";
    private static final String ATTRIBUTE_NAME = "attributeName";
    private static final String DETAIL_NAME = "detailName";
    private static final String ATTRIBUTE_DIALOG = "attributeDialog";
    private static final String DETAIL_DIALOG = "detailsDialog";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private CharacterAttributesFragment characterAttributesFragment;
    private CharacterDetailsFragment characterDetailsFragment;
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
        verifyStoragePermissions(this);
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
            startActivity(new Intent(this, DiceRoller.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCharacterAttributeUpdated(int value, String updatedAttribute) {
        characterAttributesFragment = (CharacterAttributesFragment)getFragmentManager()
            .findFragmentById(R.id.characterAttributesFragment);
        characterAttributesFragment.reloadCharacterAttributes(characterAttributesFragment.getView(), value,
            updatedAttribute);
    }

    @Override
    public void onCharacterDetailUpdated(String value, String updatedAttribute) {
        characterDetailsFragment = (CharacterDetailsFragment)getFragmentManager()
            .findFragmentById(R.id.CharacterDetailsFragment);
        characterDetailsFragment.reloadCharacterDetails(characterDetailsFragment.getView(), value, updatedAttribute);
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

    public void startDiceRollerActivity(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, DiceRoller.class));
        }
    }

    public String getCharacterName() {
        return characterName;
    }

    private void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
