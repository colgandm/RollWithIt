package com.example.daniel.rollwithit.database;

import static com.example.daniel.rollwithit.utils.ConstAttributes.AGE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ALIGNMENT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.ARMOUR;
import static com.example.daniel.rollwithit.utils.ConstAttributes.BACKGROUND;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARACTER_NAME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CHARISMA;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CLASS_TYPE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.CONSTITUTION;
import static com.example.daniel.rollwithit.utils.ConstAttributes.DEXTERITY;
import static com.example.daniel.rollwithit.utils.ConstAttributes.GENDER;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HEIGHT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.HIT_POINTS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.INSPIRATION;
import static com.example.daniel.rollwithit.utils.ConstAttributes.INTELLIGENCE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.LEVEL;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PLAYER_NAME;
import static com.example.daniel.rollwithit.utils.ConstAttributes.PROFICIENCY_BONUS;
import static com.example.daniel.rollwithit.utils.ConstAttributes.RACE;
import static com.example.daniel.rollwithit.utils.ConstAttributes.SPEED;
import static com.example.daniel.rollwithit.utils.ConstAttributes.STRENGTH;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WEIGHT;
import static com.example.daniel.rollwithit.utils.ConstAttributes.WISDOM;
import static com.example.daniel.rollwithit.utils.ConstAttributes.XP;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CHARACTER_TABLE = "character";
    private static final String DATABASE_NAME = "characterdb";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_CHARACTER_TABLE = "CREATE TABLE " + CHARACTER_TABLE + "(" + CHARACTER_NAME
        + " TEXT PRIMARY KEY," + PLAYER_NAME + " TEXT," + CLASS_TYPE + " TEXT," + LEVEL + " INT," + BACKGROUND
        + " TEXT," + RACE + " TEXT," + ALIGNMENT + " TEXT," + XP + " INT," + STRENGTH + " INT," + DEXTERITY + " INT,"
        + CONSTITUTION + " INT," + INTELLIGENCE + " INT," + WISDOM + " INT," + CHARISMA + " INT," + INSPIRATION
        + " INT," + PROFICIENCY_BONUS + " INT," + ARMOUR + " INT," + SPEED + " INT," + HIT_POINTS + " INT," + GENDER
        + " TEXT," + WEIGHT + " INT," + HEIGHT + " INT," + AGE + " INT" + ")";
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
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CHARACTER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
