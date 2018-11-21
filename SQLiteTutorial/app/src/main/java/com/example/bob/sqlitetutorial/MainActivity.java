package com.example.bob.sqlitetutorial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//Referred: https://www.tutorialspoint.com/android/android_sqlite_database.html

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase mydatabase = openOrCreateDatabase("Something", MODE_PRIVATE,
                null);

        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS " +
                "TutorialsPoint(Username VARCHAR,Password VARCHAR);");
        mydatabase.execSQL("INSERT INTO TutorialsPoint VALUES('admin','admin');");

        Cursor resultSet = mydatabase.rawQuery("Select * from TutorialsPoint",null);
        resultSet.moveToFirst();
        String username = resultSet.getString(0);
        String password = resultSet.getString(1);

        Log.i("dhl", "User name is: " + username);
        Log.i("dhl", "Password is: " + password);
    }
}
