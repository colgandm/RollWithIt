package com.example.daniel.roll20.database;

import static com.example.daniel.roll20.utils.ConstAttributes.ALIGNMENT;
import static com.example.daniel.roll20.utils.ConstAttributes.ARMOUR_CLASS;
import static com.example.daniel.roll20.utils.ConstAttributes.BACKGROUND;
import static com.example.daniel.roll20.utils.ConstAttributes.CHARACTER_NAME;
import static com.example.daniel.roll20.utils.ConstAttributes.CHARISMA;
import static com.example.daniel.roll20.utils.ConstAttributes.CONSTITUTION;
import static com.example.daniel.roll20.utils.ConstAttributes.DEXTERITY;
import static com.example.daniel.roll20.utils.ConstAttributes.DND_CLASS;
import static com.example.daniel.roll20.utils.ConstAttributes.HIT_POINTS;
import static com.example.daniel.roll20.utils.ConstAttributes.INTELLIGENCE;
import static com.example.daniel.roll20.utils.ConstAttributes.LEVEL;
import static com.example.daniel.roll20.utils.ConstAttributes.PLAYER_NAME;
import static com.example.daniel.roll20.utils.ConstAttributes.PROFICIENCY_BONUS;
import static com.example.daniel.roll20.utils.ConstAttributes.RACE;
import static com.example.daniel.roll20.utils.ConstAttributes.SPEED;
import static com.example.daniel.roll20.utils.ConstAttributes.STRENGTH;
import static com.example.daniel.roll20.utils.ConstAttributes.WISDOM;
import static com.example.daniel.roll20.utils.ConstAttributes.XP;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CHARACTER_TABLE = "character";
    private static final String DATABASE_NAME = "characterdb";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_CHARACTER_TABLE = "CREATE TABLE " + CHARACTER_TABLE + "(" + CHARACTER_NAME
        + " TEXT PRIMARY KEY," + PLAYER_NAME + " TEXT," + BACKGROUND + " TEXT," + ALIGNMENT + " TEXT," + RACE + " TEXT,"
        + DND_CLASS + " TEXT," + PROFICIENCY_BONUS + " INT," + ARMOUR_CLASS + " INT," + SPEED + " INT," + HIT_POINTS
        + " INT," + LEVEL + " INT," + XP + " INT," + STRENGTH + " INT," + DEXTERITY + " INT," + CONSTITUTION + " INT,"
        + INTELLIGENCE + " INT," + WISDOM + " INT," + CHARISMA + " INT" + ")";
    private static DataBaseHelper instance;

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DataBaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DataBaseHelper(context);
        return instance;
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
