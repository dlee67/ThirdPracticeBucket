package com.example.bob.databasebestpractice;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import static com.example.bob.databasebestpractice.ThingContract.ThingEntry;

import com.facebook.stetho.Stetho;

/*
    Near copy paste of what the Udacity provides.
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this);
        }
    }

    public void insertQuery(View view){
        ThingHelper thingHelper = new ThingHelper(getApplicationContext());
        SQLiteDatabase db = thingHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ThingEntry.COLUMN_THING_NAME, "COOL THING");

        Uri newUri = getContentResolver().insert(ThingEntry.CONTENT_URI, values);
    }

    public void displayResult(View view){
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        // When your application is using the combination of Resolver and Provider,
        // there is no need to use a helper object in Activity classes
        // (in fact, the official documentation states that it's a very entropy prone way
        // to persist data).
        ThingHelper mDbHelper = new ThingHelper(this);

        // Create and/or open a database to read from it
        // At the later part of the Udacity course,
        //SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {ThingEntry.COLUMN_THING_NAME};

        //Cursor cursor = db.rawQuery(
        //        "SELECT * FROM " + ThingEntry.TABLE_NAME,
        //        null);

        // One could easily be baffled by the fact that there is no identifier ralted to ThingProvider.java;
        // the thing is, the ContentProvider get's coupled with the programmer's application via
        // URI, and I am guessing the application know which ContentProvider to look for via
        // manifest file.
        Cursor cursor = getContentResolver().query(
                ThingEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);

        try{
            cursor.moveToFirst();
            String name=cursor.getString(0);
            Log.i("dhl", "name is: " + name);
        } finally {
            cursor.close();
        }
    }
}
