package com.example.bob.sqlliteprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bob.sqlliteprac.FeedReaderContract.FeedEntry
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase



class MainActivity : AppCompatActivity() {

    val dbHelper = FeedReaderDbHelper(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Gets the data repository in write mode
        val db = dbHelper.writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(FeedEntry.COLUMN_NAME_TITLE, title)
            put(FeedEntry.COLUMN_NAME_SUBTITLE, subtitle)
        }

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, values)
    }
}
