package com.example.bob.contentprovideronmyown;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.bob.contentprovideronmyown.CoursesContract.get;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertQuery(View view){
        CoursesHelper coursesHelper = new CoursesHelper(getApplicationContext());
        ContentValues values = new ContentValues();
        values.put(get.COLUMN_TERM, "Fall 2014");
        values.put(get.COLUMN_COURSE, "Computer Organization 2");
        values.put(get.COLUMN_FINAL_GRADE, "C+");

        Uri newUri = getContentResolver().insert(get.FINAL_GRADES_URI, values);
    }

    public void displayResult(View view){
        CoursesHelper helper = new CoursesHelper(this);
        String[] projection = {get.COLUMN_TERM, get.COLUMN_COURSE, get.COLUMN_FINAL_GRADE};
        Cursor cursor = getContentResolver()
                .query(
                    get.FINAL_GRADES_URI,
                    projection,
                    null,
                    null,
                    null
                );
        try{
            for(int index = 0; cursor.moveToNext(); index++){
                Log.i("dhl", cursor.getString(index));
            }
        } finally {
            cursor.close();
        }
    }
}
