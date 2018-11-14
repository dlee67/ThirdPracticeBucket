package com.example.bob.sqlitetutorial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String dbName){
        super(context, dbName, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
