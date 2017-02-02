package com.example.daniel.roll20.database;

import static com.example.daniel.roll20.utils.constantAttributes.ALIGNMENT;
import static com.example.daniel.roll20.utils.constantAttributes.ARMOUR_CLASS;
import static com.example.daniel.roll20.utils.constantAttributes.BACKGROUND;
import static com.example.daniel.roll20.utils.constantAttributes.CHARACTER_NAME;
import static com.example.daniel.roll20.utils.constantAttributes.CHARISMA;
import static com.example.daniel.roll20.utils.constantAttributes.CONSTITUTION;
import static com.example.daniel.roll20.utils.constantAttributes.DEXTERITY;
import static com.example.daniel.roll20.utils.constantAttributes.DND_CLASS;
import static com.example.daniel.roll20.utils.constantAttributes.HIT_POINTS;
import static com.example.daniel.roll20.utils.constantAttributes.INTELLIGENCE;
import static com.example.daniel.roll20.utils.constantAttributes.LEVEL;
import static com.example.daniel.roll20.utils.constantAttributes.PLAYER_NAME;
import static com.example.daniel.roll20.utils.constantAttributes.PROFICIENCY_BONUS;
import static com.example.daniel.roll20.utils.constantAttributes.RACE;
import static com.example.daniel.roll20.utils.constantAttributes.SPEED;
import static com.example.daniel.roll20.utils.constantAttributes.STRENGTH;
import static com.example.daniel.roll20.utils.constantAttributes.WISDOM;
import static com.example.daniel.roll20.utils.constantAttributes.XP;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "characterdb";
    private static final int DATABASE_VERSION = 1;
    private static DataBaseHelper instance;

    public static final String CHARACTER_TABLE = "character";

    private static final String CREATE_CHARACTER_TABLE = "CREATE TABLE " + CHARACTER_TABLE + "(" + CHARACTER_NAME
        + " TEXT PRIMARY KEY," + PLAYER_NAME + " TEXT," + BACKGROUND + " TEXT," + ALIGNMENT + " TEXT," + RACE + " TEXT,"
        + DND_CLASS + " TEXT," + PROFICIENCY_BONUS + " INT," + ARMOUR_CLASS + " INT," + SPEED + " INT," + HIT_POINTS
        + " INT," + LEVEL + " INT," + XP + " INT," + STRENGTH + " INT," + DEXTERITY + " INT," + CONSTITUTION + " INT,"
        + INTELLIGENCE + " INT," + WISDOM + " INT," + CHARISMA + " INT" + ")";

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CHARACTER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
