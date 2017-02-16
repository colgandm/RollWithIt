package com.example.daniel.rollwithit.interfaces;

public interface AttributeDialogListener {

    void onCharacterAttributeUpdated(int value, String attribute);

    void onCharacterDetailUpdated(String value, String attribute);

    void onCharacterStatsUpdated(int value, String updatedAttribute);
}
