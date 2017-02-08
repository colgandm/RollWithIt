package com.example.daniel.roll20.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

class CharacterDBDAO {

    SQLiteDatabase database;
    private DataBaseHelper dbHelper;
    private final Context mContext;

    CharacterDBDAO(Context context) {
        this.mContext = context;
        dbHelper = DataBaseHelper.getHelper(mContext);
        open();

    }

    private void open() throws SQLException {
        if (dbHelper == null)
            dbHelper = DataBaseHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
        database = null;
    }

}
