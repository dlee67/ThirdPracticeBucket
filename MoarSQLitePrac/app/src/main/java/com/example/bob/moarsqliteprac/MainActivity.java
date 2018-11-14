package com.example.bob.moarsqliteprac;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(this);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, title);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, subtitle);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME,
                null, values);
    }
}