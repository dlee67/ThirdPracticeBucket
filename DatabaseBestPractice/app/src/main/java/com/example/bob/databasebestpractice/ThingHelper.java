package com.example.bob.databasebestpractice;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.example.bob.databasebestpractice.ThingContract.ThingEntry;

public class ThingHelper extends SQLiteOpenHelper {

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "thing.db";

    public ThingHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE =  "CREATE TABLE " + ThingEntry.TABLE_NAME + " ("
                + ThingEntry.COLUMN_THING_NAME + " );";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onConfigure(SQLiteDatabase db){
        super.onConfigure(db);

        setWriteAheadLoggingEnabled(true);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
