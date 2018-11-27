package com.example.bob.commonssqliteprac;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String TITLE="title";
    static final String VALUE="value";
    static final String TABLE="constants";

    public DatabaseHelper(Context context){
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Below is the SQL query.
        db.execSQL("CREATE TABLE constants (title TEXT, VALUE READ);");

        //It seems like all the values associated with SQLite must be wrapped with ContentValues before being inserted.
        //https://developer.android.com/reference/android/content/ContentValues
        //More specifically, ContentValues are objects those can be processed via ContentResolver.
        ContentValues cv=new ContentValues();
        
        cv.put(TITLE, "Gravity, Death Start I");
        //The below is an actual constant provided by SensorManager...
        cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
        db.insert(TABLE, TITLE, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new RuntimeException("How did we get here?");
    }

}
