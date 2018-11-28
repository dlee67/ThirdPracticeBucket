package com.example.bob.commonssqliteprac;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.SensorManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String TITLE="title";
    String VALUE="value";
    String TABLE="constants";
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.deleteDatabase("stuff.db");

        Log.i("dhl", "Initializing DatabaseHelper.");
        dbHelper = new DatabaseHelper(this, "stuff.db");
        dbHelper.close();

        insertStuff();
        readStuff();

        //Wow, the below is actually pretty neat.
        //The below has a lot of potential to decrease a complexity.
        //getSupportFragmentManager().beginTransaction()
        //        .add(R.id.main_fragment, new MainFragment(), "MainFragment")
        //        .commit();
    }

    public void insertStuff(){

        Log.i("dhl", "On insert stuff.");

        SQLiteDatabase db  = dbHelper.getWritableDatabase();

        //It seems like all the values associated with SQLite must be wrapped with ContentValues before being inserted.
        //https://developer.android.com/reference/android/content/ContentValues
        //More specifically, ContentValues are objects those can be processed via ContentResolver.
        ContentValues cv=new ContentValues();

        cv.put(TITLE, "Gravity, Death Start I");
        //The below is an actual constant provided by SensorManager...
        cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
        db.insert(TABLE, TITLE, cv);
    }

    public void readStuff(){

        Log.i("dhl", "On read stuff.");

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor result = db.rawQuery("SELECT * FROM constants;", null);
        for(int index = 0; result.moveToNext(); index++){
            int id=result.getInt(index);
            String name=result.getString(index);
            int inventory=result.getInt(index);
            Log.i("dhl", "id is: " + id);
            Log.i("dhl", "name is: " + name);
            Log.i("dhl", "inventory is: " + inventory);
        }
        result.close();
    }
}
