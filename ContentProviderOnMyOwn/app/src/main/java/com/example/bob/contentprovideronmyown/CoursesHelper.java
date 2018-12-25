package com.example.bob.contentprovideronmyown;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.bob.contentprovideronmyown.CoursesContract.get;

public class CoursesHelper extends SQLiteOpenHelper{

    // The DATABASE_VERSION is essentially getting used only once
    // because the system remembers the database's version
    // each time when the update happens.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "courses.db";
    private static Context applicationContext;

    public CoursesHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.applicationContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(get.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.applicationContext.deleteDatabase(this.DATABASE_NAME);
        db.setVersion(newVersion);
    }
}
