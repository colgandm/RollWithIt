package com.example.daniel.roll20.activities;

import com.example.daniel.roll20.R;
import com.example.daniel.roll20.dialogs.AttributeDialogFragment;
import com.example.daniel.roll20.fragments.CharacterAttributesFragment;
import com.example.daniel.roll20.interfaces.AttributeDialogListener;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class CharacterDisplayActivity extends FragmentActivity implements AttributeDialogListener{

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String[] PERMISSIONS_STORAGE = {
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_display);
        verifyStoragePermissions(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }

    public void raiseDialog(String attributeName) {
        Bundle args = new Bundle();
        args.putString("attributeName", attributeName);
        AttributeDialogFragment dialog = new AttributeDialogFragment();
        dialog.setArguments(args);
        dialog.show(getFragmentManager(), "dialog");
    }

    @Override
    public void onUpdatedAttribute(int value) {
        CharacterAttributesFragment fragment = (CharacterAttributesFragment) getFragmentManager().findFragmentById(R.id.characterAttributesFragment);
        fragment.reloadCharacterAttributes(fragment.getView());
    }
}
